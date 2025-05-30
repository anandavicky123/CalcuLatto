package com.softgasm.calculatto;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.softgasm.calculatto.system.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressLint("SetTextI18n")
public class premium extends Fragment {


    private final String PRODUCT_PREMIUM = "premium";
    private final ArrayList<String> purchaseItemIDs = new ArrayList<String>() {{
        add(PRODUCT_PREMIUM);
    }};

    CardView amonth;
    AppCompatButton iap;
    private BillingClient billingClient;

    TextView onemonthprice;

    List<ProductDetails> thelist;

    public premium() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_premium, container, false);
        amonth = view.findViewById(R.id.onemonthplan);
        onemonthprice = view.findViewById(R.id.onemonthprice);
        iap = view.findViewById(R.id.iapbutton);

        billingClient = BillingClient.newBuilder(requireContext())
                .enablePendingPurchases()
                .setListener(
                        (billingResult, list) -> {
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && list != null) {
                                for (Purchase purchase : list) {
                                    verifySubPurchase(purchase);
                                }
                            }
                        }
                ).build();

        establishConnection();

        if (App.SubscriptionStatus(requireContext()) && MainActivity.AdsIsShown) {
            MainActivity.getmInstanceActivity().goRecreate();
            MainActivity.AdsIsShown = false;
        }

        amonth.setOnClickListener(v -> {
            try {
                LaunchSubPurchase(thelist.get(0));
            } catch (NullPointerException | IndexOutOfBoundsException ignored) {
            }
        });

        iap.setOnClickListener(v -> {
            App.CheckSubscription(requireContext());
            MainActivity.getmInstanceActivity().goRecreate();
        });


        return view;
    }

    void establishConnection() {
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.
                    //Use any of function below to get details upon successful connection
                    ArrayList<QueryProductDetailsParams.Product> productList = new ArrayList<>();

                    for (String ids : purchaseItemIDs) {
                        productList.add(
                                QueryProductDetailsParams.Product.newBuilder()
                                        .setProductId(ids)
                                        .setProductType(BillingClient.ProductType.INAPP)
                                        .build());
                    }

                    QueryProductDetailsParams params = QueryProductDetailsParams.newBuilder()
                            .setProductList(productList)
                            .build();


                    billingClient.queryProductDetailsAsync(params, (billingResult1, list) -> {
                        thelist = list;

                        requireActivity().runOnUiThread(() -> {
                            try {
                                String omonth = Objects.requireNonNull(thelist.get(0).getOneTimePurchaseOfferDetails()).getFormattedPrice();
                                onemonthprice.setText(omonth);
                            } catch (IndexOutOfBoundsException e) {
                                onemonthprice.setText(getString(R.string.error));
                            }
                        });
                    });
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
                Log.d("TAG", "Connection NOT Established");
                establishConnection();
            }
        });
    }


    void LaunchSubPurchase(ProductDetails productDetails) {
        ArrayList<BillingFlowParams.ProductDetailsParams> productList = new ArrayList<>();

        productList.add(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                        .setProductDetails(productDetails)
                        .build());

        BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productList)
                .build();

        billingClient.launchBillingFlow(requireActivity(), billingFlowParams);
    }

    void verifySubPurchase(Purchase purchases) {

        requireActivity().runOnUiThread(() -> {
            try{
                Toast.makeText(requireContext(), R.string.pleasewait, Toast.LENGTH_SHORT).show();
            } catch (RuntimeException ignored){

            }
        });

        AcknowledgePurchaseParams acknowledgePurchaseParams = AcknowledgePurchaseParams
                .newBuilder()
                .setPurchaseToken(purchases.getPurchaseToken())
                .build();

        billingClient.acknowledgePurchase(acknowledgePurchaseParams, billingResult -> {
            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                App.handlePurchases(requireContext(), purchases, thelist, billingClient);

            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();

        billingClient.queryPurchasesAsync(
                QueryPurchasesParams.newBuilder().setProductType(BillingClient.ProductType.INAPP).build(),
                (billingResult, list) -> {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        for (Purchase purchase : list) {
                            if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED && !purchase.isAcknowledged()) {
                                verifySubPurchase(purchase);
                            }
                        }
                    }
                }
        );
    }
}
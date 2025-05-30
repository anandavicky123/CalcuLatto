package com.softgasm.calculatto;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.adapter.utils.SectionAdapter;
import com.softgasm.calculatto.system.adapter.utils.SectionInfoFactory;
import com.softgasm.calculatto.system.adapter.utils.SectionItemInfoDialog;
import com.softgasm.calculatto.system.adapter.utils.SectionItemInfoFactory;
import com.softgasm.calculatto.system.adapter.utils.SectionedRecyclerViewAdapter;
import com.softgasm.calculatto.ui.sections.ArraysOfSections;
import com.softgasm.calculatto.ui.sections.GeometrySections;

import java.util.concurrent.TimeUnit;


public class geometry extends Fragment implements GeometrySections.ClickListener {

    private static final String DIALOG_TAG = "SectionItemInfoDialogTag";

    private int retryAttempt;

    private SectionedRecyclerViewAdapter sectionedAdapter;

    View view;

    public geometry() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_geometry, container, false);


        sectionedAdapter = new SectionedRecyclerViewAdapter();

        sectionedAdapter.addSection(new GeometrySections(getString(R.string.oneD),
                ArraysOfSections.gm_one(), this,  R.drawable.item_1d));
        sectionedAdapter.addSection(new GeometrySections(getString(R.string.twoD),
                ArraysOfSections.gm_two(), this,  R.drawable.item_2d));
        sectionedAdapter.addSection(new GeometrySections(getString(R.string.threeD),
                ArraysOfSections.gm_three(), this,  R.drawable.item_3d));


        final RecyclerView recyclerView = view.findViewById(R.id.geometryview);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(requireContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);

        Display display = ((AppCompatActivity) requireContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        int jc;
        if (width > 1100) {
            jc = JustifyContent.CENTER;
        } else {
            jc = JustifyContent.SPACE_BETWEEN;
        }
        layoutManager.setJustifyContent(jc);


        recyclerView.setLayoutManager(layoutManager);
        ConcatAdapter concatenated = new ConcatAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = inflater.inflate(R.layout.header_geometry, parent , false);
                return new RecyclerView.ViewHolder(v) {

                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 1;
            }
        }, sectionedAdapter);
        recyclerView.setAdapter(concatenated);

        return view;
    }


    @Override
    public void onHeaderRootViewClicked(@NonNull final GeometrySections section) {
        final SectionAdapter sectionAdapter = sectionedAdapter.getAdapterForSection(section);

        // store info of current section state before changing its state
        final boolean wasExpanded = section.isExpanded();
        final int previousItemsTotal = section.getContentItemsTotal();

        section.setExpanded(!wasExpanded);
        sectionAdapter.notifyHeaderChanged();

        if (wasExpanded) {
            sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal);
        } else {
            sectionAdapter.notifyAllItemsInserted();
        }
    }

    @Override
    public void onItemRootViewClicked(@NonNull GeometrySections section, int itemAdapterPosition) {
        final SectionItemInfoDialog dialog = SectionItemInfoDialog.getInstance(
                SectionItemInfoFactory.create(itemAdapterPosition, sectionedAdapter),
                SectionInfoFactory.create(section, sectionedAdapter.getAdapterForSection(section))
        );
        dialog.show(getParentFragmentManager(), DIALOG_TAG);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!App.SubscriptionStatus(requireContext())) {
            Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
                @Override
                public void onInterstitialClicked() {

                }

                @Override
                public void onInterstitialLoaded(boolean b) {
                    retryAttempt = 0;
                }

                @Override
                public void onInterstitialFailedToLoad() {
                    retryAttempt++;
                    long delayMillis = TimeUnit.SECONDS.toMillis((long) Math.pow(2, Math.min(6, retryAttempt)));
                    new Handler().postDelayed(() -> Appodeal.cache(MainActivity.getmInstanceActivity(), Appodeal.INTERSTITIAL), delayMillis);

                }

                @Override
                public void onInterstitialShown() {

                }

                @Override
                public void onInterstitialShowFailed() {
                    loadgeometryads(requireActivity());
                }

                @Override
                public void onInterstitialClosed() {
                }

                @Override
                public void onInterstitialExpired() {
                    Appodeal.cache(requireActivity(), Appodeal.INTERSTITIAL);
                }
            });

        }
    }

    public static boolean checkads() {
        return Appodeal.isLoaded(Appodeal.INTERSTITIAL);
    }

    public static void loadgeometryads(Activity activity) {
        Appodeal.cache(activity, Appodeal.INTERSTITIAL);
    }

    public static void showads() {
        Appodeal.show(MainActivity.getmInstanceActivity(), Appodeal.INTERSTITIAL);
    }

}
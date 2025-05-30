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
import com.softgasm.calculatto.ui.sections.HealthSections;

import java.util.concurrent.TimeUnit;


public class health extends Fragment implements HealthSections.ClickListener {

    private static final String DIALOG_TAG = "SectionItemInfoDialogTag";


    private int retryAttempt;
    private SectionedRecyclerViewAdapter sectionedAdapter;

    public health() {
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_health, container, false);

        sectionedAdapter = new SectionedRecyclerViewAdapter();

        sections();


        final RecyclerView recyclerView = view.findViewById(R.id.healthView);

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
                View v = inflater.inflate(R.layout.header_health, parent, false);
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

    private void sections() {
        sectionedAdapter.addSection(new HealthSections(getString(R.string.bodyshape),
                ArraysOfSections.h_bodyshape(), this, R.drawable.bodyshape));
        sectionedAdapter.addSection(new HealthSections(getString(R.string.bloodcirculation),
                ArraysOfSections.h_bloodcirculation(), this, R.drawable.bloodcirculation));
        sectionedAdapter.addSection(new HealthSections(getString(R.string.serum),
                ArraysOfSections.h_serum(), this, R.drawable.serum));
        sectionedAdapter.addSection(new HealthSections(getString(R.string.others),
                ArraysOfSections.h_others(), this, R.drawable.otherhealth));
    }



    @Override
    public void onHeaderRootViewClicked(@NonNull final HealthSections section) {
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
    public void onItemRootViewClicked(@NonNull HealthSections section, int itemAdapterPosition) {
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
                    loadhealthads(requireActivity());
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

    public static void loadhealthads(Activity activity) {
        Appodeal.cache(activity, Appodeal.INTERSTITIAL);
    }

    public static void showads() {
        Appodeal.show(MainActivity.getmInstanceActivity(), Appodeal.INTERSTITIAL);

    }

    public static boolean checkads() {
        return Appodeal.isLoaded(Appodeal.INTERSTITIAL);
    }
}
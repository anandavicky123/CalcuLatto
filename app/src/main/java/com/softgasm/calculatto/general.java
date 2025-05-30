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
import com.softgasm.calculatto.ui.sections.GeneralSections;

import java.util.concurrent.TimeUnit;


public class general extends Fragment implements GeneralSections.ClickListener {

    private static final String DIALOG_TAG = "SectionItemInfoDialogTag";

    View view;
    private int retryAttempt;
    private SectionedRecyclerViewAdapter sectionedAdapter;

    public general() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_general, container, false);


        sectionedAdapter = new SectionedRecyclerViewAdapter();

        sectionedAdapter.addSection(new GeneralSections(getString(R.string.basic_calculations),
                ArraysOfSections.gl_basic(), this, R.drawable.basiccalc));
        sectionedAdapter.addSection(new GeneralSections(getString(R.string.algebra),
                ArraysOfSections.gl_algebra(), this, R.drawable.algebra));
        sectionedAdapter.addSection(new GeneralSections(getString(R.string.statistics),
                ArraysOfSections.gl_statistic(), this, R.drawable.statistics));
        sectionedAdapter.addSection(new GeneralSections(getString(R.string.other_calculations),
                ArraysOfSections.gl_others(), this, R.drawable.othergeneral));


        final RecyclerView recyclerView = view.findViewById(R.id.generalview);


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
                View v = inflater.inflate(R.layout.header_general, parent, false);
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
    public void onHeaderRootViewClicked(@NonNull final GeneralSections section) {
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
    public void onItemRootViewClicked(@NonNull GeneralSections section, int itemAdapterPosition) {
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
                    loadgeneralads(requireActivity());
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

    public static void loadgeneralads(Activity activity) {
        Appodeal.cache(activity, Appodeal.INTERSTITIAL);
    }

    public static void showads() {
        Appodeal.show(MainActivity.getmInstanceActivity(), Appodeal.INTERSTITIAL);
    }

    public static boolean checkads() {
        return Appodeal.isLoaded(Appodeal.INTERSTITIAL);
    }
}
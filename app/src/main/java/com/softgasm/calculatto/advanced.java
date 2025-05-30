package com.softgasm.calculatto;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.RewardedVideoCallbacks;
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
import com.softgasm.calculatto.ui.sections.Avsections;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class advanced extends Fragment implements Avsections.ClickListener {


    private static final String DIALOG_TAG = "SectionItemInfoDialogTag";
    @IdRes
    public static int navigation;
    Avsections sectionAD;
    int itemAdapterPositionAD;
    View view;
    private int retryAttempt;
    private SectionedRecyclerViewAdapter sectionedAdapter;

    public advanced() {
    }

    public static void loadadvancedads(Activity ac) {
        Appodeal.cache(ac, Appodeal.REWARDED_VIDEO);
    }

    public static boolean checkads() {
        return Appodeal.isLoaded(Appodeal.REWARDED_VIDEO);
    }

    public static void gettheget(@IdRes int destination, View views, Context context) {
        navigation = destination;
        Dialog dialog = new Dialog(context);
        dialog.setTitle(R.string.selecttheoption);
        dialog.setContentView(R.layout.dialog_options);
        dialog.setCanceledOnTouchOutside(true);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button cancelButton = dialog.findViewById(R.id.odc);
        CardView opt1 = dialog.findViewById(R.id.watchtoenter);
        CardView opt2 = dialog.findViewById(R.id.instantenter);

        opt1.setOnClickListener(v -> {
            if (checkads()) {
                dialog.dismiss();
                Appodeal.show(MainActivity.getmInstanceActivity(), Appodeal.REWARDED_VIDEO);
            } else {
                dialog.dismiss();
                loadadvancedads(MainActivity.getmInstanceActivity());
                Toast.makeText(context, R.string.adsisnotloaded, Toast.LENGTH_SHORT).show();
            }
        });

        opt2.setOnClickListener(v -> {
            dialog.dismiss();
            Navigation.findNavController(views).navigate(R.id.premium);
        });

        cancelButton.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_advanced, container, false);


        sectionedAdapter = new SectionedRecyclerViewAdapter();
        sections();

        final RecyclerView recyclerView = view.findViewById(R.id.advanceview);

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
                View v = inflater.inflate(R.layout.header_advanced, parent, false);
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


        sectionedAdapter.addSection(new Avsections(getString(R.string.kinematicsdynamicsstatics),
                ArraysOfSections.a_kds(), this, R.drawable.kds));
        sectionedAdapter.addSection(new Avsections(getString(R.string.chemistry),
                ArraysOfSections.a_chemistry(), this, R.drawable.chemistry));
        sectionedAdapter.addSection(new Avsections(getString(R.string.relativity),
                ArraysOfSections.a_relativity(), this, R.drawable.relativity));
        sectionedAdapter.addSection(new Avsections(getString(R.string.thermodynamics),
                ArraysOfSections.a_thermo(), this, R.drawable.thermodynamics));
        sectionedAdapter.addSection(new Avsections(getString(R.string.others),
                ArraysOfSections.a_others(), this, R.drawable.otheradvanced));

    }

    @Override
    public void onHeaderRootViewClicked(@NonNull final Avsections section) {
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
    public void onItemRootViewClicked(@NonNull Avsections section, int itemAdapterPosition) {
        sectionAD = section;
        itemAdapterPositionAD = itemAdapterPosition;
        final SectionItemInfoDialog dialog = SectionItemInfoDialog.getInstance(
                SectionItemInfoFactory.create(itemAdapterPositionAD, sectionedAdapter),
                SectionInfoFactory.create(sectionAD, sectionedAdapter.getAdapterForSection(sectionAD))
        );
        dialog.show(getParentFragmentManager(), DIALOG_TAG);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!App.SubscriptionStatus(requireContext())) {
            Appodeal.setRewardedVideoCallbacks(new RewardedVideoCallbacks() {
                @Override
                public void onRewardedVideoClicked() {

                }

                @Override
                public void onRewardedVideoLoaded(boolean b) {
                    retryAttempt = 0;
                }

                @Override
                public void onRewardedVideoFailedToLoad() {
                    retryAttempt++;
                    long delayMillis = TimeUnit.SECONDS.toMillis((long) Math.pow(2, Math.min(6, retryAttempt)));
                    new Handler().postDelayed(() -> Appodeal.cache(MainActivity.getmInstanceActivity(), Appodeal.REWARDED_VIDEO), delayMillis);
                }

                @Override
                public void onRewardedVideoShown() {
                    Navigation.findNavController(view).navigate(navigation);
                }

                @Override
                public void onRewardedVideoShowFailed() {
                    Appodeal.cache(requireActivity(), Appodeal.REWARDED_VIDEO);
                }

                @Override
                public void onRewardedVideoFinished(double v, String s) {

                }

                @Override
                public void onRewardedVideoClosed(boolean b) {

                }

                @Override
                public void onRewardedVideoExpired() {
                    Appodeal.cache(requireActivity(), Appodeal.REWARDED_VIDEO);
                }
            });
        }
    }

}
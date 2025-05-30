package com.softgasm.calculatto.ui.sections;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.MainActivity;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.health;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.HeaderViewHolder;
import com.softgasm.calculatto.system.adapter.ItemViewHolder;
import com.softgasm.calculatto.system.adapter.Items;
import com.softgasm.calculatto.system.adapter.utils.Section;
import com.softgasm.calculatto.system.adapter.utils.SectionParameters;

import java.util.ArrayList;

public final class HealthSections extends Section {

    private final String title;

    private final @DrawableRes int headericon;
    private final ArrayList<Items> list;
    private final ClickListener clickListener;
    private boolean expanded = true;

    View newview;

    private final @IdRes int tfs = R.id.thefragments;
    private final @IdRes int tws = R.id.thefragments_ws;

    public HealthSections(@NonNull final String title, @NonNull final ArrayList<Items> list,
                            @NonNull final ClickListener clickListener, @DrawableRes final int headericon) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_main)
                .headerResourceId(R.layout.header)
                .build());

        this.title = title;
        this.headericon = headericon;
        this.list = list;
        this.clickListener = clickListener;
    }

    @Override
    public int getContentItemsTotal() {
        return expanded ? list.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(final View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;

        final Items theitems = list.get(position);
        itemHolder.tvItem.setText(theitems.name);
        itemHolder.image.setImageResource(theitems.image);
        int itemID = theitems.itemID;
        // String destination = items.category;

        itemHolder.rootView.setOnClickListener(v -> {
            Temp.name = theitems.name;
            Temp.icon = theitems.image;
            newview = v;

            switch (itemID){
                case 1:
                    Temp.req = "bmi";
                    Temp.desc = gs(R.string.bmidesc);
                    ch(tfs);
                    break;
                case 9:
                    ch(R.id.health_metabolicrates);
                    break;
                case 2:
                    Temp.req = "bsa";
                    Temp.desc = gs(R.string.bsadesc);
                    ch(tfs);
                    break;
                case 4:
                    Temp.req = "waistr";
                    Temp.desc = gs(R.string.wrdesc);
                    ch(tfs);
                    break;
                case 7:
                    Temp.req = "bloodp";
                    Temp.desc = gs(R.string.bprule);
                    ch(tws);
                    break;
                case 8:
                    Temp.req = "cardiac";
                    Temp.desc = gs(R.string.cardiacindexdesc);
                    ch(tfs);
                    break;
                case 3:
                    Temp.req = "lbm";
                    Temp.desc = gs(R.string.lbmdesc);
                    ch(tfs);
                    break;
                case 5:
                    Temp.req = "rfm";
                    Temp.desc = gs(R.string.rfmdesc);
                    ch(tfs);
                    break;
                case 6:
                    Temp.req = "ffmi";
                    Temp.desc = gs(R.string.ffmidesc);
                    ch(tfs);
                    break;
                case 10:
                    Temp.req = "calco";
                    Temp.desc = gs(R.string.ccdesc);
                    ch(tws);
                    break;
                case 11:
                    Temp.req = "bun";
                    Temp.desc = gs(R.string.bundesc);
                    ch(tfs);
                    break;
                case 12:
                    Temp.req = "anion";
                    Temp.desc = gs(R.string.aniondesc);
                    ch(tfs);
                    break;
                case 13:
                    Temp.req = "iron";
                    Temp.desc = gs(R.string.irondefdesc);
                    ch(tfs);
                    break;
                case 14:
                    Temp.req = "tsat";
                    Temp.desc = gs(R.string.transferrindesc);
                    ch(tfs);
                    break;
                case 15:
                    Temp.req = "qtc";
                    Temp.desc = gs(R.string.qtcdesc);
                    ch(tfs);
                    break;
                case 16:
                    Temp.req = "saag";
                    Temp.desc = gs(R.string.saagdesc);
                    ch(tfs);
                    break;
                case 17:
                    Temp.req = "ldl";
                    Temp.desc = gs(R.string.ldldesc);
                    ch(tfs);
                    break;
                case 18:
                    Temp.req = "insulin";
                    Temp.desc = gs(R.string.insulinresistancedesc);
                    ch(tfs);
                    break;
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(final View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(final RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.tvTitle.setText(title);

        headerHolder.icon.setImageResource(headericon);

        headerHolder.imgArrow.setImageResource(
                expanded ? R.drawable.ic_keyboard_arrow_up_black_18dp : R.drawable.ic_keyboard_arrow_down_black_18dp
        );
        headerHolder.rootView.setOnClickListener(v -> clickListener.onHeaderRootViewClicked(this));
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(final boolean expanded) {
        this.expanded = expanded;
    }

    public interface ClickListener {

        void onHeaderRootViewClicked(@NonNull final HealthSections section);

        void onItemRootViewClicked(@NonNull final HealthSections section, final int itemAdapterPosition);
    }

    private String gs(@StringRes int string) {
        return App.getAppResources().getString(string);
    }

    private void ch(@IdRes int destination) {
        if (!App.SubscriptionStatus(newview.getContext())) {
            if (App.TimeToShowAds) {
                if (health.checkads()) {
                    health.showads();
                    goNavigate(destination);
                    App.TimeToShowAds = false;
                } else {
                    showToast();
                }
            } else {
                App.TimeToShowAds = true;
                goNavigate(destination);
            }
        } else {
            goNavigate(destination);
        }
    }


    private void goNavigate(@IdRes int destination) {
        Navigation.findNavController(newview).navigate(destination);
    }

    private void showToast() {
        Toast.makeText(newview.getContext(), R.string.loadingad, Toast.LENGTH_SHORT).show();
        MainActivity.getmInstanceActivity().loadads();
        Toast.makeText(newview.getContext(), R.string.tryagain, Toast.LENGTH_SHORT).show();
    }
}

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
import com.softgasm.calculatto.general;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.HeaderViewHolder;
import com.softgasm.calculatto.system.adapter.ItemViewHolder;
import com.softgasm.calculatto.system.adapter.Items;
import com.softgasm.calculatto.system.adapter.utils.Section;
import com.softgasm.calculatto.system.adapter.utils.SectionParameters;

import java.util.List;

public final class GeneralSections extends Section {

    private final String title;

    private final @DrawableRes int headericon;
    private final List<Items> list;
    private final ClickListener clickListener;
    private boolean expanded = true;

    View newview;

    private final @IdRes int tfs = R.id.thefragments;
    private final @IdRes int tws = R.id.thefragments_ws;

    private final @IdRes int tfa = R.id.thefragments_arrays;

    public GeneralSections(@NonNull final String title, @NonNull final List<Items> list,
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

        itemHolder.rootView.setOnClickListener(v -> {
            Temp.name = theitems.name;
            Temp.icon = theitems.image;
            newview = v;


            switch (itemID) {
                case 1:
                    cg(R.id.numeral_systems);
                    break;
                case 2:
                    Temp.req = "%";
                    Temp.desc = gs(R.string.percentagedesc);
                    cg(tws);
                    break;
                case 3:
                    Temp.req = "poe";
                    Temp.desc = gs(R.string.poedesc);
                    cg(tws);
                    break;
                case 4:
                    Temp.req = "median";
                    cg(tfa);
                    break;
                case 5:
                    Temp.req = "ratio";
                    Temp.desc = gs(R.string.ratiodesc);
                    cg(tws);
                    break;
                case 6:
                    Temp.req = "fraction";
                    Temp.desc = gs(R.string.fracdesc);
                    cg(tws);
                    break;
                case 7:
                    Temp.req = "roman";
                    Temp.desc = gs(R.string.romannumeraldesc);
                    cg(tws);
                    break;
                case 8:
                    Temp.req = "gl";
                    cg(tfa);
                    break;
                case 9:
                    Temp.req = "modulo";
                    Temp.desc = gs(R.string.modulodesc);
                    cg(tws);
                    break;
                case 10:
                    Temp.req = "radical";
                    Temp.desc = gs(R.string.radicaldesc);
                    cg(tws);
                    break;
                case 11:
                    cg(R.id.longbasic);
                    break;
                case 12:
                    Temp.req = "bco";
                    Temp.desc = gs(R.string.bcdesc);
                    cg(tws);
                    break;
                case 13:
                    Temp.req = "gfu";
                    Temp.desc = gs(R.string.gfdesc);
                    cg(tws);
                    break;
                case 14:
                    cg(R.id.matrix);
                    break;
                case 15:
                    Temp.req = "leq";
                    Temp.desc = gs(R.string.ledesc);
                    cg(tws);
                    break;
                case 16:
                    cg(R.id.vector);
                    break;
                case 17:
                    Temp.req = "probability";
                    Temp.desc = gs(R.string.probdesc);
                    cg(tws);
                    break;
                case 18:
                    Temp.req = "coin";
                    Temp.desc = gs(R.string.coinprobdesc);
                    cg(tws);
                    break;
                case 19:
                    Temp.req = "cnp";
                    Temp.desc = gs(R.string.cnpdesc);
                    cg(tws);
                    break;
                case 20:
                    Temp.req = "dice";
                    Temp.desc = gs(R.string.dicedesc);
                    cg(tws);
                    break;
                case 21:
                    cg(R.id.date_calculation);
                    break;
                case 22:
                    Temp.req = "fabric";
                    Temp.desc = gs(R.string.fabricdesc);
                    cg(tfs);
                    break;
                case 23:
                    Temp.req = "clock";
                    Temp.desc = gs(R.string.clockangledesc);
                    cg(tws);
                    break;
                case 24:
                    Temp.req = "aqua";
                    Temp.desc = gs(R.string.aqdesc);
                    cg(tfs);
                    break;
                case 25:
                    cg(R.id.timezone);
                    break;
                case 26:
                    Temp.req = "cofunction";
                    Temp.desc = gs(R.string.cofunctiondesc);
                    cg(tfs);
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

        void onHeaderRootViewClicked(@NonNull final GeneralSections section);

        void onItemRootViewClicked(@NonNull final GeneralSections section, final int itemAdapterPosition);
    }

    private String gs(@StringRes int string) {
        return App.getAppResources().getString(string);
    }

    private void cg(@IdRes int destination) {

        if (!App.SubscriptionStatus(newview.getContext())) {
            if (App.TimeToShowAds) {
                if (general.checkads()) {
                    general.showads();
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

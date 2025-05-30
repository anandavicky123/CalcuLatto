package com.softgasm.calculatto.ui.sections;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.advanced;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.HeaderViewHolder;
import com.softgasm.calculatto.system.adapter.ItemViewHolder;
import com.softgasm.calculatto.system.adapter.Items;
import com.softgasm.calculatto.system.adapter.utils.Section;
import com.softgasm.calculatto.system.adapter.utils.SectionParameters;

import java.util.List;

public final class Avsections extends Section {

    private final String title;

    private final @DrawableRes int headericon;
    private final List<Items> list;
    private final ClickListener clickListener;
    private boolean expanded = true;

    View newview;

    private final @IdRes int tfs = R.id.thefragments;

    public Avsections(@NonNull final String title, @NonNull final List<Items> list,
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

            switch (itemID){
                case 1:
                    Temp.req = "acceleration";
                    Temp.desc = gs(R.string.accdesc);
                    break;
                case 2:
                    Temp.req = "displacement";
                    Temp.desc = gs(R.string.dispdesc);
                    break;
                case 3:
                    Temp.req = "velocity";
                    Temp.desc = gs(R.string.velodesc);
                    break;
                case 4:
                    Temp.req = "momentum";
                    Temp.desc = gs(R.string.momentumdesc);
                    break;
                case 5:
                    Temp.req = "friction";
                    Temp.desc = gs(R.string.frictiondesc);
                    break;
                case 6:
                    Temp.req = "psa";
                    Temp.desc = gs(R.string.pressdesc);
                    break;
                case 7:
                    Temp.req = "molality";
                    Temp.desc = gs(R.string.molardesc);
                    break;
                case 8:
                    Temp.req = "molarity";
                    Temp.desc = gs(R.string.molardesc);
                    break;
                case 9:
                    Temp.req = "einstein";
                    Temp.desc = gs(R.string.einsteindesc);
                    break;
                case 10:
                    Temp.req = "lorentz";
                    Temp.desc = gs(R.string.lfdesc);
                    break;
                case 11:
                    Temp.req = "heatc";
                    Temp.desc = gs(R.string.heatdesc);
                    break;
                case 12:
                    Temp.req = "idealgas";
                    Temp.desc = gs(R.string.idealgasdesc);
                    break;
                case 13:
                    Temp.req = "energye";
                    Temp.desc = gs(R.string.energyedesc);
                    break;
                case 14:
                    Temp.req = "mach";
                    Temp.desc = gs(R.string.machdesc);
                    break;
                case 15:
                    Temp.req = "epower";
                    Temp.desc = gs(R.string.epowerdesc);
                    break;
                case 16:
                    Temp.req = "force";
                    Temp.desc = gs(R.string.forcedesc);
                    break;
                case 17:
                    Temp.req = "avogadro";
                    Temp.desc = gs(R.string.avogadrodesc);
                    break;
                case 18:
                    Temp.req = "conc";
                    Temp.desc = gs(R.string.concdesc);
                    break;
                case 19:
                    Temp.req = "waterh";
                    Temp.desc = gs(R.string.waterheatingdesc);
                    break;
                case 20:
                    Temp.req = "freq";
                    Temp.desc = gs(R.string.freqdesc);
                    break;
                case 21:
                    Temp.req = "bond";
                    Temp.desc = gs(R.string.bondorderdesc);
                    break;
                case 22:
                    Temp.req = "neutral";
                    Temp.desc = gs(R.string.neutralizationdesc);
                    break;
            }
            ca(tfs);




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

        void onHeaderRootViewClicked(@NonNull final Avsections section);

        void onItemRootViewClicked(@NonNull final Avsections section, final int itemAdapterPosition);
    }


    private String gs(@StringRes int string) {
        return App.getAppResources().getString(string);
    }

    private void ca(@IdRes int destination) {
        if (!App.SubscriptionStatus(newview.getContext())) {
            advanced.gettheget(destination, newview, newview.getContext());
        } else {
            Navigation.findNavController(newview).navigate(destination);
        }
    }
}

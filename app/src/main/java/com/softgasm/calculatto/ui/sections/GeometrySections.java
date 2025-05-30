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
import com.softgasm.calculatto.geometry;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.HeaderViewHolder;
import com.softgasm.calculatto.system.adapter.ItemViewHolder;
import com.softgasm.calculatto.system.adapter.Items;
import com.softgasm.calculatto.system.adapter.utils.Section;
import com.softgasm.calculatto.system.adapter.utils.SectionParameters;

import java.util.List;

public final class GeometrySections extends Section {

    private final String title;

    private final @DrawableRes int headericon;
    private final List<Items> list;
    private final ClickListener clickListener;
    private boolean expanded = true;

    View newview;

    private final @IdRes int geo = R.id.thefragments_geometry;


    public GeometrySections(@NonNull final String title, @NonNull final List<Items> list,
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
                    Temp.req = "circlearc";
                    Temp.desc = gs(R.string.cadesc);
                    cge(geo);
                    break;
                case 2:
                    Temp.req = "helix";
                    cge(geo);
                    Temp.desc = gs(R.string.helixdesc);
                    break;
                case 3:
                    Temp.req = "koch";
                    cge(geo);
                    Temp.desc = gs(R.string.kochdesc);
                    break;
                case 4:
                    Temp.req = "parabola";
                    cge(geo);
                    Temp.desc = gs(R.string.paraboladesc);
                    break;
                case 5:
                    Temp.req = "rectangle";
                    Temp.desc = gs(R.string.rectdesc);
                    cge(geo);
                    break;
                case 6:
                    Temp.req = "circle";
                    Temp.desc = gs(R.string.circdesc);
                    cge(geo);
                    break;
                case 7:
                    Temp.req = "triangle";
                    Temp.desc = gs(R.string.tridesc);
                    cge(geo);
                    break;
                case 8:
                    Temp.desc = gs(R.string.squaredesc);
                    Temp.req = "square";
                    cge(geo);
                    break;
                case 9:
                    Temp.req = "ellipse";
                    Temp.desc = gs(R.string.elldesc);
                    cge(geo);
                    break;
                case 10:
                    Temp.req = "pentagon";
                    Temp.desc = gs(R.string.pentadesc);
                    cge(geo);
                    break;
                case 11:
                    Temp.req = "hexagon";
                    Temp.desc = gs(R.string.hexadesc);
                    cge(geo);
                    break;
                case 12:
                    Temp.desc = gs(R.string.trapezodesc);
                    Temp.req = "trapezoid";
                    cge(geo);
                    break;
                case 13:
                    Temp.desc = gs(R.string.rhodesc);
                    Temp.req = "rhombus";
                    cge(geo);
                    break;
                case 14:
                    Temp.desc = gs(R.string.rtriangdesc);
                    Temp.req = "rtriangle";
                    cge(geo);
                    break;
                case 15:
                    Temp.req = "sphere";
                    Temp.desc = gs(R.string.spheredesc);
                    cge(geo);
                    break;
                case 16:
                    Temp.req = "cube";
                    Temp.desc = gs(R.string.cubedesc);
                    cge(geo);
                    break;
                case 17:
                    Temp.req = "prism";
                    Temp.desc = gs(R.string.prismdesc);
                    cge(geo);
                    break;
                case 18:
                    Temp.req = "pyramid";
                    Temp.desc = gs(R.string.pydesc);
                    cge(geo);
                    break;
                case 19:
                    Temp.req = "cylinder";
                    Temp.desc = gs(R.string.cydesc);
                    cge(geo);
                    break;
                case 20:
                    Temp.req = "ellipsoid";
                    cge(geo);
                    Temp.desc = gs(R.string.ellipsoiddesc);
                    break;
                case 21:
                    Temp.req = "cone";
                    Temp.desc = gs(R.string.conedesc);
                    cge(geo);
                    break;
                case 22:
                    Temp.req = "pfrustum";
                    Temp.desc = gs(R.string.pfdesc);
                    cge(geo);
                    break;
                case 23:
                    Temp.req = "cfrustum";
                    Temp.desc = gs(R.string.cfrusdesc);
                    cge(geo);
                    break;
                case 24:
                    Temp.req = "scap";
                    Temp.desc = gs(R.string.scapdesc);
                    cge(geo);
                    break;
                case 25:
                    Temp.req = "sseg";
                    Temp.desc = gs(R.string.ssegdesc);
                    cge(geo);
                    break;
                case 26:
                    Temp.req = "torus";
                    Temp.desc = gs(R.string.torusdesc);
                    cge(geo);
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

        void onHeaderRootViewClicked(@NonNull final GeometrySections section);

        void onItemRootViewClicked(@NonNull final GeometrySections section, final int itemAdapterPosition);
    }


    private String gs(@StringRes int string) {
        return App.getAppResources().getString(string);
    }


    private void cge(@IdRes int destination) {
        if (!App.SubscriptionStatus(newview.getContext())) {
            if (App.TimeToShowAds) {
                if (geometry.checkads()) {
                    geometry.showads();
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

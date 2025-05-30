package com.softgasm.calculatto.ui.sections;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.items.Dipole;
import com.softgasm.calculatto.contents.Unitconverter.items.Luminance;
import com.softgasm.calculatto.contents.Unitconverter.items.SolidAngle;
import com.softgasm.calculatto.contents.Unitconverter.items.Temperature;
import com.softgasm.calculatto.contents.Unitconverter.items.Angle;
import com.softgasm.calculatto.contents.Unitconverter.items.Area;
import com.softgasm.calculatto.contents.Unitconverter.items.Cooking;
import com.softgasm.calculatto.contents.Unitconverter.items.Energy;
import com.softgasm.calculatto.contents.Unitconverter.items.Charge;
import com.softgasm.calculatto.contents.Unitconverter.items.Current;
import com.softgasm.calculatto.contents.Unitconverter.items.Density;
import com.softgasm.calculatto.contents.Unitconverter.items.DynamicViscosity;
import com.softgasm.calculatto.contents.Unitconverter.items.Flow;
import com.softgasm.calculatto.contents.Unitconverter.items.FuelConsumption;
import com.softgasm.calculatto.contents.Unitconverter.items.Illumination;
import com.softgasm.calculatto.contents.Unitconverter.items.Length;
import com.softgasm.calculatto.contents.Unitconverter.items.Loudness;
import com.softgasm.calculatto.contents.Unitconverter.items.Magnet;
import com.softgasm.calculatto.contents.Unitconverter.items.Mass;
import com.softgasm.calculatto.contents.Unitconverter.items.Power;
import com.softgasm.calculatto.contents.Unitconverter.items.AbsorbedDose;
import com.softgasm.calculatto.contents.Unitconverter.items.SpecificHeat;
import com.softgasm.calculatto.contents.Unitconverter.items.Speed;
import com.softgasm.calculatto.contents.Unitconverter.items.Time;
import com.softgasm.calculatto.contents.Unitconverter.items.Torque;
import com.softgasm.calculatto.contents.Unitconverter.items.Volume;
import com.softgasm.calculatto.contents.Unitconverter.items.Weight;
import com.softgasm.calculatto.contents.Unitconverter.items.Storage;
import com.softgasm.calculatto.contents.Unitconverter.items.KinematicViscosity;
import com.softgasm.calculatto.contents.Unitconverter.items.Potential;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.HeaderViewHolder;
import com.softgasm.calculatto.system.adapter.ItemViewHolder;
import com.softgasm.calculatto.system.adapter.Items;
import com.softgasm.calculatto.system.adapter.utils.Section;
import com.softgasm.calculatto.system.adapter.utils.SectionParameters;

import java.util.ArrayList;

public final class ConverterSections extends Section {

    private final String title;

    private final @DrawableRes int headericon;
    private final ArrayList<Items> list;
    private final ClickListener clickListener;
    private boolean expanded = true;

    public ConverterSections(@NonNull final String title, @NonNull final ArrayList<Items> list,
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
        final Items items = list.get(position);
        itemHolder.tvItem.setText(items.name);
        itemHolder.image.setImageResource(items.image);
        int itemID = items.itemID;
        itemHolder.rootView.setOnClickListener(v -> {
            Temp.name = items.name;
            Temp.icon = items.image;
            switch (itemID) {
                case 1:
                    Temp.conversion = new Temperature();
                    break;
                case 2:
                    Temp.conversion = new Length();
                    break;
                case 3:
                    Temp.conversion = new Area();
                    break;
                case 4:
                    Temp.conversion = new Volume();
                    break;
                case 5:
                    Temp.conversion = new Weight();
                    break;
                case 8:
                    Temp.conversion = new Time();
                    break;
                case 9:
                    Temp.conversion = new Cooking();
                    break;
                case 10:
                    Temp.conversion = new Loudness();
                    break;
                case 11:
                    Temp.conversion = new Power();
                    break;
                case 12:
                    Temp.conversion = new Energy();
                    break;
                case 18:
                    Temp.conversion = new Storage();
                    break;
                case 19:
                    Temp.conversion = new AbsorbedDose();
                    break;
                case 20:
                    Temp.conversion = new Magnet();
                    break;
                case 21:
                    Temp.conversion = new SpecificHeat();
                    break;
                case 22:
                    Temp.conversion = new Illumination();
                    break;
                case 24:
                    Temp.conversion = new Angle();
                    break;
                case 25:
                    Temp.conversion = new Torque();
                    break;
                case 26:
                    Temp.conversion = new Speed();
                    break;
                case 27:
                    Temp.conversion = new Mass();
                    break;
                case 28:
                    Temp.conversion = new KinematicViscosity();
                    break;
                case 29:
                    Temp.conversion = new DynamicViscosity();
                    break;
                case 30:
                    Temp.conversion = new Flow();
                    break;
                case 31:
                    Temp.conversion = new Density();
                    break;
                case 32:
                    Temp.conversion = new FuelConsumption();
                    break;
                case 33:
                    Temp.conversion = new Potential();
                    break;
                case 34:
                    Temp.conversion = new Charge();
                    break;
                case 35:
                    Temp.conversion = new Current();
                    break;
                case 36:
                    Temp.conversion = new Dipole();
                    break;
                case 37:
                    Temp.conversion = new Luminance();
                    break;
                case 38:
                    Temp.conversion = new Illumination();
                    break;
                case 39:
                    Temp.conversion = new SolidAngle();
                    break;

            }
            Navigation.findNavController(v).navigate(R.id.unitconverter_child);
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

        void onHeaderRootViewClicked(@NonNull final ConverterSections section);

        void onItemRootViewClicked(@NonNull final ConverterSections section, final int itemAdapterPosition);
    }
}

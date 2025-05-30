package com.softgasm.calculatto;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.softgasm.calculatto.system.adapter.utils.SectionAdapter;
import com.softgasm.calculatto.system.adapter.utils.SectionInfoFactory;
import com.softgasm.calculatto.system.adapter.utils.SectionItemInfoDialog;
import com.softgasm.calculatto.system.adapter.utils.SectionItemInfoFactory;
import com.softgasm.calculatto.system.adapter.utils.SectionedRecyclerViewAdapter;
import com.softgasm.calculatto.ui.sections.ArraysOfSections;
import com.softgasm.calculatto.ui.sections.ConverterSections;

public class unitconverter extends Fragment implements ConverterSections.ClickListener{


    ConverterSections sectionAD;
    int itemAdapterPositionAD;
    private static final String DIALOG_TAG = "SectionItemInfoDialogTag";
    View view;
    private SectionedRecyclerViewAdapter sectionedAdapter;




    public unitconverter() {
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
        view = inflater.inflate(R.layout.fragment_unitconverter, container, false);
        sectionedAdapter = new SectionedRecyclerViewAdapter();

        sections();

        final RecyclerView recyclerView = view.findViewById(R.id.ucview);

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
                View v = inflater.inflate(R.layout.header_unitconverter, parent , false);
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
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.objectproperties),
                ArraysOfSections.uc_objectproperties(), this,  R.drawable.objectproperties));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.thermodynamics),
                ArraysOfSections.uc_thermodynamics(), this,  R.drawable.thermodynamics));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.electricity),
                ArraysOfSections.uc_electricity(), this,  R.drawable.electricity));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.fluids),
                ArraysOfSections.uc_liquid(), this,  R.drawable.liquid));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.mechanics),
                ArraysOfSections.uc_mechanics(), this,  R.drawable.mechanics));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.visual),
                ArraysOfSections.uc_visual(), this,  R.drawable.visual));
        sectionedAdapter.addSection(new ConverterSections(getString(R.string.others),
                ArraysOfSections.uc_others(), this,  R.drawable.otherunitconverter));
    }



    @Override
    public void onHeaderRootViewClicked(@NonNull final ConverterSections section) {
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
    public void onItemRootViewClicked(@NonNull ConverterSections section, int itemAdapterPosition) {
        sectionAD = section;
        itemAdapterPositionAD = itemAdapterPosition;
        final SectionItemInfoDialog dialog = SectionItemInfoDialog.getInstance(
                SectionItemInfoFactory.create(itemAdapterPositionAD, sectionedAdapter),
                SectionInfoFactory.create(sectionAD, sectionedAdapter.getAdapterForSection(sectionAD))
        );
        dialog.show(getParentFragmentManager(), DIALOG_TAG);
    }

}


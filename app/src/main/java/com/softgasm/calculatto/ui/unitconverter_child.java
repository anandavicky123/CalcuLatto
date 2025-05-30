package com.softgasm.calculatto.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.UnitConverterViewHolder;

import java.util.ArrayList;

public class unitconverter_child extends Fragment {

    View view;
    RecyclerView mRecycleView;
    ImageView icon;
    double DefaultValue = 1;
    String FromSymbol;
    ConversionMethods conversion;
    TextView hint, conversiontitle;
    private Spinner s_category, s_from;
    private EditText mEditText;

    public unitconverter_child() {
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
        view = inflater.inflate(R.layout.fragment_thefragments_unitconverter, container, false);
        conversion = Temp.conversion;
        hint = view.findViewById(R.id.unitconverterhint);


        return view;
    }


    private void initView() {
        icon = view.findViewById(R.id.unit_icon);
        conversiontitle = view.findViewById(R.id.unit_title);

        conversiontitle.setText(Temp.name);
        icon.setImageResource(Temp.icon);
        mEditText = view.findViewById(R.id.unit_value);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (App.NumberToWordsStatus(requireContext())) {
                    try {
                        if (s.toString().isEmpty()) {
                            hint.setText("");
                        } else {
                            hint.setText(Filters.number_toWords(Double.valueOf(s.toString())));
                        }
                    } catch (NumberFormatException ignored) {

                    }

                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        s_from = view.findViewById(R.id.unit_from);
        s_category = view.findViewById(R.id.unit_category);
        ArrayAdapter<String> categoryadapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, conversion.CategoryList());
        s_category.setAdapter(categoryadapter);
        mRecycleView = view.findViewById(R.id.unit_list);
        mRecycleView.setHasFixedSize(true);
        LinearLayoutManager mLayout = new LinearLayoutManager(requireContext());
        mRecycleView.setLayoutManager(mLayout);
        setRecyclerAdapter();


    }

    private ArrayList<ConverterItems> ConversionList() {
        return conversion.ItemList(CategoryPosition(), DefaultValue);
    }

    private void setRecyclerAdapter() {
        mRecycleView.setAdapter(new RecyclerView.Adapter<UnitConverterViewHolder>() {
            @NonNull
            @Override
            public UnitConverterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result_unit, parent, false);
                return new UnitConverterViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull UnitConverterViewHolder holder, int position) {
                ConverterItems ci = ConversionList().get(position);
                holder.tvName.setText(ci.name);
                holder.tvSymbol.setText(ci.symbol);
                holder.tvValue.setText(ci.valueOf);
            }

            @Override
            public int getItemCount() {
                return ListSize();
            }
        });
    }

    private int CategoryPosition() {
        return s_category.getSelectedItemPosition();
    }

    private int ListSize() {
        return ConversionList().size();
    }

    private void setFromSpinner() {
        String[] TheList = new String[ListSize()];
        for (int i = 0; i < ListSize(); i++) {
            TheList[i] = ConversionList().get(i).symbol;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, TheList);
        s_from.setAdapter(adapter);
    }


    @Override
    public void onStart() {
        super.onStart();

        initView();


        setFromSpinner();
        FromSymbol = s_from.getSelectedItem().toString();

        s_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setRecyclerAdapter();
                mEditText.setText("");
                setFromSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FromSymbol = s_from.getSelectedItem().toString();

                if (!mEditText.getText().toString().equals("")) {
                    try {
                        DefaultValue = conversion.FindValue(CategoryPosition(), FromSymbol, Double.parseDouble(mEditText.getText().toString()));
                    } catch (NumberFormatException ignored) {

                    }

                } else {
                    DefaultValue = 1;
                }

                setRecyclerAdapter();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (!s.toString().equals("")) {
                    try {
                        DefaultValue = conversion.FindValue(CategoryPosition(), FromSymbol, Double.parseDouble(s.toString()));
                    } catch (NumberFormatException ignored) {

                    }

                } else {
                    DefaultValue = 1;
                }

                setRecyclerAdapter();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
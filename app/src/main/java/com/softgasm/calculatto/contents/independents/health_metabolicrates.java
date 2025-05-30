package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.contents.Math2;


public class health_metabolicrates extends Fragment {

    Spinner g, he, we;
    TextView tv_bmr, tv_no, tv_light, tv_moderate, tv_heavy, tv_extreme;
    EditText e_age, e_height, e_weight, e_height2;

    int gender = 0, age = 0;
    double height, weight, bmr, no, light, moderate, heavy, extreme, gen;
    View view;

    public health_metabolicrates() {
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
        view = inflater.inflate(R.layout.fragment_metabolicrates, container, false);

        g = view.findViewById(R.id.mrate_gender);
        he = view.findViewById(R.id.mr_h);
        we = view.findViewById(R.id.mr_w);
        e_age = view.findViewById(R.id.mr_age);
        e_height = view.findViewById(R.id.mr_height);
        e_height2 = view.findViewById(R.id.mr_height2);
        e_weight = view.findViewById(R.id.mr_weight);
        tv_bmr = view.findViewById(R.id.mr_bmr);
        tv_no = view.findViewById(R.id.mr_sedentary);
        tv_light = view.findViewById(R.id.mr_lightexercise);
        tv_moderate = view.findViewById(R.id.mr_moderateexercise);
        tv_heavy = view.findViewById(R.id.mr_heavyexercise);
        tv_extreme = view.findViewById(R.id.mr_extremeexercise);


        String[] list_height = {("cm"), ("ft"), ("ft/in")};
        String[] list_weight = {("kg"), ("lb")};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_matrixspinner, list_height);
        he.setAdapter(adapter);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                requireContext(), R.layout.view_matrixspinner, list_weight);
        we.setAdapter(adapter1);


        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = position;
                result();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        he.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    e_height2.setVisibility(View.VISIBLE);
                } else {
                    e_height2.setVisibility(View.GONE);
                }
                result();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        we.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        e_age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e_height2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e_weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void result() {
        try {
            age = Integer.parseInt(e_age.getText().toString());
            height = Double.parseDouble(e_height.getText().toString());
            if (he.getSelectedItemPosition() == 1) {
                height = Math2.ft_toCm(height);
            } else if (he.getSelectedItemPosition() == 2) {
                double height2 = Math2.in_toft(Double.parseDouble(e_height2.getText().toString()));
                double height_pre = height + height2;
                height = Math2.ft_toCm(height_pre);
            }
            weight = Double.parseDouble(e_weight.getText().toString());
            if (we.getSelectedItemPosition() == 1) {
                weight = Math2.lb_toKg(weight);
            }

            if (gender == 1) {
                gen = 5;
            } else if (gender == 2) {
                gen = -161;
            }

            bmr = (10 * weight) + (6.25 * height) - (5 * age) + gen;
            no = bmr * 1.2;
            light = bmr * 1.375;
            moderate = bmr * 1.55;
            heavy = bmr * 1.9;
            extreme = bmr * 2.4;

            tv_bmr.setText(Filters.twobelowcomma(bmr) + " kcal/" + getString(R.string.day));
            tv_no.setText(Filters.twobelowcomma(no) + " kcal/" + getString(R.string.day));
            tv_light.setText(Filters.twobelowcomma(light) + " kcal/" + getString(R.string.day));
            tv_moderate.setText(Filters.twobelowcomma(moderate) + " kcal/" + getString(R.string.day));
            tv_heavy.setText(Filters.twobelowcomma(heavy) + " kcal/" + getString(R.string.day));
            tv_extreme.setText(Filters.twobelowcomma(extreme) + " kcal/" + getString(R.string.day));
        } catch (NullPointerException | NumberFormatException ignored) {

        }
    }
}
package com.softgasm.calculatto.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Math2;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.Temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class thefragments_arrays extends Fragment {

    View view;

    TextView result, list, labellist_tv, hint;

    Button add, reset;

    TextInputLayout labeltil;


    String req;
    AppCompatEditText et, et1;

    Double[] numberlist;

    RelativeLayout labellayout;
    List<Double> thelist;

    public thefragments_arrays() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_thefragments_arrays, container, false);
        req = Temp.req;

        ImageView icon = view.findViewById(R.id.unit_icon);
        icon.setImageResource(Temp.icon);

        TextView title = view.findViewById(R.id.unit_title);
        title.setText(Temp.name);


        list = view.findViewById(R.id.median_list);
        result = view.findViewById(R.id.median_result_tv);
        add = view.findViewById(R.id.median_add);
        reset = view.findViewById(R.id.median_reset);
        et = view.findViewById(R.id.median_et);
        et1 = view.findViewById(R.id.median_et1);
        labeltil = view.findViewById(R.id.median_til1);
        labellist_tv = view.findViewById(R.id.array_labelist);
        labellayout = view.findViewById(R.id.array_labellayout);
        hint = view.findViewById(R.id.hint);

        Space thespace = view.findViewById(R.id.thespace);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (App.NumberToWordsStatus(requireContext())) {
                    try {
                        if (!s.toString().isEmpty()) {
                            hint.setText(Filters.number_toWords(Double.parseDouble(s.toString())));
                        } else {
                            hint.setText("");
                        }
                    } catch (NumberFormatException e) {
                        hint.setText("");
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        if (!App.NumberToWordsStatus(requireContext())) {
            hint.setVisibility(View.GONE);
            thespace.setVisibility(View.VISIBLE);
        } else {
            hint.setVisibility(View.VISIBLE);
            thespace.setVisibility(View.GONE);
        }

        if (App.SubscriptionStatus(requireContext())) {
            labeltil.setVisibility(View.VISIBLE);
            labellayout.setVisibility(View.VISIBLE);
        } else {
            labeltil.setVisibility(View.GONE);
            labellayout.setVisibility(View.GONE);
        }


        thelist = new ArrayList<>();
        add.setOnClickListener(v -> {
            if (!Objects.requireNonNull(et.getText()).toString().isEmpty()) {
                String thenumberS = Objects.requireNonNull(et.getText()) + "\n";
                String takethelist = list.getText().toString();
                list.setText(takethelist + thenumberS);
                thelist.add(Double.valueOf(thenumberS));


                if (App.SubscriptionStatus(requireContext())) {
                    String labels;
                    if (Objects.requireNonNull(et1.getText()).toString().isEmpty()) {
                        labels = " " + "\n";
                    } else {
                        labels = et1.getText() + "\n";
                    }
                    String takethelabelist = labellist_tv.getText().toString();
                    labellist_tv.setText(takethelabelist + labels);
                    et1.setText("");
                }


                numberlist = new Double[thelist.size()];
                for (int i = 0; i < thelist.size(); i++)
                    numberlist[i] = thelist.get(i);
                Arrays.sort(numberlist);


                executer();
                et.setText("");
                hint.setText("");
            }
        });


        reset.setOnClickListener(v -> {
            result.setText("");
            list.setText("");
            if (App.SubscriptionStatus(requireContext())) {
                labellist_tv.setText("");
                et1.setText("");
            }


            thelist.removeAll(thelist);
            et.setText("");
            hint.setText("");
        });

        return view;
    }

    private void executer() {

        switch (req) {
            case "median":
                median();
                break;
            case "gl":
                gcflcm();
                break;
        }


    }


    private void median() {
        double m;
        double mean;
        double mode;

        if (numberlist.length % 2 == 0)
            m = ((double) numberlist[numberlist.length / 2] + numberlist[numberlist.length / 2 - 1]) / 2;
        else
            m = numberlist[numberlist.length / 2];


        mean = Math2.mean(numberlist);
        mode = Math2.mode(numberlist);

        String res = getString(R.string.median) + ": " + ftbc(m) + "\n" + getString(R.string.mean) + ": " + ftbc(mean) + "\n" + getString(R.string.modestatistic) + ": " + ftbc(mode);
        result.setText(res);


    }

    private void gcflcm() {

        double gcf = 0;
        double res = numberlist[0];
        for (double element : numberlist) {
            res = Math2.gcd(res, element);

            gcf = res;
        }

        double lcm = Arrays.stream(numberlist).reduce(
                1.0, (x, y) -> (x * y) / Math2.gcd(x, y));

        String ress = getString(R.string.gcf) + ": " + ftbc(gcf) + "\n\n" + getString(R.string.lcm) + ": " + ftbc(lcm);
        result.setText(ress);


    }


    private String ftbc(double result) {
        return Filters.twobelowcomma(result);
    }

}
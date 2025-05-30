package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

@SuppressLint("SetTextI18n")
public class vector extends Fragment {


    View view;

    TextView v1, v2, result;

    TextInputEditText ox1, ox2, oy1, oy2, oz1, oz2;

    Spinner dimen, cond;

    AppCompatButton calculate;

    ScrollView sv;

    public vector() {
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
        view = inflater.inflate(R.layout.fragment_vector, container, false);

        v1 = view.findViewById(R.id.v_vector1);
        v2 = view.findViewById(R.id.v_vector2);
        result = view.findViewById(R.id.v_result);
        calculate = view.findViewById(R.id.v_calculate);

        sv = view.findViewById(R.id.v_scrollview);

        dimen = view.findViewById(R.id.v_dimension);
        cond = view.findViewById(R.id.v_condition);

        ox1 = view.findViewById(R.id.v_x1);
        ox2 = view.findViewById(R.id.v_x2);
        oy1 = view.findViewById(R.id.v_y1);
        oy2 = view.findViewById(R.id.v_y2);
        oz1 = view.findViewById(R.id.v_z1);
        oz2 = view.findViewById(R.id.v_z2);


        v1.setText(getString(R.string.vector) + " 1");
        v2.setText(getString(R.string.vector) + " 2");

        oz1.setVisibility(View.GONE);
        oz2.setVisibility(View.GONE);

        String[] list2d = {(getString(R.string.addition)), (getString(R.string.subtraction)), (getString(R.string.scalarp))};
        ArrayAdapter<String> adapter2d = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list2d);


        dimen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    if (!App.SubscriptionStatus(requireContext())) {

                        Toast.makeText(requireContext(), R.string.premiumvectoralert, Toast.LENGTH_SHORT).show();
                        dimen.setSelection(0);
                    } else {
                        oz1.setVisibility(View.VISIBLE);
                        oz2.setVisibility(View.VISIBLE);

                        String[] list = {(getString(R.string.addition)), (getString(R.string.subtraction)), (getString(R.string.crossp)), (getString(R.string.scalarp))};
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
                        cond.setAdapter(adapter);
                    }
                } else {
                    oz1.setVisibility(View.GONE);
                    oz2.setVisibility(View.GONE);


                    cond.setAdapter(adapter2d);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        calculate.setOnClickListener(v -> {
            results();
            sv.post(() -> sv.fullScroll(View.FOCUS_DOWN));
        });


        return view;
    }


    private void results() {
        if (dimen.getSelectedItemPosition() == 1) {
            try {
                double x1 = dp(ox1.getText().toString());
                double x2 = dp(ox2.getText().toString());
                double y1 = dp(oy1.getText().toString());
                double y2 = dp(oy2.getText().toString());
                double z1 = dp(oz1.getText().toString());
                double z2 = dp(oz2.getText().toString());


                switch (cond.getSelectedItemPosition()) {
                    case 1: {
                        double xr = x1 - x2;
                        double yr = y1 - y2;
                        double zr = z1 - z2;

                        String res = "X = " + ftbc(xr) + "\n" + "Y = " + ftbc(yr) + "\n" + "Z = " + ftbc(zr);
                        setResult(res);
                    }
                    break;
                    case 2: {
                        double xr = (y1 * z2) - (z1 * y2);
                        double yr = (z1 * x2) - (x1 * z2);
                        double zr = (x1 * y2) - (y1 * x2);

                        String res = "X = " + ftbc(xr) + "\n" + "Y = " + ftbc(yr) + "\n" + "Z = " + ftbc(zr);
                        setResult(res);
                    }
                    break;
                    case 3: {
                        double xr = x1 * x2;
                        double yr = y1 * y2;
                        double zr = z1 * z2;

                        double finale = xr + yr + zr;

                        String res = getString(R.string.vector) + " 1 + " + getString(R.string.vector) + " 2 = " + ftbc(finale);
                        setResult(res);
                    }
                    break;
                    default: {
                        double xr = x1 + x2;
                        double yr = y1 + y2;
                        double zr = z1 + z2;

                        String res = "X = " + ftbc(xr) + "\n" + "Y = " + ftbc(yr) + "\n" + "Z = " + ftbc(zr);
                        setResult(res);
                    }
                    break;
                }


            } catch (NullPointerException | NumberFormatException e) {
                Toast.makeText(requireContext(), getString(R.string.somethingismissing), Toast.LENGTH_SHORT).show();
            }


        } else {
            try {
                double x1 = dp(ox1.getText().toString());
                double x2 = dp(ox2.getText().toString());
                double y1 = dp(oy1.getText().toString());
                double y2 = dp(oy2.getText().toString());


                switch (cond.getSelectedItemPosition()) {
                    case 1: {
                        double xr = x1 - x2;
                        double yr = y1 - y2;

                        String res = "X = " + ftbc(xr) + "\n" + "Y = " + ftbc(yr);
                        setResult(res);
                    }
                    break;
                    case 2: {
                        double xr = x1 * x2;
                        double yr = y1 * y2;
                        double finale = xr + yr;

                        String res = getString(R.string.vector) + " 1 + " + getString(R.string.vector) + " 2 = " + ftbc(finale);
                        setResult(res);
                    }
                    break;
                    default: {
                        double xr = x1 + x2;
                        double yr = y1 + y2;

                        String res = "X = " + ftbc(xr) + "\n" + "Y = " + ftbc(yr);
                        setResult(res);
                    }
                    break;
                }

            } catch (NullPointerException | NumberFormatException e) {
                Toast.makeText(requireContext(), getString(R.string.somethingismissing), Toast.LENGTH_SHORT).show();
            }
        }
    }


    private double dp(String text) {
        return Double.parseDouble(text);
    }

    private String ftbc(double result) {
        return Filters.twobelowcomma(result);
    }

    private void setResult(String theresult) {
        result.setText(theresult);
    }
}
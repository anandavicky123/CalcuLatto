package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.App;

import java.math.BigDecimal;
import java.math.MathContext;

import ch.obermuhlner.math.big.BigDecimalMath;

public class longbasic extends Fragment {


    View view;


    Spinner main, sfirst, ssecond, operator_edit;
    TextView results_tv;
    TextInputEditText efirst, esecond;

    TextInputLayout tlfirst, tlsecond;

    EditText precision_edit;

    CharSequence aa, bb;

    MathContext mc;

    BigDecimal result;

    int precision = 20, type = 0, operator = 0, tfirst = 0, tsecond = 0;

    public longbasic() {
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
        view = inflater.inflate(R.layout.fragment_longbasic, container, false);


        main = view.findViewById(R.id.main_spinner);
        sfirst = view.findViewById(R.id.first_spinner);
        ssecond = view.findViewById(R.id.second_spinner);
        operator_edit = view.findViewById(R.id.operator);
        results_tv = view.findViewById(R.id.result);
        efirst = view.findViewById(R.id.first_edittext);
        esecond = view.findViewById(R.id.second_edittext);
        precision_edit = view.findViewById(R.id.precision);
        tlfirst = view.findViewById(R.id.first_edittext_tl);
        tlsecond = view.findViewById(R.id.second_edittext_tl);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mc = new MathContext(precision);

        main.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = position;
                if (position == 1) {
                    operator_edit.setVisibility(View.GONE);
                    tlsecond.setVisibility(View.GONE);
                    ssecond.setVisibility(View.GONE);

                    sfirst.setVisibility(View.VISIBLE);

                }
                if (position == 2) {
                    if (!App.SubscriptionStatus(requireContext())) {
                        Toast.makeText(requireContext(), R.string.premiumlongbasicalert, Toast.LENGTH_SHORT).show();
                        main.setSelection(0);
                    } else {
                        operator_edit.setVisibility(View.VISIBLE);
                        tlsecond.setVisibility(View.VISIBLE);
                        ssecond.setVisibility(View.VISIBLE);
                        sfirst.setVisibility(View.VISIBLE);
                    }
                }
                if (position == 0) {
                    tlsecond.setVisibility(View.VISIBLE);
                    sfirst.setVisibility(View.GONE);
                    ssecond.setVisibility(View.GONE);
                    operator_edit.setVisibility(View.VISIBLE);
                }

                resultMethods();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        precision_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (!(count == 0) || !(s.toString().equals("0"))) {
                        precision = Integer.parseInt(s.toString());
                    } else {
                        precision = 1;
                    }
                    mc = new MathContext(precision);
                    resultMethods();
                } catch (NullPointerException | NumberFormatException ignored) {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        efirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                aa = s;
                resultMethods();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        esecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bb = s;
                resultMethods();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        operator_edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operator = position;
                resultMethods();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sfirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tfirst = position;
                resultMethods();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tsecond = position;
                resultMethods();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void resultMethods() {
        try {
            if (type == 1) {
                trigonometrics();
            } else if (type == 2) {
                combinations();
            } else {
                arithmetics();
            }
        } catch (NullPointerException | NumberFormatException ignored) {
        }

    }


    private void arithmetics() {
        BigDecimal first = new BigDecimal(aa.toString());
        BigDecimal second = new BigDecimal(bb.toString());

        bd_a(first, second);
        showResults();
//        System.out.println(BigDecimalMath.sqrt(result, new MathContext(precision)));

    }

    private void trigonometrics() {
        BigDecimal first = new BigDecimal(aa.toString());
        result = bd_t(first, tfirst);
        showResults();
    }


    private void combinations() {
        BigDecimal first = bd_t(new BigDecimal(aa.toString()), tfirst);
        BigDecimal second = bd_t(new BigDecimal(bb.toString()), tsecond);

        bd_a(first, second);
        showResults();

    }

    private BigDecimal bd_t(BigDecimal bd, int position) {
        try {
            switch (position) {
                case 1:
                    return BigDecimalMath.cos(bd, mc);
                case 2:
                    return BigDecimalMath.tan(bd, mc);
                case 3:
                    return BigDecimalMath.asin(bd, mc);
                case 4:
                    return BigDecimalMath.acos(bd, mc);
                case 5:
                    return BigDecimalMath.atan(bd, mc);
                case 6:
                    return BigDecimalMath.log(bd, mc);
                case 7:
                    return BigDecimalMath.log2(bd, mc);
                case 8:
                    return BigDecimalMath.log10(bd, mc);
                case 9:
                    return BigDecimalMath.sqrt(bd, mc);
                default:
                    return BigDecimalMath.sin(bd, mc);
            }
        } catch (ArithmeticException e){
            results_tv.setText("???");
            return null;
        }
    }

    private void bd_a(BigDecimal bd1, BigDecimal bd2) {
        switch (operator) {
            case 1:
                result = bd1.subtract(bd2, mc);
                break;
            case 2:
                result = bd1.multiply(bd2, mc);
                break;
            case 3:
                result = bd1.divide(bd2, mc);
                break;
            default:
                result = bd1.add(bd2, mc);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void showResults() {
        results_tv.setText(result.toString());
    }


}
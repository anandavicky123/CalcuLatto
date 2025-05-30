package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.Filters;

public class numeral_systems extends Fragment {


    EditText et_decimal, et_bin, et_hex, et_oct, et_3, et_5, et_7, et_11, et_12;

    long decimal = 0;

    String access = "free";

    public numeral_systems() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_numeral_systems, container, false);


        et_decimal = view.findViewById(R.id.ns_decimal);
        et_bin = view.findViewById(R.id.ns_binary);
        et_hex = view.findViewById(R.id.ns_hexa);
        et_oct = view.findViewById(R.id.ns_octal);
        et_3 = view.findViewById(R.id.ns_base3);
        et_5 = view.findViewById(R.id.ns_base5);
        et_7 = view.findViewById(R.id.ns_base7);
        et_11 = view.findViewById(R.id.ns_base11);
        et_12 = view.findViewById(R.id.ns_base12);


        String hexregex = "^[0-9A-F]+$";
        et_hex.setFilters(Filters.inputfilters(hexregex));


        et_decimal.setOnFocusChangeListener((view, b) -> access = "decimal");

        et_hex.setOnFocusChangeListener((view, b) -> access = "hex");

        et_bin.setOnFocusChangeListener((view, b) -> access = "bin");

        et_oct.setOnFocusChangeListener((view, b) -> access = "oct");

        et_3.setOnFocusChangeListener((view, b) -> access = "3");
        et_5.setOnFocusChangeListener((view, b) -> access = "5");
        et_7.setOnFocusChangeListener((view, b) -> access = "7");
        et_11.setOnFocusChangeListener((view, b) -> access = "11");
        et_12.setOnFocusChangeListener((view, b) -> access = "12");

        et_decimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("decimal")) {
                    if (!et_decimal.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_decimal.getText().toString());
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


        et_hex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("hex")) {
                    if (!et_hex.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_hex.getText().toString(), 16);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        et_bin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("bin")) {
                    if (!et_bin.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_bin.getText().toString(), 2);
                            toDecimal();
                            decimal_to_hex();
                            decimal_to_octal();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        et_oct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("oct")) {
                    if (!et_oct.getText().toString().isEmpty()) {

                        try {
                            decimal = Long.parseLong(et_oct.getText().toString(), 8);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("3")) {
                    if (!et_3.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_3.getText().toString(), 3);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("5")) {
                    if (!et_5.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_5.getText().toString(), 5);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_7();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_7.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("7")) {
                    if (!et_7.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_7.getText().toString(), 7);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_11();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_11.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("11")) {
                    if (!et_11.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_11.getText().toString(), 11);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_12();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_12.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (access.equals("12")) {
                    if (!et_12.getText().toString().isEmpty()) {
                        try {
                            decimal = Long.parseLong(et_12.getText().toString(), 12);
                            toDecimal();
                            decimal_to_binary();
                            decimal_to_octal();
                            decimal_to_hex();
                            decimal_to_3();
                            decimal_to_5();
                            decimal_to_7();
                            decimal_to_11();
                        } catch (NumberFormatException e) {
                            Log.e("NumberFormatException", "Limit reached", e);
                        }
                    } else {
                        et_decimal.setText("");
                        et_oct.setText("");
                        et_hex.setText("");
                        et_bin.setText("");
                        et_3.setText("");
                        et_5.setText("");
                        et_7.setText("");
                        et_11.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }


    private void decimal_to_binary() {
        String result = Long.toBinaryString(decimal);
        et_bin.setText(result);

    }

    private void decimal_to_octal() {
        String result = Long.toOctalString(decimal);
        et_oct.setText(result);

    }

    private void decimal_to_hex() {
        String result = Long.toHexString(decimal);
        et_hex.setText(result.toUpperCase());
    }

    private void decimal_to_3() {
        int condition = 3;
        long num = decimal;
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % condition * factor;
            num /= condition;
            factor *= 10;
        }
        et_3.setText(String.valueOf(ret));
    }

    private void decimal_to_5() {
        int condition = 5;
        long num = decimal;
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % condition * factor;
            num /= condition;
            factor *= 10;
        }
        et_5.setText(String.valueOf(ret));
    }

    private void decimal_to_7() {
        int condition = 7;
        long num = decimal;
        long ret = 0, factor = 1;
        while (num > 0) {
            ret += num % condition * factor;
            num /= condition;
            factor *= 10;
        }
        et_7.setText(String.valueOf(ret));
    }

    private void decimal_to_11() {
        et_11.setText(toBase11(decimal));
    }

    private void decimal_to_12() {
        et_12.setText(toBase12(decimal));
    }

    private void toDecimal() {
        et_decimal.setText(String.valueOf(decimal));
    }

    public static String toBase12(long n) {
        if (n < 10)
            return Long.toString(n); // or  String.valueOf(n)  or  "" + n
        if (n == 10)
            return "A";
        if (n == 11)
            return "B";
        return toBase12(n / 12) + toBase12(n % 12);
    }
    public static String toBase11(long n) {
        if (n < 10)
            return Long.toString(n); // or  String.valueOf(n)  or  "" + n
        if (n == 10)
            return "A";
        return toBase11(n / 11) + toBase11(n % 11);
    }
}
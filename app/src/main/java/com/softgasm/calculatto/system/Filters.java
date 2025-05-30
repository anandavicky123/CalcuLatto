package com.softgasm.calculatto.system;

import static com.softgasm.calculatto.system.App.DeviceLocale;

import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filters {
    public static String rd(Double result_to_display){
        NumberFormat format = new DecimalFormat("0.######");

        return String.valueOf(format.format(result_to_display));
    }

    public static String twobelowcomma(Double result_to_display){
        NumberFormat format = new DecimalFormat("0.##");

        return String.valueOf(format.format(result_to_display));
    }

    public static String nocomma(Double result_to_display){
        NumberFormat format = new DecimalFormat("0");

        return String.valueOf(format.format(result_to_display));
    }


    public static boolean isInteger(String numericValue) {
        if (numericValue == null) return false;
        try {
            Integer.parseInt(numericValue);
            return true;
        } catch (NumberFormatException e) {
            if (numericValue.equals("π") || numericValue.equals("℮") || numericValue.equals("φ")) {
                return true;
            } else return numericValue.equals(")");
        }
    }

    public static InputFilter[] inputfilters (String regex) {
        return new InputFilter[]{new InputFilter() {

            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                boolean keepOriginal = true;
                StringBuilder sb = new StringBuilder(end - start);
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    if (isCharAllowed(c)) // put your condition here
                        sb.append(c);
                    else
                        keepOriginal = false;
                }
                if (keepOriginal)
                    return null;
                else {
                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(sb);
                        TextUtils.copySpansFrom((Spanned) source, start, sb.length(), null, sp, 0);
                        return sp;
                    } else {
                        return sb;
                    }
                }
            }

            private boolean isCharAllowed(char c) {
                Pattern ps = Pattern.compile(regex);
                Matcher ms = ps.matcher(String.valueOf(c));
                return ms.matches();
            }
        }};
    }


    public static String number_toWords(Double number) {
        Locale local = App.getSystemLocale();
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(local, RuleBasedNumberFormat.SPELLOUT);
        return ruleBasedNumberFormat.format(number);
    }

    public static String CountryName(String code){
        return new Locale(DeviceLocale().getLanguage(), code).getDisplayCountry();
    }

}

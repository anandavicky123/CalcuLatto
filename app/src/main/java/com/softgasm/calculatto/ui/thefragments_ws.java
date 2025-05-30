package com.softgasm.calculatto.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Math2;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.CustomPagerAdapter;

import org.apache.commons.math3.special.Gamma;

import java.util.Arrays;

@SuppressLint("SetTextI18n")
public class thefragments_ws extends Fragment {

    TextInputLayout l1, l2, l3, l4, l5;

    TextView tr, h1, h2, h3, h4, h5;

    Spinner sMS;

    int MS = 0, active = 1;

    AppCompatEditText e1, e2, e3, e4, e5;

    String req, e1r, e2r, e3r, e4r, e5r, title;

    boolean visible2 = false, visible3 = false, visible4 = false, visible5 = false;
    View view;

    ViewPager viewpager;
    TabLayout tl;

    public thefragments_ws() {
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
        view = inflater.inflate(R.layout.fragment_thefragments_ws, container, false);

        return view;
    }

    private void preparation() {
        switch (req) {
            case "%":
                needMS();
                only2();

                String[] ac1 = {(getString(R.string.difference)), (getString(R.string.change)), (getString(R.string.increase)), (getString(R.string.decrease))};
                setadapterMS(ac1);
                l1.setHint(getString(R.string.value));
                l2.setHint(getString(R.string.percentagepercentage));
                break;
            case "roman":
                MSless();
                only1();

                l1.setHint(getString(R.string.value));

                break;
            case "odds":
                MSless();
                only2();

                l1.setHint(getString(R.string.chancesofsuccess));
                l2.setHint(getString(R.string.chancesoflose));

                break;
            case "fraction":
                needMS();
                String[] aa = {(getString(R.string.fraction)), (getString(R.string.percentagepercentage)), (getString(R.string.decimal))};
                setadapterMS(aa);
                only2();

                l1.setHint(getString(R.string.chancesofsuccess));
                l2.setHint(getString(R.string.chancesoflose));
                break;
            case "modulo":
                MSless();
                only2();

                l1.setHint(getString(R.string.dividenty));
                l2.setHint(getString(R.string.divisorx));

                break;
            case "gl":
                MSless();
                only2();

                l1.setHint("A");
                l2.setHint("B");

                break;
            case "bco":
                MSless();
                only2();

                l1.setHint("n");
                l2.setHint("k");

                break;
            case "gfu":
                MSless();
                only1();

                l1.setHint("x");

                break;
            case "cnp":
                MSless();
                only2();

                l1.setHint(getString(R.string.totalnumbersofobjects));
                l2.setHint(getString(R.string.samplesize));

                break;
            case "probability":
                needMS();
                only2();
                String[] axa = {(getString(R.string.twoevents)), (getString(R.string.threeevents))};
                setadapterMS(axa);

                l1.setHint("P(A)");
                l2.setHint("P(B)");
                l3.setHint("P(C)");
                break;
            case "radical":
                MSless();
                only2();

                l1.setHint(getString(R.string.number));
                l2.setHint(getString(R.string.radicaldegree));
                break;
            case "poe":
                MSless();
                only1();

                l1.setHint(getString(R.string.number));
                break;
            case "leq":
                needMS();
                String[] leqq = {("1D"), ("2D")};
                setadapterMS(leqq);
                only2();

                l1.setHint("A");
                l2.setHint("B");
                break;
            case "ratio":
                needMS();
                String[] ratios = {(getString(R.string.simplify)), (getString(R.string.enlarge)), (getString(R.string.reduce)), ("n:1"), ("1:n")};
                setadapterMS(ratios);
                only2();

                l1.setHint("A");
                l2.setHint("B");
                break;
            case "clock":
                needMS();
                String[] fdadsda = {(getString(R.string.degree)), (getString(R.string.radian))};
                setadapterMS(fdadsda);
                only2();

                l1.setHint(getString(R.string.hour));
                l2.setHint(getString(R.string.minute));
                break;
            case "coin":
                MSless();
                only2();


                l1.setHint(getString(R.string.numberofflips));
                l2.setHint(getString(R.string.heads));
                break;
            case "dice":
                needMS();
                String[] dfafas = {(getString(R.string.diceone)), (getString(R.string.dicetwo)), (getString(R.string.dicethree)), (getString(R.string.dicefour))};
                setadapterMS(dfafas);
                only2();


                l1.setHint(getString(R.string.diceface));
                l2.setHint(getString(R.string.totaldices));
                l3.setHint(getString(R.string.targetvalue));
                e1.setText("6");
                e2.setText("2");
                break;
            case "bloodp":
                MSless();
                only2();


                l1.setHint("Systolic");
                l2.setHint("Diastolic");
                break;

            case "calco":
                needMS();
                only2();
                String[] afasaaa = {("mg/dL"), ("mmol/L")};
                setadapterMS(afasaaa);


                l1.setHint(getString(R.string.serumcalcium) + " mg/dL");
                l2.setHint(getString(R.string.albumin_hint) + " g/dL");
                break;
        }
    }


    private void sMSListener() {
        sMS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MS = position;
                switch (req) {
                    case "fraction":
                        if (!(position == 0)) {
                            only1();
                            l1.setHint(getString(R.string.value));
                        } else {
                            only2();
                            l1.setHint(getString(R.string.value) + " (A/b)");
                            l2.setHint(getString(R.string.value) + " (a/B)");
                        }
                        break;
                    case "probability":
                        if (position == 1) {
                            only3();
                        } else {
                            only2();
                        }
                        break;
                    case "leq":
                        if (position == 1) {
                            only4();
                            l1.setHint("X1");
                            l2.setHint("Y1");
                            l3.setHint("X2");
                            l4.setHint("Y2");
                        } else {
                            only2();

                            l1.setHint("A");
                            l2.setHint("B");
                        }
                        break;
                    case "ratio":
                        if (position == 1 || position == 2) {
                            only3();
                            l1.setHint("X1");
                            l2.setHint("Y1");
                            l3.setHint(sMS.getSelectedItem().toString() + " " + getString(R.string.to));
                        } else {
                            only2();

                            l1.setHint("A");
                            l2.setHint("B");
                        }
                        break;
                    case "dice":
                        if (!(position == 0)) {
                            only3();
                        } else {
                            only2();
                        }
                        break;
                    case "calco":
                        if (position == 1) {
                            l1.setHint(getString(R.string.serumcalcium) + " mmol/L");
                            l2.setHint(getString(R.string.albumin_hint) + " g/L");
                        } else {
                            l1.setHint(getString(R.string.serumcalcium) + " mg/dL");
                            l2.setHint(getString(R.string.albumin_hint) + " g/dL");
                        }
                        break;
                    case "%":
                        if (position == 1) {
                            l1.setHint(getString(R.string.value) + " A");
                            l2.setHint(getString(R.string.value) + " B");
                        } else if (position == 2 || position == 3) {
                            l1.setHint(getString(R.string.from));
                            l2.setHint(getString(R.string.by) + " (%)");
                        } else {
                            l1.setHint(getString(R.string.value));
                            l2.setHint(getString(R.string.percentagepercentage));
                        }
                        break;
                }
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void calculations() {
        getStrings();

        if (!ec(active)) {
            try {
                switch (req) {
                    case "%":
                        percentage();
                        break;
                    case "roman":
                        roman();
                        break;
                    case "odds":
                        odds();
                        break;
                    case "fraction":
                        fraction();
                        break;
                    case "modulo":
                        modulo();
                        break;
                    case "gl":
                        gcflcm();
                        break;
                    case "bco":
                        bco();
                        break;
                    case "cnp":
                        cnp();
                        break;
                    case "probability":
                        probs();
                        break;
                    case "radical":
                        radical();
                        break;
                    case "poe":
                        poe();
                        break;
                    case "leq":
                        leq();
                        break;
                    case "ratio":
                        ratio();
                        break;
                    case "clock":
                        clock();
                        break;
                    case "gfu":
                        gfu();
                        break;
                    case "coin":
                        coin();
                        break;
                    case "dice":
                        dice();
                        break;
                    case "bloodp":
                        bloodp();
                        break;
                    case "calco":
                        calco();
                        break;

                }
            } catch (NumberFormatException ignored) {

            }

        }

    }


    private void calco() {
        double albumin = dp(e2r);
        double serum = dp(e1r);
        double measurement;
        String mea = sMS.getSelectedItem().toString();
        int na;

        if (MS == 1) {
            measurement = 0.02;
            na = 40;
        } else {
            measurement = 0.8;
            na = 4;
        }

        double result = (measurement * (na - albumin)) + serum;

        tr.setText(title + ":\n" + frd(result) + mea);
    }


    private void bloodp() {
        int systolic = Integer.parseInt(e1r);
        int diastolic = Integer.parseInt(e2r);

        if (systolic <= 89 && diastolic <= 59) {
            tr.setText(getString(R.string.lowbp));
        } else if ((systolic >= 70 && systolic <= 119) && (diastolic >= 40 && diastolic <= 79)) {
            tr.setText(getString(R.string.idealbp));
        } else if ((systolic >= 120 && systolic <= 139) && (diastolic <= 80) || (systolic >= 81 && systolic <= 139) && (diastolic >= 80 && diastolic <= 89)) {
            tr.setText(getString(R.string.highbp1));
        } else if ((systolic >= 140 && systolic <= 190 || diastolic >= 90 && diastolic <= 100)) {
            tr.setText(getString(R.string.highbp2));
        } else {
            tr.setText(getString(R.string.invalid));
        }
    }

    private void dice() {

        int faces = Integer.parseInt(e1r);
        int dices = Integer.parseInt(e2r);
        int target = 0;
        int ax;
        double aaa;
        if (active == 3) {
            target = Integer.parseInt(e3r);
        }
        double result;
        switch (MS) {
            case 1:
                ax = faces - target + 1;
                aaa = ax * (1f / faces);
                result = Math.pow(aaa, dices);
                setResult(getString(R.string.probability), frd(result));
                break;
            case 2:
                ax = target;
                aaa = ax * (1f / faces);
                result = Math.pow(aaa, dices);
                setResult(getString(R.string.probability), frd(result));
                break;
            case 3:
                if (dices < 1 || target < dices || target > faces * dices) {
                    result = 0;
                } else {
                    long[][] mem = new long[dices][target];
                    for (long[] mi : mem) {
                        Arrays.fill(mi, 0L);
                    }
                    long n = Math2.whatAreTheOddsRec(target, dices, mem, faces);
                    result = n / Math.pow(faces, dices);
                }
                setResult(getString(R.string.probability), frd(result));
                break;
            default:
                result = Math.pow((1f / faces), dices);
                setResult(getString(R.string.probability), frd(result));
                break;

        }
    }


    private void coin() {
        double trials = dp(e1r);
        double heads = dp(e2r);
        double possibles = Math.pow(2, trials);
        double favors = Math2.subfactorial(trials) / (Math2.subfactorial(heads) * Math2.subfactorial(trials - heads));
        double aaa = favors / possibles;
        String possibilities = getString(R.string.probability) + ": " + frd(aaa) + " (" + ftbc(favors) + "/" + ftbc(possibles) + ")" + "\n";
        String percentage = getString(R.string.percentage) + ": " + ftbc(aaa * 100) + "%";
        tr.setText(possibilities + percentage);
    }


    private void gfu() {
        double x = dp(e1r);
        double loggamma = Gamma.logGamma(x);
        double gam = Gamma.gamma(x);
        double digamma = Gamma.digamma(x);
        double trigamma = Gamma.trigamma(x);
        double lanczos = Gamma.lanczos(x);


        tr.setText("Gamma" + ": " + ftbc(gam) + "\n" + "Digamma" + ": " + frd(digamma) + "\n" + "Trigamma" + ": " + frd(trigamma) + "\n" + "Log gamma" + ": " + frd(loggamma) + "\n" + "Lanczos" + ": " + frd(lanczos));

    }


    private void clock() {
        double hour = dp(e1r);
        double minute = dp(e2r);

        double h = (hour % 12 * 30) + (minute / 60 * 30);

        // Degree covered by minute hand (Each minute = 6 degree)
        double m = minute * 6;

        // Absolute angle between them
        double angle = Math.abs(m - h);

        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
        if (angle > 180) angle = 360.0 - angle;
        if (MS == 1) {
            angle = Math.toRadians(angle);
        }

        setResult(title, ftbc(angle));
    }


    private void ratio() {
        if (MS == 1) {

            double a = dp(e1r);
            double b = dp(e2r);
            double condition = dp(e3r);


            String res = ftbc(a * condition) + " : " + ftbc(b * condition);

            setResult(title, res);

        } else if (MS == 2) {

            double a = dp(e1r);
            double b = dp(e2r);
            double condition = dp(e3r);


            String res = ftbc(a / condition) + " : " + ftbc(b / condition);

            setResult(title, res);

        } else if (MS == 3) {

            double a = dp(e1r);
            double b = dp(e2r);

            String res = ftbc(a / b) + " : " + ftbc(1.0);

            setResult(title, res);

        } else if (MS == 4) {

            double a = dp(e1r);
            double b = dp(e2r);

            String res = ftbc(1.0) + " : " + ftbc(b / a);

            setResult(title, res);

        } else {

            double a = dp(e1r);
            double b = dp(e2r);


            double gcf = Math2.gcd(a, b);
            String res = ftbc(a / gcf) + " : " + ftbc(b / gcf);

            setResult(title, res);

        }
    }


    private void leq() {
        if (MS == 1) {

            double xo = dp(e1r);
            double yo = dp(e2r);
            double xt = dp(e3r);
            double yt = dp(e4r);

            double a = (yt - yo) / (xt - xo);
            double b = yo - a * xo;

            double aa = yt - yo;
            double bb = xo - xt;
            double c = yo * (xt - xo) - (yt - yo) * xo;


            String minus_string = "- ";
            String plus_string = "+ ";

            String first_operator = plus_string;
            String second_operator = plus_string;
            String third_operator = plus_string;
            if (bb < 0) {
                bb = bb * -1;
                first_operator = minus_string;
            }
            if (c < 0) {
                c = c * -1;
                second_operator = minus_string;
            }
            if (b < 0) {
                b = b * -1;
                third_operator = minus_string;
            }

            String sie = getString(R.string.slopeinterceptequation) + ": y = " + frd(a) + "x " + third_operator + frd(b);
            if (aa == 0 && bb == 0) {
                sie = getString(R.string.slopeinterceptequation) + ": " + "0";
            } else if (aa == 0) {
                sie = getString(R.string.slopeinterceptequation) + ": y = " + ftbc(yo);
            } else if (bb == 0) {
                sie = getString(R.string.slopeinterceptequation) + ": x = " + ftbc(xo);
            }
            String ge = getString(R.string.generalequation) + ": " + ftbc(aa) + "x " + first_operator + ftbc(bb) + "y " + second_operator + ftbc(c) + " = 0";
            if (aa == 0 && bb == 0) {
                ge = getString(R.string.generalequation) + ": " + "0";
            } else if (aa == 0) {
                ge = getString(R.string.generalequation) + ": " + ftbc(bb) + "y " + second_operator + ftbc(c) + " = 0";
            } else if (bb == 0) {
                ge = getString(R.string.generalequation) + ": " + ftbc(aa) + "x " + second_operator + ftbc(c) + " = 0";
            }
            String result = sie + "\n" + ge;
            setResult(title, result);

        } else {

            double x = dp(e1r);
            double y = dp(e2r);

            double result = (y / x) * -1;

            setResult(title, ftbc(result));

        }

    }

    private void poe() {

        int myNumber = Integer.parseInt(e1r);

        boolean even = false;
        boolean prime = true;

        if (myNumber % 2 == 0) {
            even = true;
            prime = false;
        } else {
            for (int i = 3; i * i <= myNumber; i += 2) {
                if (myNumber % i == 0) {
                    prime = false;
                    break;
                }
            }
        }


        String oddd = myNumber + " " + getString(R.string.grammaris) + "\n" + getString(R.string.oddnumber);
        if (myNumber == 1) {
            tr.setText(oddd);
        } else if (myNumber == 2) {
            tr.setText(myNumber + " " + getString(R.string.grammaris) + "\n" + getString(R.string.bothevenprime));
        } else {
            if (even) {
                tr.setText(myNumber + " " + getString(R.string.grammaris) + "\n" + getString(R.string.evennumber));
            } else {
                if (prime) {
                    tr.setText(myNumber + " " + getString(R.string.grammaris) + "\n" + getString(R.string.primenumber));
                } else {
                    tr.setText(oddd);
                }
            }

        }
    }


    private void radical() {

        double num = dp(e1r);
        double n = dp(e2r);

        double xPre = Math.random() % 10;
        double error = 0.0000001;
        double delX = 2147483647;
        double current = 0.0;

        while (delX > error) {
            current = ((n - 1.0) * xPre + num / Math.pow(xPre, n - 1)) / n;
            delX = Math.abs(current - xPre);
            xPre = current;
        }

        double nth = current * 1000.0 / 1000.0;
        setResult(title, frd(nth));

    }


    private void probs() {

        if (MS == 1) {

            double a = dp(e1r);
            double b = dp(e2r);
            double c = dp(e3r);


            double a_todec = a / 100;
            double b_todec = b / 100;
            double c_todec = c / 100;

            double all_o = a_todec * b_todec * c_todec;
            double one_c = a_todec + b_todec + c_todec - (a_todec * b_todec) - (a_todec * c_todec) - (b_todec * c_todec) + all_o;
            double one_exact = a_todec * (1 - b_todec) * (1 - c_todec) + (1 - a_todec) * b_todec * (1 - c_todec) + (1 - a_todec) * (1 - b_todec) * c_todec;
            double none = 1 - one_c;

            String aaa = "P(A ∩ B ∩ C): " + frd(all_o * 100) + "%\n";
            String bbb = "P(A ∪ B ∪ C): " + frd(one_c * 100) + "%\n";
            String ccc = "P(A∩B'∩C')+P(A'∩B∩C')+P(A'∩B'∩C): " + frd(one_exact * 100) + "%\n";
            String ddd = "P(∅): " + frd(none * 100) + "%";

            tr.setText(aaa + bbb + ccc + ddd);

        } else {

            double a = dp(e1r);
            double b = dp(e2r);

            double a_todec = a / 100;
            double b_todec = b / 100;


            double intersection = a_todec * b_todec;
            double union = (a_todec + b_todec) - intersection;
            double sym_diff = union - intersection;
            double complement = 1 - union;
            double no_a = 1 - a_todec;
            double no_b = 1 - b_todec;

            String aaa = "P(A∩B): " + ftbc(intersection * 100) + "%\n";
            String bbb = "P(A∪B): " + ftbc(union * 100) + "%\n";
            String ccc = "P(A∆B): " + ftbc(sym_diff * 100) + "%\n";
            String ddd = "P((A∪B)'): " + ftbc(complement * 100) + "%\n";
            String eee = "P(A'): " + ftbc(no_a * 100) + "%\n";
            String fff = "P(B'): " + ftbc(no_b * 100) + "%";

            tr.setText(aaa + bbb + ccc + ddd + eee + fff);

        }

    }


    private void cnp() {

        double n = dp(e1r);
        double r = dp(e2r);


        double per = Math2.subfactorial(n) / Math2.subfactorial(n - r);
        double comb = Math2.subfactorial(n) / (Math2.subfactorial(r) * Math2.subfactorial(n - r));
        if (r > n) {
            per = 0;
            comb = 0;
        }
        double perr = Math.pow(n, r);
        double combr = Math2.subfactorial(n + r - 1) / (Math2.subfactorial(r) * Math2.subfactorial(n - 1));


        tr.setText(getString(R.string.combination) + ": " + ftbc(comb) + "\n" + getString(R.string.permutation) + ": " + ftbc(per) + "\n" + getString(R.string.combinationr) + ": " + ftbc(combr) + "\n" + getString(R.string.permutationr) + ": " + ftbc(perr));

    }

    private void bco() {

        double n = dp(e1r);
        double k = dp(e2r);
        double binomial;

        if (k > n - k)
            k = n - k;

        double b = 1;
        for (double i = 1, m = n; i <= k; i++, m--)
            b = b * m / i;
        binomial = b;


        setResult(title, ftbc(binomial));

    }


    private void gcflcm() {

        double a = dp(e1r);
        double b = dp(e2r);

        String gcf = ftbc(Math2.gcd(a, b));
        String lcm = ftbc(Math2.lcm(a, b));

        tr.setText(getString(R.string.gcf) + ": " + gcf + "\n" + getString(R.string.lcm) + ": " + lcm);

    }

    private void modulo() {

        double x = dp(e1r);
        double y = dp(e2r);

        double aaa = x % y;
        String res = ftbc(aaa);

        setResult(getString(R.string.remainderr), res);

    }


    private void fraction() {
        if (MS == 1) {

            double a = dp(e1r);

            double decimal = a / 100;
            String fraction = Math2.convertDecimalToFraction(decimal);


            tr.setText(getString(R.string.decimal) + ": " + frd(decimal) + "\n" + getString(R.string.fraction) + ": " + fraction);

        } else if (MS == 2) {

            double a = dp(e1r);

            double percentage = a * 100;
            String fraction = Math2.convertDecimalToFraction(a);


            tr.setText(getString(R.string.percentagepercentage) + ": " + ftbc(percentage) + "\n" + getString(R.string.fraction) + ": " + fraction);

        } else {

            double a = dp(e1r);
            double b = dp(e2r);

            double decimals = a / b;
            double percentage = decimals * 100;
            String simplified;
            double s = Math2.gcd(a, b);
            if (s == 1) {
                simplified = a + "/" + b;
            } else {
                simplified = Filters.nocomma(a / s) + "/" + Filters.nocomma(b / s);
            }


            tr.setText(getString(R.string.percentagepercentage) + ": " + ftbc(percentage) + "\n" + getString(R.string.decimal) + ": " + frd(decimals) + "\n" + getString(R.string.simplifiedfraction) + ": " + simplified);

        }

    }


    private void odds() {

        double s = dp(e1r);
        double l = dp(e2r);
        double all = s + l;

        double winning = (s / all) * 100;
        double losing = (l / all) * 100;

        double aaa = winning / losing;
        String fraction = Math2.convertDecimalToFraction(aaa);

        String res = getString(R.string.probabilityofwinning) + ": " + ftbc(winning) + "\n" + getString(R.string.probabilityoflosing) + ": " + ftbc(losing) + "\n" + getString(R.string.fraction) + ": " + fraction;


        setResult(title, res);

    }


    private void roman() {

        int num = Integer.parseInt(e1r);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }

        setResult(title, roman.toString());

    }


    private void percentage() {

        switch (MS) {
            case 1: {
                double result = (dp(e1r) * 100) / dp(e2r);
                tr.setText(e1r + " " + getString(R.string.grammaris) + " " + frd(result) + "% " + getString(R.string.ofDari) + " " + e2r);
            }
            break;
            case 2: {
                Double result = dp(e1r) * ((100 + dp(e2r)) / 100);
                String res = getString(R.string.additionof) + " " + e1r + " " + getString(R.string.bysmall) + " " + e2r + "% " + getString(R.string.grammaris);
                setResult(res, Filters.rd(result));


            }
            break;
            case 3: {
                Double result = dp(e1r) - (dp(e1r) / 100.0) * dp(e2r);
                String res = getString(R.string.subtractionof) + " " + e1r + " " + getString(R.string.bysmall) + " " + e2r + "% " + getString(R.string.grammaris);
                setResult(res, Filters.rd(result));


            }
            break;
            default: {
                Double result = (dp(e2r) / 100.0) * dp(e1r);
                String res = e2r + "% " + getString(R.string.ofDari) + " " + e1r + " " + getString(R.string.grammaris);
                setResult(res, Filters.rd(result));
            }
            break;
        }


    }

    private void MSless() {
        //.
        sMS.setVisibility(View.GONE);
    }

    private void needMS() {
        //.
        sMS.setVisibility(View.VISIBLE);
    }

    private void only1() {
        turn2off();
        turn3off();
        turn4off();
        turn5off();
        active = 1;

    }

    private void only2() {
        l2.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        visible2 = true;
        turn3off();
        turn4off();
        turn5off();
        active = 2;
    }

    private void only3() {
        l2.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        visible3 = true;
        turn5off();
        turn4off();
        active = 3;
    }

    private void only4() {
        l2.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        visible4 = true;
        turn5off();
        active = 4;
    }

    private void useall() {
        l2.setVisibility(View.VISIBLE);
        h2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        h3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        h4.setVisibility(View.VISIBLE);
        visible4 = true;
        l5.setVisibility(View.VISIBLE);
        h5.setVisibility(View.VISIBLE);
        visible5 = true;
        active = 5;
    }

    private void turn2off() {
        l2.setVisibility(View.GONE);
        h2.setVisibility(View.GONE);
        visible2 = false;
    }

    private void turn3off() {
        l3.setVisibility(View.GONE);
        h3.setVisibility(View.GONE);
        visible3 = false;
    }

    private void turn4off() {
        l4.setVisibility(View.GONE);
        h4.setVisibility(View.GONE);
        visible4 = false;
    }

    private void turn5off() {
        l5.setVisibility(View.GONE);
        h5.setVisibility(View.GONE);
        visible5 = false;
    }

    private void findView() {
        tr = view.findViewById(R.id.tfsws_main_result_tv);
        l3 = view.findViewById(R.id.tfsws_3_til);
        l4 = view.findViewById(R.id.tfsws_4_til);
        l5 = view.findViewById(R.id.tfsws_5_til);
        l1 = view.findViewById(R.id.tfsws_1_til);
        l2 = view.findViewById(R.id.tfsws_2_til);
        sMS = view.findViewById(R.id.tfsws_main_s);
        e1 = view.findViewById(R.id.tfsws_1_et);
        e2 = view.findViewById(R.id.tfsws_2_et);
        e3 = view.findViewById(R.id.tfsws_3_et);
        e4 = view.findViewById(R.id.tfsws_4_et);
        e5 = view.findViewById(R.id.tfsws_5_et);
        viewpager = view.findViewById(R.id.viewpager_ws);
        tl = view.findViewById(R.id.tab_layout_ws);
        viewpager.setAdapter(new CustomPagerAdapter(requireContext()));
        tl.setupWithViewPager(viewpager);
        h1 = view.findViewById(R.id.hint_1);
        h2 = view.findViewById(R.id.hint_2);
        h3 = view.findViewById(R.id.hint_3);
        h4 = view.findViewById(R.id.hint_4);
        h5 = view.findViewById(R.id.hint_5);
    }

    private void setListener() {

        //EditText
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setadapterMS(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        sMS.setAdapter(adapter);
    }

    private void getStrings() {
        e1r = e1.getText().toString();
        getNumberToWords(1);
        if (visible2) {
            e2r = e2.getText().toString();
            getNumberToWords(2);
        }
        if (visible3) {
            e3r = e3.getText().toString();
            getNumberToWords(3);
        }
        if (visible4) {
            e4r = e4.getText().toString();
            getNumberToWords(4);
        }
        if (visible5) {
            e5r = e5.getText().toString();
            getNumberToWords(5);
        }
    }

    private void setResult(String name, String theresult) {
        tr.setText(name + ":\n" + theresult);
    }

    private double dp(String text) {
        return Double.parseDouble(text);
    }

    private String frd(double result) {
        return Filters.rd(result);
    }

    private String ftbc(double result) {
        return Filters.twobelowcomma(result);
    }

    private Boolean ec(int er) {
        if (er == 1) {
            return e1r.isEmpty();
        } else if (er == 2) {
            return e1r.isEmpty() || e2r.isEmpty();
        } else if (er == 3) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty();
        } else if (er == 4) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty() || e4r.isEmpty();
        } else if (er == 5) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty() || e4r.isEmpty() || e5r.isEmpty();
        }
        return false;
    }

    public void getNumberToWords(int position) {
        if (App.NumberToWordsStatus(requireContext())) {
            try {
                if (position == 2) {
                    if (!e2r.isEmpty()) {
                        h2.setText(Filters.number_toWords(dp(e2r)));
                    } else {
                        h2.setText("");
                    }
                } else if (position == 3) {
                    if (!e3r.isEmpty()) {
                        h3.setText(Filters.number_toWords(dp(e3r)));
                    } else {
                        h3.setText("");
                    }
                } else if (position == 4) {
                    if (!e4r.isEmpty()) {
                        h4.setText(Filters.number_toWords(dp(e4r)));
                    } else {
                        h4.setText("");
                    }
                } else if (position == 5) {
                    if (!e5r.isEmpty()) {
                        h5.setText(Filters.number_toWords(dp(e5r)));
                    } else {
                        h5.setText("");
                    }
                } else {
                    if (!e1r.isEmpty()) {
                        h1.setText(Filters.number_toWords(dp(e1r)));
                    } else {
                        h1.setText("");
                    }
                }
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        req = Temp.req;
        title = Temp.name;


        if (isVisible()) {

            findView();
            preparation();


            sMSListener();
            setListener();

        }
        TextView stv = view.findViewById(R.id.selecttv);
        if (sMS.getVisibility() == View.VISIBLE) {
            stv.setVisibility(View.VISIBLE);
        } else {
            stv.setVisibility(View.GONE);
        }
    }
}
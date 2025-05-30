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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.ArraysOfUnits;
import com.softgasm.calculatto.contents.Math2;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.CustomPagerAdapter;

@SuppressLint("SetTextI18n")
public class thefragments extends Fragment {

    LinearLayout l1, l2, l3, l4, l5, lr;
    TextView t1, t2, t3, t4, t5, tr, h1, h2, h3, h4, h5;
    EditText et1, et2, et3, et4, et5, sec1, sec2, sec3, sec4, sec5;
    Spinner sMS, s1, s2, s3, s4, s5, sr;
    int MS = 0, s1v, s2v, s3v, s4v, s5v, srv, active = 1;
    String req, e1r, e2r, e3r, e4r, e5r, title;
    boolean visible2 = false, visible3 = false, visible4 = false, visible5 = false;
    View view;

    ViewPager viewpager;
    TabLayout tl;

    public thefragments() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_thefragments, container, false);

        return view;
    }

    private void preparation() {
        switch (req) {
            case "molality": {

                MSless();
                only2();

                String[] s1s = {("mol")};
                setadapter1(s1s);
                setadapter2(ArraysOfUnits.weight());
                setadapterresult(ArraysOfUnits.weight());
                t1.setText(getString(R.string.molessolute));
                t2.setText(getString(R.string.masssolvent));
                break;
            }
            case "molarity": {
                MSless();
                only2();

                String[] s1s = {("g/mol")};
                String[] s2s = {("g/L"), ("lb/US gal")};
                String[] srs = {("M")};
                setadapter1(s1s);
                setadapter2(s2s);
                setadapterresult(srs);
                t1.setText(getString(R.string.molarmass));
                t2.setText(getString(R.string.concentration));
                break;
            }
            case "fabric": {
                only4();
                MSless();

                t1.setText(getString(R.string.fabricwidth));
                t2.setText(getString(R.string.piecewidth));
                t3.setText(getString(R.string.piecelength));
                t4.setText(getString(R.string.numberofpieces));
                break;
            }
            case "einstein":
                MSless();
                only1();

                String[] srazaz = {("joule")};
                setadapter1(ArraysOfUnits.weight());
                setadapterresult(srazaz);
                t1.setText(getString(R.string.mass));
                break;
            case "lorentz": {
                MSless();
                only1();

                String[] s1s = {("c"), ("m/s"), ("km/h"), ("mph"), ("ft/s"), ("knots")};
                setadapter1(s1s);
                t1.setText(getString(R.string.velocity));
                break;
            }
            case "mach":
                MSless();
                only2();

                setadapter1(ArraysOfUnits.speed());
                setadapter2(ArraysOfUnits.speed());

                t1.setText(getString(R.string.speedofobject));
                t2.setText(getString(R.string.speedofsound));
                et2.setText("343.2");
                break;
            case "friction": {
                MSless();
                only2();

                setadapter2(ArraysOfUnits.force());
                String[] s1s = {("μ")};
                setadapter1(s1s);

                t1.setText(getString(R.string.frictioncoefficient));
                t2.setText(getString(R.string.normalforce));

                break;
            }
            case "psa": {
                needMS();
                only2();

                String[] sm = {(getString(R.string.pressure)), getString(R.string.force), getString(R.string.area)};
                setadapterMS(sm);
                setadapter1(ArraysOfUnits.force());
                setadapter2(ArraysOfUnits.area());
                setadapterresult(ArraysOfUnits.pressure());


                t1.setText(getString(R.string.force));
                t2.setText(getString(R.string.area));
                break;
            }
            case "momentum": {
                MSless();
                only2();

                String[] sar = {("kg·m/s"), ("lbs·ft/s")};
                setadapter1(ArraysOfUnits.weight());
                setadapter2(ArraysOfUnits.speed());
                setadapterresult(sar);


                t1.setText(getString(R.string.mass));
                t2.setText(getString(R.string.velocity));
                break;
            }
            case "acceleration": {
                needMS();
                only2();

                String[] sm = {(getString(R.string.mass_and_force)), getString(R.string.speeddifference), getString(R.string.distance)};
                setadapterMS(sm);
                setadapter1(ArraysOfUnits.weight());
                setadapter2(ArraysOfUnits.force());
                setadapterresult(ArraysOfUnits.acceleration());


                t1.setText(getString(R.string.mass));
                t2.setText(getString(R.string.netforce));
                break;
            }
            case "velocity": {
                needMS();
                only2();

                String[] sm = {(getString(R.string.distance)), getString(R.string.acceleration)};
                setadapterMS(sm);
                setadapter1(ArraysOfUnits.distance());
                setadapter2(ArraysOfUnits.time());
                setadapterresult(ArraysOfUnits.speed());


                t1.setText(getString(R.string.distance));
                t2.setText(getString(R.string.time));
                break;
            }
            case "displacement": {
                needMS();
                only2();

                String[] sm = {(getString(R.string.constantvelocity)), getString(R.string.acceleration)};
                setadapterMS(sm);
                setadapter1(ArraysOfUnits.time());
                setadapter2(ArraysOfUnits.speed());
                setadapterresult(ArraysOfUnits.distance());


                t1.setText(getString(R.string.time));
                t2.setText(getString(R.string.averagevelocity));
                break;
            }
            case "coin": {
                MSless();
                only2();

                String[] sm = {(getString(R.string.exact)), getString(R.string.atleast), getString(R.string.atmost)};
                setadapterresult(sm);


                t1.setText(getString(R.string.numberofflips));
                t2.setText(getString(R.string.heads));
                break;
            }
            case "bmi":
                MSless();
                only2();
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.weight());


                t1.setText(getString(R.string.height));
                t2.setText(getString(R.string.weight));
                tr.setText(getString(R.string.bmi));
                break;
            case "bsa":
                MSless();
                only2();
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.weight());
                setadapterresult(ArraysOfUnits.area());


                t1.setText(getString(R.string.height));
                t2.setText(getString(R.string.weight));
                tr.setText(getString(R.string.bsa));
                break;
            case "cardiac":
                MSless();
                only4();
                setadapter3(ArraysOfUnits.length());
                setadapter4(ArraysOfUnits.weight());

                t1.setText(getString(R.string.strokevolume) + " (ml/" + getString(R.string.beat) + ")");
                t2.setText(getString(R.string.ci_heartrate) + " (" + getString(R.string.beat) + "/" + getString(R.string.minute_small) + ")");
                t3.setText(getString(R.string.height));
                t4.setText(getString(R.string.weight));
                break;
            case "ffmi":
                needMS();
                setadapterMS(ArraysOfUnits.gender());
                useall();
                setadapterresult(ArraysOfUnits.weight());
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.weight());
                setadapter3(ArraysOfUnits.length());
                setadapter4(ArraysOfUnits.length());
                setadapter5(ArraysOfUnits.length());

                t1.setText(getString(R.string.height));
                t2.setText(getString(R.string.weight));
                t3.setText(getString(R.string.neckcircum));
                t4.setText(getString(R.string.waistcircumference));
                t5.setText(getString(R.string.hipcircumference));
                break;
            case "lbm":
                needMS();
                only2();
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.weight());
                setadapterMS(ArraysOfUnits.gender());
                setadapterresult(ArraysOfUnits.weight());

                t1.setText(getString(R.string.height));
                t2.setText(getString(R.string.weight));
                break;
            case "rfm":
                needMS();
                only2();
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.length());
                setadapterMS(ArraysOfUnits.gender());

                t1.setText(getString(R.string.waistcircumference));
                t2.setText(getString(R.string.height));
                break;
            case "waistr":
                needMS();
                only3();
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.length());
                setadapter3(ArraysOfUnits.length());
                setadapterMS(ArraysOfUnits.gender());

                t1.setText(getString(R.string.waistcircumference));
                t2.setText(getString(R.string.height));
                t3.setText(getString(R.string.hipcircumference));
                break;
            case "idealgas":
                MSless();
                only3();
                setadapter1(ArraysOfUnits.pressure());
                setadapter2(ArraysOfUnits.volume());
                String[] safafs = {("mol")};
                setadapter3(safafs);
                setadapterresult(ArraysOfUnits.temperature());
                s2.setSelection(3);
                sr.setSelection(2);


                t1.setText(getString(R.string.pressure));
                t2.setText(getString(R.string.volume));
                t3.setText(getString(R.string.amountofsubstance));
                break;
            case "epower":
                MSless();
                only3();
                String[] ae1 = {("V"), ("kV")};
                String[] s1s2 = {("A")};
                et3.setText("1");
                setadapter1(ae1);
                setadapter2(s1s2);
                String[] asfqr = {("W"), ("kW"), ("BTU/h")};
                setadapterresult(asfqr);


                t1.setText(getString(R.string.voltage));
                t2.setText(getString(R.string.electriccurrent));
                t3.setText(getString(R.string.powerfactor));
                break;
            case "heatc":
                MSless();
                only2();
                String[] aa1a = {("J/kgK"), ("BTU/lb°F")};
                setadapter1(ArraysOfUnits.weight());
                setadapter2(aa1a);
                String[] asasas = {("J/K"), ("cal/°C"), ("BTU/°F")};
                setadapterresult(asasas);


                t1.setText(getString(R.string.mass));
                t2.setText(getString(R.string.specificheat));
                break;
            case "energye":
                MSless();
                only2();
                setadapter1(ArraysOfUnits.energy());
                setadapter2(ArraysOfUnits.energy());

                t1.setText(getString(R.string.input));
                t2.setText(getString(R.string.output));
                break;
            case "aqua":
                needMS();
                only3();
                String[] adafas = {(getString(R.string.rectangle)), (getString(R.string.cube)), (getString(R.string.cylinder))};
                setadapterMS(adafas);
                setadapter1(ArraysOfUnits.length());
                setadapter2(ArraysOfUnits.length());
                setadapter3(ArraysOfUnits.length());
                setadapterresult(ArraysOfUnits.volume());

                t1.setText(getString(R.string.length));
                t2.setText(getString(R.string.width));
                t3.setText(getString(R.string.height));
                break;
            case "force": {
                MSless();
                only2();

                setadapter1(ArraysOfUnits.weight());
                setadapter2(ArraysOfUnits.acceleration());
                setadapterresult(ArraysOfUnits.force());


                t1.setText(getString(R.string.mass));
                t2.setText(getString(R.string.acceleration));
            }
            break;
            case "bun": {
                MSless();
                only2();

                String[] conc = {("mg/dL"), ("mmol/L"), ("µmol/L")};
                setadapter1(conc);
                setadapter2(ArraysOfUnits.concentration());
                s2.setSelection(2);

                t1.setText(getString(R.string.bunlong));
                t2.setText(getString(R.string.serumcreatinine));
            }
            break;
            case "anion": {
                needMS();
                only3();

                String[] a0a = {("mEq/L / mmol/L")};
                setadapter1(a0a);
                setadapter2(a0a);
                setadapter3(a0a);
                setadapter4(a0a);
                setadapter5(ArraysOfUnits.concentration());
                String[] akaa = {(getString(R.string.aniongap)), (getString(R.string.correctedaniongap))};
                setadapterMS(akaa);


                t1.setText(getString(R.string.sodium_s));
                t2.setText(getString(R.string.chloride_s));
                t3.setText(getString(R.string.bicarbonate_s));
            }
            break;
            case "iron": {
                MSless();
                only4();

                setadapter1(ArraysOfUnits.weight());
                setadapter2(ArraysOfUnits.concentration());
                setadapter3(ArraysOfUnits.concentration());
                String[] akaa = {("mg")};
                setadapter4(akaa);
                setadapterresult(akaa);


                t1.setText(getString(R.string.weight));
                t2.setText(getString(R.string.actualhemoglobin));
                t3.setText(getString(R.string.targethemoglobin));
                t4.setText(getString(R.string.ironstores));
                et4.setText("500");
            }
            break;
            case "tsat": {
                needMS();
                only2();

                setadapter1(ArraysOfUnits.concentration());
                setadapter2(ArraysOfUnits.concentration());
                s1.setSelection(5);
                s2.setSelection(5);
                String[] akaa = {(getString(R.string.tibc)), (getString(R.string.stc))};
                setadapterMS(akaa);
                String[] akss = {("%")};
                setadapterresult(akss);

                t1.setText(getString(R.string.siconc));
                t2.setText(getString(R.string.tibc));
            }
            break;
            case "qtc": {
                MSless();
                only2();


                String[] akaa = {(getString(R.string.millisecond)), (getString(R.string.seconds))};
                setadapter1(akaa);
                String[] akss = {("bpm")};
                setadapter2(akss);

                setadapterresult(akaa);

                t1.setText(getString(R.string.qtin));
                t2.setText(getString(R.string.ci_heartrate));
            }
            break;
            case "saag": {
                MSless();
                only2();

                setadapter1(ArraysOfUnits.concentration());
                setadapter2(ArraysOfUnits.concentration());
                setadapterresult(ArraysOfUnits.concentration());


                t1.setText(getString(R.string.sac));
                t2.setText(getString(R.string.afac));
            }
            break;
            case "ldl": {
                MSless();
                only3();

                String[] akaa = {("mg/dL"), ("mmol/L")};
                setadapter1(akaa);
                setadapter2(akaa);
                setadapter3(akaa);
                setadapterresult(akaa);


                t1.setText(getString(R.string.totalcholesterol));
                t2.setText(getString(R.string.hdl));
                t3.setText(getString(R.string.tgs));
            }
            break;
            case "avogadro": {
                MSless();
                only2();

                String[] akaa = {("mol")};
                String[] axx = {("×10²³ " + getString(R.string.atom))};
                setadapter1(akaa);
                setadapterresult(axx);

                et2.setText("0");


                t1.setText(getString(R.string.moles));
                t2.setText(getString(R.string.raisedto));
            }
            break;
            case "conc": {
                MSless();
                only3();


                String[] axx = {("M"), ("mM"), ("μM")};
                String[] aaa = {("g/mol")};
                String[] aas = {("wt/wt %")};
                setadapter1(ArraysOfUnits.density());
                setadapter2(aaa);
                setadapter3(axx);
                setadapterresult(aas);


                t1.setText(getString(R.string.density));
                t2.setText(getString(R.string.molarmass));
                t3.setText(getString(R.string.molarity));
            }
            break;
            case "waterh": {
                MSless();
                useall();


                String[] aas = {("%")};
                setadapter1(ArraysOfUnits.weight());
                setadapter2(ArraysOfUnits.temperature());
                setadapter3(ArraysOfUnits.temperature());
                setadapter4(ArraysOfUnits.power());
                setadapter5(aas);
                setadapterresult(ArraysOfUnits.time());


                t1.setText(getString(R.string.amountofwater));
                t2.setText(getString(R.string.starttemperature));
                t3.setText(getString(R.string.endtemperature));
                t4.setText(getString(R.string.heatingpower));
                t5.setText(getString(R.string.energyefficiency));
            }
            break;
            case "freq": {
                MSless();
                only2();

                String[] akaa = {("Hz"), ("kHz"), ("MHz"), ("GHz")};
                setadapter1(ArraysOfUnits.speed());
                setadapter2(ArraysOfUnits.distance());
                setadapterresult(akaa);


                t1.setText(getString(R.string.wavevelocity));
                t2.setText(getString(R.string.wavelength));
            }
            break;
            case "insulin": {
                MSless();
                only2();

                String[] akaa = {("mg/dL"), ("mmol/L")};
                String[] as1 = {("mU/L")};
                setadapter1(akaa);
                setadapter2(as1);


                t1.setText(getString(R.string.fastingglucose));
                t2.setText(getString(R.string.fastinginsulin));
            }
            break;
            case "bond": {
                MSless();
                only2();

                t1.setText(getString(R.string.bondingelectrons));
                t2.setText(getString(R.string.antibondingelectrons));
            }
            break;
            case "neutral": {
                MSless();
                only3();


                setadapter1(ArraysOfUnits.weight());
                s1.setSelection(2);
                setadapter2(ArraysOfUnits.volume());
                setadapter3(ArraysOfUnits.weight());
                s3.setSelection(2);
                String[] as1 = {("N")};
                setadapterresult(as1);


                t1.setText(getString(R.string.weightofsolute));
                t2.setText(getString(R.string.volumeofsolvent));
                t3.setText(getString(R.string.equivalentweight));
            }
            break;
            case "cofunction": {
                needMS();
                only1();

                String[] sss = {(getString(R.string.radian)), (getString(R.string.degree))};
                setadapter1(sss);

                String[] s1s = {("sin"), ("cos"), ("tan"), ("cot"), ("sec"), ("csc")};
                setadapterMS(s1s);


                t1.setText(getString(R.string.angle));
            }
            break;
        }
    }

    private void sMSListener() {
        sMS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MS = position;
                switch (req) {
                    case "psa":
                        switch (MS) {
                            case 1:
                                setadapter1(ArraysOfUnits.pressure());
                                setadapter2(ArraysOfUnits.area());
                                setadapterresult(ArraysOfUnits.force());
                                t1.setText(getString(R.string.pressure));
                                t2.setText(getString(R.string.area));
                                break;
                            case 2:
                                setadapter1(ArraysOfUnits.force());
                                setadapter2(ArraysOfUnits.pressure());
                                setadapterresult(ArraysOfUnits.area());
                                t1.setText(getString(R.string.force));
                                t2.setText(getString(R.string.pressure));
                                break;
                            default:
                                setadapter1(ArraysOfUnits.force());
                                setadapter2(ArraysOfUnits.area());
                                setadapterresult(ArraysOfUnits.pressure());


                                t1.setText(getString(R.string.force));
                                t2.setText(getString(R.string.area));
                                break;
                        }
                        break;
                    case "acceleration":
                        switch (MS) {
                            case 1:
                                only3();
                                setadapter1(ArraysOfUnits.speed());
                                setadapter2(ArraysOfUnits.speed());
                                setadapter3(ArraysOfUnits.time());
                                t1.setText(getString(R.string.initialspeed));
                                t2.setText(getString(R.string.finalspeed));
                                t3.setText(getString(R.string.time));
                                break;
                            case 2:
                                only3();
                                setadapter1(ArraysOfUnits.speed());
                                setadapter2(ArraysOfUnits.distance());
                                setadapter3(ArraysOfUnits.time());
                                t1.setText(getString(R.string.initialspeed));
                                t2.setText(getString(R.string.distance));
                                t3.setText(getString(R.string.time));
                                break;
                            default:
                                only2();

                                setadapter1(ArraysOfUnits.weight());
                                setadapter2(ArraysOfUnits.force());


                                t1.setText(getString(R.string.mass));
                                t2.setText(getString(R.string.netforce));
                                break;
                        }
                        break;
                    case "velocity":
                        if (MS == 1) {
                            only3();
                            setadapter1(ArraysOfUnits.speed());
                            setadapter2(ArraysOfUnits.acceleration());
                            setadapter3(ArraysOfUnits.time());
                            t1.setText(getString(R.string.initialvelocity));
                            t2.setText(getString(R.string.acceleration));
                            t3.setText(getString(R.string.time));
                        } else {
                            only2();

                            setadapter1(ArraysOfUnits.distance());
                            setadapter2(ArraysOfUnits.time());


                            t1.setText(getString(R.string.distance));
                            t2.setText(getString(R.string.time));
                        }
                        break;
                    case "displacement":
                        if (MS == 1) {
                            only3();
                            setadapter1(ArraysOfUnits.time());
                            setadapter2(ArraysOfUnits.speed());
                            setadapter3(ArraysOfUnits.speed());
                            t1.setText(getString(R.string.time));
                            t2.setText(getString(R.string.initialvelocity));
                            t3.setText(getString(R.string.finalvelocity));
                        } else {
                            only2();

                            setadapter1(ArraysOfUnits.time());
                            setadapter2(ArraysOfUnits.speed());
                            setadapterresult(ArraysOfUnits.distance());


                            t1.setText(getString(R.string.time));
                            t2.setText(getString(R.string.averagevelocity));
                        }
                        break;
                    case "ffmi":
                        if (MS == 1) {
                            only4();
                        } else {
                            useall();
                        }
                        break;
                    case "aqua":
                        if (MS == 1) {
                            only1();
                            t1.setText(getString(R.string.length));
                        } else if (MS == 2) {
                            only2();
                            t1.setText(getString(R.string.diameter));
                            t2.setText(getString(R.string.height));
                        } else {
                            only3();
                            t1.setText(getString(R.string.length));
                            t2.setText(getString(R.string.width));
                            t3.setText(getString(R.string.height));
                        }
                        break;
                    case "anion":
                        if (MS == 1) {
                            useall();
                            t1.setText(getString(R.string.sodium_s));
                            t2.setText(getString(R.string.chloride_s));
                            t3.setText(getString(R.string.bicarbonate_s));
                            t4.setText(getString(R.string.potassium_s));
                            t5.setText(getString(R.string.albumin_hint));
                        } else {
                            only3();
                            t1.setText(getString(R.string.sodium_s));
                            t2.setText(getString(R.string.chloride_s));
                            t3.setText(getString(R.string.bicarbonate_s));
                        }
                        break;
                    case "tsat": {
                        if (MS == 1) {
                            s2.setSelection(2);
                            t2.setText(getString(R.string.stc));
                        } else {
                            s2.setSelection(5);
                            t2.setText(getString(R.string.tibc));
                        }
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
        sr.setMinimumHeight(tr.getHeight());
            try {
                switch (req) {
                    case "molality":
                        molality();
                        break;
                    case "molarity":
                        molarity();
                        break;
                    case "fabric":
                        fabric();
                        break;
                    case "einstein":
                        einstein();
                        break;
                    case "lorentz":
                        lorentz();
                        break;
                    case "mach":
                        mach();
                        break;
                    case "friction":
                        friction();
                        break;
                    case "psa":
                        psa();
                        break;
                    case "momentum":
                        momentum();
                        break;
                    case "velocity":
                        velocity();
                        break;
                    case "acceleration":
                        acceleration();
                        break;
                    case "displacement":
                        displacement();
                        break;
                    case "bmi":
                        bmi();
                        break;
                    case "bsa":
                        bsa();
                        break;
                    case "cardiac":
                        cardiac();
                        break;
                    case "ffmi":
                        ffmi();
                        break;
                    case "lbm":
                        lbm();
                        break;
                    case "rfm":
                        rfm();
                        break;
                    case "waistr":
                        waistr();
                        break;
                    case "idealgas":
                        idealgas();
                        break;
                    case "epower":
                        epower();
                        break;
                    case "heatc":
                        heatc();
                        break;
                    case "energye":
                        energye();
                        break;
                    case "aqua":
                        aqua();
                        break;
                    case "force":
                        force();
                        break;
                    case "bun":
                        bun();
                        break;
                    case "anion":
                        anion();
                        break;
                    case "iron":
                        iron();
                        break;
                    case "tsat":
                        tsat();
                        break;
                    case "qtc":
                        qtc();
                        break;
                    case "saag":
                        saag();
                        break;
                    case "ldl":
                        ldl();
                        break;
                    case "avogadro":
                        avogadro();
                        break;
                    case "conc":
                        conc();
                        break;
                    case "waterh":
                        waterh();
                        break;
                    case "freq":
                        freq();
                        break;
                    case "insulin":
                        insulin();
                        break;
                    case "bond":
                        bond();
                        break;
                    case "neutral":
                        neutral();
                        break;
                    case "cofunction":
                        cofunction();
                        break;
                }
            } catch (NumberFormatException | NullPointerException ignored) {

            }
    }


    private void cofunction() {

        double r1 = dp(e1r);

        String res;
        double angle;
        double finalresult;
        String cofunc;

        double toTrigs;

        if (s1v == 1) {
            angle = 90 - r1;
            toTrigs = Math.toRadians(angle);
        } else {
            angle = (Math.PI / 2) - r1;
            toTrigs = angle;
        }

        switch (MS) {
            case 1:
                cofunc = "sin";
                finalresult = Math.sin(toTrigs);
                break;
            case 2:
                cofunc = "cot";
                finalresult = Math2.cot(toTrigs);
                break;
            case 3:
                cofunc = "tan";
                finalresult = Math.tan(toTrigs);
                break;
            case 4:
                cofunc = "csc";
                finalresult = Math2.csc(toTrigs);
                break;
            case 5:
                cofunc = "sec";
                finalresult = Math2.sec(toTrigs);
                break;
            default:
                cofunc = "cos";
                finalresult = Math.cos(toTrigs);
                break;

        }

        if (s1v == 1) {
            res = sMS.getSelectedItem().toString() + "(" + e1r + "°) = " + cofunc + "(" + frd(angle) + "°)\n(" + frd(finalresult) + ")";
        } else {
            res = sMS.getSelectedItem().toString() + "(" + e1r + ") = " + cofunc + "(" + frd(angle) + ")\n(" + frd(finalresult) + ")";
        }


        tr.setText(res);

    }


    private void neutral() {

        double r1 = Math2.kg_tog(dp_weight(1));
        double r2 = dp_volume(2);
        double r3 = Math2.kg_tog(dp_weight(3));


        setResult(title, frd(r1 / (r2 * r3)));

    }


    private void bond() {

        double result = (dp(e1r) - dp(e2r)) / 2;

        setResult(title, ftbc(result));

    }

    private void insulin() {

        double v1 = dp(e1r);
        double v2 = dp(e2r);

        double res1;
        if (s1v == 1) {
            res1 = (v2 * v1) / 22.5;
        } else {
            res1 = (v2 * v1) / 405;
        }

        String safe = getString(R.string.normal);
        String cautious = getString(R.string.ir_d);
        String diabetic = getString(R.string.diabetic);

        String result1;
        if (res1 > 2) {
            result1 = "HOMA-IR: " + ftbc(res1) + " (" + cautious + ")";
        } else {
            result1 = "HOMA-IR: " + ftbc(res1) + " (" + safe + ")";
        }

        double v11;
        if (s1v == 1) {
            v11 = Math2.mmoll_tomgdl(v1);
        } else {
            v11 = v1;
        }

        double res2 = 1 / (Math.log10(v2) + Math.log10(v11));


        String result2;
        if (res2 > 0.45) {
            result2 = "QUICKI: " + ftbc(res2) + " (" + safe + ")";
        } else if (res2 >= 0.30 && res2 <= 0.45) {
            result2 = "QUICKI: " + ftbc(res2) + " (" + cautious + ")";
        } else {
            result2 = "QUICKI: " + ftbc(res2) + " (" + diabetic + ")";
        }


        tr.setText(result1 + "\n\n" + result2);


    }


    private void freq() {


        double v1 = dp_speed(1);
        double v2 = dp_distance(2);

        double res1 = v1 / v2;
        double res2 = 1 / res1;


        double res11;
        switch (srv) {
            case 1:
                res11 = Math2.hz_tokhz(res1);
                break;
            case 2:
                res11 = Math2.hz_tomhz(res1);
                break;
            case 3:
                res11 = Math2.hz_toghz(res1);
                break;
            default:
                res11 = res1;
                break;
        }
        String r1 = getString(R.string.frequency) + ": " + frd(res11) + "\n";
        String r2 = getString(R.string.period) + ": " + frd(res2) + " " + getString(R.string.seconds);
        tr.setText(r1 + r2);


    }


    private void waterh() {

        double v1 = dp_weight(1);
        double v2 = dp_temp(2);
        double v3 = dp_temp(3);
        double v4 = dp_power(4);
        double v5 = dp(e5r);


        double result = v1 * (v3 - v2) * 4190 / ((v5 / 100.0) * v4);

        if (v2 > 99 || v3 > 99) {
            tr.setText(R.string.waterboilingerror);
        } else {
            setResult(getString(R.string.time), ftbc(dp_result_time(result)));
        }

    }


    private void conc() {

        double v1 = dp_density(1);
        double v2 = dp(e2r);
        double v3 = dp(e3r);

        switch (s3v) {
            case 1:
                v3 = Math2.mmole_tomole(dp(e3r));
                break;
            case 2:
                v3 = Math2.micromole_tomole(dp(e3r));
                break;
        }

        double r1 = (v3 * v2 * 100) / v1;

        setResult(getString(R.string.percentage), ftbc(r1));
    }


    private void avogadro() {

        double v1 = dp(e1r);
        double v2 = dp(e2r);


        if (!(v2 == 0)) {
            double exp = Math.pow(10, v2);
            v1 = dp(e1r) * exp;
        }
        double result = 6.02214076 * v1;

        setResult(getString(R.string.numberofatoms), frd(result));


    }


    private void ldl() {


        double v1 = dp(e1r);
        if (s1v == 1) {
            v1 = dp(e1r) * 38.67;
        }
        double v2 = dp(e2r);
        if (s2v == 1) {
            v2 = dp(e2r) * 38.67;
        }
        double v3 = dp(e3r);
        if (s3v == 1) {
            v3 = dp(e3r) * 88.57;
        }


        double result = v1 - v2 - (v3 / 5);
        if (srv == 1) {
            result = result * 0.02586;
        }
        setResult(title, frd(result));


    }


    private void saag() {

        double v1 = dp_concentration(1);
        double v2 = dp_concentration(2);

        double result = v1 - v2;

        setResult(title, frd(dp_result_concentration(result)));


    }


    private void qtc() {
        double v1 = dp(e1r);
        if (s1v == 0) {
            v1 = Math2.ms_tos(dp(e1r));
        }
        double v2 = dp(e2r);


        double r1 = 60 / v2;
        double r2 = v1 / Math.sqrt(r1);
        double r3 = v1 / Math.cbrt(r1);
        double r4 = v1 + 0.154 * (1 - r1);

        if (srv == 0) {
            r1 = Math2.s_toms(r1);
            r2 = Math2.s_toms(r2);
            r3 = Math2.s_toms(r3);
            r4 = Math2.s_toms(r4);
        }

        String res1 = getString(R.string.rrinterval) + ": " + ftbc(r1);
        String res2 = "QTc (Bazett): " + ftbc(r2);
        String res3 = "QTc (Fridericia): " + ftbc(r3);
        String res4 = "QTc (Framingham): " + ftbc(r4);

        tr.setText(res1 + "\n\n" + res2 + "\n" + res3 + "\n" + res4);

    }


    private void tsat() {
        double v1 = Math2.gdl_tomicrogramdl(dp_concentration(1));
        double v2;
        double result;
        if (MS == 1) {
            v2 = Math2.gdl_tomgdl(dp_concentration(2));
            result = (v1 / v2) * 70.9;
        } else {
            v2 = Math2.gdl_tomicrogramdl(dp_concentration(2));
            result = (v1 / v2) * 100;
        }
        setResult(getString(R.string.deficit), ftbc(result));
    }


    private void iron() {

        double v1 = dp_weight(1);
        double v2 = dp_concentration(2);
        double v3 = dp_concentration(3);
        double v4 = dp(e4r);

        double result = v1 * (v3 - v2) * 2.4 + v4;
        setResult(getString(R.string.deficit), ftbc(result));
    }


    private void anion() {


        if (MS == 1) {
            double result = dp(e1r) + dp(e4r) - (dp(e2r) + dp(e3r));
            double albumin = dp_concentration(5);
            double result2 = (result + (2.5 * (4 - albumin))) + 1;
            String res1 = getString(R.string.aniongap) + ": " + result;
            String res2 = getString(R.string.correctedaniongap) + ": " + result2;
            tr.setText(res1 + "\n" + res2);
        } else {
            double result = dp(e1r) - (dp(e2r) + dp(e3r));
            setResult(title, ftbc(result));
        }

    }


    private void bun() {

        double v1;
        if (s1v == 1) {
            v1 = dp(e1r) / 0.3571;
        } else if (s1v == 2) {
            v1 = dp(e1r) / 357.1429;
        } else {
            v1 = dp(e1r);
        }
        double v2 = Math2.gdl_tomgdl(dp_concentration(2));

        double result = v1 / v2;
        String res1 = getString(R.string.buncr) + ": " + ftbc(result);
        String status;
        if (result > 20) {
            status = getString(R.string.high);
        } else if (result < 10) {
            status = getString(R.string.low);
        } else {
            status = getString(R.string.normal);
        }
        tr.setText(res1 + "\n" + "(" + status + ")");


    }


    private void force() {

        double v1 = dp_weight(1);
        double v2 = dp_acceleration(2);

        double result = v1 * v2;
        setResult(title, frd(dp_result_force(result)));


    }

    private void aqua() {
        if (MS == 1) {
            double a = dp_length(1);

            double res = Math.pow(a, 3) * 0.001;
            res = dp_result_volume(res);
            setResult(title, ftbc(res));


        } else if (MS == 2) {
            double a = dp_length(1);
            double b = dp_length(2);

            double res = (Math.PI * Math.pow((a / 2), 2) * b) * 0.001;
            res = dp_result_volume(res);
            setResult(title, ftbc(res));

        } else {
            double a = dp_length(1);
            double b = dp_length(2);
            double c = dp_length(3);

            double res = (a * b * c) * 0.001;
            res = dp_result_volume(res);

            setResult(title, ftbc(res));
        }
    }


    private void energye() {
        double a = dp_energy(1);
        double b = dp_energy(2);

        double res = (b / a) * 100;

        String result = ftbc(res) + " %";

        setResult(title, result);

    }


    private void heatc() {
        double m = dp_weight(1);
        double c = dp(e2r);
        if (s2v == 1) {
            c = Math2.btulbf_tojkgk(c);
        }

        double res = m * c;
        if (srv == 1) {
            res = Math2.jk_tocalc(res);
        } else if (srv == 2) {
            res = Math2.jk_tobtuf(res);
        }

        setResult(title, frd(res));

    }


    private void epower() {
        double v = dp(e1r);
        if (s1v == 1) {
            v = Math2.kv_tov(v);
        }

        double i = dp(e2r);
        double p = dp(e3r);


        double res = v * i * p;
        if (srv == 1) {
            res = Math2.w_tokw(res);
        } else if (srv == 2) {
            res = Math2.w_tobtuh(res);
        }

        setResult(title, frd(res));

    }


    private void idealgas() {
        double p = dp_pressure(1);
        double v = dp_volume(2);
        v = Math2.l_tom3(v);
        double n = dp(e3r);


        double res = (p * v) / (n * 8.31446261815324);
        if (srv != 2) {
            res = Math2.kelvin_toC(res);
            res = dp_result_temp(res);
        }
        setResult(getString(R.string.temperature), frd(res));

    }


    private void waistr() {
        double waist = dp_length(1);
        double hip = dp_length(3);
        double result1 = waist / hip;
        String res1 = getString(R.string.waisttohip) + " " + ftbc(result1) + "\n";
        String healthrisk = null;
        double theresult = dp(ftbc(result1));
        if (MS == 1) {
            if (theresult <= 0.95) {
                healthrisk = getString(R.string.low);
            } else if (theresult >= 0.96 && theresult < 1.0) {
                healthrisk = getString(R.string.medium);
            } else if (theresult == 1.0) {
                healthrisk = getString(R.string.medium);
            } else if (theresult > 1.0) {
                healthrisk = getString(R.string.high);
            }
        } else if (MS == 2) {
            if (theresult <= 0.80) {
                healthrisk = getString(R.string.low);
            } else if (theresult == 0.81) {
                healthrisk = getString(R.string.medium);
            } else if (theresult > 0.81 && theresult < 0.86) {
                healthrisk = getString(R.string.medium);
            } else if (theresult == 0.86) {
                healthrisk = getString(R.string.high);
            } else if (theresult > 0.86) {
                healthrisk = getString(R.string.high);
            }
        } else {
            healthrisk = "";
        }

        double height = dp_length(2);
        double result2 = waist / height;
        String res3 = getString(R.string.yourhealthrisk) + " " + healthrisk;
        String res2 = getString(R.string.waisttoheight) + " " + ftbc(result2) + "\n";
        tr.setText(res1 + res2 + res3);

    }


    private void rfm() {
        double height = dp_length(2);
        double waist = dp_length(1);
        double rfm = 0;

        if (MS == 1) {
            rfm = 64 - ((20 * height) / waist);
        } else if (MS == 2) {
            rfm = 76 - ((20 * height) / waist);
        }
        tr.setText(getString(R.string.rfmass) + ":\n" + ftbc(rfm) + "%");

    }


    private void lbm() {
        if (!(MS == 0)) {
            String weight = s2.getSelectedItem().toString();
            double he = dp_length(1);
            double we = dp_weight(2);


            double result = 0;
            double bmr;
            if (MS == 1) {
                result = 0.407 * we + 0.267 * he - 19.2;
            } else if (MS == 2) {
                result = 0.252 * we + 0.473 * he - 48.3;
            }
            bmr = 370 + (21.6 * result);


            String lbms = getString(R.string.lean_bm) + ":\n" + frd(dp_result_weight(result)) + " " + weight + "\n";
            String lbms2 = getString(R.string.bmr_k_m) + ": " + ftbc(bmr) + " " + "kcal/day";
            tr.setText(lbms + lbms2);


        }


    }

    private void ffmi() {
        if (!(MS == 0)) {
            double he = dp_length(1);
            double we = dp_weight(2);
            double ne = dp_length(3);
            double wa = dp_length(4);

            double bodyfat = 0;

            if (MS == 1) {
                bodyfat = 495 / (1.0324 - 0.19077 * Math.log10(wa - ne) + 0.15456 * Math.log10(he)) - 450;
            } else if (MS == 2) {
                double hip = dp_length(5);
                bodyfat = 495 / (1.29579 - 0.35004 * Math.log10(wa + hip - ne) + 0.22100 * Math.log10(he)) - 450;
            }

            double height = Math2.cm_toM(he);

            double ffm = we * (1 - (bodyfat / 100));
            double ffmi = ffm / Math.pow(height, 2);
            double n_ffmi = ffmi + 6.1 * (1.8 - height);
            double tbf = we * (bodyfat / 100);


            String _measurement = sr.getSelectedItem().toString();

            String _bodyfat = getString(R.string.bodyfat) + ": " + ftbc(bodyfat) + "%";
            String _ffmi = getString(R.string.ffmi) + ": " + ftbc(dp_result_weight(ffmi)) + _measurement + "/m²";
            String _nffmi = getString(R.string.nffmi) + ": " + ftbc(dp_result_weight(n_ffmi)) + _measurement + "/m²";
            String _ffm = getString(R.string.ffm) + ": " + ftbc(dp_result_weight(ffm)) + _measurement;
            String _tbf = getString(R.string.tbf) + ": " + ftbc(dp_result_weight(tbf)) + _measurement;


            tr.setText(_bodyfat + "\n" + _ffmi + "\n" + _nffmi + "\n" + _ffm + "\n" + _tbf);
        }


    }


    private void cardiac() {
        double stroke = dp(e1r);
        int hr = Integer.parseInt(e2r);
        double height = dp_length(3);
        double weight = dp_weight(4);


        double co = stroke * hr;


        double bsa = 0.024265 * Math.pow(weight, 0.5378) * Math.pow(height, 0.3964);

        double ci = (co / bsa) * 0.001;
        String result = Filters.twobelowcomma(ci);
        String status;
        if (ci > 2.49 && ci < 4.01) {
            status = getString(R.string.normal);
        } else {
            status = getString(R.string.abnormal);
        }

        String co_r = getString(R.string.cardiac_output) + ": " + co / 1000 + " L/min";
        String ci_r = title + ":\n" + result + " L/min/m²" + " (" + status + ")\n";

        tr.setText(ci_r + co_r);

    }


    private void bsa() {

        double height = dp_length(1);
        double weight = dp_weight(2);


        double dubois = 0.007184 * Math.pow(weight, 0.425) * Math.pow(height, 0.725);
        double hay = 0.024265 * Math.pow(weight, 0.5378) * Math.pow(height, 0.3964);
        double gng = 0.0235 * Math.pow(weight, 0.51456) * Math.pow(height, 0.42246);
        double fuji = 0.008883 * Math.pow(weight, 0.444) * Math.pow(height, 0.663);

        String _fuji = "Fujimoto" + ": " + frd(dp_result_area(fuji));
        String _dubois = "Du Bois " + getString(R.string.widelyused) + ": " + frd(dp_result_area(dubois));
        String _hay = "Haycock: " + frd(dp_result_area(hay));
        String _gng = "Gehan & George" + ": " + frd(dp_result_area(gng));

        tr.setText(_dubois + "\n" + _hay + "\n" + _gng + "\n" + _fuji);
    }


    private void bmi() {
        double height = dp_length(1);
        double weight = dp_weight(2);

        double heightM = height / 100;

        double BMI = (weight) / (heightM * heightM);


        String res;
        if (BMI < 15) {
            res = getString(R.string.veryseverelyunderiweight);
        } else if (BMI >= 15 && BMI < 16) {
            res = getString(R.string.severelyunderweight);
        } else if (BMI >= 16 && BMI < 18.5) {
            res = getString(R.string.underweight);
        } else if (BMI >= 18.5 && BMI < 25) {
            res = getString(R.string.normal2);
        } else if (BMI >= 25 && BMI < 30) {
            res = getString(R.string.overweight);
        } else if (BMI >= 30 && BMI < 35) {
            res = getString(R.string.obese1);
        } else if (BMI >= 35 && BMI < 40) {
            res = getString(R.string.obese2);
        } else {
            res = getString(R.string.obese3);
        }

        tr.setText(res);
    }

    private void displacement() {

        if (MS == 1) {
            double time = dp_time(1);
            double initial = dp_speed(2);
            double finalv = dp_speed(3);

            double res = 0.5 * (finalv + initial) * time;
            setResult(getString(R.string.finalvelocity), frd(dp_result_distance(res)));
        } else {
            double a = dp_time(1);
            double b = dp_speed(2);


            double res = a * b;
            setResult(title, frd(dp_result_distance(res)));
        }
    }


    private void acceleration() {

        if (MS == 1) {

            double a = dp_speed(1);
            double b = dp_speed(2);
            double c = dp_time(3);


            double res = (b - a) / c;
            setResult(title, frd(dp_result_acceleration(res)));
        } else if (MS == 2) {

            double a = dp_speed(1);
            double b = dp_distance(2);
            double c = dp_time(3);


            double res = 2 * (b - (a * c)) / Math.pow(c, 2);
            setResult(title, frd(dp_result_acceleration(res)));

        } else {
            double a = dp_weight(1);
            double b = dp_force(2);


            double res = b / a;
            setResult(title, frd(dp_result_acceleration(res)));
        }
    }


    private void velocity() {

        if (MS == 1) {

            double initial = dp_speed(1);
            double acc = dp_acceleration(2);
            double time = dp_time(3);


            double res = initial + (acc * time);
            setResult(getString(R.string.finalvelocity), frd(dp_result_speed(res)));

        } else {
            double a = dp_distance(1);
            double b = dp_time(2);


            double res = a / b;
            setResult(title, frd(dp_result_speed(res)));
        }
    }


    private void momentum() {

        double mass = dp_weight(1);

        double velocity = dp_speed(2);

        double momentum = mass * velocity;
        if (srv == 1) {
            momentum = Math2.kgms_tolbfts(momentum);
        }

        setResult(title, frd(momentum));
    }

    private void psa() {

        if (MS == 1) {
            double pressure = dp_pressure(1);
            double area = dp(e2r);
            if (s2v == 1) {
                area = Math2.sqft_toSqm(area);
            } else if (s2v == 2) {
                area = Math2.sqyd_toSqm(area);
            } else if (s2v == 3) {
                area = Math2.Ares_toSqm(area);
            } else if (s2v == 4) {
                area = Math2.ha_toSqm(area);
            }
            double result = pressure * area;
            if (srv == 1) {
                result = Math2.n_toLbf(result);
            }
            setResult(getString(R.string.force), String.valueOf(result));

        } else if (MS == 2) {
            double force = dp_force(1);
            double pressure = dp_pressure(2);

            double result = force / pressure;
            setResult(getString(R.string.area), frd(dp_result_area(result)));

        } else {
            double force = dp_force(1);

            double area = dp(e2r);
            if (s2v == 1) {
                area = Math2.sqft_toSqm(area);
            } else if (s2v == 2) {
                area = Math2.sqyd_toSqm(area);
            } else if (s2v == 3) {
                area = Math2.Ares_toSqm(area);
            } else if (s2v == 4) {
                area = Math2.ha_toSqm(area);
            }


            double result = force / area;
            double results = dp_result_pressure(result);
            setResult(getString(R.string.pressure), frd(results));
        }
    }


    private void friction() {
        double result = dp(e1r) * dp(e2r);
        setResult(title, frd(result));

    }

    private void mach() {
        double object = dp_speed(1);
        double sound = dp_speed(2);
        double result = object / sound;


        setResult(title, String.valueOf(result));
    }

    private void fabric() {

        double fabricwidth;
        double piecewidth;
        double piecelength;
        int pieces;
        double across;
        double rows;

        fabricwidth = dp(e1r);
        piecewidth = dp(e2r);
        piecelength = dp(e3r);
        pieces = Integer.parseInt(e4r);


        across = fabricwidth / piecewidth;
        across = Math.floor(across);
        rows = pieces / across;
        rows = Math.round(rows);
        double needed = piecelength * rows;
        needed = Math.ceil(needed);


        tr.setText(getString(R.string.lengthofmaterialyouwillneed) + ":\n" + Filters.nocomma(needed) + " " + "\n" + "(" + Filters.nocomma(rows) + " " + getString(R.string.rows_down) + ", " + Filters.nocomma(across) + " " + getString(R.string.piecesacross) + ")");


    }

    private void molality() {
        double moles;
        double mass;

        moles = dp(e1r);
        mass = dp_weight(2);
        double molality = moles / mass;
        if (srv == 1) {
            molality = Math2.lb_toKg(molality);
        }
        tr.setText(getString(R.string.molality) + ":\n" + frd(molality) + " " + "mol/");
    }

    private void einstein() {
        double mass;
        double speedoflight = Math.pow(299792458, 2);
        mass = dp_weight(1);
        double einstein = speedoflight * mass;
        setResult("Energy", String.valueOf(einstein));
    }

    private void lorentz() {
        double velocity = dp(e1r);
        switch (s1v) {
            case 1:
                velocity = dp(e1r) * 3.33564e-9;
                break;
            case 2:
                velocity = dp(e1r) * 9.26567e-10;
                break;
            case 3:
                velocity = dp(e1r) * 1.49116e-9;
                break;
            case 4:
                velocity = dp(e1r) * 1.0167e-9;
                break;
            case 5:
                velocity = dp(e1r) * 1.716e-9;
                break;
        }
        double lorentz = 1 / Math.sqrt(1 - Math.pow(velocity, 2));
        double beta = Math.sqrt(1 - (1 / Math.pow(lorentz, 2)));
        tr.setText("Beta (β): " + beta + "\n" + "Gamma (γ): " + lorentz);
    }

    private void molarity() {

        double molarmass;
        double concentration;

        molarmass = dp(e1r);
        concentration = dp(e2r);

        double molarity = concentration / molarmass;
        if (s2v == 1) {
            molarity = Math2.lbusgal_togL(molarity);
        }
        setResult(title, frd(molarity));
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
        visible2 = true;
        turn3off();
        turn4off();
        turn5off();
        active = 2;
    }

    private void only3() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        turn5off();
        turn4off();
        active = 3;
    }

    private void only4() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        visible4 = true;
        turn5off();
        active = 4;
    }

    private void useall() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        visible4 = true;
        l5.setVisibility(View.VISIBLE);
        visible5 = true;
        active = 5;
    }

    private void turn2off() {
        l2.setVisibility(View.GONE);
        visible2 = false;
    }

    private void turn3off() {
        l3.setVisibility(View.GONE);
        visible3 = false;
    }

    private void turn4off() {
        l4.setVisibility(View.GONE);
        visible4 = false;
    }

    private void turn5off() {
        l5.setVisibility(View.GONE);
        visible5 = false;
    }

    private void findView() {
        lr = view.findViewById(R.id.tfs_main_result);
        tr = view.findViewById(R.id.tfs_main_result_tv);
        l3 = view.findViewById(R.id.tfs_3);
        l4 = view.findViewById(R.id.tfs_4);
        l5 = view.findViewById(R.id.tfs_5);
        l1 = view.findViewById(R.id.tfs_1);
        l2 = view.findViewById(R.id.tfs_2);
        t1 = view.findViewById(R.id.tfs_1_tv);
        t2 = view.findViewById(R.id.tfs_2_tv);
        t3 = view.findViewById(R.id.tfs_3_tv);
        t4 = view.findViewById(R.id.tfs_4_tv);
        t5 = view.findViewById(R.id.tfs_5_tv);
        s1 = view.findViewById(R.id.tfs_1_s);
        s2 = view.findViewById(R.id.tfs_2_s);
        s3 = view.findViewById(R.id.tfs_3_s);
        s4 = view.findViewById(R.id.tfs_4_s);
        s5 = view.findViewById(R.id.tfs_5_s);
        sr = view.findViewById(R.id.tfs_main_result_s);
        sMS = view.findViewById(R.id.tfs_main_s);
        et1 = view.findViewById(R.id.tfs_1_et);
        et2 = view.findViewById(R.id.tfs_2_et);
        et3 = view.findViewById(R.id.tfs_3_et);
        et4 = view.findViewById(R.id.tfs_4_et);
        et5 = view.findViewById(R.id.tfs_5_et);
        sec1 = view.findViewById(R.id.secondet1);
        sec2 = view.findViewById(R.id.secondet2);
        sec3 = view.findViewById(R.id.secondet3);
        sec4 = view.findViewById(R.id.secondet4);
        sec5 = view.findViewById(R.id.secondet5);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListener() {

        //Spinner
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s1.getSelectedItem().toString().equals("ft/in")){
                    sec1.setVisibility(View.VISIBLE);
                } else {
                    sec1.setVisibility(View.GONE);
                }
                s1v = position;
                calculations();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s2.getSelectedItem().toString().equals("ft/in")){
                    sec2.setVisibility(View.VISIBLE);
                } else {
                    sec2.setVisibility(View.GONE);
                }
                s2v = position;
                if (req.equals("friction")) {
                    String measurement = s2.getSelectedItem().toString();
                    String[] all = {measurement};
                    setadapterresult(all);
                }
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s3.getSelectedItem().toString().equals("ft/in")){
                    sec3.setVisibility(View.VISIBLE);
                } else {
                    sec3.setVisibility(View.GONE);
                }
                s3v = position;
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s4.getSelectedItem().toString().equals("ft/in")){
                    sec4.setVisibility(View.VISIBLE);
                } else {
                    sec4.setVisibility(View.GONE);
                }
                s4v = position;
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (s5.getSelectedItem().toString().equals("ft/in")){
                    sec5.setVisibility(View.VISIBLE);
                } else {
                    sec5.setVisibility(View.GONE);
                }
                s5v = position;
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                srv = position;
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //EditText
        et1.addTextChangedListener(new TextWatcher() {
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
        et2.addTextChangedListener(new TextWatcher() {
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
        et3.addTextChangedListener(new TextWatcher() {
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
        et4.addTextChangedListener(new TextWatcher() {
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
        et5.addTextChangedListener(new TextWatcher() {
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
        sec1.addTextChangedListener(new TextWatcher() {
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
        sec2.addTextChangedListener(new TextWatcher() {
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
        sec3.addTextChangedListener(new TextWatcher() {
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
        sec4.addTextChangedListener(new TextWatcher() {
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
        sec5.addTextChangedListener(new TextWatcher() {
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

    private void setadapter1(String[] list) {
        s1.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        s1.setAdapter(adapter);
    }

    private void setadapter2(String[] list) {
        s2.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        s2.setAdapter(adapter);
    }

    private void setadapter3(String[] list) {
        s3.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        s3.setAdapter(adapter);
    }

    private void setadapter4(String[] list) {
        s4.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        s4.setAdapter(adapter);
    }

    private void setadapter5(String[] list) {
        s5.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        s5.setAdapter(adapter);
    }

    private void setadapterresult(String[] list) {
        sr.setVisibility(View.VISIBLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_customspinnerclosed, list);
        adapter.setDropDownViewResource(R.layout.view_customdropdown);
        sr.setAdapter(adapter);
    }

    private void getStrings() {
        e1r = et1.getText().toString();
        getNumberToWords(1);
        if (visible2) {
            e2r = et2.getText().toString();
            getNumberToWords(2);
        }
        if (visible3) {
            e3r = et3.getText().toString();
            getNumberToWords(3);
        }
        if (visible4) {
            e4r = et4.getText().toString();
            getNumberToWords(4);
        }
        if (visible5) {
            e5r = et5.getText().toString();
            getNumberToWords(5);
        }
    }

    private void setResult(String name, String theresult) {
        tr.setText(name + ":\n" + theresult);
    }

    private String ftbc(double result) {
        return Filters.twobelowcomma(result);
    }

    private String frd(double result) {
        return Filters.rd(result);
    }

    private int spinner_position(int position) {
        switch (position) {
            case 1:
                return s1v;
            case 2:
                return s2v;
            case 3:
                return s3v;
            case 4:
                return s4v;
            default:
                return s5v;
        }
    }

    private String edittext_position(int position) {
        switch (position) {
            case 1:
                return e1r;
            case 2:
                return e2r;
            case 3:
                return e3r;
            case 4:
                return e4r;
            default:
                return e5r;
        }
    }

    private String secet_position(int position) {
        switch (position) {
            case 1:
                return sec1.getText().toString();
            case 2:
                return sec2.getText().toString();
            case 3:
                return sec3.getText().toString();
            case 4:
                return sec4.getText().toString();
            default:
                return sec5.getText().toString();
        }
    }


    private double dp(String text) {
        return Double.parseDouble(text);
    }

    private double dp_distance(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.km_tom(thevalue);
            case 2:
                return Math2.feet_tom(thevalue);
            case 3:
                return Math2.yd_tom(thevalue);
            case 4:
                return Math2.mi_tom(thevalue);
            default:
                return thevalue;
        }

    }


    private double dp_temp(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.fahrenheit_toC(thevalue);
            case 2:
                return Math2.kelvin_toC(thevalue);
            case 3:
                return Math2.ra_toc(thevalue);
            case 4:
                return Math2.re_toc(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_power(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.kw_tow(thevalue);
            case 2:
                return Math2.mw_tow(thevalue);
            case 3:
                return Math2.gw_tow(thevalue);
            case 4:
                return Math2.btuh_tow(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_time(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.minute_tosec(thevalue);
            case 2:
                return Math2.hours_tosec(thevalue);
            case 3:
                return Math2.days_tosec(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_weight(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.lb_toKg(thevalue);
            case 2:
                return Math2.g_tokg(thevalue);
            case 3:
                return Math2.mg_tokg(thevalue);
            case 4:
                return Math2.oz_tokg(thevalue);
            case 5:
                return Math2.mton_tokg(thevalue);
            case 6:
                return Math2.uston_tokg(thevalue);
            case 7:
                return Math2.ukton_tokg(thevalue);
            case 8:
                return Math2.usst_tokg(thevalue);
            case 9:
                return Math2.ukst_tokg(thevalue);
            default:
                return thevalue;
        }
    }

    private double dp_length(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.inch_toCm(thevalue);
            case 2:
                return Math2.m_tocm(thevalue);
            case 3:
                return Math2.ft_tocm(thevalue);
            case 4:
                return Math2.mm_tocm(thevalue);
            case 5:
                double inch = Math2.in_toft(dp(secet_position(position)));
                double ftin = thevalue + inch;
                return Math2.ft_tocm(ftin);
            default:
                return thevalue;
        }

    }

    private double dp_force(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        if (sP == 1) {
            return Math2.lbf_toN(thevalue);
        }
        return thevalue;

    }

    private double dp_speed(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.kmh_toms(thevalue);
            case 2:
                return Math2.mph_toms(thevalue);
            case 3:
                return Math2.fts_toms(thevalue);
            case 4:
                return Math2.knot_toms(thevalue);
            default:
                return thevalue;
        }

    }


    private double dp_energy(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.kj_toj(thevalue);
            case 2:
                return Math2.kwh_toj(thevalue);
            case 3:
                return Math2.ftlb_toj(thevalue);
            case 4:
                return Math2.kcal_toj(thevalue);
            case 5:
                return Math2.ev_toj(thevalue);
            case 6:
                return Math2.btu_toj(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_pressure(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.psi_toPascal(thevalue);
            case 2:
                return Math2.inhg_topa(thevalue);
            case 3:
                return Math2.mmhg_topa(thevalue);
            case 4:
                return Math2.bar_topa(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_volume(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.usgal_toL(thevalue);
            case 2:
                return Math2.ukgal_toL(thevalue);
            case 3:
                return Math2.m3_tol(thevalue);
            case 4:
                return Math2.cm3_tol(thevalue);
            case 5:
                return Math2.floz_tol(thevalue);
            case 6:
                return Math2.incb_tol(thevalue);
            case 7:
                return Math2.ftcb_tol(thevalue);
            default:
                return thevalue;
        }

    }


    private double dp_density(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.gcm3_tokgm3(thevalue);
            case 2:
                return Math2.slugsft3_tokgm3(thevalue);
            case 3:
                return Math2.lbmft3_tokgm3(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_concentration(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.gl_togdl(thevalue);
            case 2:
                return Math2.mgdl_togdl(thevalue);
            case 3:
                return Math2.mmoll_togdl(thevalue);
            case 4:
                return Math2.mcmolel_togdl(thevalue);
            case 5:
                return Math2.microgramdl_togdl(thevalue);
            default:
                return thevalue;
        }

    }


    private double dp_acceleration(int position) {
        double thevalue = dp(edittext_position(position));
        int sP = spinner_position(position);

        switch (sP) {
            case 1:
                return Math2.g_tomstwo(thevalue);
            case 2:
                return Math2.ftstwo_tomstwo(thevalue);
            default:
                return thevalue;
        }

    }

    private double dp_result_speed(double preresult) {
        switch (srv) {
            case 1:
                return Math2.ms_tokmh(preresult);
            case 2:
                return Math2.ms_tomph(preresult);
            case 3:
                return Math2.ms_tofts(preresult);
            case 4:
                return Math2.ms_toknot(preresult);
            default:
                return preresult;
        }
    }

    private double dp_result_acceleration(double preresult) {
        switch (srv) {
            case 1:
                return Math2.mstwo_tog(preresult);
            case 2:
                return Math2.mstwo_toftstwo(preresult);
            default:
                return preresult;
        }
    }

    private double dp_result_weight(double preresult) {

        switch (srv) {
            case 1:
                return Math2.kg_tolb(preresult);
            case 2:
                return Math2.kg_tog(preresult);
            case 3:
                return Math2.kg_tomg(preresult);
            case 4:
                return Math2.kg_tooz(preresult);
            case 5:
                return Math2.kg_tomton(preresult);
            case 6:
                return Math2.kg_touston(preresult);
            case 7:
                return Math2.kg_toukton(preresult);
            case 8:
                return Math2.kg_tousst(preresult);
            case 9:
                return Math2.kg_toukst(preresult);
            default:
                return preresult;
        }
    }


    private double dp_result_distance(double preresult) {
        switch (srv) {
            case 1:
                return Math2.m_tokm(preresult);
            case 2:
                return Math2.m_toft(preresult);
            case 3:
                return Math2.m_toyd(preresult);
            case 4:
                return Math2.m_tomi(preresult);
            default:
                return preresult;
        }
    }

    private double dp_result_area(double preresult) {
        switch (srv) {
            case 1:
                return Math2.sqm_toSqft(preresult);
            case 2:
                return Math2.sqm_toSqyd(preresult);
            case 3:
                return Math2.sqm_toAres(preresult);
            case 4:
                return Math2.sqm_toHa(preresult);
            default:
                return preresult;
        }
    }


    private double dp_result_pressure(double preresult) {
        switch (srv) {
            case 1:
                return Math2.pascal_toPsi(preresult);
            case 2:
                return Math2.pa_toinhg(preresult);
            case 3:
                return Math2.pa_tommhg(preresult);
            case 4:
                return Math2.pa_tobar(preresult);
            default:
                return preresult;
        }
    }


    private double dp_result_temp(double preresult) {
        switch (srv) {
            case 1:
                return Math2.c_tof(preresult);
            case 2:
                return Math2.c_tok(preresult);
            case 3:
                return Math2.c_tora(preresult);
            case 4:
                return Math2.c_tore(preresult);
            default:
                return preresult;
        }
    }

    private double dp_result_time(double preresult) {
        switch (srv) {
            case 1:
                return Math2.sec_tomin(preresult);
            case 2:
                return Math2.sec_toh(preresult);
            case 3:
                return Math2.sec_tod(preresult);
            default:
                return preresult;
        }
    }


    private double dp_result_volume(double preresult) {
        switch (srv) {
            case 1:
                return Math2.liter_tousgal(preresult);
            case 2:
                return Math2.liter_toukgal(preresult);
            case 3:
                return Math2.liter_tocmeter(preresult);
            case 4:
                return Math2.liter_toccentimeter(preresult);
            case 5:
                return Math2.l_tofloz(preresult);
            case 6:
                return Math2.l_toincb(preresult);
            case 7:
                return Math2.l_toftcb(preresult);
            default:
                return preresult;
        }
    }


    private double dp_result_concentration(double preresult) {
        switch (srv) {
            case 1:
                return Math2.gdl_togl(preresult);
            case 2:
                return Math2.gdl_tomgdl(preresult);
            case 3:
                return Math2.gdl_tommoll(preresult);
            case 4:
                return Math2.gdl_tomicromoll(preresult);
            case 5:
                return Math2.gdl_tomicrogramdl(preresult);
            default:
                return preresult;
        }
    }

    private double dp_result_force(double preresult) {
        switch (srv) {
            case 1:
                return Math2.n_to_lbf(preresult);
            default:
                return preresult;
        }
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
        } else {
            try {
                h1.setVisibility(View.GONE);
                h2.setVisibility(View.GONE);
                h3.setVisibility(View.GONE);
                h4.setVisibility(View.GONE);
                h5.setVisibility(View.GONE);
            } catch (NullPointerException ignored) {

            }
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        req = Temp.req;
        title = Temp.name;


        findView();
        if (isVisible()) {
            viewpager = view.findViewById(R.id.viewpager_tfs);
            tl = view.findViewById(R.id.tab_layout_tfs);
            viewpager.setAdapter(new CustomPagerAdapter(requireContext()));
            tl.setupWithViewPager(viewpager);
            sMSListener();
            setListener();

            preparation();


            h1 = view.findViewById(R.id.hint_1);
            h2 = view.findViewById(R.id.hint_2);
            h3 = view.findViewById(R.id.hint_3);
            h4 = view.findViewById(R.id.hint_4);
            h5 = view.findViewById(R.id.hint_5);
            if (!App.NumberToWordsStatus(requireContext())) {
                h1.setVisibility(View.GONE);
                h2.setVisibility(View.GONE);
                h3.setVisibility(View.GONE);
                h4.setVisibility(View.GONE);
                h5.setVisibility(View.GONE);
            } else {
                h1.setVisibility(View.VISIBLE);
                h2.setVisibility(View.VISIBLE);
                h3.setVisibility(View.VISIBLE);
                h4.setVisibility(View.VISIBLE);
                h5.setVisibility(View.VISIBLE);
            }
        }

        TextView stv = view.findViewById(R.id.selecttv);
        if (sMS.getVisibility() == View.VISIBLE) {
            stv.setVisibility(View.VISIBLE);
        } else {
            stv.setVisibility(View.GONE);
        }
    }
}
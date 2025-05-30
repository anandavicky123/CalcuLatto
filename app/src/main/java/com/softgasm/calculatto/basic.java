package com.softgasm.calculatto;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.tabs.TabLayout;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.contents.eval;
import com.softgasm.calculatto.ui.basic_viewmodel;
import com.softgasm.calculatto.ui.functions.Functions;
import com.softgasm.calculatto.ui.functions.ListOfFunctions;
import com.softgasm.calculatto.ui.functions.functions_viewholder;

import java.util.ArrayList;
import java.util.Objects;

@SuppressLint("SetTextI18n")
public class basic extends Fragment {


    static int angle_basic = 0;
    View view;
    basic_viewmodel viewmodel;
    Button btnClear, btnPercent, btnNegative, btnDelete, btnothers,
            btnDivision, btnMultiplication, btnSubmission, btnSum, btnEqual, btnDot, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    TextView tvDisplay, tvPhrase;
    Spinner s_angle;
    String parser;
    String operator = "nothing";
    String getpercent = "";
    String thepercent = "";
    int numlength;
    double acent = 0.0;
    double ccent;
    boolean takepercent = false;

    LinearLayout basic_numbers;
    ArrayList<Functions> function_list;


    public basic() {
        // Required empty public constructor
    }

    public static int basic_angle() {
        return angle_basic;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewmodel = new ViewModelProvider(requireActivity()).get(basic_viewmodel.class);


    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basic, container, false);


        btnClear = view.findViewById(R.id.btn_clear);
        btnPercent = view.findViewById(R.id.btn_percent);
        btnNegative = view.findViewById(R.id.btn_negative);
        btnDelete = view.findViewById(R.id.btn_delete);
        btnDivision = view.findViewById(R.id.btn_division);
        btnMultiplication = view.findViewById(R.id.btn_multiplication);
        btnSubmission = view.findViewById(R.id.btn_submission);
        btnSum = view.findViewById(R.id.btn_sum);
        btnEqual = view.findViewById(R.id.btn_equal);
        btnDot = view.findViewById(R.id.btn_dot);
        tvDisplay = view.findViewById(R.id.tv_display);
        tvPhrase = view.findViewById(R.id.tv_phrase);
        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);
        btn5 = view.findViewById(R.id.btn_5);
        btn6 = view.findViewById(R.id.btn_6);
        btn7 = view.findViewById(R.id.btn_7);
        btn8 = view.findViewById(R.id.btn_8);
        btn9 = view.findViewById(R.id.btn_9);
        btn0 = view.findViewById(R.id.btn_0);
        btnothers = view.findViewById(R.id.btn_other);
        s_angle = view.findViewById(R.id.basicspinner);
        basic_numbers = view.findViewById(R.id.basic_numbers);




        return view;
    }





    private void numbutton(int number) {
        clearzero();
        setparser(getit() + number);
        setOperator("null");
        if (takepercent) {
            setthepercent(thepercent + number);
        } else {
            setpercent(getpercent + number);
        }
    }


    private void calculate() {
        if (!(angle_basic == 0 || angle_basic == 1) && !(App.SubscriptionStatus(requireContext()))) {
            Toast.makeText(requireContext(), R.string.premiumanglealert, Toast.LENGTH_SHORT).show();
        } else {
            try {
                String thenumbers = getit();
                thenumbers = thenumbers.replaceAll("π", "3.1415926");
                thenumbers = thenumbers.replaceAll("℮", "2.71828");
                thenumbers = thenumbers.replaceAll("φ", "1.61803398875");
                thenumbers = thenumbers.replaceAll("!", "sfact");
                thenumbers = thenumbers.replaceAll("log10", "logten");
                thenumbers = thenumbers.replaceAll("log1p", "logap");
                thenumbers = thenumbers.replaceAll("expm1", "expm");
                Double results = eval.calculate(thenumbers);

                String ress = results.toString();

                if (thenumbers.contains("ulp")) {
                   setresult("= " + ress.substring(0, 5));
                } else {
                    setresult("= " + Filters.rd(results));
                }
            } catch (Exception e) {
                setresult("error");
            }
        }
    }

    private void reset() {
        setpercent("");;
        setthepercent("");
        setparser("0");
        setresult("");
        setTakepercent(false);
        setOperator("nothing");
    }


    private void showfunctions() {
        final Dialog dialog = new Dialog(requireContext());

        dialog.setTitle(R.string.formulas);


        dialog.setContentView(R.layout.dialog_otherfunctions_layout);
        dialog.setCanceledOnTouchOutside(true);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        String phrases = getit();

        Button cancelButton = dialog.findViewById(R.id.functioncancel);
        cancelButton.setOnClickListener(v -> dialog.dismiss());

        function_list = ListOfFunctions.basics();
        RecyclerView rv = dialog.findViewById(R.id.functions_view);
        RecyclerView.Adapter<functions_viewholder> aaa = new RecyclerView.Adapter<functions_viewholder>() {

            @NonNull
            @Override
            public functions_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_otherfunctions, parent, false);
                return new functions_viewholder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull functions_viewholder holder, int position) {
                final Functions theitems = function_list.get(position);

                holder.tvTitle.setText(theitems.DisplayName);

                holder.rootView.setOnClickListener(v -> {
                    String function_s = theitems.function;
                    int type_int = theitems.type;

                    switch (type_int) {
                        case 1:
                            symbolicnumber(function_s);
                            break;
                        case 2: {
                            String phrases = getit();
                            if (!phrases.equals("0")) {
                                setparser(getit() + ")");
                            }
                        }
                        break;
                        case 3:
                            setparser(phrases + function_s);
                            break;
                        default:
                            multi(function_s);
                            break;
                    }
                });

            }

            @Override
            public int getItemCount() {
                return function_list.size();
            }
        };
        rv.setAdapter(aaa);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(requireContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);


        layoutManager.setJustifyContent(JustifyContent.SPACE_EVENLY);

        rv.setLayoutManager(layoutManager);


        TabLayout tabLayout = dialog.findViewById(R.id.formulas_tab);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 1) {
                    function_list = ListOfFunctions.trigonometries();
                    rv.setAdapter(aaa);

                } else {
                    function_list = ListOfFunctions.basics();
                    rv.setAdapter(aaa);
                }

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        dialog.show();
    }

    private void multi(String condition) {
        clearzero();
        String phrase = getit();

        if (phrase.endsWith(")") || Filters.isInteger(getlength())) {
            setparser(getit() + "×" + condition);
        } else {
            setparser(getit() + condition);
        }

    }

    private void symbolicnumber(String condition) {
        clearzero();
        String phrase = getit();

        if (phrase.endsWith(")") || Filters.isInteger(getlength())) {
            setparser(getit() + "×" + condition);
            setOperator("null");
        } else {
            setparser(getit() + condition);
            setOperator("null");
        }

    }


    private void clearzero() {
        String phrase = getit();
        if (phrase.equals("0")) {
            setparser("");
        }
    }

    private String getit() {
        return tvPhrase.getText().toString();
    }

    private String getlength() {
        String aaa = null;


        if (getit().length() == 0) {

        } else if (getit().length() == 1) {
            aaa = getit();
        } else {
            aaa = String.valueOf(getit().charAt(getit().length() - 1));
        }

        return aaa;
    }


    private void help_dialog() {
        final Dialog dialog = new Dialog(requireContext());

        dialog.setTitle(R.string.help);

        dialog.setContentView(R.layout.dialog_basic_help);
        dialog.setCanceledOnTouchOutside(true);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        Button close = dialog.findViewById(R.id.help_close);
        close.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void onStart() {
        super.onStart();

        Display display = ((AppCompatActivity) requireContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        ViewGroup.LayoutParams layoutParams = basic_numbers.getLayoutParams();
        if (width > 1100) {
            layoutParams.width = 1100;
            basic_numbers.setLayoutParams(layoutParams);
        } else {
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            basic_numbers.setLayoutParams(layoutParams);
        }


        String[] angles = {(getString(R.string.radian)), (getString(R.string.degree)), (getString(R.string.angleturn) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.gradian) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.quadrant) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.piradian) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.miliradian) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.compasspoint) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.hourangle) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.arcminute) + " ᴾᴿᴱᴹᴵᵁᴹ"), (getString(R.string.arcsec) + " ᴾᴿᴱᴹᴵᵁᴹ")};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, angles);
        s_angle.setAdapter(adapter);

        s_angle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setangle(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn1.setOnClickListener(v -> numbutton(1));

        btn2.setOnClickListener(v -> numbutton(2));

        btn3.setOnClickListener(v -> numbutton(3));

        btn4.setOnClickListener(v -> numbutton(4));

        btn5.setOnClickListener(v -> numbutton(5));

        btn6.setOnClickListener(v -> numbutton(6));

        btn7.setOnClickListener(v -> numbutton(7));

        btn8.setOnClickListener(v -> numbutton(8));

        btn9.setOnClickListener(v -> numbutton(9));

        btn0.setOnClickListener(v -> numbutton(0));


        btnClear.setOnClickListener(v -> {
            btnClear.startAnimation(new AlphaAnimation(1F, 0.4F));
            reset();
        });

        btnPercent.setOnClickListener(v -> {
            try {
                if (!(getit().equals("0") || getit().equals("-"))) {
                    if (getpercent.isEmpty()) {
                        setacent(1.0);
                    } else {
                        setacent(Double.parseDouble(getpercent));
                    }
                    parser = getit();
                    setNumlength(thepercent.length());


                    if (takepercent) {
                        if (!thepercent.isEmpty()) {
                            double b = Double.parseDouble(thepercent);
                            String substring = parser.substring(0, parser.length() - numlength);
                            setccent((acent / 100.0f) * b);

                            setparser(substring + Filters.rd(ccent));
                        }
                    } else {
                        if (!(acent == 0)) {
                            setccent((acent / 100.0f) * acent);
                            setparser(Filters.rd(ccent));
                        }
                    }
                }
            } catch (NumberFormatException ignored) {

            }
        });

        btnNegative.setOnClickListener(v -> {
            clearzero();
            String parser = getit();
            if (parser.endsWith("-")) {

            } else {
                setparser(parser + "-");
            }

        });

        btnDelete.setOnClickListener(v -> {
            String condition = getit();
            if (condition.equals("0")) {

            } else if (condition.length() == 1) {
                reset();
            } else
                setparser(getit().substring(0, getit().length() - 1));


        });

        btnDivision.setOnClickListener(v -> {
            String phrases = getit();
            if (operator.equals("null") || operator.equals("nothing")) {
                setparser(phrases + "÷");
            } else if (!operator.equals("÷")) {
                setparser(phrases.substring(0, phrases.length() - 1) + "÷");
            }
            setOperator("÷");
            setTakepercent(true);

        });

        btnMultiplication.setOnClickListener(v -> {
            String phrases = getit();
            if (operator.equals("null") || operator.equals("nothing")) {
                setparser(phrases + "×");
            } else if (!operator.equals("×")) {
                setparser(phrases.substring(0, phrases.length() - 1) + "×");
            }
            setOperator("×");
            setTakepercent(true);

        });

        btnSubmission.setOnClickListener(v -> {
            String phrases = getit();
            if (operator.equals("null") || operator.equals("nothing")) {
                setparser(phrases + "−");
            } else if (!operator.equals("−")) {
                setparser(phrases.substring(0, phrases.length() - 1) + "−");
            }
            setOperator("−");
            setTakepercent(true);
        });

        btnSum.setOnClickListener(v -> {
            String phrases = getit();
            if (operator.equals("null") || operator.equals("nothing")) {
                setparser(phrases + "+");
            } else if (!operator.equals("+")) {
                setparser(phrases.substring(0, phrases.length() - 1) + "+");
            }
            setOperator("+");
            setTakepercent(true);

        });

        btnEqual.setOnClickListener(v -> {
            setTakepercent(false);
            String endchar = getit();
            if (!Filters.isInteger(String.valueOf(endchar.charAt(endchar.length() - 1)))) {
                setparser(endchar.substring(0, endchar.length() - 1));
            }

            if (endchar.equals(operator)) {
                reset();
            } else if (endchar.equals(".")) {
                reset();
            } else if (endchar.equals("-")) {
                reset();
            } else {
                calculate();
            }

            viewmodel.setTakepercent(false);

        });

        btnDot.setOnClickListener(v -> {
            String parser = getit();
            if (parser.isEmpty() || parser.endsWith(".")) {

            } else {
                setOperator("null");
                if (takepercent) {
                    setthepercent(thepercent + ".");
                } else {
                    setpercent(getpercent + ".");
                }
                setparser(parser + ".");
            }
        });

        btnothers.setOnClickListener(v -> {
            btnothers.startAnimation(new AlphaAnimation(1F, 0.4F));
            showfunctions();

        });


        ImageView help_result = view.findViewById(R.id.basic_help);
        help_result.setOnClickListener(v -> help_dialog());

        Handler handler = new Handler(Looper.getMainLooper());
        viewmodel.getParser().observe(getViewLifecycleOwner(), s -> {
            handler.postDelayed(() -> tvPhrase.setText(s), 0);
        });
        viewmodel.getResult().observe(getViewLifecycleOwner(), s -> {
            handler.postDelayed(() -> tvDisplay.setText(s), 300);
        });
//        viewmodel.getacent().observe(getViewLifecycleOwner(), this::setacent);
//        viewmodel.getangle_basic().observe(getViewLifecycleOwner(), this::setangle);
//        viewmodel.getccent().observe(getViewLifecycleOwner(), this::setccent);
//        viewmodel.getnumlength().observe(getViewLifecycleOwner(), this::setNumlength);
//        viewmodel.getOperator().observe(getViewLifecycleOwner(), this::setOperator);
//        viewmodel.getThePercent().observe(getViewLifecycleOwner(), this::setthepercent);
//        viewmodel.gettakepercent().observe(getViewLifecycleOwner(), this::setTakepercent);
//        viewmodel.getPercent().observe(getViewLifecycleOwner(), this::setpercent);
    }
    
    private void setOperator (String value){
        operator = value;
        viewmodel.setOperator(value);
    }

    private void setNumlength (int value){
        numlength = value;
        viewmodel.setnumlength(value);
    }

    private void setccent (double value){
        ccent = value;
        viewmodel.setccent(value);
    }

    private void setTakepercent (boolean value){
        takepercent = value;
        viewmodel.setTakepercent(value);
    }
    private void setpercent (String value){
        getpercent = value;
        viewmodel.setPercent(value);
    }

    private void setthepercent (String value){
        thepercent = value;
        viewmodel.setthepercent(value);
    }


    private void setangle (int value){
        angle_basic = value;
        viewmodel.setangle_basic(value);
    }

    private void setacent (double value){
        acent = value;
        viewmodel.setacent(value);
    }

    private void setparser (String value){
        tvPhrase.setText(value);
        viewmodel.setParser(value);
    }

    private void setresult (String value){
        tvDisplay.setText(value);
        viewmodel.putresult(value);
    }











}

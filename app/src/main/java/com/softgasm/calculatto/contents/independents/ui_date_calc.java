package com.softgasm.calculatto.contents.independents;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.DateCalculator;

import java.util.Calendar;

@SuppressLint("SetTextI18n")
public class ui_date_calc extends Fragment {


    Spinner s;
    int dd, mm, yyyy;
    String aaj;
    View view;
    TextView startDateDisplay, remainingtv, endDateDisplay, txtResult, txtMonthDays, txtWeekDays, txtTotalDays, tv_hours, tv_minutes, tv_seconds;
    Button startPickDate, endPickDate;
    AppCompatButton btnCalculate;
    Calendar startDate, endDate;

    public ui_date_calc() {
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
        view = inflater.inflate(R.layout.fragment_ui_date_calc, container, false);

        String[] arraySpinner = new String[]{
                getResources().getString(R.string.date),
                getResources().getString(R.string.age)
        };

        s = view.findViewById(R.id.date_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


        txtResult = view.findViewById(R.id.txtResult);
        txtMonthDays = view.findViewById(R.id.txtMonthDay);
        txtWeekDays = view.findViewById(R.id.txtWeekDays);
        txtTotalDays = view.findViewById(R.id.txtTotalDays);
        btnCalculate = view.findViewById(R.id.btnCalculateAge);
        startDateDisplay = view.findViewById(R.id.startDateDisplay);
        startPickDate = view.findViewById(R.id.btnStartDate);
        endDateDisplay = view.findViewById(R.id.endDateDisplay);
        endPickDate = view.findViewById(R.id.btnEndDate);
        remainingtv = view.findViewById(R.id.remainingdaystv);
        tv_hours = view.findViewById(R.id.txtTotalhours);
        tv_minutes = view.findViewById(R.id.txtTotalminutes);
        tv_seconds = view.findViewById(R.id.txtTotalseconds);

        LinearLayout endsss = view.findViewById(R.id.date_endbuttonandtv);


        startDate = Calendar.getInstance();

        Calendar calendar = getInstance();
        yyyy = calendar.get(YEAR);
        mm = calendar.get(MONTH);
        dd = calendar.get(DAY_OF_MONTH);
        if (mm < 10) {
            aaj = "" + dd + "-0" + (mm + 1) + "-" + yyyy;
        } else {
            aaj = "" + dd + "-" + (mm + 1) + "-" + yyyy;
        }

        startPickDate.setOnClickListener(v -> showDateDialog(1));

        endDate = Calendar.getInstance();

        endPickDate.setOnClickListener(v -> showDateDialog(2));

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection();
                if (position == 1) {
                    endsss.setVisibility(View.GONE);
                } else {
                    endsss.setVisibility(View.VISIBLE);
                    remainingtv.setVisibility(View.GONE);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    private void showDateDialog(int condition) {

        DatePickerDialog datePickerDialog;
        if (condition == 1) {
            datePickerDialog = new DatePickerDialog(requireContext(), (view, year, monthOfYear, dayOfMonth) -> {
                startDate.set(year, monthOfYear + 1, dayOfMonth);
                startDateDisplay.setText(startDate.get(DATE) + "/" + startDate.get(MONTH) + "/" + startDate.get(YEAR));
            }, startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        } else {
            datePickerDialog = new DatePickerDialog(requireContext(), (view, year, monthOfYear, dayOfMonth) -> {
                endDate.set(year, monthOfYear + 1, dayOfMonth);
                endDateDisplay.setText(endDate.get(DATE) + "/" + endDate.get(MONTH) + "/" + endDate.get(YEAR));
            }, endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH), endDate.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    }


    private void selection() {

        if (s.getSelectedItemPosition() == 1) {
            endPickDate.setEnabled(false);
            startPickDate.setText(getString(R.string.birthdate));
            btnCalculate.setOnClickListener(v -> {
                DateCalculator dateCaculator = DateCalculator.calculateAge(startDate.get(Calendar.DAY_OF_MONTH), startDate.get(Calendar.MONTH), startDate.get(Calendar.YEAR), dd, mm + 1, yyyy);
                String age = dateCaculator.getYear() + " " + getString(R.string.years) + ", " + dateCaculator.getMonth() + " " + getString(R.string.monthss) + ", " + dateCaculator.getDay() + " " + getString(R.string.days);
                int num_weeks = dateCaculator.getTotalDay() / 7;
                int num_months = dateCaculator.getYear() * 12 + dateCaculator.getMonth();
                int num_hours = dateCaculator.getTotalDay() * 24;
                int num_minutes = dateCaculator.getTotalDay() * 1440;
                int num_seconds = dateCaculator.getTotalDay() * 86400;
                txtResult.setText(age);
                txtTotalDays.setText(dateCaculator.getTotalDay() + " " + getString(R.string.days));
                txtWeekDays.setText(num_weeks + " " + getString(R.string.weeks) + ", " + dateCaculator.getTotalDay() % 7 + " " + getString(R.string.days));
                txtMonthDays.setText(num_months + " " + getString(R.string.monthss) + ", " + dateCaculator.getDay() + " " + getString(R.string.days));
                tv_hours.setText("" + num_hours + " " + getString(R.string.hours));
                tv_minutes.setText("" + num_minutes + " " + getString(R.string.minutes));
                tv_seconds.setText("" + num_seconds + " " + getString(R.string.seconds));
                remainingtv.setVisibility(View.VISIBLE);
                remainDays();
            });
        } else {
            endPickDate.setEnabled(true);
            startPickDate.setText(getString(R.string.startdate));
            btnCalculate.setOnClickListener(v -> {
                DateCalculator dateCaculator = DateCalculator.calculateAge(startDate.get(Calendar.DAY_OF_MONTH), startDate.get(Calendar.MONTH), startDate.get(Calendar.YEAR), endDate.get(Calendar.DAY_OF_MONTH), endDate.get(Calendar.MONTH), endDate.get(Calendar.YEAR));
                String age = dateCaculator.getYear() + " " + getString(R.string.years) + ", " + dateCaculator.getMonth() + " " + getString(R.string.monthss) + ", " + dateCaculator.getDay() + " " + getString(R.string.days);
                int num_weeks = dateCaculator.getTotalDay() / 7;
                int num_months = dateCaculator.getYear() * 12 + dateCaculator.getMonth();
                int num_hours = dateCaculator.getTotalDay() * 24;
                int num_minutes = dateCaculator.getTotalDay() * 1440;
                int num_seconds = dateCaculator.getTotalDay() * 86400;
                System.out.println(dateCaculator.getYear());
                txtResult.setText(age);
                txtTotalDays.setText(dateCaculator.getTotalDay() + " " + getString(R.string.days));
                txtWeekDays.setText(num_weeks + " " + getString(R.string.weeks) + ", " + dateCaculator.getTotalDay() % 7 + " " + getString(R.string.days));
                txtMonthDays.setText(num_months + " " + getString(R.string.monthss) + ", " + dateCaculator.getDay() + " " + getString(R.string.days));
                tv_hours.setText("" + num_hours + " " + getString(R.string.hours));
                tv_minutes.setText("" + num_minutes + " " + getString(R.string.minutes));
                tv_seconds.setText("" + num_seconds + " " + getString(R.string.seconds));
            });
        }
    }

    private void remainDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, startDate.get(DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, startDate.get(MONTH) - 1);
        calendar.set(Calendar.YEAR, yyyy);

        Calendar today = Calendar.getInstance();

        long difference = calendar.getTimeInMillis() - today.getTimeInMillis();
        int days = (int) (difference / (1000 * 60 * 60 * 24));

        if (days < 0) {
            calendar.add(Calendar.YEAR, 1);
        }
        difference = calendar.getTimeInMillis() - today.getTimeInMillis();
        days = (int) (difference / (1000 * 60 * 60 * 24));

        remainingtv.setText(getString(R.string.remainingdays) + " " + days + " " + getString(R.string.dayands));
    }
}
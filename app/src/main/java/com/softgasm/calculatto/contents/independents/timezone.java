package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.softgasm.calculatto.R;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SuppressLint({"SetTextI18n", "SimpleDateFormat"})
public class timezone extends Fragment {


    View view;

    AppCompatButton selectTime;

    RadioGroup from_group, to_group;

    Spinner sfrom, sto;

    Date raw_time;

    TextView result_tv;

    SimpleDateFormat fromFormat;

    final Calendar currentCalendar = Calendar.getInstance();


    public static int hour, minute;

    boolean from24;


    public timezone() {
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
        view = inflater.inflate(R.layout.fragment_timezone, container, false);

        sfrom = view.findViewById(R.id.tz_from);
        sto = view.findViewById(R.id.tz_to);
        selectTime = view.findViewById(R.id.tz_select);
        from_group = view.findViewById(R.id.tz_from_rb);
        to_group = view.findViewById(R.id.tz_to_rb);
        result_tv = view.findViewById(R.id.tz_result);


        return view;
    }


    private void result() {
        try {
            DateTimeZone dz = DateTimeZone.forID(TimeZone.getTimeZone(sto.getSelectedItem().toString()).getID());
            String timezone = dz.getNameKey(DateTimeUtils.currentTimeMillis());


            Date parsed = null;
            if (from24) {
                try {
                    parsed = fromFormat.parse(hour + ":" + minute); // => Date is in UTC now
                } catch (ParseException ignored) {
                }
            } else {
                parsed = raw_time;
            }


            TimeZone tz = TimeZone.getTimeZone(sto.getSelectedItem().toString());

            String formatter;
            int iTO = to_group.indexOfChild(to_group.findViewById(to_group.getCheckedRadioButtonId()));
            if (iTO == 1) {
                formatter = "HH:mm";
            } else {
                formatter = "KK:mm a";
            }
            SimpleDateFormat destFormat = new SimpleDateFormat(formatter);
            destFormat.setTimeZone(tz);

            String sresult = destFormat.format(parsed);
            result_tv.setText(sresult + " " + timezone);
        } catch (NullPointerException ignored) {

        }


    }


    @Override
    public void onStart() {
        super.onStart();

        sfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        from_group.setOnCheckedChangeListener((group, checkedId) -> result());

        to_group.setOnCheckedChangeListener((group, checkedId) -> result());

        String[] idArray = TimeZone.getAvailableIDs();
        ArrayAdapter<String> idAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item,
                idArray);
        idAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sfrom.setAdapter(idAdapter);
        sto.setAdapter(idAdapter);

        // now set the spinner to default timezone from the time zone settings
        for (int i = 0; i < idAdapter.getCount(); i++) {
            if (idAdapter.getItem(i).equals(TimeZone.getDefault().getID())) {
                sfrom.setSelection(i);
            }
        }


        selectTime.setOnClickListener(v -> {

            String fromID = sfrom.getSelectedItem().toString();
            DateTimeZone dz = DateTimeZone.forID(TimeZone.getTimeZone(fromID).getID());
            String timezone = dz.getNameKey(DateTimeUtils.currentTimeMillis());


            int iFrom = from_group.indexOfChild(from_group.findViewById(from_group.getCheckedRadioButtonId()));
            if (iFrom == 1) {
                from24 = true;
                fromFormat = new SimpleDateFormat("HH:mm");
            } else {
                from24 = false;
                fromFormat = new SimpleDateFormat("KK:mm a");
            }
            TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(),
                    (view, hourOfDay, minute1) -> {
                        hour = hourOfDay;
                        minute = minute1;
                        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
                        String given_time = hour + ":" + minute;
                        try {
                            raw_time = sdf1.parse(given_time);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        if (from24) {
                            selectTime.setText(hour + ":" + minute + " " + timezone);
                        } else {
                            selectTime.setText(fromFormat.format(raw_time) + " " + timezone);
                        }
                        fromFormat.setTimeZone(TimeZone.getTimeZone(fromID));
                        result();
                    }, currentCalendar.get(Calendar.HOUR), currentCalendar.get(Calendar.MINUTE), from24);
            timePickerDialog.show();
        });
    }
}
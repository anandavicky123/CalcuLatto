package com.softgasm.calculatto;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.softgasm.calculatto.system.App;

@SuppressLint("SetTextI18n")
public class settings extends Fragment {


    Switch toWords;
    LinearLayout about, privacypolicy, versionhistory;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        toWords = view.findViewById(R.id.towordsswitch);
        toWords.setChecked(App.NumberToWordsStatus(requireContext()));
        privacypolicy = view.findViewById(R.id.privacypolicy_button);
        versionhistory = view.findViewById(R.id.versionhistory_button);
        about = view.findViewById(R.id.about_button);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        toWords.setOnCheckedChangeListener((buttonView, isChecked) -> {
            App.SaveNumberToWordsPreference(isChecked, requireContext());
        });

        privacypolicy.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://sites.google.com/view/privacypolicyofsoftgasm/"); // missing 'http://' will cause crashed
            Intent ppintent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(ppintent);
        });


        versionhistory.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(requireContext());

            dialog.setTitle(R.string.versionhistory);


            dialog.setContentView(R.layout.dialog_version_history);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            Button cancelButton = dialog.findViewById(R.id.vh_cancel);
            cancelButton.setOnClickListener(v1 -> dialog.dismiss());
            dialog.show();
        });


        about.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.about));
    }


}
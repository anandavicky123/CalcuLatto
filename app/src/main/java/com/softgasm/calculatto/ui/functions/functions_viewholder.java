package com.softgasm.calculatto.ui.functions;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;

public class functions_viewholder extends RecyclerView.ViewHolder {


    public final TextView tvTitle;

    public final View rootView;


    public functions_viewholder(@NonNull final View view) {
        super(view);
        tvTitle = view.findViewById(R.id.functions_item);
        rootView = view;
    }
}

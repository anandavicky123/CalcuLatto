package com.softgasm.calculatto.system.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;

public class UnitConverterViewHolder extends RecyclerView.ViewHolder {

    public final View rootView;
    public final TextView tvName;
    public final TextView tvSymbol;
    public final TextView tvValue;

    public UnitConverterViewHolder(@NonNull final View view) {
        super(view);

        rootView = view;
        tvName = view.findViewById(R.id.txtname);
        tvSymbol = view.findViewById(R.id.txtsymbol);
        tvValue = view.findViewById(R.id.txtResult);
    }
}

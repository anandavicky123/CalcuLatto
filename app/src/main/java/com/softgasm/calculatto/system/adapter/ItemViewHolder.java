package com.softgasm.calculatto.system.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softgasm.calculatto.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public final View rootView;
    public final TextView tvItem;

    public final ImageView image;

    public ItemViewHolder(@NonNull final View view) {
        super(view);

        rootView = view;
        tvItem = view.findViewById(R.id.tvItem);
        image = view.findViewById(R.id.imgItem);
    }
}

package com.softgasm.calculatto.system.adapter;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public final class Items {
    public final String name;
    public final int image;

    public final int itemID;


    public Items(@NonNull final String name, @DrawableRes int image, int itemID) {
        this.name = name;
        this.image = image;
        this.itemID = itemID;
    }
}

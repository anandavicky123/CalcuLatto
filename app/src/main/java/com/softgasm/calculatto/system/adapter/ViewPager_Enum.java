package com.softgasm.calculatto.system.adapter;

import com.softgasm.calculatto.R;

public enum ViewPager_Enum {

    THUMBNAIL(R.layout.viewpager_thumbnail),
    DESC(R.layout.viewpager_desc);

    private final int mLayoutResId;

    ViewPager_Enum(int layoutResId) {
        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
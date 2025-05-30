package com.softgasm.calculatto.system.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.Temp;

public class CustomPagerAdapter extends PagerAdapter {

    private final Context mContext;
    String titles, desc;
    @DrawableRes
    int icon;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        ViewPager_Enum enums = ViewPager_Enum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(enums.getLayoutResId(), collection, false);
        collection.addView(layout);
        icon = Temp.icon;
        titles = Temp.name;
        desc = Temp.desc;
        TextView title = layout.findViewById(R.id.viewpager_title);
        ImageView thumbnail = layout.findViewById(R.id.viewpager_icon);
        TextView desctv = layout.findViewById(R.id.viewpager_desctext);

        if (position == 0) {
            title.setText(titles);
            thumbnail.setImageResource(icon);
        } else if (position == 1){
            desctv.setText(desc);
        }

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ViewPager_Enum.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}
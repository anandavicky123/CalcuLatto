package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class SolidAngle implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Steradian", "sr", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.squaredegree), "deg²", ResultLimit(DefaultValue * 3282.80635001298)));
        TheList.add(new ConverterItems("Spat", "spat", ResultLimit(DefaultValue * 0.07957981855)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "deg²":
                return NewValue * 0.000304617419786594;
            case "spat":
                return NewValue * 12.5659713495853;
            default:
                return NewValue;
        }


    }


    public String getString(@StringRes int StringID) {
        return App.getAppResources().getString(StringID);
    }

    public String ResultLimit(double result) {
        return Filters.rd(result);
    }
}
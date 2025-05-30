package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Potential implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Volt", "V", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Statvolt", "statV", ResultLimit(DefaultValue * 0.0033356405)));
        TheList.add(new ConverterItems("Abvolt", "abV", ResultLimit(DefaultValue * 100000000)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "statV":
                return NewValue * 299.7925;
            case "abV":
                return NewValue * 1.E-8;
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
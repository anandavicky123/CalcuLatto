package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Current implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Ampere", "A", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Kiloampere", "kA", ResultLimit(DefaultValue * 0.001)));
        TheList.add(new ConverterItems("Milliampere", "mA", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems("Abampere", "abA", ResultLimit(DefaultValue * 0.1)));
        TheList.add(new ConverterItems("Statampere", "statA", ResultLimit(DefaultValue * 2997924536.8)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "kA":
                return NewValue * 1000;
            case "mA":
                return NewValue * 0.001;
            case "abA":
                return NewValue * 10;
            case "statA":
                return NewValue * 3.335641E-10;
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
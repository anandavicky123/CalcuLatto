package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Dipole implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Coulomb-meter", "C⋅m", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.atomicunit), "ea₀", ResultLimit(DefaultValue * 1.1794744e+29)));
        TheList.add(new ConverterItems("Debye", "D", ResultLimit(DefaultValue * 2.997924581780902e+29)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "D":
                return NewValue * 3.33564095E-30;
            case "ea₀":
                return NewValue * 8.4783528e-30;
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
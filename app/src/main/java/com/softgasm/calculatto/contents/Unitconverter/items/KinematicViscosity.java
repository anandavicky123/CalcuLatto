package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class KinematicViscosity implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems(getString(R.string.sqmps), "m²/s", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.sqfps), "ft²/s", ResultLimit(DefaultValue * 10.763910417)));
        TheList.add(new ConverterItems("Stokes", "St", ResultLimit(DefaultValue * 10000)));
        TheList.add(new ConverterItems(getString(R.string.centistokes), "cSt", ResultLimit(DefaultValue * 1000000)));



        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "ft²/s":
                return NewValue * 0.09290304;
            case "St":
                return NewValue * 0.0001;
            case "cSt":
                return NewValue * 0.000001;
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
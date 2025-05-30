package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class AbsorbedDose implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Gray", "Gy", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.ergpergram), "erg/g", ResultLimit(DefaultValue * 10000)));
        TheList.add(new ConverterItems("Rad", "rad", ResultLimit(DefaultValue * 100)));



        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "erg/g":
                toSI = NewValue * 0.0001;
                break;
            case "rad":
                toSI = NewValue * 0.01;
                break;
            default:
                toSI = NewValue;
                break;
        }

        return toSI;
    }


    public String getString(@StringRes int StringID) {
        return App.getAppResources().getString(StringID);
    }

    public String ResultLimit(double result) {
        return Filters.rd(result);
    }
}
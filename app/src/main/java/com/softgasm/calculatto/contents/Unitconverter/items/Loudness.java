package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Loudness implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Decibel", "dB", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Bel", "B", ResultLimit(DefaultValue * 0.1)));
        TheList.add(new ConverterItems("Sone", "N", ResultLimit(10 * ((DefaultValue - 28) / 33.2))));
        TheList.add(new ConverterItems("Phon", "LN", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Neper", "Np", ResultLimit(DefaultValue * 0.115129254650564)));
        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "B":
                toSI = NewValue * 10;
                break;
            case "N":
                toSI = 33.2 * Math.log10(NewValue) + 28;
                break;
            case "LN":
                toSI = NewValue;
                break;
            case "Np":
                toSI = NewValue * 8.685889638;
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
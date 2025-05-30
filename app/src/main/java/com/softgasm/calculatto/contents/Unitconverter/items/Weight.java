package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Weight implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Newton", "N", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Kilonewton", "kN", ResultLimit(DefaultValue * 0.001)));
        TheList.add(new ConverterItems(getString(R.string.poundofforce), "lbf", ResultLimit(DefaultValue * 0.2248089431)));
        TheList.add(new ConverterItems("Dyne", "dyn", ResultLimit(DefaultValue * 100000)));
        TheList.add(new ConverterItems(getString(R.string.kilopond), "kp", ResultLimit(DefaultValue * 0.1019716213)));
        TheList.add(new ConverterItems(getString(R.string.poundal), "pdl", ResultLimit(DefaultValue * 7.2330138512)));
        TheList.add(new ConverterItems(getString(R.string.tonne_force), "tf", ResultLimit(DefaultValue * 0.0001019716)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "kN":
                toSI = NewValue * 1000;
                break;
            case "lbf":
                toSI = NewValue * 4.4482216153;
                break;
            case "dyn":
                toSI = NewValue * 0.00001;
                break;
            case "kp":
                toSI = NewValue * 9.80665;
                break;
            case "pdl":
                toSI = NewValue * 0.1382549544;
                break;
            case "tf":
                toSI = NewValue * 9806.65;
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
package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Illumination implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Lux", "lx", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.footcandle), "fc", ResultLimit(DefaultValue * 0.09290304)));
        TheList.add(new ConverterItems("Phot", "ph", ResultLimit(DefaultValue * 0.0001)));
        TheList.add(new ConverterItems("Nox", "nox", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems(getString(R.string.lumenpersquareinch), "lm/in²", ResultLimit(DefaultValue * 0.00064516)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "ph":
                return NewValue * 10000;
            case "lm/in²":
                return NewValue * 1550.0031000062;
            case "fc":
                return NewValue * 10.763910417;
            case "nox":
                return NewValue * 0.001;
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
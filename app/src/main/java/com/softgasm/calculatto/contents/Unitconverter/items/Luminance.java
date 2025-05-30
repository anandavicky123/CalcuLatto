package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Luminance implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems(getString(R.string.candelapersqm), "cd/m²", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.candelapersqin), "cd/in²", ResultLimit(DefaultValue * 0.00064516)));
        TheList.add(new ConverterItems(getString(R.string.candelapersqft), "cd/ft²", ResultLimit(DefaultValue * 0.09290304)));
        TheList.add(new ConverterItems(getString(R.string.footlambert), "fL", ResultLimit(DefaultValue * 0.291863508)));
        TheList.add(new ConverterItems("Lambert", "L", ResultLimit(DefaultValue * 0.0003141593)));
        TheList.add(new ConverterItems("Stilb", "sb", ResultLimit(DefaultValue * 0.0001)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "sb":
                return NewValue * 10000;
            case "cd/in²":
                return NewValue * 1550.0031;
            case "cd/ft²":
                return NewValue * 10.763910417;
            case "fL":
                return NewValue * 3.4262590996;
            case "L":
                return NewValue * 3183.0988618;
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
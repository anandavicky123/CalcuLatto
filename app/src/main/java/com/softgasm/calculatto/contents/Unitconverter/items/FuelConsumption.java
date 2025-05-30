package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class FuelConsumption implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Meter per liter", "m/L", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Liter per 100 km", "L/100 km", ResultLimit(DefaultValue * 100000)));
        TheList.add(new ConverterItems(getString(R.string.milegallonus), "mpg (US)", ResultLimit(DefaultValue * 0.00235214583331685)));
        TheList.add(new ConverterItems(getString(R.string.milegallonuk), "mpg (UK)", ResultLimit(DefaultValue * 0.00282480936330651)));
        TheList.add(new ConverterItems("Kilometer per liter", "km/L", ResultLimit(DefaultValue * 0.001)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "km/L":
                return NewValue * 1000;
            case "mpg (UK)":
                return NewValue * 354.006189936115;
            case "mpg (US)":
                return NewValue * 425.143707433252;
            case "L/100 km":
                return NewValue * 1E-05;
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
package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.R;

import java.util.ArrayList;

public class Charge implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements), getString(R.string.siunits)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {
            case 1:
                TheList.add(new ConverterItems("Coulomb", "C", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.millicoulomb), "mC", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.microcoulomb), "µC", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems("Nanocoulomb", "nC", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems(getString(R.string.picocoulomb), "pC", ResultLimit(DefaultValue * 1e12)));
                break;

            default:
                TheList.add(new ConverterItems("Coulomb", "C", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.millicoulomb), "mC", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.microcoulomb), "µC", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems("Nanocoulomb", "nC", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems(getString(R.string.picocoulomb), "pC", ResultLimit(DefaultValue * 1e12)));
                TheList.add(new ConverterItems("Abcoulomb", "abC", ResultLimit(DefaultValue * 0.1)));
                TheList.add(new ConverterItems("Statcoulomb (Franklin)", "statC", ResultLimit(DefaultValue * 2.99792458e9)));
                TheList.add(new ConverterItems(getString(R.string.atomicunit), "au", ResultLimit(DefaultValue * 6.24151e+18)));
                TheList.add(new ConverterItems(getString(R.string.milliamperehour), "mA⋅h", ResultLimit(DefaultValue * 0.277778)));
                TheList.add(new ConverterItems("Faraday", "F", ResultLimit(DefaultValue * 0.00001036427)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "mC":
                return NewValue * 0.001;
            case "µC":
                return NewValue * 0.000001;
            case "nC":
                return NewValue * 1.E-9;
            case "pC":
                return NewValue * 1.E-12;
            case "abC":
                return NewValue * 10;
            case "statC":
                return NewValue * 3.335640951E-10;
            case "au":
                return NewValue * 1.602176e+19;
            case "mA⋅h":
                return NewValue * 3.6;
            case "F":
                return NewValue * 96485.309;
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
package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Math2;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Temperature implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.stillinuse))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        if (CategoryPosition == 0) {
            TheList.add(new ConverterItems("Celcius", "°C", ResultLimit(DefaultValue)));
            TheList.add(new ConverterItems("Fahrenheit", "°F", ResultLimit(Math2.c_tof(DefaultValue))));
            TheList.add(new ConverterItems("Kelvin", "K", ResultLimit(Math2.c_tok(DefaultValue))));
            TheList.add(new ConverterItems("Gas Mark", "G", gasmark(DefaultValue)));
            TheList.add(new ConverterItems("Stufe", "S", ResultLimit((DefaultValue / 25) - 5)));
            TheList.add(new ConverterItems("Delisle, 2", "°D", ResultLimit((-1.5 * DefaultValue) + 150)));
            TheList.add(new ConverterItems("Leiden", "°L", ResultLimit(DefaultValue + 253)));
            TheList.add(new ConverterItems("Newton", "°N", ResultLimit(DefaultValue / 3.030303)));
            TheList.add(new ConverterItems("Rankine", "°Ra", ResultLimit((1.8 * DefaultValue) + 491.67)));
            TheList.add(new ConverterItems("Réaumur", "°Ré", ResultLimit(DefaultValue / 1.25)));
            TheList.add(new ConverterItems("Rømer", "°Rø", ResultLimit((DefaultValue / 1.904762) + 7.5)));
            TheList.add(new ConverterItems("Wedgwood, 2", "°W", ResultLimit((DefaultValue / 24.857191) - 10.821818)));
        } else {
            TheList.add(new ConverterItems("Celcius", "°C", ResultLimit(DefaultValue)));
            TheList.add(new ConverterItems("Fahrenheit", "°F", ResultLimit(Math2.c_tof(DefaultValue))));
            TheList.add(new ConverterItems("Kelvin", "K", ResultLimit(Math2.c_tok(DefaultValue))));
            TheList.add(new ConverterItems("Gas Mark", "G", gasmark(DefaultValue)));
            TheList.add(new ConverterItems("Stufe", "S", ResultLimit((DefaultValue / 25) - 5)));
            TheList.add(new ConverterItems("Rankine", "°Ra", ResultLimit((1.8 * DefaultValue) + 491.67)));
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        switch (FromSymbol) {
            case "°F":
                return Math2.fahrenheit_toC(NewValue);
            case "K":
                return Math2.kelvin_toC(NewValue);
            case "G":
                return (13.888875 * NewValue) + 121.111125;
            case "S":
                return (25 * NewValue) + 125;
            case "°D":
                return (-NewValue / 1.5) + 100;
            case "°L":
                return NewValue - 253;
            case "°N":
                return 3.030303 * NewValue;
            case "°Ra":
                return (NewValue / 1.8) - 273.15;
            case "°Ré":
                return 1.25 * NewValue;
            case "°Rø":
                return (1.904762 * NewValue) - 14.285714;
            case "°W":
                return (24.857191 * NewValue) + 269;
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


    String gasmark(double defaults) {
        if (defaults >= 135) {
            return Filters.nocomma((defaults - 121) * 9 / 125);
        } else if (defaults == 121) {
            return "0.5";
        } else if (defaults == 107) {
            return "0.25";
        } else {
            return "-";
        }
    }
}
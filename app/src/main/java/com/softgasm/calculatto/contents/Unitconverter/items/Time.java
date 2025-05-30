package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Time implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems(getString(R.string.seconds), "s", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.minute), "m", ResultLimit(DefaultValue / 60)));
        TheList.add(new ConverterItems(getString(R.string.hour), "h", ResultLimit(DefaultValue / 3600)));
        TheList.add(new ConverterItems(getString(R.string.day), "d", ResultLimit(DefaultValue / 86400)));
        TheList.add(new ConverterItems(getString(R.string.weeks), "w", ResultLimit(DefaultValue / 604800)));
        TheList.add(new ConverterItems(getString(R.string.month1), "M", ResultLimit(DefaultValue / 2628000)));
        TheList.add(new ConverterItems(getString(R.string.years), "y", ResultLimit(DefaultValue * 3.168808781E-8)));
        TheList.add(new ConverterItems(getString(R.string.milliseconds), "ms", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems(getString(R.string.microseconds), "μs", ResultLimit(DefaultValue * 1e+6)));
        TheList.add(new ConverterItems(getString(R.string.nanoseconds), "ns", ResultLimit(DefaultValue * 1e+9)));
        TheList.add(new ConverterItems(getString(R.string.femtoseconds), "fs", ResultLimit(DefaultValue * 1e+15)));
        TheList.add(new ConverterItems(getString(R.string.zeptoseconds), "zs", ResultLimit(DefaultValue * 1e+21)));
        TheList.add(new ConverterItems(getString(R.string.plancktime), "tₚ", ResultLimit(DefaultValue * 1.855094832E+43)));
        TheList.add(new ConverterItems(getString(R.string.jiffy) + " (50Hz)", "j", ResultLimit(DefaultValue * 50)));
        TheList.add(new ConverterItems("Svedberg", "S", ResultLimit(DefaultValue * 1e13)));
        TheList.add(new ConverterItems(getString(R.string.shake), "shake", ResultLimit(DefaultValue * 1e8)));
        TheList.add(new ConverterItems(getString(R.string.moment) + " (90/s)", "momentum", ResultLimit(DefaultValue * 90)));
        TheList.add(new ConverterItems(getString(R.string.fortnight), "fn", ResultLimit(DefaultValue / 1209600)));
        TheList.add(new ConverterItems(getString(R.string.semester), "sem", ResultLimit(DefaultValue / 10886400)));
        TheList.add(new ConverterItems(getString(R.string.decades), "D", ResultLimit(DefaultValue * 3.168808781E-9)));
        TheList.add(new ConverterItems(getString(R.string.jubilee), "jubilee", ResultLimit(DefaultValue / 1577880000)));
        TheList.add(new ConverterItems(getString(R.string.century), "c", ResultLimit(DefaultValue * 3.17098e-10)));
        TheList.add(new ConverterItems(getString(R.string.millenium), "ka", ResultLimit(DefaultValue * 3.17098e-11)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "m":
                toSI = NewValue * 60;
                break;
            case "h":
                toSI = NewValue * 3600;
                break;
            case "d":
                toSI = NewValue * 86400;
                break;
            case "w":
                toSI = NewValue * 604800;
                break;
            case "M":
                toSI = NewValue * 2628000;
                break;
            case "y":
                toSI = NewValue * 31557600;
                break;
            case "ms":
                toSI = NewValue / 1000;
                break;
            case "μs":
                toSI = NewValue / 1e+6;
                break;
            case "ns":
                toSI = NewValue / 1e+9;
                break;
            case "fs":
                toSI = NewValue / 1e+15;
                break;
            case "zs":
                toSI = NewValue / 1e+21;
                break;
            case "tₚ":
                toSI = NewValue / 1.855e+43;
                break;
            case "j":
                toSI = NewValue / 50;
                break;
            case "S":
                toSI = NewValue / 1e13;
                break;
            case "shake":
                toSI = NewValue / 1e8;
                break;
            case "momentum":
                toSI = NewValue / 90;
                break;
            case "fn":
                toSI = NewValue * 1209600;
                break;
            case "sem":
                toSI = NewValue * 10886400;
                break;
            case "jubilee":
                toSI = NewValue * 1577880000;
                break;
            case "c":
                toSI = NewValue * 3.154e+9;
                break;
            case "ka":
                toSI = NewValue * 3.154e+10;
                break;
            case "D":
                toSI = NewValue * 315576000;
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
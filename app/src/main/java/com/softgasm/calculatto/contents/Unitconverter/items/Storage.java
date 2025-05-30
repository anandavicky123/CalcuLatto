package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Storage implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Byte", "B", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Bit", "b", ResultLimit(DefaultValue * 8)));
        TheList.add(new ConverterItems("Nibble", "nibble", ResultLimit(DefaultValue * 2)));
        TheList.add(new ConverterItems("Crumb", "crumb", ResultLimit(DefaultValue * 4)));
        TheList.add(new ConverterItems("Word", "word", ResultLimit(DefaultValue * 0.5)));
        TheList.add(new ConverterItems("Double word", "dword", ResultLimit(DefaultValue * 0.25)));
        TheList.add(new ConverterItems("Kilobit", "kb", ResultLimit(DefaultValue * 0.0078125)));
        TheList.add(new ConverterItems("Kilobyte", "kB", ResultLimit(DefaultValue * 0.0009765625)));
        TheList.add(new ConverterItems("Megabit", "Mb", ResultLimit(DefaultValue * 0.0000076294)));
        TheList.add(new ConverterItems("Megabyte", "MB", ResultLimit(DefaultValue * 9.536743164E-7)));
        TheList.add(new ConverterItems("Gigabit", "Gb", ResultLimit(DefaultValue * 7.450580596E-9)));
        TheList.add(new ConverterItems("Gigabyte", "GB", ResultLimit(DefaultValue * 9.313225746E-10)));
        TheList.add(new ConverterItems("Terabit", "Tb", ResultLimit(DefaultValue * 7.275957614E-12)));
        TheList.add(new ConverterItems("Terabyte", "TB", ResultLimit(DefaultValue * 9.094947017E-13)));
        TheList.add(new ConverterItems("Petabit", "Pb", ResultLimit(DefaultValue * 7.105427357E-15)));
        TheList.add(new ConverterItems("Petabyte", "PB", ResultLimit(DefaultValue * 8.881784197E-16)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "b":
                return NewValue * 0.125;
            case "nibble":
                return NewValue * 0.5;
            case "crumb":
                return NewValue * 0.25;
            case "word":
                return NewValue * 2;
            case "dword":
                return NewValue * 4;
            case "kb":
                return NewValue * 128;
            case "kB":
                return NewValue * 1024;
            case "Mb":
                return NewValue * 131072;
            case "MB":
                return NewValue * 1048576;
            case "Gb":
                return NewValue * 134217728;
            case "GB":
                return NewValue * 1073741824;
            case "Tb":
                return NewValue * 1.37438953472e11;
            case "TB":
                return NewValue * 1.099511627776e12;
            case "Pb":
                return NewValue * 1.40737488355330e14;
            case "PB":
                return NewValue * 1.12589990684260e15;
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
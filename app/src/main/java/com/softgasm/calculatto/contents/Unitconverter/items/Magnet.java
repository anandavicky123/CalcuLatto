package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Magnet implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Weber", "Wb", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Milliweber", "mWb", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems("Microweber", "µWb", ResultLimit(DefaultValue * 1000000)));
        TheList.add(new ConverterItems("Maxwell", "Mx", ResultLimit(DefaultValue * 100000000)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol){
            case "Mx":
                return NewValue * 0.00000001;
            case "mWb":
                return NewValue * 0.001;
            case "µWb":
                return NewValue * 0.000001;
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
package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Speed implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems(getString(R.string.meterpersecond), "m/s", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.kilometerperhour), "km/h", ResultLimit(DefaultValue * 3.6)));
        TheList.add(new ConverterItems(getString(R.string.milesperhour), "mph", ResultLimit(DefaultValue * 2.2369362921)));
        TheList.add(new ConverterItems(getString(R.string.knot), "knot", ResultLimit(DefaultValue * 1.9438444924)));
        TheList.add(new ConverterItems(getString(R.string.feetpersecond), "fps", ResultLimit(DefaultValue * 3.280839895)));
        TheList.add(new ConverterItems("Mach", "Ma", ResultLimit(DefaultValue * 0.0033892974)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "km/h":
                return NewValue * 0.2777777778;
            case "mph":
                return NewValue * 0.44704;
            case "knot":
                return NewValue * 0.5144444444;
            case "fps":
                return NewValue * 0.3048;
            case "Ma":
                return NewValue * 295.0464;
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
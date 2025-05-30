package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Torque implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Newton-meter", "N⋅m", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems(getString(R.string.newtoncentimeter), "N⋅cm", ResultLimit(DefaultValue * 100)));
        TheList.add(new ConverterItems(getString(R.string.newtonmillimeter), "N⋅mm", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems(getString(R.string.poundforcefoot), "lbf⋅ft", ResultLimit(DefaultValue * 0.7375621212)));
        TheList.add(new ConverterItems(getString(R.string.poundforceinch), "lbf⋅in", ResultLimit(DefaultValue * 8.850745454)));
        TheList.add(new ConverterItems(getString(R.string.ounceforceinch), "ozf⋅in", ResultLimit(DefaultValue * 141.61192894)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        switch (FromSymbol) {
            case "N⋅cm":
                return NewValue * 0.01;
            case "N⋅mm":
                return NewValue * 0.001;
            case "lbf⋅ft":
                return NewValue * 1.355818;
            case "lbf⋅in":
                return NewValue * 0.1129848333;
            case "ozf⋅in":
                return NewValue * 0.007061552;
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
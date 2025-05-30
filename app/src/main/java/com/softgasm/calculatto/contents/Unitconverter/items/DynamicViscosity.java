package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class DynamicViscosity implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems(getString(R.string.pascalsec), "Pa⋅s", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Poise", "P", ResultLimit(DefaultValue * 10)));
        TheList.add(new ConverterItems(getString(R.string.centipoise), "cP", ResultLimit(DefaultValue * 1000)));
        TheList.add(new ConverterItems(getString(R.string.poundperfoothour), "lb/(ft⋅h)", ResultLimit(DefaultValue * 2419.0883105)));
        TheList.add(new ConverterItems(getString(R.string.poundperfootsec), "lb/(ft⋅s)", ResultLimit(DefaultValue * 0.6719689751)));
        TheList.add(new ConverterItems(getString(R.string.lbfssqft), "lbf⋅s/ft²", ResultLimit(DefaultValue * 0.0208854342)));
        TheList.add(new ConverterItems(getString(R.string.lbfssqin), "lbf⋅s/in²", ResultLimit(DefaultValue * 0.0001450377)));


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "P":
                return NewValue * 0.1;
            case "cP":
                return NewValue * 0.001;
            case "lb/(ft⋅h)":
                return NewValue * 0.0004133789;
            case "lb/(ft⋅s)":
                return NewValue * 1.4881639436;
            case "lbf⋅s/ft²":
                return NewValue * 47.88025898;
            case "lbf⋅s/in²":
                return NewValue * 6894.7572932;
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
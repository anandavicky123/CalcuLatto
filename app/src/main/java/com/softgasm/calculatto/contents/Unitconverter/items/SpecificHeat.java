package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class SpecificHeat implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        TheList.add(new ConverterItems("Joule/Kelvin/kilogram", "J⋅K⁻¹⋅kg⁻¹", ResultLimit(DefaultValue)));
        TheList.add(new ConverterItems("Joule/Kelvin/gram", "J⋅K⁻¹⋅g⁻¹", ResultLimit(DefaultValue * 0.001)));
        TheList.add(new ConverterItems("BTU/Rankine/pound", "BTU/lb⋅°R", ResultLimit(DefaultValue * 0.00023884475)));
        TheList.add(new ConverterItems(getString(R.string.smallcalorie), "cal", ResultLimit(DefaultValue * 0.23900573613)));
        TheList.add(new ConverterItems(getString(R.string.grandcalorie), "Cal", ResultLimit(DefaultValue * 0.00023900573)));

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "J⋅K⁻¹⋅g⁻¹":
                return NewValue * 1000;
            case "BTU/lb⋅°R":
                return NewValue * 4186.82;
            case "cal":
                return NewValue * 4.184;
            case "Cal":
                return NewValue * 4184;
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
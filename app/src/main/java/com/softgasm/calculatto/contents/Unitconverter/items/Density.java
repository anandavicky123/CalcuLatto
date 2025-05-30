package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Density implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements), (getString(R.string.siunits)), (getString(R.string.imperialandusc))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {
            case 1:
                TheList.add(new ConverterItems(getString(R.string.kgperm3), "kg/m³", ResultLimit(DefaultValue)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.ozperft3), "oz/ft³", ResultLimit(DefaultValue * 0.998847369242177)));
                TheList.add(new ConverterItems(getString(R.string.ozperin3), "oz/in³", ResultLimit(DefaultValue * 0.00057803667201515)));
                TheList.add(new ConverterItems(getString(R.string.ozpergalus), "oz/gal", ResultLimit(DefaultValue * 0.133526471232962)));
                TheList.add(new ConverterItems(getString(R.string.lbperft3), "lb/ft³", ResultLimit(DefaultValue * 0.0624279605755126)));
                TheList.add(new ConverterItems(getString(R.string.lbperin3), "lb/in³", ResultLimit(DefaultValue * 3.61272919997179E-05)));
                TheList.add(new ConverterItems(getString(R.string.lbpergalus), "lb/gal", ResultLimit(DefaultValue * 0.00834540445177617)));
                TheList.add(new ConverterItems(getString(R.string.slugperft3), "slug/ft³", ResultLimit(DefaultValue * 0.00194032033322652)));
                break;

            default:
                TheList.add(new ConverterItems(getString(R.string.kgperm3), "kg/m³", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.gpml), "g/mL", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.gpcm3), "g/cm³", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems("Gram per liter", "g/L", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("Kilogram per liter", "kg/L", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.ozperft3), "oz/ft³", ResultLimit(DefaultValue * 0.998847369242177)));
                TheList.add(new ConverterItems(getString(R.string.ozperin3), "oz/in³", ResultLimit(DefaultValue * 0.00057803667201515)));
                TheList.add(new ConverterItems(getString(R.string.ozpergalus), "oz/gal", ResultLimit(DefaultValue * 0.133526471232962)));
                TheList.add(new ConverterItems(getString(R.string.lbperft3), "lb/ft³", ResultLimit(DefaultValue * 0.0624279605755126)));
                TheList.add(new ConverterItems(getString(R.string.lbperin3), "lb/in³", ResultLimit(DefaultValue * 3.61272919997179E-05)));
                TheList.add(new ConverterItems(getString(R.string.lbpergalus), "lb/gal", ResultLimit(DefaultValue * 0.00834540445177617)));
                TheList.add(new ConverterItems(getString(R.string.slugperft3), "slug/ft³", ResultLimit(DefaultValue * 0.00194032033322652)));
                TheList.add(new ConverterItems(getString(R.string.earthdensity), "\uD83D\uDF28ρ", ResultLimit(DefaultValue * 0.000181225081551287)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "g/L":
                return NewValue;
            case "g/mL":
            case "g/cm³":
            case "kg/L":
                return NewValue * 1000;
            case "oz/ft³":
                return NewValue * 1.00115396084859;
            case "oz/in³":
                return NewValue * 1729.99404434636;
            case "oz/gal":
                return NewValue * 7.48915170726945;
            case "lb/ft³":
                return NewValue * 16.0184633741223;
            case "lb/in³":
                return NewValue * 27679.9047104834;
            case "lb/gal":
                return NewValue * 119.826427320388;
            case "slug/ft³":
                return NewValue * 515.378818062026;
            case "\uD83D\uDF28ρ":
                return NewValue * 5518;
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
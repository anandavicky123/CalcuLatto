package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Math2;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Angle implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.frequentlyused))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        if (CategoryPosition == 1) {
            TheList.add(new ConverterItems(getString(R.string.radian), "rad", ResultLimit(DefaultValue)));
            TheList.add(new ConverterItems(getString(R.string.degree), "°", ResultLimit(Math.toDegrees(DefaultValue))));
        } else {
            TheList.add(new ConverterItems(getString(R.string.radian), "rad", ResultLimit(DefaultValue)));
            TheList.add(new ConverterItems(getString(R.string.piradian), "π rad", ResultLimit(DefaultValue / Math.PI)));
            TheList.add(new ConverterItems(getString(R.string.miliradian), "mil", ResultLimit(DefaultValue * 1000)));
            TheList.add(new ConverterItems(getString(R.string.degree), "°", ResultLimit(Math.toDegrees(DefaultValue))));
            TheList.add(new ConverterItems(getString(R.string.angleturn), "tr", ResultLimit(DefaultValue / (Math.PI * 2))));
            TheList.add(new ConverterItems(getString(R.string.gradian), "gon", ResultLimit(DefaultValue * (200 / Math.PI))));
            TheList.add(new ConverterItems(getString(R.string.quadrant), "90°", ResultLimit(DefaultValue * 0.6366197724)));
            TheList.add(new ConverterItems(getString(R.string.sextant), "60°", ResultLimit(DefaultValue * 0.9549296586)));
            TheList.add(new ConverterItems(getString(R.string.octant), "45°", ResultLimit(DefaultValue * 1.2732398096252)));
            TheList.add(new ConverterItems(getString(R.string.compasspoint), "NESW", ResultLimit(DefaultValue * 5.0929581789407)));
            TheList.add(new ConverterItems(getString(R.string.hourangle), "HA", ResultLimit(DefaultValue * 3.8197186342)));
            TheList.add(new ConverterItems(getString(R.string.arcminute), "′", ResultLimit(DefaultValue * (60 * 180) / Math.PI)));
            TheList.add(new ConverterItems(getString(R.string.arcsec), "″", ResultLimit(DefaultValue * (3600 * 180) / Math.PI)));
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "π rad":
                toSI = Math2.pirad_toRadians(NewValue);
                break;
            case "mil":
                toSI = Math2.milirad_toRadians(NewValue);
                break;
            case "°":
                toSI = Math.toRadians(NewValue);
                break;
            case "tr":
                toSI = Math2.turn_toRadians(NewValue);
                break;
            case "gon":
                toSI = Math2.gradian_toRadians(NewValue);
                break;
            case "90°":
                toSI = Math2.quadrant_toRadians(NewValue);
                break;
            case "60°":
                toSI = NewValue * 1.0471975511965976;
                break;
            case "45°":
                toSI = NewValue * 0.7853981633974483;
                break;
            case "NESW":
                toSI = NewValue * 0.19634954084936207;
                break;
            case "HA":
                toSI = Math2.hourangle_toRadians(NewValue);
                break;
            case "′":
                toSI = Math2.arcminute_toRadians(NewValue);
                break;
            case "″":
                toSI = Math2.arcsec_toRadians(NewValue);
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
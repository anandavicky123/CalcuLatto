package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Area implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc), (Filters.CountryName("in"))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {

            case 1:
                TheList.add(new ConverterItems(getString(R.string.squaremeter), "m²", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.squarecentimeter), "cm²", ResultLimit(DefaultValue * 10000)));
                TheList.add(new ConverterItems(getString(R.string.squarekilometer), "km²", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems(getString(R.string.squaredecameter), "dam²", ResultLimit(DefaultValue * 0.01)));
                TheList.add(new ConverterItems(getString(R.string.squaredecimeter), "dm²", ResultLimit(DefaultValue * 100)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.squarefoot), "ft²", ResultLimit(DefaultValue * 10.763910417)));
                TheList.add(new ConverterItems(getString(R.string.squareinch), "in²", ResultLimit(DefaultValue * 1550.0031)));
                TheList.add(new ConverterItems(getString(R.string.squaremil), "mil²", ResultLimit(DefaultValue * 1550003100)));
                TheList.add(new ConverterItems(getString(R.string.squareyard), "yd²", ResultLimit(DefaultValue * 1.1959900463)));
                TheList.add(new ConverterItems(getString(R.string.squaremile), "mi²", ResultLimit(DefaultValue * 3.861021585E-7)));
                break;
            case 3:
                TheList.add(new ConverterItems("Guntha", "guntha", ResultLimit(DefaultValue * 0.009884)));
                TheList.add(new ConverterItems("Dhur (Bihar, Jharkhand)", "dhur", ResultLimit(DefaultValue * 0.158177)));
                TheList.add(new ConverterItems("Bigha-Pucca", "bigha-pucca", ResultLimit(DefaultValue * 0.000399)));
                TheList.add(new ConverterItems("Kanal", "kanal", ResultLimit(DefaultValue * 0.001977)));
                TheList.add(new ConverterItems("Ghumaon", "ghumaon", ResultLimit(DefaultValue * 0.0002471054)));
                break;
            default:
                TheList.add(new ConverterItems(getString(R.string.squaremeter), "m²", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.squarecentimeter), "cm²", ResultLimit(DefaultValue * 10000)));
                TheList.add(new ConverterItems(getString(R.string.squarekilometer), "km²", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems(getString(R.string.squaredecameter), "dam²", ResultLimit(DefaultValue * 0.01)));
                TheList.add(new ConverterItems(getString(R.string.squaredecimeter), "dm²", ResultLimit(DefaultValue * 100)));
                TheList.add(new ConverterItems(getString(R.string.squarefoot), "ft²", ResultLimit(DefaultValue * 10.763910417)));
                TheList.add(new ConverterItems(getString(R.string.squareinch), "in²", ResultLimit(DefaultValue * 1550.0031)));
                TheList.add(new ConverterItems(getString(R.string.squaremil), "mil²", ResultLimit(DefaultValue * 1550003100)));
                TheList.add(new ConverterItems(getString(R.string.squareyard), "yd²", ResultLimit(DefaultValue * 1.1959900463)));
                TheList.add(new ConverterItems(getString(R.string.squaremile), "mi²", ResultLimit(DefaultValue * 3.861021585E-7)));
                TheList.add(new ConverterItems(getString(R.string.areunit), "a", ResultLimit(DefaultValue * 0.01)));
                TheList.add(new ConverterItems(getString(R.string.hectare), "ha", ResultLimit(DefaultValue * 0.0001)));
                TheList.add(new ConverterItems(getString(R.string.acre), "ac", ResultLimit(DefaultValue * 0.0002471054)));
                TheList.add(new ConverterItems(getString(R.string.barn), "b", ResultLimit(DefaultValue * 1.E+28)));
                TheList.add(new ConverterItems("Guntha", "guntha", ResultLimit(DefaultValue * 0.009884)));
                TheList.add(new ConverterItems("Dhur (Bihar, Jharkhand)", "dhur", ResultLimit(DefaultValue * 0.158177)));
                TheList.add(new ConverterItems("Bigha-Pucca", "bigha-pucca", ResultLimit(DefaultValue * 0.000399)));
                TheList.add(new ConverterItems("Kanal", "kanal", ResultLimit(DefaultValue * 0.001977)));
                TheList.add(new ConverterItems("Ghumaon", "ghumaon", ResultLimit(DefaultValue * 0.0002471054)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        switch (FromSymbol) {
            case "cm²":
                return NewValue * 0.0001;
            case "km²":
                return NewValue * 1000000;
            case "dam²":
                return NewValue * 100;
            case "dm²":
                return NewValue * 0.01;
            case "ft²":
                return NewValue * 0.09290304;
            case "in²":
                return NewValue * 0.00064516;
            case "mil²":
                return NewValue * 6.4516E-10;
            case "yd²":
                return NewValue * 0.83612736;
            case "mi²":
                return NewValue * 2589988.1103;
            case "a":
                return NewValue * 100;
            case "ha":
                return NewValue * 10000;
            case "ac":
                return NewValue * 4046.8564224;
            case "b":
                return NewValue * 1.E-28;
            case "guntha":
                return NewValue * 101.17141056;
            case "dhur":
                return NewValue * 6.32321316;
            case "bigha-pucca":
                return NewValue * 2529.285264;
            case "kanal":
                return NewValue * 505.8570528;
            case "ghumaon":
                return NewValue * 4046.8564224;
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
package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;

import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Cooking implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), (Filters.CountryName("us")), (Filters.CountryName("uk")), (Filters.CountryName("au"))};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {

            case 1:
                TheList.add(new ConverterItems(getString(R.string.milliliter), "mL", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.liter), "L", ResultLimit(DefaultValue * 0.001)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.teaspoon) + " (" + Filters.CountryName("us") + ")", "tsp. (US)", ResultLimit(DefaultValue * 0.20283975659)));
                TheList.add(new ConverterItems(getString(R.string.dessertspoon) + " (" + Filters.CountryName("us") + ")", "dsp. (US)", ResultLimit(DefaultValue * 0.10141987829)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon) + " (" + Filters.CountryName("us") + ")", "tbsp. (US)", ResultLimit(DefaultValue * 0.06761325219)));
                TheList.add(new ConverterItems(getString(R.string.fluidounce) + " (" + Filters.CountryName("us") + ")", "fl oz (US)", ResultLimit(DefaultValue * 0.03381805884)));
                TheList.add(new ConverterItems(getString(R.string.gill) + " (" + Filters.CountryName("us") + ")", "gill", ResultLimit(DefaultValue * 0.00845351)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("us") + ")", "c (US)", ResultLimit(DefaultValue * 0.00422672133)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("us") + ")", "p (US)", ResultLimit(DefaultValue * 0.00211336066)));
                TheList.add(new ConverterItems(getString(R.string.quart) + " (" + Filters.CountryName("us") + ")", "q (US)", ResultLimit(DefaultValue * 0.00105669149)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("us") + ")", "gal (US)", ResultLimit(DefaultValue * 0.00026417217)));
                break;
            case 3:
                TheList.add(new ConverterItems(getString(R.string.teaspoon), "tsp.", ResultLimit(DefaultValue * 0.2)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon), "tbsp.", ResultLimit(DefaultValue * 0.06666666666)));
                TheList.add(new ConverterItems(getString(R.string.fluidounce), "fl oz", ResultLimit(DefaultValue * 0.03519887363)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("uk") + ")", "c (UK)", ResultLimit(DefaultValue * 0.00351951571)));
                TheList.add(new ConverterItems(getString(R.string.pint), "p", ResultLimit(DefaultValue * 0.00175975785)));
                TheList.add(new ConverterItems(getString(R.string.quart), "q", ResultLimit(DefaultValue * 0.00087987892)));
                TheList.add(new ConverterItems(getString(R.string.gallon), "gal", ResultLimit(DefaultValue * 0.00021996924)));
                break;
            case 4:
                TheList.add(new ConverterItems(getString(R.string.teaspoon), "tsp.", ResultLimit(DefaultValue * 0.2)));
                TheList.add(new ConverterItems(getString(R.string.dessertspoon) + " (" + Filters.CountryName("au") + ")", "dsp. (AU)", ResultLimit(DefaultValue * 0.1)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon) + " (" + Filters.CountryName("au") + ")", "tbsp. (AU)", ResultLimit(DefaultValue * 0.05)));
                TheList.add(new ConverterItems(getString(R.string.fluidounce), "fl oz", ResultLimit(DefaultValue * 0.03519887363)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("au") + ")", "c (AU)", ResultLimit(DefaultValue * 0.004)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (570 mL)", "p (AU)", ResultLimit(DefaultValue * 0.00175438596)));
                TheList.add(new ConverterItems(getString(R.string.quart), "q", ResultLimit(DefaultValue * 0.00087987892)));
                TheList.add(new ConverterItems(getString(R.string.gallon), "gal", ResultLimit(DefaultValue * 0.00021996924)));
                break;
            default:
                TheList.add(new ConverterItems(getString(R.string.milliliter), "mL", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.liter), "L", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.teaspoon), "tsp.", ResultLimit(DefaultValue * 0.2)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon), "tbsp.", ResultLimit(DefaultValue * 0.06666666666)));
                TheList.add(new ConverterItems(getString(R.string.fluidounce), "fl oz", ResultLimit(DefaultValue * 0.03519887363)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("uk") + ")", "c (UK)", ResultLimit(DefaultValue * 0.00351951571)));
                TheList.add(new ConverterItems(getString(R.string.pint), "p (US)", ResultLimit(DefaultValue * 0.00175975785)));
                TheList.add(new ConverterItems(getString(R.string.quart), "q", ResultLimit(DefaultValue * 0.00087987892)));
                TheList.add(new ConverterItems(getString(R.string.gallon), "gal", ResultLimit(DefaultValue * 0.00021996924)));
                TheList.add(new ConverterItems(getString(R.string.teaspoon) + " (" + Filters.CountryName("us") + ")", "tsp. (US)", ResultLimit(DefaultValue * 0.20283975659)));
                TheList.add(new ConverterItems(getString(R.string.dessertspoon) + " (" + Filters.CountryName("us") + ")", "dsp. (US)", ResultLimit(DefaultValue * 0.10141987829)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon) + " (" + Filters.CountryName("us") + ")", "tbsp. (US)", ResultLimit(DefaultValue * 0.06761325219)));
                TheList.add(new ConverterItems(getString(R.string.fluidounce) + " (" + Filters.CountryName("us") + ")", "fl oz (US)", ResultLimit(DefaultValue * 0.03381805884)));
                TheList.add(new ConverterItems(getString(R.string.gill) + " (" + Filters.CountryName("us") + ")", "gill", ResultLimit(DefaultValue * 0.00845351)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("us") + ")", "c (US)", ResultLimit(DefaultValue * 0.00422672133)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("us") + ")", "p (US)", ResultLimit(DefaultValue * 0.00211336066)));
                TheList.add(new ConverterItems(getString(R.string.quart) + " (" + Filters.CountryName("us") + ")", "q (US)", ResultLimit(DefaultValue * 0.00105669149)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("us") + ")", "gal (US)", ResultLimit(DefaultValue * 0.00026417217)));
                TheList.add(new ConverterItems(getString(R.string.dessertspoon) + " (" + Filters.CountryName("au") + ")", "dsp. (AU)", ResultLimit(DefaultValue * 0.1)));
                TheList.add(new ConverterItems(getString(R.string.tablespoon) + " (" + Filters.CountryName("au") + ")", "tbsp. (AU)", ResultLimit(DefaultValue * 0.05)));
                TheList.add(new ConverterItems(getString(R.string.cup) + " (" + Filters.CountryName("au") + ")", "c (AU)", ResultLimit(DefaultValue * 0.004)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (570 mL)", "p (AU)", ResultLimit(DefaultValue * 0.00175438596)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "L":
                return NewValue * 1000;
            case "tsp.":
                return NewValue * 5;
            case "tbsp.":
                return NewValue * 15;
            case "fl oz":
                return NewValue * 28.41;
            case "c (UK)":
                return NewValue * 284.13;
            case "p":
                return NewValue * 568.26;
            case "q":
                return NewValue * 1136.52;
            case "gal":
                return NewValue * 4546.09;
            case "tsp. (US)":
                return NewValue * 4.93;
            case "dsp. (US)":
                return NewValue * 9.86;
            case "tbsp. (US)":
                return NewValue * 14.79;
            case "fl oz (US)":
                return NewValue * 29.57;
            case "gill":
                return NewValue * 118.294;
            case "c (US)":
                return NewValue * 236.59;
            case "p (US)":
                return NewValue * 473.18;
            case "q (US)":
                return NewValue * 946.35;
            case "gal (US)":
                return NewValue * 3785.41;
            case "dsp. (AU)":
                return NewValue * 10;
            case "tbsp. (AU)":
                return NewValue * 20;
            case "c (AU)":
                return NewValue * 250;
            case "p (AU)":
                return NewValue * 570;
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
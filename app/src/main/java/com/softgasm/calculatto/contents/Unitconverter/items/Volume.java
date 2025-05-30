package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Volume implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {

            case 1:
                TheList.add(new ConverterItems(getString(R.string.cubicmeter), "m³", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.cubiccentimeter), "cm³", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.cubickilometer), "km³", ResultLimit(DefaultValue * 1.E-9)));
                TheList.add(new ConverterItems(getString(R.string.cubicdecameter), "dam³", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.cubicdecimeter) + " (" + getString(R.string.liter) + ")", "dm³ / L", ResultLimit(DefaultValue * 1000)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.cubicfoot), "ft³", ResultLimit(DefaultValue * 35.314666721)));
                TheList.add(new ConverterItems(getString(R.string.cubicinch), "in³", ResultLimit(DefaultValue * 61023.744095)));
                TheList.add(new ConverterItems(getString(R.string.cubicmil), "mil³", ResultLimit(DefaultValue * 6.10237e+13)));
                TheList.add(new ConverterItems(getString(R.string.cubicyard), "yd³", ResultLimit(DefaultValue * 1.3079506193)));
                TheList.add(new ConverterItems(getString(R.string.barrel) + " (" + Filters.CountryName("us") + ")", "bbl (US)", ResultLimit(DefaultValue * 8.3864143606)));
                TheList.add(new ConverterItems(getString(R.string.barrel) + " (" + Filters.CountryName("uk") + ")", "bbl (UK)", ResultLimit(DefaultValue * 6.1102568972)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("us") + ")", "gal (US)", ResultLimit(DefaultValue * 264.17205236)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("uk") + ")", "gal (UK)", ResultLimit(DefaultValue * 219.9692483)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("us") + ")", "pt (US)", ResultLimit(DefaultValue * 2113.3764189)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("uk") + ")", "pt (UK)", ResultLimit(DefaultValue * 1759.7539864)));
                TheList.add(new ConverterItems(getString(R.string.boardfoot), "FBM", ResultLimit(DefaultValue * 423.77600066)));
                TheList.add(new ConverterItems(getString(R.string.cordfoot), "cd ft", ResultLimit(DefaultValue * 0.2758958338)));
                TheList.add(new ConverterItems(getString(R.string.hoppus), "h cu ft", ResultLimit(DefaultValue * 27.7360744)));
                break;
            default:
                TheList.add(new ConverterItems(getString(R.string.cubicmeter), "m³", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.cubiccentimeter), "cm³", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.cubickilometer), "km³", ResultLimit(DefaultValue * 1.E-9)));
                TheList.add(new ConverterItems(getString(R.string.cubicdecameter), "dam³", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.cubicdecimeter) + " (" + getString(R.string.liter) + ")", "dm³ / L", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.cubicfoot), "ft³", ResultLimit(DefaultValue * 35.314666721)));
                TheList.add(new ConverterItems(getString(R.string.cubicinch), "in³", ResultLimit(DefaultValue * 61023.744095)));
                TheList.add(new ConverterItems(getString(R.string.cubicmil), "mil³", ResultLimit(DefaultValue * 6.10237e+13)));
                TheList.add(new ConverterItems(getString(R.string.cubicyard), "yd³", ResultLimit(DefaultValue * 1.3079506193)));
                TheList.add(new ConverterItems(getString(R.string.barrel) + " (" + Filters.CountryName("us") + ")", "bbl (US)", ResultLimit(DefaultValue * 8.3864143606)));
                TheList.add(new ConverterItems(getString(R.string.barrel) + " (" + Filters.CountryName("uk") + ")", "bbl (UK)", ResultLimit(DefaultValue * 6.1102568972)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("us") + ")", "gal (US)", ResultLimit(DefaultValue * 264.17205236)));
                TheList.add(new ConverterItems(getString(R.string.gallon) + " (" + Filters.CountryName("uk") + ")", "gal (UK)", ResultLimit(DefaultValue * 219.9692483)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("us") + ")", "pt (US)", ResultLimit(DefaultValue * 2113.3764189)));
                TheList.add(new ConverterItems(getString(R.string.pint) + " (" + Filters.CountryName("uk") + ")", "pt (UK)", ResultLimit(DefaultValue * 1759.7539864)));
                TheList.add(new ConverterItems(getString(R.string.boardfoot), "FBM", ResultLimit(DefaultValue * 423.77600066)));
                TheList.add(new ConverterItems(getString(R.string.cordfoot), "cd ft", ResultLimit(DefaultValue * 0.2758958338)));
                TheList.add(new ConverterItems(getString(R.string.hoppus), "h cu ft", ResultLimit(DefaultValue * 27.7360744)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        switch (FromSymbol) {
            case "cm³":
               return NewValue * 0.000001;
            case "km³":
                return NewValue * 1000000000;
            case "dam³":
                return NewValue * 1000;
            case "dm³ / L":
                return NewValue * 0.001;
            case "ft³":
                return NewValue * 0.0283168466;
            case "in³":
                return NewValue * 0.0000163871;
            case "mil³":
                return NewValue * 0.016387064;
            case "yd³":
                return NewValue * 0.764554858;
            case "bbl (US)":
                return NewValue * 0.1192404712;
            case "bbl (UK)":
                return NewValue * 0.16365924;
            case "gal (US)":
                return NewValue * 0.0037854118;
            case "gal (UK)":
                return NewValue * 0.00454609;
            case "pt (US)":
                return NewValue * 0.0004731765;
            case "pt (UK)":
                return NewValue * 0.0005682613;
            case "FBM":
                return NewValue * 0.0023597372;
            case "cd ft":
                return NewValue * 3.6245563638;
            case "h cu ft":
                return NewValue * 0.03605;
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
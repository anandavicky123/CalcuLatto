package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Energy implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {

            case 1:
                TheList.add(new ConverterItems("Joule", "J", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("Kilojoule", "kJ", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems("Megajoule", "MJ", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems("Gigajoule", "GJ", ResultLimit(DefaultValue * 9.999999999E-10)));
                TheList.add(new ConverterItems("Terajoule", "TJ", ResultLimit(DefaultValue * 1e-12)));
                TheList.add(new ConverterItems("Millijoule", "mJ", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems("Microjoule", "µJ", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems("Nanojoule", "nJ", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems("Picojoule", "pJ", ResultLimit(DefaultValue * 1e+12)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.britishthermalunit), "BTU", ResultLimit(DefaultValue * 0.0009478171)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound), "ft⋅lb", ResultLimit(DefaultValue * 0.7375621493)));
                break;
            default:
                TheList.add(new ConverterItems("Joule", "J", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("Kilojoule", "kJ", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems("Megajoule", "MJ", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems("Gigajoule", "GJ", ResultLimit(DefaultValue * 9.999999999E-10)));
                TheList.add(new ConverterItems("Terajoule", "TJ", ResultLimit(DefaultValue * 1e-12)));
                TheList.add(new ConverterItems("Millijoule", "mJ", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems("Microjoule", "µJ", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems("Nanojoule", "nJ", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems("Picojoule", "pJ", ResultLimit(DefaultValue * 1e+12)));
                TheList.add(new ConverterItems(getString(R.string.britishthermalunit), "BTU", ResultLimit(DefaultValue * 0.0009478171)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound), "ft⋅lb", ResultLimit(DefaultValue * 0.7375621493)));
                TheList.add(new ConverterItems("Erg", "erg", ResultLimit(DefaultValue * 10000000)));
                TheList.add(new ConverterItems(getString(R.string.calorie), "cal", ResultLimit(DefaultValue * 0.2388458966)));
                TheList.add(new ConverterItems(getString(R.string.kilocalorie), "kcal", ResultLimit(DefaultValue * 0.0002388459)));
                TheList.add(new ConverterItems(getString(R.string.kilowatthour), "kWh", ResultLimit(DefaultValue * 2.777777777E-7)));
                TheList.add(new ConverterItems("Electronvolt", "eV", ResultLimit(DefaultValue * 6.241509074461e18)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "kJ":
                return NewValue * 1000;
            case "MJ":
                return NewValue * 1000000;
            case "GJ":
                return NewValue * 1000000000;
            case "TJ":
                return NewValue * 1e+12;
            case "mJ":
                return NewValue * 0.001;
            case "µJ":
                return NewValue * 0.000001;
            case "nJ":
                return NewValue * 1.E-9;
            case "pJ":
                return NewValue * 1e-12;
            case "BTU":
                return NewValue * 1055.0558526;
            case "ft⋅lb":
                return NewValue * 1.3558179483;
            case "erg":
                return NewValue * 1.E-7;
            case "cal":
                return NewValue * 4.1868;
            case "kcal":
                return NewValue * 4186.8;
            case "kWh":
                return NewValue * 3600000;
            case "eV":
                return NewValue * 1.602176633E-19;
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
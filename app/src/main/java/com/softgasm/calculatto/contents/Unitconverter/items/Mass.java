package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Mass implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {


            case 1:
                TheList.add(new ConverterItems("Kilogram", "kg", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("gram", "g", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.milligram), "mg", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.microgram), "μg", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems(getString(R.string.nanogram), "ng", ResultLimit(DefaultValue * 1e12)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.tonne), "t", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.shortton), "tn", ResultLimit(DefaultValue * 0.0011023113)));
                TheList.add(new ConverterItems(getString(R.string.longton), "LT", ResultLimit(DefaultValue * 0.0009842065)));
                TheList.add(new ConverterItems(getString(R.string.pound), "lb", ResultLimit(DefaultValue * 2.2046226218)));
                TheList.add(new ConverterItems(getString(R.string.ounce), "oz", ResultLimit(DefaultValue * 35.27396195)));
                TheList.add(new ConverterItems(getString(R.string.stone), "st", ResultLimit(DefaultValue * 0.15747304441)));
                TheList.add(new ConverterItems(getString(R.string.ushundredweight), "cwt", ResultLimit(DefaultValue * 0.02204622621)));
                TheList.add(new ConverterItems(getString(R.string.longhundredweight), "CWT", ResultLimit(DefaultValue * 0.01968413055)));
                TheList.add(new ConverterItems(getString(R.string.grain), "gr", ResultLimit(DefaultValue * 15432.358353)));
                TheList.add(new ConverterItems(getString(R.string.pennyweight), "dwt", ResultLimit(DefaultValue * 643.01493137)));
                TheList.add(new ConverterItems(getString(R.string.troyounce), "oz t", ResultLimit(DefaultValue * 32.1507)));
                TheList.add(new ConverterItems(getString(R.string.troypound), "lb t", ResultLimit(DefaultValue * 2.67923)));
                TheList.add(new ConverterItems(getString(R.string.dram), "dr", ResultLimit(DefaultValue * 564.382)));
                TheList.add(new ConverterItems(getString(R.string.slug), "sl", ResultLimit(DefaultValue * 0.0685217659)));
                break;
            default:
                TheList.add(new ConverterItems("Kilogram", "kg", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("gram", "g", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.milligram), "mg", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.microgram), "μg", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems(getString(R.string.nanogram), "ng", ResultLimit(DefaultValue * 1e12)));
                TheList.add(new ConverterItems(getString(R.string.tonne), "t", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.shortton), "tn", ResultLimit(DefaultValue * 0.0011023113)));
                TheList.add(new ConverterItems(getString(R.string.longton), "LT", ResultLimit(DefaultValue * 0.0009842065)));
                TheList.add(new ConverterItems(getString(R.string.pound), "lb", ResultLimit(DefaultValue * 2.2046226218)));
                TheList.add(new ConverterItems(getString(R.string.ounce), "oz", ResultLimit(DefaultValue * 35.27396195)));
                TheList.add(new ConverterItems(getString(R.string.stone), "st", ResultLimit(DefaultValue * 0.15747304441)));
                TheList.add(new ConverterItems(getString(R.string.ushundredweight), "cwt US", ResultLimit(DefaultValue * 0.02204622621)));
                TheList.add(new ConverterItems(getString(R.string.longhundredweight), "cwt UK", ResultLimit(DefaultValue * 0.01968413055)));
                TheList.add(new ConverterItems(getString(R.string.grain), "gr", ResultLimit(DefaultValue * 15432.358353)));
                TheList.add(new ConverterItems(getString(R.string.pennyweight), "dwt", ResultLimit(DefaultValue * 643.01493137)));
                TheList.add(new ConverterItems(getString(R.string.troyounce), "oz t", ResultLimit(DefaultValue * 32.1507)));
                TheList.add(new ConverterItems(getString(R.string.troypound), "lb t", ResultLimit(DefaultValue * 2.67923)));
                TheList.add(new ConverterItems(getString(R.string.dram), "dr", ResultLimit(DefaultValue * 564.382)));
                TheList.add(new ConverterItems(getString(R.string.slug), "sl", ResultLimit(DefaultValue * 0.0685217659)));
                TheList.add(new ConverterItems(getString(R.string.carat), "ct", ResultLimit(DefaultValue * 5000)));
                TheList.add(new ConverterItems(getString(R.string.quintal), "quintal", ResultLimit(DefaultValue * 0.01)));
                TheList.add(new ConverterItems(getString(R.string.planckmass), "h", ResultLimit(DefaultValue * 45940892.448)));
                TheList.add(new ConverterItems(getString(R.string.earthmass), "M⊕", ResultLimit(DefaultValue * 1.6744809e+23)));
                TheList.add(new ConverterItems("Dalton", "Da", ResultLimit(DefaultValue * 6.022173643E+26)));
                TheList.add(new ConverterItems("Electronvolt", "eV", ResultLimit(DefaultValue * 5.6095861672249E+35)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "g":
               return NewValue * 0.001;
            case "mg":
                return NewValue * 0.000001;
            case "μg":
                return NewValue * 1.E-9;
            case "ng":
                return NewValue * 1.E-12;
            case "t":
                return NewValue * 1000;
            case "tn":
                return NewValue * 907.18474;
            case "LT":
                return NewValue * 1016.0469088;
            case "lb":
                return NewValue * 0.45359237;
            case "oz":
                return NewValue * 0.0283495231;
            case "st":
                return NewValue * 6.35029318;
            case "cwt US":
                return NewValue * 45.359237;
            case "cwt UK":
                return NewValue * 50.80;
            case "gr":
                return NewValue * 0.0000647989;
            case "dwt":
                return NewValue * 0.0015551738;
            case "oz t":
                return NewValue * 0.0311035;
            case "lb t":
                return NewValue * 0.373242;
            case "dr":
                return NewValue * 0.00177185;
            case "sl":
                return NewValue * 14.593902937;
            case "ct":
                return NewValue * 0.0002;
            case "quintal":
                return NewValue * 100;
            case "h":
                return NewValue * 2.17645e-8;
            case "M⊕":
                return NewValue * 5.976E+24;
            case "Da":
                return NewValue * 1.66053E-27;
            case "eV":
                return NewValue * 1.78266269594484E-36;
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
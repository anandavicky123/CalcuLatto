package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Flow implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {
            case 1:
                TheList.add(new ConverterItems(getString(R.string.m3ps), "m³/s", ResultLimit(DefaultValue)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.cfm), "CFM", ResultLimit(DefaultValue * 2118.8800032)));
                TheList.add(new ConverterItems(getString(R.string.cfs), "ft³/s", ResultLimit(DefaultValue * 35.31466672)));
                TheList.add(new ConverterItems(getString(R.string.cim), "in³/min", ResultLimit(DefaultValue * 3661424.6457)));
                TheList.add(new ConverterItems(getString(R.string.cis), "in³/s", ResultLimit(DefaultValue * 61023.744095)));
                TheList.add(new ConverterItems(getString(R.string.gpdus), "GPD", ResultLimit(DefaultValue * 22824465.324)));
                TheList.add(new ConverterItems(getString(R.string.gphus), "GPH", ResultLimit(DefaultValue * 951019.38849)));
                TheList.add(new ConverterItems(getString(R.string.gpmus), "GPM", ResultLimit(DefaultValue * 15850.323141)));
                TheList.add(new ConverterItems(getString(R.string.bushelpermin), "bsh/min", ResultLimit(DefaultValue * 1702.66)));
                TheList.add(new ConverterItems(getString(R.string.acrefeetperday), "ac⋅ft/d", ResultLimit(DefaultValue * 70.045339761)));
                break;

            default:
                TheList.add(new ConverterItems(getString(R.string.m3ps), "m³/s", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.cm3pm), "cm³/min", ResultLimit(DefaultValue * 60000000)));
                TheList.add(new ConverterItems(getString(R.string.literperminute), "L/min", ResultLimit(DefaultValue * 60000)));
                TheList.add(new ConverterItems(getString(R.string.cfm), "CFM", ResultLimit(DefaultValue * 2118.8800032)));
                TheList.add(new ConverterItems(getString(R.string.cfs), "ft³/s", ResultLimit(DefaultValue * 35.31466672)));
                TheList.add(new ConverterItems(getString(R.string.cim), "in³/min", ResultLimit(DefaultValue * 3661424.6457)));
                TheList.add(new ConverterItems(getString(R.string.cis), "in³/s", ResultLimit(DefaultValue * 61023.744095)));
                TheList.add(new ConverterItems(getString(R.string.gpdus), "GPD", ResultLimit(DefaultValue * 22824465.324)));
                TheList.add(new ConverterItems(getString(R.string.gphus), "GPH", ResultLimit(DefaultValue * 951019.38849)));
                TheList.add(new ConverterItems(getString(R.string.gpmus), "GPM", ResultLimit(DefaultValue * 15850.323141)));
                TheList.add(new ConverterItems(getString(R.string.bushelpermin), "bsh/min", ResultLimit(DefaultValue * 1702.66)));
                TheList.add(new ConverterItems(getString(R.string.acrefeetperday), "ac⋅ft/d", ResultLimit(DefaultValue * 70.045339761)));
                TheList.add(new ConverterItems("Sverdrup", "Sv", ResultLimit(DefaultValue * 0.000001)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "cm³/min":
                return NewValue * 1.666666666E-8;
            case "L/min":
                return NewValue * 0.0000166667;
            case "CFM":
                return NewValue * 0.0004719474;
            case "ft³/s":
                return NewValue * 0.0283168466;
            case "in³/min":
                return NewValue * 2.731177333E-7;
            case "in³/s":
                return NewValue * 0.0000163871;
            case "GPD":
                return NewValue * 4.381263638E-8;
            case "GPH":
                return NewValue * 0.0000010515;
            case "GPM":
                return NewValue * 0.0000630902;
            case "bsh/min":
                return NewValue * 0.000587318;
            case "ac⋅ft/d":
                return NewValue * 0.0142764673;
            case "Sv":
                return NewValue * 1000000;
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
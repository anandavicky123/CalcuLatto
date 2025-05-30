package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Power implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {
            case 1:
                TheList.add(new ConverterItems("Watt", "W", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("Kilowatt", "kW", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems("Megawatt", "MW", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems("Terawatt", "TW", ResultLimit(DefaultValue * 1.E-12)));
                TheList.add(new ConverterItems("Milliwatt", "mW", ResultLimit(DefaultValue * 1000)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.horsepower_mechanical), "hp(I)", ResultLimit(DefaultValue * 0.0013410221)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_metric), "hp(M)", ResultLimit(DefaultValue * 0.0013596216)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_electrical), "hp(E)", ResultLimit(DefaultValue * 0.0013404826)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_boiler), "hp(S)", ResultLimit(DefaultValue * 0.000101942)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_hydraulic), "hp(H)", ResultLimit(DefaultValue * 0.0013404053)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_air), "hp(A)", ResultLimit(DefaultValue / 745.69987)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound_sec), "ft⋅lbf/s", ResultLimit(DefaultValue * 0.7375621493)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound_minute), "ft⋅lbf/min", ResultLimit(DefaultValue * 44.253728957)));
                TheList.add(new ConverterItems(getString(R.string.btuperhour), "BTU/h", ResultLimit(DefaultValue * 3.4121416331)));
                break;
            default:
                TheList.add(new ConverterItems("Watt", "W", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems("Kilowatt", "kW", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems("Megawatt", "MW", ResultLimit(DefaultValue * 0.000001)));
                TheList.add(new ConverterItems("Terawatt", "TW", ResultLimit(DefaultValue * 1.E-12)));
                TheList.add(new ConverterItems("Milliwatt", "mW", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_mechanical), "hp(I)", ResultLimit(DefaultValue * 0.0013410221)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_metric), "hp(M)", ResultLimit(DefaultValue * 0.0013596216)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_electrical), "hp(E)", ResultLimit(DefaultValue * 0.0013404826)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_boiler), "hp(S)", ResultLimit(DefaultValue * 0.000101942)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_hydraulic), "hp(H)", ResultLimit(DefaultValue * 0.0013404053)));
                TheList.add(new ConverterItems(getString(R.string.horsepower_air), "hp(A)", ResultLimit(DefaultValue / 745.69987)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound_sec), "ft⋅lbf/s", ResultLimit(DefaultValue * 0.7375621493)));
                TheList.add(new ConverterItems(getString(R.string.foot_pound_minute), "ft⋅lbf/min", ResultLimit(DefaultValue * 44.253728957)));
                TheList.add(new ConverterItems(getString(R.string.btuperhour), "BTU/h", ResultLimit(DefaultValue * 3.4121416331)));
                TheList.add(new ConverterItems(getString(R.string.ergspersecond), "erg/s", ResultLimit(DefaultValue * 10000000)));
                TheList.add(new ConverterItems(getString(R.string.caloriesperhour), "cal/h", ResultLimit(DefaultValue * 859.84522786)));
                TheList.add(new ConverterItems(getString(R.string.tonof_r), "TR", ResultLimit(DefaultValue * 0.0002843451)));
                break;
        }


        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {

        switch (FromSymbol) {
            case "kW":
                return NewValue * 1000;
            case "MW":
                return NewValue * 1000000;
            case "TW":
                return NewValue * 1e12;
            case "mW":
                return NewValue * 0.001;
            case "hp(I)":
                return NewValue * 745.69987158;
            case "hp(M)":
                return NewValue * 735.49875;
            case "hp(E)":
                return NewValue * 746;
            case "hp(S)":
                return NewValue * 9809.5;
            case "hp(H)":
                return NewValue * 746.043;
            case "hp(A)":
                return NewValue * 745.69987;
            case "ft⋅lbf/s":
                return NewValue * 1.3558179483;
            case "ft⋅lbf/min":
                return NewValue * 0.0225969658;
            case "BTU/h":
                return NewValue * 0.2930710702;
            case "erg/s":
                return NewValue * 1.E-7;
            case "cal/h":
                return NewValue * 0.001163;
            case "TR":
                return NewValue * 3516.8528421;
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
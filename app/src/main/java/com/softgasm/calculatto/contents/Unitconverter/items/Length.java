package com.softgasm.calculatto.contents.Unitconverter.items;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Unitconverter.ConversionMethods;
import com.softgasm.calculatto.contents.Unitconverter.ConverterItems;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;

import java.util.ArrayList;

public class Length implements ConversionMethods {


    @Override
    public String[] CategoryList() {
        return new String[]{(getString(R.string.allmeasurements)), (getString(R.string.siunits)), getString(R.string.imperialandusc)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
        ArrayList<ConverterItems> TheList = new ArrayList<>();
        switch (CategoryPosition) {

            case 1:
                TheList.add(new ConverterItems(getString(R.string.meter), "m", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.centimeter), "cm", ResultLimit(DefaultValue * 100)));
                TheList.add(new ConverterItems(getString(R.string.kilometer), "km", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.decameter), "dam", ResultLimit(DefaultValue * 0.1)));
                TheList.add(new ConverterItems(getString(R.string.decimeter), "dm", ResultLimit(DefaultValue * 10)));
                TheList.add(new ConverterItems(getString(R.string.millimeter), "mm", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.micrometer), "µm", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.nanometer), "nm", ResultLimit(DefaultValue * 1000000000)));
                break;
            case 2:
                TheList.add(new ConverterItems(getString(R.string.foot), "ft", ResultLimit(DefaultValue * 3.280839895)));
                TheList.add(new ConverterItems(getString(R.string.inch), "in", ResultLimit(DefaultValue * 39.37007874)));
                TheList.add(new ConverterItems(getString(R.string.mil), "mil", ResultLimit(DefaultValue * 39370.07874)));
                TheList.add(new ConverterItems(getString(R.string.yard), "yd", ResultLimit(DefaultValue * 1.0936132983)));
                TheList.add(new ConverterItems(getString(R.string.mile), "mi", ResultLimit(DefaultValue * 0.0006213699)));
                TheList.add(new ConverterItems(getString(R.string.league), "lea", ResultLimit(DefaultValue * 0.0002071237)));
                TheList.add(new ConverterItems(getString(R.string.chain), "ch", ResultLimit(DefaultValue * 0.0497096954)));
                TheList.add(new ConverterItems(getString(R.string.rod), "rod", ResultLimit(DefaultValue * 0.1988387815)));
                break;
            default:
                TheList.add(new ConverterItems(getString(R.string.meter), "m", ResultLimit(DefaultValue)));
                TheList.add(new ConverterItems(getString(R.string.centimeter), "cm", ResultLimit(DefaultValue * 100)));
                TheList.add(new ConverterItems(getString(R.string.kilometer), "km", ResultLimit(DefaultValue * 0.001)));
                TheList.add(new ConverterItems(getString(R.string.decameter), "dam", ResultLimit(DefaultValue * 0.1)));
                TheList.add(new ConverterItems(getString(R.string.decimeter), "dm", ResultLimit(DefaultValue * 10)));
                TheList.add(new ConverterItems(getString(R.string.millimeter), "mm", ResultLimit(DefaultValue * 1000)));
                TheList.add(new ConverterItems(getString(R.string.micrometer), "µm", ResultLimit(DefaultValue * 1000000)));
                TheList.add(new ConverterItems(getString(R.string.nanometer), "nm", ResultLimit(DefaultValue * 1000000000)));
                TheList.add(new ConverterItems(getString(R.string.foot), "ft", ResultLimit(DefaultValue * 3.280839895)));
                TheList.add(new ConverterItems(getString(R.string.inch), "in", ResultLimit(DefaultValue * 39.37007874)));
                TheList.add(new ConverterItems(getString(R.string.mil), "mil", ResultLimit(DefaultValue * 39370.07874)));
                TheList.add(new ConverterItems(getString(R.string.yard), "yd", ResultLimit(DefaultValue * 1.0936132983)));
                TheList.add(new ConverterItems(getString(R.string.mile), "mi", ResultLimit(DefaultValue * 0.0006213699)));
                TheList.add(new ConverterItems(getString(R.string.league), "lea", ResultLimit(DefaultValue * 0.0002071237)));
                TheList.add(new ConverterItems(getString(R.string.chain), "ch", ResultLimit(DefaultValue * 0.0497096954)));
                TheList.add(new ConverterItems(getString(R.string.rod), "rod", ResultLimit(DefaultValue * 0.1988387815)));
                TheList.add(new ConverterItems(getString(R.string.scandinavianmil) + " (10km)", "mil NO/SE", ResultLimit(DefaultValue * 0.0001)));
                TheList.add(new ConverterItems("Ångström", "Å", ResultLimit(DefaultValue * 1e10)));
                TheList.add(new ConverterItems(getString(R.string.xunit), "xu", ResultLimit(DefaultValue * 9.979243174198e12)));
                TheList.add(new ConverterItems(getString(R.string.fathom), "fathom", ResultLimit(DefaultValue * 0.5468066492)));
                TheList.add(new ConverterItems(getString(R.string.nauticalmile), "NM", ResultLimit(DefaultValue * 0.0005399568)));
                TheList.add(new ConverterItems(getString(R.string.earthradius), "R\uD83D\uDF28", ResultLimit(DefaultValue * 1.567850289E-7)));
                TheList.add(new ConverterItems(getString(R.string.astronomicalunit), "au", ResultLimit(DefaultValue * 6.684587122E-12)));
                TheList.add(new ConverterItems(getString(R.string.lightyear), "ly", ResultLimit(DefaultValue * 1.057000834E-16)));
                TheList.add(new ConverterItems(getString(R.string.furlong), "furlong", ResultLimit(DefaultValue * 0.0049709695)));
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
        double toSI;
        switch (FromSymbol) {
            case "cm":
                return NewValue * 0.01;
            case "km":
                return NewValue * 1000;
            case "dam":
                return NewValue * 10;
            case "dm":
                return NewValue * 0.1;
            case "mm":
                return NewValue * 0.001;
            case "µm":
                return NewValue * 0.000001;
            case "nm":
                return NewValue * 9.999999999E-10;
            case "ft":
                return NewValue * 0.3048;
            case "in":
                return NewValue * 0.0254;
            case "mil":
                return NewValue * 0.0000254;
            case "yd":
                return NewValue * 0.9144;
            case "mi":
                return NewValue * 1609.3472187;
            case "lea":
                return NewValue * 4828.032;
            case "ch":
                return NewValue * 20.1168;
            case "rod":
                return NewValue * 5.0292;
            case "mil NO/SE":
                return NewValue * 10000;
            case "Å":
                return NewValue * 9.999999999E-11;
            case "xu":
                return NewValue * 1.002079999E-13;
            case "fathom":
                return NewValue * 1.8288;
            case "NM":
                return NewValue * 1852;
            case "R\uD83D\uDF28":
                return NewValue * 6378160;
            case "au":
                return NewValue * 1.49597870691e11;
            case "ly":
                return NewValue * 9.460730472580000e15;
            case "furlong":
                return NewValue * 201.168;
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
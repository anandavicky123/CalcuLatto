package com.softgasm.calculatto.contents.Unitconverter;

import java.util.ArrayList;

public interface ConversionMethods {

    String[] CategoryList();
    ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue);
    double FindValue(int Category, String FromSymbol, double NewValue);
}

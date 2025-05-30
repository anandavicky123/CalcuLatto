package com.softgasm.calculatto.contents.Geometry;

public class side_square {


    public static double toArea (double side){
        return Math.pow(side, 2);
    }
    public static double toPerimeter (double side){
        return side * 4;
    }
    public static double fromArea(double area){
        return Math.sqrt(area);
    }
    public static double fromPerimeter(double perimeter){
        return perimeter/4;
    }
}

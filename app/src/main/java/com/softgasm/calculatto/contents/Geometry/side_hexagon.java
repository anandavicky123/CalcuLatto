package com.softgasm.calculatto.contents.Geometry;

public class side_hexagon {


    public static double toArea (double side){
        return Math.pow(side, 2) * ((3 * Math.sqrt(3))/2);
    }
    public static double toPerimeter (double side){
        return side * 6;
    }
    public static double fromArea(double area){
        return Math.sqrt(area/((3 * Math.sqrt(3))/2));
    }
    public static double fromPerimeter(double perimeter){
        return perimeter/6;
    }
}

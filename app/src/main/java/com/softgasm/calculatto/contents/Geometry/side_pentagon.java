package com.softgasm.calculatto.contents.Geometry;

public class side_pentagon {


    public static double toArea (double side){
        return Math.pow(side, 2) * ((5 * Math.tan((54 * Math.PI)/180))/4);
    }
    public static double toPerimeter (double side){
        return side * 5;
    }
    public static double fromArea(double area){
        return Math.sqrt(area/((5 * Math.tan((54 * Math.PI)/180)/4)));
    }
    public static double fromPerimeter(double perimeter){
        return perimeter/5;
    }
}

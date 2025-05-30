package com.softgasm.calculatto.contents.Geometry;

public class radius_circle {


    public static double toDiameter(double radius) {
        return radius * 2;
    }

    public static double toArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double toCircumference(double radius) {
        return (Math.PI * 2) * radius;
    }

    public static double fromDiameter(double diameter) {
        return diameter / 2;
    }

    public static double fromArea(double area) {
        return Math.sqrt(area / Math.PI);
    }

    public static double fromCircumference(double circumference) {
        return circumference / (2 * Math.PI);
    }


}

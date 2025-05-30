package com.softgasm.calculatto.contents.Geometry;

public class radius_sphere {


    public static double toArea(double radius) {
        return (4 * Math.PI) * Math.pow(radius, 2);
    }

    public static double toVolume(double radius) {
        return (4 * Math.PI) * Math.pow(radius, 3) / 3;
    }

    public static double fromArea(double area) {
        return Math.sqrt(area / (4 * Math.PI));
    }

    public static double fromVolume(double vol) {
        return Math.cbrt((3*vol) / (4 * Math.PI));
    }


}

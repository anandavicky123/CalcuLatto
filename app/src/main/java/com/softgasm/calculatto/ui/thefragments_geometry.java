package com.softgasm.calculatto.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.softgasm.calculatto.R;
import com.softgasm.calculatto.contents.Geometry.radius_circle;
import com.softgasm.calculatto.contents.Geometry.radius_sphere;
import com.softgasm.calculatto.contents.Geometry.side_hexagon;
import com.softgasm.calculatto.contents.Geometry.side_pentagon;
import com.softgasm.calculatto.contents.Geometry.side_square;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.Temp;
import com.softgasm.calculatto.system.adapter.CustomPagerAdapter;

@SuppressLint("SetTextI18n")
public class thefragments_geometry extends Fragment {

    LinearLayout l1, l2, l3, l4, l5, lr;
    TextView tr, h1, h2, h3, h4, h5;

    TextInputLayout t1, t2, t3, t4, t5;
    EditText e1, e2, e3, e4, e5;
    Spinner s1, s2, s3, s4, s5;
    int s1v, s2v, s3v, s4v, s5v, active = 1;
    String req, e1r, e2r, e3r, e4r, e5r, title;
    boolean visible2 = false, visible3 = false, visible4 = false, visible5 = false;
    View view;

    final double pi = 3.1415926535897932384626433832795;

    final double dpi = 2 * pi;

    ViewPager viewpager;
    TabLayout tl;

    public thefragments_geometry() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_thefragments_geometry, container, false);
        req = Temp.req;
        title = Temp.name;

        return view;
    }

    private void calculations() {
        getStrings();
        if (!ec(active)) {
            try {
                switch (req) {
                    case "circle":
                        circle();
                        break;
                    case "rectangle":
                        rectangle();
                        break;
                    case "ellipse":
                        ellipse();
                        break;
                    case "rhombus":
                        rhombus();
                        break;
                    case "circlearc":
                        circlearc();
                        break;
                    case "trapezoid":
                        trapezoid();
                        break;
                    case "triangle":
                        triangle();
                        break;
                    case "square":
                        square();
                        break;
                    case "hexagon":
                        hexagon();
                        break;
                    case "pentagon":
                        pentagon();
                        break;
                    case "ellipsoid":
                        ellipsoid();
                        break;
                    case "sseg":
                        sseg();
                        break;
                    case "scap":
                        scap();
                        break;
                    case "sphere":
                        sphere();
                        break;
                    case "cylinder":
                        cylinder();
                        break;
                    case "cfrustum":
                        cfrustum();
                        break;
                    case "cone":
                        cone();
                        break;
                    case "pfrustum":
                        pfrustum();
                        break;
                    case "pyramid":
                        pyramid();
                        break;
                    case "prism":
                        prism();
                        break;
                    case "cube":
                        cube();
                        break;
                    case "rtriangle":
                        rtriangle();
                        break;
                    case "helix":
                        helix();
                        break;
                    case "koch":
                        koch();
                        break;
                    case "torus":
                        torus();
                        break;
                    case "parabola":
                        parabola();
                        break;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private void parabola() {


        double s = dp(e1r);
        double a = dp(e2r);
        double b = dp(e3r);


        double m = -Math.signum(a) * (Math.abs(a / 2) * Math.sqrt(1 + 4 * Math.pow(s, 2) * Math.pow(a, 2)) + Math.log(Math.abs(2 * s * a) + Math.sqrt(1 + 4 * Math.pow(s, 2) * Math.pow(a, 2))) / Math.abs(4 * s));
        double n = Math.signum(b) * (Math.abs(b / 2) * Math.sqrt(1 + 4 * Math.pow(s, 2) * Math.pow(b, 2)) + Math.log(Math.abs(2 * s * b) + Math.sqrt(1 + 4 * Math.pow(s, 2) * Math.pow(b, 2))) / Math.abs(4 * s));
        double l = m + n;


        String res = getString(R.string.length) + "  a: " + frd(m) + "\n" + getString(R.string.length) + " b: " + frd(n) + "\n" + getString(R.string.section) + ": " + frd(l);

        setResult(title, res);
    }


    private void torus() {


        double Ra = dp(e1r);
        double r = dp(e2r);

        double a = Ra - r;
        double b = 2 * (Ra + r);
        double A = 4 * Math.pow(pi, 2) * Ra * r;
        double V = 2 * Math.pow(pi, 2) * Ra * Math.pow(r, 2);

        String res = getString(R.string.holeradius) + ": " + frd(a) + "\n" + getString(R.string.breadth) + ": " + frd(b) + "\n" + getString(R.string.surfacearea) + ": " + frd(A) + "\n" + getString(R.string.volume) + ": " + frd(V);

        setResult(title, res);
    }

    private void koch() {


        double n = dp(e1r);
        double l = dp(e2r);

        double m = l * Math.pow((1.333333333333333333333), n);
        double h = Math.sqrt(3) / 6 * l;


        String res = getString(R.string.length) + ": " + frd(m) + "\n" + getString(R.string.height) + ": " + frd(h);

        setResult(title, res);
    }


    private void helix() {


        double r = dp(e1r);
        double h = dp(e2r);
        double t = dp(e3r);

        double k = h / (2 * pi * r);
        double curvature = 1 / (r * (1 + Math.pow(k, 2)));
        double w = k / (r * (1 + Math.pow(k, 2)));
        double s = 2 * pi * r * Math.sqrt(1 + Math.pow(k, 2)) * t;


        String res = getString(R.string.slope) + ": " + frd(k) + "\n" + getString(R.string.curvature) + ": " + frd(curvature) + "\n" + getString(R.string.torsion) + ": " + frd(w) + "\n" + getString(R.string.arclength) + ": " + frd(s);

        setResult(title, res);
    }


    private void rtriangle() {


        double a = dp(e1r);
        double b = dp(e2r);


        double c = Math.pow(a, 2) + Math.pow(b, 2);
        c = Math.sqrt(c);
        double angle_a = (180 * Math.asin(a / c)) / pi;
        double angle_b = (180 * Math.asin(b / c)) / pi;
        double area = a * b / 2;
        double perimeter = a + b + c;


        String res = getString(R.string.hypotenuse) + ": " + frd(c) + "\n" + getString(R.string.angle_a) + ": " + frd(angle_a) + "\n" + getString(R.string.angle_b) + ": " + frd(angle_b) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);

        setResult(title, res);
    }


    private void cube() {


        double a = dp(e1r);


        double area = 6 * Math.pow(a, 2);
        double volume = Math.pow(a, 3);
        double vd = a * Math.sqrt(3);
        double larea = 4 * Math.pow(a, 2);

        String res = getString(R.string.surfacearea) + ": " + frd(area) + "\n" + getString(R.string.lateralarea) + ": " + frd(larea) + "\n" + getString(R.string.volume) + ": " + frd(volume) + "\n" + getString(R.string.volumediagonal) + ": " + frd(vd);

        setResult(title, res);
    }


    private void prism() {


        double a = dp(e1r);
        double b = dp(e2r);
        double c = dp(e3r);


        double larea = (2 * a * b) + (2 * a * c);
        double tarea = (2 * a * b) + (2 * b * c) + (2 * a * c);
        double volume = a * b * c;

        String res = getString(R.string.lateralarea) + ": " + frd(larea) + "\n" + getString(R.string.totalarea) + ": " + frd(tarea) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void pyramid() {


        double a = dp(e1r);
        double h = dp(e2r);

        double larea = 2 * a * Math.sqrt(Math.pow(h, 2) + Math.pow((a / 2), 2));
        double tarea = larea + Math.pow(a, 2);
        double volume = Math.pow(a, 2) * (h / 3);

        String res = getString(R.string.lateralarea) + ": " + frd(larea) + "\n" + getString(R.string.totalarea) + ": " + frd(tarea) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void pfrustum() {

        double a = dp(e1r);
        double b = dp(e2r);
        double h = dp(e3r);


        double larea = 2 * (a + b) * Math.sqrt(Math.pow(h, 2) + Math.pow(((b - a) / 2), 2));
        double tarea = larea + Math.pow(a, 2) + Math.pow(b, 2);
        double va = Math.pow(a, 2) + (a * b) + Math.pow(b, 2);
        double vaa = va * h;
        double volume = vaa / 3;

        String res = getString(R.string.lateralarea) + ": " + frd(larea) + "\n" + getString(R.string.totalarea) + ": " + frd(tarea) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void cone() {

        double r = dp(e1r);
        double h = dp(e2r);


        double s = Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2));
        double l = r * s * pi;
        double a = r * pi * (r + s);
        double volume = 0.33333333333 * Math.pow(r, 2) * pi * h;

        double oa = 2 * Math.toDegrees(Math.asin(r / s));
        double ba = (180 - oa) / 2;

        String res = getString(R.string.slantlength) + ": " + frd(s) + "\n" + getString(R.string.lateralsurface) + ": " + frd(l) + "\n" + getString(R.string.surfacearea) + ": " + frd(a) + "\n" + getString(R.string.volume) + ": " + frd(volume) + "\n" + getString(R.string.openingangle_degree) + ": " + frd(oa) + "\n" + getString(R.string.baseangle_degree) + ": " + frd(ba);

        setResult(title, res);
    }


    private void cfrustum() {

        double t = dp(e1r);
        double b = dp(e2r);
        double h = dp(e3r);


        double s = Math.sqrt(Math.pow((b - t), 2) + Math.pow(h, 2));
        double larea = pi * (t + b) * s;
        double tarea = larea + (pi * Math.pow(t, 2)) + (pi * Math.pow(b, 2));
        double volume = (pi * h * (Math.pow(t, 2) + t * b + Math.pow(b, 2))) / 3;

        String res = getString(R.string.lateralarea) + ": " + frd(larea) + "\n" + getString(R.string.totalarea) + ": " + frd(tarea) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void cylinder() {

        double r = dp(e1r);
        double h = dp(e2r);

        double d = Math.sqrt(Math.pow(h, 2) + Math.pow((2 * r), 2));
        double a = 2 * pi * r * (h + r);
        double l = 2 * pi * r * h;
        double volume = pi * Math.pow(r, 2) * h;

        String res = getString(R.string.volumediagonal) + ": " + frd(d) + "\n" + getString(R.string.surfacearea) + ": " + frd(a) + "\n" + getString(R.string.lateralsurface) + ": " + frd(l) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void sphere() {

        double value = dp(e1r);

        double r;
        double area;
        double volume;

        switch (s1v) {
            case 1:
                area = value;
                r = radius_sphere.fromArea(area);
                volume = radius_sphere.toVolume(r);
                break;
            case 2:
                volume = value;
                r = radius_sphere.fromVolume(volume);
                area = radius_sphere.toArea(r);
                break;
            default:
                r = value;
                volume = radius_sphere.toVolume(r);
                area = radius_sphere.toArea(r);
                break;
        }
        String res = getString(R.string.radius) + ": " + frd(r) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.volume) + ": " + frd(volume);
        setResult(title, res);

    }


    private void scap() {

        double r = dp(e1r);
        double h = dp(e2r);

        double a = Math.sqrt(h * (2 * r - h));
        double area = pi * (2 * r * h + Math.pow(a, 2));
        double volume = Math.pow(h, 2) * pi / 3 * (3 * r - h);

        String res = getString(R.string.surfacearea) + ": " + frd(area) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void sseg() {

        double t = dp(e1r);
        double b = dp(e2r);
        double h = dp(e3r);

        double volume = pi * h / 6 * (3 * Math.pow(b, 2) + 3 * Math.pow(t, 2) + Math.pow(h, 2));

        String res = getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void ellipsoid() {

        double x = dp(e1r);
        double y = dp(e2r);
        double z = dp(e3r);

        double area = 4 * 3.141592653 * Math.pow((Math.pow(x * y, 1.6) +
                Math.pow(x * z, 1.6) + Math.pow(y * z, 1.6)) /
                3, 1 / 1.6);
        double volume = (4 * pi * x * y * z) / 3;

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.volume) + ": " + frd(volume);

        setResult(title, res);
    }


    private void pentagon() {

        double value = dp(e1r);

        double s;
        double area;
        double perimeter;

        switch (s1v) {
            case 1:
                area = value;
                s = side_pentagon.fromArea(area);
                perimeter = side_pentagon.toPerimeter(s);
                break;
            case 2:
                perimeter = value;
                s = side_pentagon.fromPerimeter(perimeter);
                area = side_pentagon.toArea(s);
                break;
            default:
                s = value;
                perimeter = side_pentagon.toPerimeter(s);
                area = side_pentagon.toArea(s);
                break;
        }
        String res = getString(R.string.side) + ": " + frd(s) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);
        setResult(title, res);

    }


    private void hexagon() {

        double value = dp(e1r);

        double s;
        double area;
        double perimeter;

        switch (s1v) {
            case 1:
                area = value;
                s = side_hexagon.fromArea(area);
                perimeter = side_hexagon.toPerimeter(s);
                break;
            case 2:
                perimeter = value;
                s = side_hexagon.fromPerimeter(perimeter);
                area = side_hexagon.toArea(s);
                break;
            default:
                s = value;
                perimeter = side_hexagon.toPerimeter(s);
                area = side_hexagon.toArea(s);
                break;
        }
        String res = getString(R.string.side) + ": " + frd(s) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);
        setResult(title, res);

    }


    private void square() {

        double value = dp(e1r);

        double s;
        double area;
        double perimeter;

        switch (s1v) {
            case 1:
                area = value;
                s = side_square.fromArea(area);
                perimeter = side_square.toPerimeter(s);
                break;
            case 2:
                perimeter = value;
                s = side_square.fromPerimeter(perimeter);
                area = side_square.toArea(s);
                break;
            default:
                s = value;
                perimeter = side_square.toPerimeter(s);
                area = side_square.toArea(s);
                break;
        }
        String res = getString(R.string.side) + ": " + frd(s) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);
        setResult(title, res);

    }

    private void triangle() {

        double a = dp(e1r);
        double c = dp(e2r);
        double b = dp(e3r);

        double s = (a + b + c) / 2;
        double acosAB = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        double acosBC = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        double acosAC = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);


        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double perimeter = a + b + c;
        double angleAB = (Math.acos(acosAB) / pi) * 180;
        double angleBC = (Math.acos(acosBC) / pi) * 180;
        double angleAC = (Math.acos(acosAC) / pi) * 180;
        double heightA = (area * 2) / a;
        double heightB = (area * 2) / b;
        double heightC = (area * 2) / c;

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter) + "\n" + getString(R.string.leftangle) + ": " + frd(angleAB) + "\n" + getString(R.string.rightangle) + ": " + frd(angleBC) + "\n" + getString(R.string.centerangle) + ": " + frd(angleAC) + "\n" + getString(R.string.heightleft) + ": " + frd(heightA) + "\n" + getString(R.string.heightright) + ": " + frd(heightC) + "\n" + getString(R.string.lengthbase) + ": " + frd(heightB);

        setResult(title, res);
    }


    private void trapezoid() {

        double t = dp(e1r);
        double b = dp(e2r);
        double h = dp(e3r);

        double both = Math.sqrt(Math.pow(((b - t) / 2), 2) + Math.pow(h, 2));
        double area = ((b + t) * h) / 2;
        double perimeter = (both * 2) + t + b;

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter) + "\n" + getString(R.string.leftandright) + ": " + frd(both) + " x2";

        setResult(title, res);

    }


    private void circlearc() {


        double a = dp(e1r);
        double r = dp(e2r);

        double area = pi * Math.pow(r, 2) * (a / 360);
        double perimeter = dpi * r * (a / 360);

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);

        setResult(title, res);
    }


    private void rhombus() {


        double y = dp(e1r);
        double x = dp(e2r);

        double area = (y * x) / 2;
        double perimeter = Math.sqrt(Math.pow((y / 2), 2) + Math.pow((x / 2), 2)) * 4;

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);

        setResult(title, res);
    }


    private void ellipse() {


        double y = dp(e1r);
        double x = dp(e2r);

        double area = pi * (y * x);
        double perimeter = dpi * Math.sqrt((Math.pow(y, 2) + Math.pow(x, 2)) / 2);

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);

        setResult(title, res);
    }


    private void rectangle() {

        double height = dp(e1r);
        double width = dp(e2r);

        double area = height * width;
        double perimeter = (height * 2) + (width * 2);

        String res = getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.perimeter) + ": " + frd(perimeter);

        setResult(title, res);

    }


    private void circle() {

        double value = dp(e1r);

        double r;
        double diameter;
        double area;
        double circumference;

        switch (s1v) {
            case 1:
                diameter = value;
                r = radius_circle.fromDiameter(diameter);
                area = radius_circle.toArea(r);
                circumference = radius_circle.toCircumference(r);
                break;
            case 2:
                area = value;
                r = radius_circle.fromArea(area);
                diameter = radius_circle.toDiameter(r);
                circumference = radius_circle.toCircumference(r);
                break;
            case 3:
                circumference = value;
                r = radius_circle.fromCircumference(circumference);
                diameter = radius_circle.toDiameter(r);
                area = radius_circle.toArea(r);
                break;
            default:
                r = value;
                diameter = radius_circle.toDiameter(r);
                area = radius_circle.toArea(r);
                circumference = radius_circle.toCircumference(r);
                break;
        }
        String res = getString(R.string.radius) + ": " + frd(r) + "\n" + getString(R.string.diameter) + ": " + frd(diameter) + "\n" + getString(R.string.area) + ": " + frd(area) + "\n" + getString(R.string.circumference) + ": " + frd(circumference);
        setResult(title, res);

    }
    private void only1() {
        s1.setVisibility(View.VISIBLE);
        turn2off();
        turn3off();
        turn4off();
        turn5off();
        active = 1;
    }

    private void only2() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.VISIBLE);
        turn3off();
        turn4off();
        turn5off();
        active = 2;
    }

    private void only3() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.VISIBLE);
        s3.setVisibility(View.VISIBLE);
        turn5off();
        turn4off();
        active = 3;
    }

    private void only4() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        visible4 = true;
        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.VISIBLE);
        s3.setVisibility(View.VISIBLE);
        s4.setVisibility(View.VISIBLE);
        turn5off();
        active = 4;
    }

    private void useall() {
        l2.setVisibility(View.VISIBLE);
        visible2 = true;
        l3.setVisibility(View.VISIBLE);
        visible3 = true;
        l4.setVisibility(View.VISIBLE);
        visible4 = true;
        l5.setVisibility(View.VISIBLE);
        visible5 = true;
        s1.setVisibility(View.VISIBLE);
        s2.setVisibility(View.VISIBLE);
        s3.setVisibility(View.VISIBLE);
        s4.setVisibility(View.VISIBLE);
        s5.setVisibility(View.VISIBLE);
        active = 5;
    }

    private void turn2off() {
        l2.setVisibility(View.GONE);
        visible2 = false;
    }

    private void turn3off() {
        l3.setVisibility(View.GONE);
        visible3 = false;
    }

    private void turn4off() {
        l4.setVisibility(View.GONE);
        visible4 = false;
    }

    private void turn5off() {
        l5.setVisibility(View.GONE);
        visible5 = false;
    }

    private void findView() {
        lr = view.findViewById(R.id.geo_main_result);
        tr = view.findViewById(R.id.geo_main_result_tv);
        l3 = view.findViewById(R.id.geo_3);
        l4 = view.findViewById(R.id.geo_4);
        l5 = view.findViewById(R.id.geo_5);
        l1 = view.findViewById(R.id.geo_1);
        l2 = view.findViewById(R.id.geo_2);
        t1 = view.findViewById(R.id.geo_1_til);
        t2 = view.findViewById(R.id.geo_2_til);
        t3 = view.findViewById(R.id.geo_3_til);
        t4 = view.findViewById(R.id.geo_4_til);
        t5 = view.findViewById(R.id.geo_5_til);
        s1 = view.findViewById(R.id.geo_1_s);
        s2 = view.findViewById(R.id.geo_2_s);
        s3 = view.findViewById(R.id.geo_3_s);
        s4 = view.findViewById(R.id.geo_4_s);
        s5 = view.findViewById(R.id.geo_5_s);
        e1 = view.findViewById(R.id.geo_1_et);
        e2 = view.findViewById(R.id.geo_2_et);
        e3 = view.findViewById(R.id.geo_3_et);
        e4 = view.findViewById(R.id.geo_4_et);
        e5 = view.findViewById(R.id.geo_5_et);
        viewpager = view.findViewById(R.id.viewpager_geo);
        tl = view.findViewById(R.id.tab_layout_geo);
        viewpager.setAdapter(new CustomPagerAdapter(requireContext()));
        tl.setupWithViewPager(viewpager);

    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListener() {

        //Spinner
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s1v = position;
                t1.setHint(s1.getSelectedItem().toString());
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s2v = position;
                t2.setHint(s2.getSelectedItem().toString());
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s3v = position;
                t3.setHint(s3.getSelectedItem().toString());
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s4v = position;
                t4.setHint(s4.getSelectedItem().toString());
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s5v = position;
                t5.setHint(s5.getSelectedItem().toString());
                calculations();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //EditText
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        e5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculations();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setadapter1(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        s1.setAdapter(adapter);
    }

    private void setadapter2(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        s2.setAdapter(adapter);
    }

    private void setadapter3(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        s3.setAdapter(adapter);
    }

    private void setadapter4(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        s4.setAdapter(adapter);
    }

    private void setadapter5(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, list);
        s5.setAdapter(adapter);
    }

    private void getStrings() {
        e1r = e1.getText().toString();
        getNumberToWords(1);
        if (visible2) {
            e2r = e2.getText().toString();
            getNumberToWords(2);
        }
        if (visible3) {
            e3r = e3.getText().toString();
            getNumberToWords(3);
        }
        if (visible4) {
            e4r = e4.getText().toString();
            getNumberToWords(4);
        }
        if (visible5) {
            e5r = e5.getText().toString();
            getNumberToWords(5);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setResult(String name, String theresult) {
        tr.setText(name + ":\n" + theresult);
    }

    private double dp(String text) {
        return Double.parseDouble(text);
    }

    private String frd(double result) {
        return Filters.rd(result);
    }

    private Boolean ec(int er) {
        if (er == 1) {
            return e1r.isEmpty();
        } else if (er == 2) {
            return e1r.isEmpty() || e2r.isEmpty();
        } else if (er == 3) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty();
        } else if (er == 4) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty() || e4r.isEmpty();
        } else if (er == 5) {
            return e1r.isEmpty() || e2r.isEmpty() || e3r.isEmpty() || e4r.isEmpty() || e5r.isEmpty();
        }
        return false;
    }

    public void getNumberToWords(int position) {
        if (App.NumberToWordsStatus(requireContext())) {
            try {
                if (position == 2) {
                    if (!e2r.isEmpty()) {
                        h2.setText(Filters.number_toWords(dp(e2r)));
                    } else {
                        h2.setText("");
                    }
                } else if (position == 3) {
                    if (!e3r.isEmpty()) {
                        h3.setText(Filters.number_toWords(dp(e3r)));
                    } else {
                        h3.setText("");
                    }
                } else if (position == 4) {
                    if (!e4r.isEmpty()) {
                        h4.setText(Filters.number_toWords(dp(e4r)));
                    } else {
                        h4.setText("");
                    }
                } else if (position == 5) {
                    if (!e5r.isEmpty()) {
                        h5.setText(Filters.number_toWords(dp(e5r)));
                    } else {
                        h5.setText("");
                    }
                } else {
                    if (!e1r.isEmpty()) {
                        h1.setText(Filters.number_toWords(dp(e1r)));
                    } else {
                        h1.setText("");
                    }
                }
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        } else {
            h1.setVisibility(View.GONE);
            h2.setVisibility(View.GONE);
            h3.setVisibility(View.GONE);
            h4.setVisibility(View.GONE);
            h5.setVisibility(View.GONE);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            findView();

            switch (req) {
                case "circle":
                    only1();
                    String[] a1 = {(getString(R.string.radius)), (getString(R.string.diameter)), (getString(R.string.area)), (getString(R.string.circumference))};
                    setadapter1(a1);
                    break;
                case "rectangle":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.height));
                    t2.setHint(getString(R.string.length));
                    break;
                case "ellipse":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.yradius));
                    t2.setHint(getString(R.string.xradius));
                    break;
                case "rhombus":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.ylength));
                    t2.setHint(getString(R.string.xlength));
                    break;
                case "circlearc":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.angle));
                    t2.setHint(getString(R.string.radius));
                    break;
                case "trapezoid":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.toplength));
                    t2.setHint(getString(R.string.baselength));
                    t3.setHint(getString(R.string.height));
                    break;
                case "triangle":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.leftlength));
                    t2.setHint(getString(R.string.rightlength));
                    t3.setHint(getString(R.string.baselength));
                    break;
                case "square":
                    only1();

                    String[] a2 = {(getString(R.string.side)), (getString(R.string.area)), (getString(R.string.perimeter))};
                    setadapter1(a2);
                    break;
                case "hexagon":
                    only1();

                    String[] a3 = {(getString(R.string.side)), (getString(R.string.area)), (getString(R.string.perimeter))};
                    setadapter1(a3);
                    break;
                case "pentagon":
                    only1();

                    String[] a4 = {(getString(R.string.side)), (getString(R.string.area)), (getString(R.string.perimeter))};
                    setadapter1(a4);
                    break;
                case "ellipsoid":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.xradius));
                    t2.setHint(getString(R.string.yradius));
                    t3.setHint(getString(R.string.zradius));

                    break;

                case "sseg":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.topradius));
                    t2.setHint(getString(R.string.baseradius));
                    t3.setHint(getString(R.string.height));

                    break;

                case "scap":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.radius));
                    t2.setHint(getString(R.string.height));

                    break;
                case "sphere":
                    only1();

                    String[] a5 = {(getString(R.string.radius)), (getString(R.string.area)), (getString(R.string.volume))};
                    setadapter1(a5);
                    break;
                case "cylinder":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.radius));
                    t2.setHint(getString(R.string.height));

                    break;
                case "cfrustum":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.topradius));
                    t2.setHint(getString(R.string.baseradius));
                    t3.setHint(getString(R.string.height));


                    break;
                case "pfrustum":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.topradius));
                    t2.setHint(getString(R.string.baseradius));
                    t3.setHint(getString(R.string.height));


                    break;
                case "cone":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.baseradius));
                    t2.setHint(getString(R.string.height));

                    break;

                case "pyramid":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.base));
                    t2.setHint(getString(R.string.height));

                    break;
                case "prism":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);


                    t1.setHint(getString(R.string.height));
                    t2.setHint(getString(R.string.length));
                    t3.setHint(getString(R.string.width));
                    break;
                case "cube":
                    only1();
                    s1.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.edgelength));
                    break;
                case "rtriangle":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.side_a));
                    t2.setHint(getString(R.string.side_b));
                    break;
                case "helix":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.radius));
                    t2.setHint(getString(R.string.height));
                    t3.setHint(getString(R.string.numberofturns));
                    break;
                case "koch":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.numberofiterations));
                    t2.setHint(getString(R.string.originallinelength));
                    break;
                case "torus":
                    only2();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.majorradius));
                    t2.setHint(getString(R.string.minorradius));

                    break;
                case "parabola":
                    only3();
                    s1.setVisibility(View.GONE);
                    s2.setVisibility(View.GONE);
                    s3.setVisibility(View.GONE);

                    t1.setHint(getString(R.string.parameter));
                    t2.setHint(getString(R.string.lowerpart));
                    t3.setHint(getString(R.string.upperpart));

                    break;
            }

            setListener();

            h1 = view.findViewById(R.id.hint_1);
            h2 = view.findViewById(R.id.hint_2);
            h3 = view.findViewById(R.id.hint_3);
            h4 = view.findViewById(R.id.hint_4);
            h5 = view.findViewById(R.id.hint_5);
            if (!App.NumberToWordsStatus(requireContext())) {
                h1.setVisibility(View.GONE);
                h2.setVisibility(View.GONE);
                h3.setVisibility(View.GONE);
                h4.setVisibility(View.GONE);
                h5.setVisibility(View.GONE);
            } else {
                h1.setVisibility(View.VISIBLE);
                h2.setVisibility(View.VISIBLE);
                h3.setVisibility(View.VISIBLE);
                h4.setVisibility(View.VISIBLE);
                h5.setVisibility(View.VISIBLE);
            }
        }


    }


}
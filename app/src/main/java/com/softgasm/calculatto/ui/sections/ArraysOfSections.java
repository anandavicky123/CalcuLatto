package com.softgasm.calculatto.ui.sections;

import androidx.annotation.StringRes;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.App;
import com.softgasm.calculatto.system.adapter.Items;

import java.util.ArrayList;

public class ArraysOfSections {

    private static String gs(@StringRes int string) {
        return App.getAppResources().getString(string);
    }


    public static ArrayList<Items> uc_objectproperties() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.length), R.drawable.item_length, 2));
        sectionsItems.add(new Items(gs(R.string.area), R.drawable.item_area, 3));
        sectionsItems.add(new Items(gs(R.string.volume), R.drawable.item_volume, 4));
        sectionsItems.add(new Items(gs(R.string.mass), R.drawable.mass, 27));
        sectionsItems.add(new Items(gs(R.string.datastorage), R.drawable.storage, 18));
        return sectionsItems;
    }

    public static ArrayList<Items> uc_electricity() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.power), R.drawable.item_power, 11));
        sectionsItems.add(new Items(gs(R.string.energy), R.drawable.item_energy, 12));
        sectionsItems.add(new Items(gs(R.string.potential), R.drawable.potential, 33));
        sectionsItems.add(new Items(gs(R.string.charge), R.drawable.charges, 34));
        sectionsItems.add(new Items(gs(R.string.current), R.drawable.e_current, 35));
        sectionsItems.add(new Items(gs(R.string.dipolemoment), R.drawable.dipole, 36));

        return sectionsItems;
    }

    public static ArrayList<Items> uc_visual() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.luminance), R.drawable.luminance, 37));
        sectionsItems.add(new Items(gs(R.string.illumination), R.drawable.illuminance, 38));
        sectionsItems.add(new Items(gs(R.string.solidangle), R.drawable.solidangle, 39));


        return sectionsItems;
    }


    public static ArrayList<Items> uc_thermodynamics() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.temperature), R.drawable.item_temperature, 1));
        sectionsItems.add(new Items(gs(R.string.specificheat), R.drawable.specificheat, 21));
        sectionsItems.add(new Items(gs(R.string.fuelconsumption), R.drawable.fuel_co, 32));
        return sectionsItems;
    }

    public static ArrayList<Items> uc_mechanics() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.angle), R.drawable.angle, 24));
        sectionsItems.add(new Items(gs(R.string.speed), R.drawable.item_speed, 26));
        sectionsItems.add(new Items(gs(R.string.torque), R.drawable.torque, 25));
        sectionsItems.add(new Items(gs(R.string.weight), R.drawable.weight, 5));
        return sectionsItems;
    }

    public static ArrayList<Items> uc_liquid() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.kinematicviscosity), R.drawable.kv, 28));
        sectionsItems.add(new Items(gs(R.string.dynamicviscosity), R.drawable.dv, 29));
        sectionsItems.add(new Items(gs(R.string.flow), R.drawable.flow, 30));
        sectionsItems.add(new Items(gs(R.string.density), R.drawable.density, 31));
        return sectionsItems;
    }

    public static ArrayList<Items> uc_others() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.cooking), R.drawable.cooking, 9));
        sectionsItems.add(new Items(gs(R.string.time), R.drawable.clock, 8));
        sectionsItems.add(new Items(gs(R.string.magnet), R.drawable.magnet, 20));
        sectionsItems.add(new Items(gs(R.string.loudness), R.drawable.loudness, 10));
        sectionsItems.add(new Items(gs(R.string.absorbeddose), R.drawable.absorbeddose, 19));
        return sectionsItems;
    }









    public static ArrayList<Items> h_bodyshape() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items("BMI", R.drawable.item_bmi, 1));
        sectionsItems.add(new Items("BSA", R.drawable.item_bsa, 2));
        sectionsItems.add(new Items(gs(R.string.lean_bm), R.drawable.item_lbm, 3));
        sectionsItems.add(new Items(gs(R.string.waistratio), R.drawable.item_waist, 4));
        sectionsItems.add(new Items(gs(R.string.rfmass), R.drawable.rfm, 5));
        sectionsItems.add(new Items(gs(R.string.bf_ffmi), R.drawable.item_ffmi, 6));
        return sectionsItems;
    }

    public static ArrayList<Items> h_bloodcirculation() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.bloodpressure), R.drawable.item_bp, 7));
        sectionsItems.add(new Items(gs(R.string.cardiac_index), R.drawable.item_ci, 8));
        sectionsItems.add(new Items(gs(R.string.irondeficiency), R.drawable.iron, 13));
        sectionsItems.add(new Items(gs(R.string.qtc), R.drawable.qtc, 15));
        return sectionsItems;
    }

    public static ArrayList<Items> h_serum() {
        ArrayList<Items> sectionsItems = new ArrayList<>();

        sectionsItems.add(new Items(gs(R.string.calciumcorrection), R.drawable.item_cc, 10));
        sectionsItems.add(new Items(gs(R.string.aniongap), R.drawable.anion, 12));
        sectionsItems.add(new Items("SAAG", R.drawable.saag, 16));
        sectionsItems.add(new Items(gs(R.string.transferrin_s), R.drawable.transferrin, 14));
        sectionsItems.add(new Items(gs(R.string.buncr), R.drawable.kidneys, 11));

        return sectionsItems;
    }

    public static ArrayList<Items> h_others() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items("BMR", R.drawable.bmr, 9));
        sectionsItems.add(new Items("LDL", R.drawable.ldl, 17));
        sectionsItems.add(new Items(gs(R.string.insulinresistance), R.drawable.insulinresistance, 18));
        return sectionsItems;
    }


    public static ArrayList<Items> a_kds() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.acceleration), R.drawable.acceleration, 1));
        sectionsItems.add(new Items(gs(R.string.displacement), R.drawable.displacement, 2));
        sectionsItems.add(new Items(gs(R.string.velocity), R.drawable.velocity, 3));
        sectionsItems.add(new Items(gs(R.string.momentum), R.drawable.item_momentum, 4));
        sectionsItems.add(new Items(gs(R.string.friction), R.drawable.friction, 5));
        sectionsItems.add(new Items(gs(R.string.pressure), R.drawable.pressure, 6));
        sectionsItems.add(new Items(gs(R.string.force), R.drawable.force, 16));
        return sectionsItems;
    }

    public static ArrayList<Items> a_chemistry() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.avogadro), R.drawable.avogadro, 17));
        sectionsItems.add(new Items(gs(R.string.concentration), R.drawable.concentration, 18));
        sectionsItems.add(new Items(gs(R.string.molality), R.drawable.molar, 7));
        sectionsItems.add(new Items(gs(R.string.molarity), R.drawable.molar, 8));
        sectionsItems.add(new Items(gs(R.string.bondorder), R.drawable.bondorder, 21));
        sectionsItems.add(new Items(gs(R.string.neutralization), R.drawable.neutralization, 22));
        return sectionsItems;
    }

    public static ArrayList<Items> a_relativity() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.einsteintheory), R.drawable.einstein, 9));
        sectionsItems.add(new Items(gs(R.string.lorentzfactor), R.drawable.lorentzfactor, 10));
        return sectionsItems;
    }

    public static ArrayList<Items> a_thermo() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.heatcapacity), R.drawable.heatcapacity, 11));
        sectionsItems.add(new Items(gs(R.string.idealgas), R.drawable.idealgaslaw, 12));
        sectionsItems.add(new Items(gs(R.string.waterheating), R.drawable.waterheating, 19));
        sectionsItems.add(new Items(gs(R.string.energyefficiency), R.drawable.energyefficiency, 13));
        return sectionsItems;
    }


    public static ArrayList<Items> a_others() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.frequency), R.drawable.frequency, 20));
        sectionsItems.add(new Items(gs(R.string.electricalpower), R.drawable.electricalpower, 15));
        sectionsItems.add(new Items(gs(R.string.machnumber), R.drawable.mach_number, 14));

        return sectionsItems;
    }


    public static ArrayList<Items> gl_basic() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.numeral_systems), R.drawable.numeralsystems, 1));
        sectionsItems.add(new Items(gs(R.string.percentage), R.drawable.item_percentage, 2));
        sectionsItems.add(new Items(gs(R.string.primeoddeven), R.drawable.poe, 3));
        sectionsItems.add(new Items(gs(R.string.triplem), R.drawable.median, 4));
        sectionsItems.add(new Items(gs(R.string.ratio), R.drawable.ratio, 5));
        sectionsItems.add(new Items(gs(R.string.fraction), R.drawable.fraction, 6));
        sectionsItems.add(new Items(gs(R.string.romannumeral), R.drawable.roman_numerals, 7));
        sectionsItems.add(new Items(gs(R.string.gcflcm), R.drawable.gcflcm, 8));
        sectionsItems.add(new Items(gs(R.string.modulo), R.drawable.modulo, 9));
        sectionsItems.add(new Items(gs(R.string.radical), R.drawable.radical, 10));
        sectionsItems.add(new Items(gs(R.string.cofunction), R.drawable.cofunction, 26));
        sectionsItems.add(new Items(gs(R.string.longbasiccalculator), R.drawable.longbasic, 11));
        return sectionsItems;
    }


    public static ArrayList<Items> gl_algebra() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.binominalcoefficient), R.drawable.bc, 12));
        sectionsItems.add(new Items(gs(R.string.gammafunction), R.drawable.gamma, 13));
        sectionsItems.add(new Items(gs(R.string.matrix), R.drawable.item_matrix, 14));
        sectionsItems.add(new Items(gs(R.string.linearequation), R.drawable.linear, 15));
        sectionsItems.add(new Items(gs(R.string.vector), R.drawable.item_vector, 16));
        return sectionsItems;
    }

    public static ArrayList<Items> gl_statistic() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.probability), R.drawable.probability, 17));
        sectionsItems.add(new Items(gs(R.string.coin), R.drawable.coin, 18));
        sectionsItems.add(new Items(gs(R.string.cnp), R.drawable.cnp, 19));
        sectionsItems.add(new Items(gs(R.string.dice), R.drawable.dice, 20));
        return sectionsItems;
    }

    public static ArrayList<Items> gl_others() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.date), R.drawable.item_date, 21));
        sectionsItems.add(new Items(gs(R.string.fabric), R.drawable.fabric, 22));
        sectionsItems.add(new Items(gs(R.string.clockangle), R.drawable.clockangle, 23));
        sectionsItems.add(new Items(gs(R.string.aquariumtank), R.drawable.item_aquarium, 24));
        sectionsItems.add(new Items(gs(R.string.timezone), R.drawable.timezone, 25));
        return sectionsItems;
    }


    public static ArrayList<Items> gm_one() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.circlearc), R.drawable.circle_arc, 1));
        sectionsItems.add(new Items(gs(R.string.helix), R.drawable.helix, 2));
        sectionsItems.add(new Items(gs(R.string.kochcurve), R.drawable.kochcurve, 3));
        sectionsItems.add(new Items(gs(R.string.parabola), R.drawable.parabola, 4));
        return sectionsItems;
    }


    public static ArrayList<Items> gm_two() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.rectangle), R.drawable.rectangle, 5));
        sectionsItems.add(new Items(gs(R.string.circle), R.drawable.circle, 6));
        sectionsItems.add(new Items(gs(R.string.triangle), R.drawable.triangle, 7));
        sectionsItems.add(new Items(gs(R.string.square), R.drawable.square, 8));
        sectionsItems.add(new Items(gs(R.string.ellipse), R.drawable.ellipse, 9));
        sectionsItems.add(new Items(gs(R.string.pentagon), R.drawable.pentagon, 10));
        sectionsItems.add(new Items(gs(R.string.hexagon), R.drawable.hexagon, 11));
        sectionsItems.add(new Items(gs(R.string.trapezoid), R.drawable.trapezoid, 12));
        sectionsItems.add(new Items(gs(R.string.rhombus), R.drawable.rhombus, 13));
        sectionsItems.add(new Items(gs(R.string.rtriangle), R.drawable.right_triangle, 14));
        return sectionsItems;
    }

    public static ArrayList<Items> gm_three() {
        ArrayList<Items> sectionsItems = new ArrayList<>();
        sectionsItems.add(new Items(gs(R.string.sphere), R.drawable.sphere, 15));
        sectionsItems.add(new Items(gs(R.string.cube), R.drawable.cube, 16));
        sectionsItems.add(new Items(gs(R.string.prism), R.drawable.prism, 17));
        sectionsItems.add(new Items(gs(R.string.pyramid), R.drawable.pyramid, 18));
        sectionsItems.add(new Items(gs(R.string.cylinder), R.drawable.cylinder, 19));
        sectionsItems.add(new Items(gs(R.string.ellipsoid), R.drawable.ellipsoid, 20));
        sectionsItems.add(new Items(gs(R.string.cone), R.drawable.cone, 21));
        sectionsItems.add(new Items(gs(R.string.pfrustum), R.drawable.pyramid_frustum, 22));
        sectionsItems.add(new Items(gs(R.string.cfrustum), R.drawable.cone_frustum, 23));
        sectionsItems.add(new Items(gs(R.string.scap), R.drawable.spherical_cap, 24));
        sectionsItems.add(new Items(gs(R.string.sseg), R.drawable.spherical_segment, 25));
        sectionsItems.add(new Items(gs(R.string.torus), R.drawable.torus, 26));
        return sectionsItems;
    }


}

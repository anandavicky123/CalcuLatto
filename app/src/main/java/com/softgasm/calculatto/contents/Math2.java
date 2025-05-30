package com.softgasm.calculatto.contents;

import com.softgasm.calculatto.system.Filters;

import java.util.HashMap;

public class Math2 {

    public static double gradian_toRadians(double gradians) {
        return gradians * (Math.PI / 200);
    }

    public static double quadrant_toRadians(double numbers) {
        return numbers * 1.5707963267948966;
    }

    public static double pirad_toRadians(double numbers) {
        return numbers * Math.PI;
    }

    public static double milirad_toRadians(double numbers) {
        return numbers * 0.001;
    }

    public static double compassp_toRadians(double numbers) {
        return numbers * 0.19634954084936;
    }

    public static double hourangle_toRadians(double numbers) {
        return numbers * 0.2617993878;
    }

    public static double arcminute_toRadians(double numbers) {
        return numbers * Math.PI / (60 * 180);
    }

    public static double arcsec_toRadians(double numbers) {
        return numbers * Math.PI / (180 * 3600);
    }


    public static double turn_toRadians(double turns) {
        return turns * 6.2831853072;
    }

    public static double asinh(double a) {
        final double sign;
        if (Double.doubleToRawLongBits(a) < 0) {
            a = Math.abs(a);
            sign = -1.0d;
        } else {
            sign = 1.0d;
        }

        return sign * Math.log(Math.sqrt(a * a + 1.0d) + a);
    }

    public static double atanh(double x) {
        return 0.5 * Math.log((x + 1.0) / (x - 1.0));
    }

    public static double acosh(double a) {
        return Math.log(Math.sqrt(a * a - 1.0d) + a);
    }


    public static double cot(double a) {
        return 1.0D / Math.tan(a);
    }

    public static double acot(double a) {
        return Math.atan(1.0D / a);
    }

    public static double sec(double a) {
        return 1.0 / Math.cos(a);
    }

    public static double asec(double a) {
        if (a < 1.0D && a > -1.0D)
            throw new IllegalArgumentException("asec argument (" + a + ") must be >= 1 or <= -1");
        return Math.acos(1.0 / a);
    }

    public static double csc(double a) {
        return 1.0D / Math.sin(a);
    }

    public static double acsc(double a) {
        if (a < 1.0D && a > -1.0D)
            throw new IllegalArgumentException("acsc argument (" + a + ") must be >= 1 or <= -1");
        return Math.asin(1.0 / a);
    }

    public static double exsec(double a) {
        return (1.0 / Math.cos(a) - 1.0D);
    }

    public static double aexsec(double a) {
        if (a < 0.0D && a > -2.0D)
            throw new IllegalArgumentException("aexsec argument (" + a + ") must be >= 0.0 and <= -2");
        return Math.asin(1.0D / (1.0D + a));
    }

    public static double vers(double a) {
        return (1.0D - Math.cos(a));
    }

    public static double avers(double a) {
        return Math.acos(1.0D - a);
    }

    public static double covers(double a) {
        return (1.0D - Math.sin(a));
    }

    public static double acovers(double a) {
        return Math.asin(1.0D - a);
    }

    public static double hav(double a) {
        return 0.5D * Math2.vers(a);
    }

    public static double ahav(double a) {
        return Math.acos(1.0D - 2.0D * a);
    }

    public static double sinc(double a) {
        if (Math.abs(a) < 1e-40) {
            return 1.0D;
        } else {
            return Math.sin(a) / a;
        }
    }

    public static double nsinc(double a) {
        if (Math.abs(a) < 1e-40) {
            return 1.0D;
        } else {
            return Math.sin(Math.PI * a) / (Math.PI * a);
        }
    }

    public static double coth(double a) {
        return 1.0D / Math.tanh(a);
    }

    public static double acoth(double a) {
        double sgn = 1.0D;
        if (a < 0.0D) {
            sgn = -1.0D;
            a = -a;
        }
        return 0.5D * sgn * (Math.log(1.0D + a) - Math.log(a - 1.0D));
    }

    public static double sech(double a) {
        return 1.0D / Math.cosh(a);
    }

    public static double asech(double a) {
        return Math.log((1 / a) + Math.sqrt((1 / Math.pow(a, 2)) - 1));
    }

    public static double csch(double a) {
        return 1.0D / Math.sinh(a);
    }

    public static double acsch(double a) {
        return Math.log(1 / a + Math.sqrt(5) / a);
    }

    public static double lb_toKg(double lb) {
        return lb * 0.45359237;
    }

    public static double ft_toCm(double ft) {
        return 30.48 * ft;
    }

    public static double sqft_toSqm(double sqft) {
        return sqft * 0.092903;
    }

    public static double sqm_toSqft(double sqm) {
        return sqm * 10.7639;
    }

    public static double sqm_toSqyd(double sqm) {
        return sqm * 1.19599;
    }

    public static double sqm_toAres(double sqm) {
        return sqm * 0.01;
    }

    public static double sqm_toHa(double sqm) {
        return sqm * 0.0001;
    }

    public static double inch_toCm(double in) {
        return 2.54 * in;
    }

    public static double cm_toM(double cm) {
        return cm * 0.01;
    }

    public static double kg_tolb(double kg) {
        return kg * 2.20462;
    }

    public static double lbusgal_togL(double lbusgal) {
        return lbusgal * 119.826;
    }

    public static double usgal_toL(double usgal) {
        return usgal * 3.78541;
    }

    public static double ukgal_toL(double ukgal) {
        return ukgal * 4.54609;
    }

    public static double kmh_toms(double kmh) {
        return kmh * 0.277778;
    }

    public static double mph_toms(double mph) {
        return mph * 0.44704;
    }

    public static double fahrenheit_toC(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double kelvin_toC(double k) {
        return k - 273.15;
    }

    public static double lbf_toN(double lbf) {
        return lbf * 4.44822;
    }

    public static double sqyd_toSqm(double sqyd) {
        return sqyd * 0.836127;
    }

    public static double Ares_toSqm(double sqA) {
        return sqA * 100;
    }

    public static double ha_toSqm(double ha) {
        return ha * 10000;
    }

    public static double pascal_toPsi(double thenumbers) {
        return thenumbers * 0.000145038;
    }

    public static double n_toLbf(double thenumbers) {
        return thenumbers * 0.224809;
    }

    public static double psi_toPascal(double thenumbers) {
        return thenumbers * 6894.76;
    }

    public static double kgms_tolbfts(double thenumbers) {
        return thenumbers * 7.23301;
    }

    public static double km_tom(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double feet_tom(double thenumbers) {
        return thenumbers * 0.3048;
    }

    public static double yd_tom(double thenumbers) {
        return thenumbers * 0.9144;
    }

    public static double mi_tom(double thenumbers) {
        return thenumbers * 1609.34;
    }

    public static double minute_tosec(double thenumbers) {
        return thenumbers * 60;
    }

    public static double hours_tosec(double thenumbers) {
        return thenumbers * 3600;
    }

    public static double days_tosec(double thenumbers) {
        return thenumbers * 86400;
    }

    public static double ms_tokmh(double thenumbers) {
        return thenumbers * 3.6;
    }

    public static double ms_tofts(double thenumbers) {
        return thenumbers * 3.28084;
    }

    public static double ms_tomph(double thenumbers) {
        return thenumbers * 2.23694;
    }

    public static double mstwo_tog(double thenumbers) {
        return thenumbers * 0.10197162129779283;
    }

    public static double mstwo_toftstwo(double thenumbers) {
        return thenumbers * 3.280839895013123;
    }

    public static double g_tomstwo(double thenumbers) {
        return thenumbers * 9.80665;
    }

    public static double ftstwo_tomstwo(double thenumbers) {
        return thenumbers * 0.3048;
    }

    public static double fts_toms(double thenumbers) {
        return thenumbers * 0.3048;
    }

    public static double knot_toms(double thenumbers) {
        return thenumbers * 0.514444;
    }

    public static double ms_toknot(double thenumbers) {
        return thenumbers * 1.94384;
    }


    public static double m_tokm(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double m_toft(double thenumbers) {
        return thenumbers * 3.28084;
    }

    public static double m_toyd(double thenumbers) {
        return thenumbers * 1.09361;
    }

    public static double m_tomi(double thenumbers) {
        return thenumbers * 0.000621371;
    }

    public static String convertDecimalToFraction(double x) {
        if (x < 0) {
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);

        return Filters.nocomma(h1) + "/" + Filters.nocomma(k1);
    }

    public static double gcd(double a, double b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static double lcm(double a, double b) {
        return (a * b) / gcd(a, b);
    }

    public static double mean(Double[] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }

    public static double mode(Double[] array) {
        HashMap<Double, Double> hm = new HashMap<>();
        double max = 1;
        double temp = 0;

        for (Double aDouble : array) {

            if (hm.get(aDouble) != null) {

                double count = hm.get(aDouble);
                count++;
                hm.put(aDouble, count);

                if (count > max) {
                    max = count;
                    temp = aDouble;
                }
            } else
                hm.put(aDouble, 1.0);
        }
        return temp;
    }

    public static double subfactorial(double N) {

        long fact = 1;
        for (int i = 2; i <= N; i++) {
            fact = fact * i;
        }
        return fact;
    }


    public static long whatAreTheOddsRec(int sum, int dices, long[][] mem, int DICE_FACES) {
        if (dices <= 1) {
            return 1;
        }
        long n = 0;
        int dicesRem = dices - 1;
        int minFace = Math.max(sum - DICE_FACES * dicesRem, 1);
        int maxFace = Math.min(sum - dicesRem, DICE_FACES);
        for (int i = minFace; i <= maxFace; i++) {
            int sumRem = sum - i;
            long ni = mem[dicesRem][sumRem];
            if (ni <= 0) {
                ni = whatAreTheOddsRec(sumRem, dicesRem, mem, DICE_FACES);
                mem[dicesRem][sumRem] = ni;
            }
            n += ni;
        }
        return n;
    }


    public static double m3_tol(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double n_to_lbf(double thenumbers) {
        return thenumbers * 0.224809;
    }

    public static double cm3_tol(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double inhg_topa(double thenumbers) {
        return thenumbers * 3386.39;
    }

    public static double mmhg_topa(double thenumbers) {
        return thenumbers * 133.322;
    }

    public static double pa_toinhg(double thenumbers) {
        return thenumbers * 0.0002953;
    }

    public static double pa_tommhg(double thenumbers) {
        return thenumbers * 0.00750062;
    }

    public static double bar_topa(double thenumbers) {
        return thenumbers * 100000;
    }

    public static double pa_tobar(double thenumbers) {
        return thenumbers * 0.00001;
    }

    public static double ra_toc(double thenumbers) {
        return (thenumbers - 491.67) * 5 / 9;
    }

    public static double re_toc(double thenumbers) {
        return thenumbers * 1.25;
    }

    public static double c_tof(double thenumbers) {
        return (thenumbers * 9 / 5) + 32;
    }

    public static double c_tok(double thenumbers) {
        return thenumbers + 273.15;
    }

    public static double c_tora(double thenumbers) {
        return (thenumbers * 9 / 5) + 491.67;
    }

    public static double c_tore(double thenumbers) {
        return (thenumbers * 4) / 5;
    }

    public static double l_tom3(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double kv_tov(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double w_tokw(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double w_tobtuh(double thenumbers) {
        return thenumbers * 3.412141633;
    }

    public static double btulbf_tojkgk(double thenumbers) {
        return thenumbers * 4186.81646;
    }

    public static double jk_tocalc(double thenumbers) {
        return thenumbers * 0.239005736;
    }

    public static double jk_tobtuf(double thenumbers) {
        return thenumbers * 0.000526562997;
    }

    public static double kj_toj(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double kwh_toj(double thenumbers) {
        return thenumbers * 3600000;
    }

    public static double ftlb_toj(double thenumbers) {
        return thenumbers * 1.35582;
    }

    public static double kcal_toj(double thenumbers) {
        return thenumbers * 4184;
    }

    public static double ev_toj(double thenumbers) {
        return thenumbers * 1.6021766339999E-19;
    }

    public static double btu_toj(double thenumbers) {
        return thenumbers * 1055.055853;
    }

    public static double liter_tousgal(double thenumbers) {
        return thenumbers * 0.264172;
    }

    public static double liter_toukgal(double thenumbers) {
        return thenumbers * 0.219969;
    }

    public static double liter_tocmeter(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double liter_toccentimeter(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double vcs(double thenumbers) {
        return 1 + Math.cos(thenumbers);
    }

    public static double cvc(double thenumbers) {
        return 1 + Math.sin(thenumbers);
    }

    public static double hvc(double thenumbers) {
        return vcs(thenumbers) / 2;
    }

    public static double excsc(double thenumbers) {
        return csc(thenumbers) - 1;
    }

    public static double avcs(double thenumbers) {
        return Math.acos(thenumbers - 1);
    }

    public static double acvc(double thenumbers) {
        return Math.asin(thenumbers - 1);
    }

    public static double ahvc(double thenumbers) {
        return Math.acos((2 * thenumbers) - 1);
    }

    public static double aexcsc(double thenumbers) {
        return Math.asin(1 / (thenumbers + 1));
    }

    public static double hacov(double thenumbers) {
        return covers(thenumbers) / 2;
    }

    public static double hcc(double thenumbers) {
        return cvc(thenumbers) / 2;
    }

    public static double ahacov(double thenumbers) {
        return Math.asin(1 - (2 * thenumbers));
    }

    public static double ahcc(double thenumbers) {
        return Math.asin((2 * thenumbers) - 1);
    }

    public static double mmoll_tomgdl(double thenumbers) {
        return thenumbers * 18.0182;
    }

    public static double gl_togdl(double thenumbers) {
        return thenumbers * 0.1;
    }

    public static double gdl_tomgdl(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double mgdl_togdl(double thenumbers) {
        return thenumbers / 1000;
    }

    public static double mmoll_togdl(double thenumbers) {
        return thenumbers * 1.6113;
    }

    public static double mcmolel_togdl(double thenumbers) {
        return thenumbers * 1.131E-5;
    }

    public static double gdl_tomicrogramdl(double thenumbers) {
        return thenumbers * 1e+6;
    }

    public static double microgramdl_togdl(double thenumbers) {
        return thenumbers / 1e+6;
    }

    public static double s_toms(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double ms_tos(double thenumbers) {
        return thenumbers / 1000;
    }

    public static double gdl_togl(double thenumbers) {
        return thenumbers * 10;
    }

    public static double gdl_tommoll(double thenumbers) {
        return thenumbers * 0.6206;
    }

    public static double gdl_tomicromoll(double thenumbers) {
        return thenumbers * 88420;
    }

    public static double gcm3_tokgm3(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double slugsft3_tokgm3(double thenumbers) {
        return thenumbers * 0.00194032;
    }

    public static double lbmft3_tokgm3(double thenumbers) {
        return thenumbers * 16.0185;
    }

    public static double mmole_tomole(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double micromole_tomole(double thenumbers) {
        return thenumbers * 1e-6;
    }

    public static double kw_tow(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double mw_tow(double thenumbers) {
        return thenumbers * 1000000;
    }

    public static double gw_tow(double thenumbers) {
        return thenumbers * 1e+9;
    }

    public static double btuh_tow(double thenumbers) {
        return thenumbers * 0.293071;
    }

    public static double sec_tomin(double thenumbers) {
        return thenumbers * 0.0166667;
    }

    public static double sec_toh(double thenumbers) {
        return thenumbers * 0.000277778;
    }

    public static double sec_tod(double thenumbers) {
        return thenumbers / 86400;
    }

    public static double hz_tokhz(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double hz_tomhz(double thenumbers) {
        return thenumbers * 1e-6;
    }

    public static double hz_toghz(double thenumbers) {
        return thenumbers * 1e-9;
    }

    public static double g_tokg(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double mg_tokg(double thenumbers) {
        return thenumbers * 1E-06;
    }

    public static double oz_tokg(double thenumbers) {
        return thenumbers * 0.0283495231246628;
    }

    public static double uston_tokg(double thenumbers) {
        return thenumbers * 907.184748990598;
    }

    public static double ukton_tokg(double thenumbers) {
        return thenumbers * 1016.0469088;
    }

    public static double mton_tokg(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double usst_tokg(double thenumbers) {
        return thenumbers * 5.66990462653995;
    }

    public static double ukst_tokg(double thenumbers) {
        return thenumbers * 6.35029318071658;
    }

    public static double kg_tog(double thenumbers) {
        return thenumbers * 1000;
    }

    public static double kg_tomg(double thenumbers) {
        return thenumbers * 1000000;
    }

    public static double kg_tooz(double thenumbers) {
        return thenumbers * 35.27396195;
    }

    public static double kg_tomton(double thenumbers) {
        return thenumbers * 0.001;
    }

    public static double kg_touston(double thenumbers) {
        return thenumbers * 0.0011023113;
    }

    public static double kg_toukton(double thenumbers) {
        return thenumbers * 0.000984206527611061;
    }

    public static double kg_tousst(double thenumbers) {
        return thenumbers * 0.1763698097;
    }

    public static double kg_toukst(double thenumbers) {
        return thenumbers * 0.1574730444;
    }


    public static double floz_tol(double thenumbers) {
        return thenumbers * 0.0295735296;
    }

    public static double incb_tol(double thenumbers) {
        return thenumbers * 0.016387064;
    }

    public static double ftcb_tol(double thenumbers) {
        return thenumbers * 28.316846592;
    }


    public static double l_tofloz(double thenumbers) {
        return thenumbers * 33.814022702;
    }

    public static double l_toincb(double thenumbers) {
        return thenumbers * 61.023744095;
    }

    public static double l_toftcb(double thenumbers) {
        return thenumbers * 0.0353146667;
    }


    public static double m_tocm(double thenumbers) {
        return thenumbers * 100;
    }

    public static double ft_tocm(double thenumbers) {
        return thenumbers * 30.48;
    }

    public static double mm_tocm(double thenumbers) {
        return thenumbers * 0.1;
    }

    public static double in_toft(double thenumbers) {
        return thenumbers / 12;
    }
}
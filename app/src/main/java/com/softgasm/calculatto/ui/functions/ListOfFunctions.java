package com.softgasm.calculatto.ui.functions;

import java.util.ArrayList;

public class ListOfFunctions {

    public static ArrayList<Functions> basics() {
        ArrayList<Functions> aaa = new ArrayList<>();
        aaa.add(new Functions("(", "(", 0));
        aaa.add(new Functions(")", ")", 2));
        aaa.add(new Functions("^", "^", 3));
        aaa.add(new Functions("π", "π", 1));
        aaa.add(new Functions("sqrt(", "√", 0));
        aaa.add(new Functions("cbrt(", "∛", 0));
        aaa.add(new Functions("℮", "℮", 1));
        aaa.add(new Functions("φ", "φ", 1));
        aaa.add(new Functions("!(", "N!", 0));
        aaa.add(new Functions("log(", "log", 0));
        aaa.add(new Functions("log10(", "log10", 0));
        aaa.add(new Functions("log1p(", "log1p", 0));
        aaa.add(new Functions("ceil(", "ceil", 0));
        aaa.add(new Functions("exp(", "exp", 0));
        aaa.add(new Functions("expm1(", "eˣ-1", 0));
        aaa.add(new Functions("floor(", "floor", 0));
        aaa.add(new Functions("ulp(", "ulp", 0));
        aaa.add(new Functions("rint(", "rint", 0));
        aaa.add(new Functions("abs(", "|x|", 0));
        return aaa;

    }

    public static ArrayList<Functions> trigonometries() {
        ArrayList<Functions> aaa = new ArrayList<>();
        aaa.add(new Functions("sin(", "sin", 0));
        aaa.add(new Functions("cos(", "cos", 0));
        aaa.add(new Functions("tan(", "tan", 0));
        aaa.add(new Functions("asin(", "sin⁻¹", 0));
        aaa.add(new Functions("acos(", "cos⁻¹", 0));
        aaa.add(new Functions("atan(", "tan⁻¹", 0));
        aaa.add(new Functions("sinh(", "sinh", 0));
        aaa.add(new Functions("cosh(", "cosh", 0));
        aaa.add(new Functions("tanh(", "tanh", 0));
        aaa.add(new Functions("asinh(", "sinh⁻¹", 0));
        aaa.add(new Functions("acosh(", "cosh⁻¹", 0));
        aaa.add(new Functions("atanh(", "tanh⁻¹", 0));
        aaa.add(new Functions("sec(", "sec", 0));
        aaa.add(new Functions("cot(", "cot", 0));
        aaa.add(new Functions("csc(", "csc", 0));
        aaa.add(new Functions("asec(", "sec⁻¹", 0));
        aaa.add(new Functions("acot(", "cot⁻¹", 0));
        aaa.add(new Functions("acsc(", "csc⁻¹", 0));
        aaa.add(new Functions("sech(", "sech", 0));
        aaa.add(new Functions("coth(", "coth", 0));
        aaa.add(new Functions("csch(", "csch", 0));
        aaa.add(new Functions("asech(", "sech⁻¹", 0));
        aaa.add(new Functions("acoth(", "coth⁻¹", 0));
        aaa.add(new Functions("acsch(", "csch⁻¹", 0));
        aaa.add(new Functions("vers(", "vers", 0));
        aaa.add(new Functions("covers(", "covers", 0));
        aaa.add(new Functions("hav(", "hav", 0));
        aaa.add(new Functions("exsec(", "exsec", 0));
        aaa.add(new Functions("avers(", "vers⁻¹", 0));
        aaa.add(new Functions("acovers(", "covers⁻¹", 0));
        aaa.add(new Functions("ahav(", "hav⁻¹", 0));
        aaa.add(new Functions("aexsec(", "exsec⁻¹", 0));
        aaa.add(new Functions("vcs(", "vcs", 0));
        aaa.add(new Functions("cvc(", "cvc", 0));
        aaa.add(new Functions("hvc(", "hvc", 0));
        aaa.add(new Functions("excsc(", "excsc", 0));
        aaa.add(new Functions("avcs(", "vcs⁻¹", 0));
        aaa.add(new Functions("acvc(", "cvc⁻¹", 0));
        aaa.add(new Functions("ahvc(", "hvc⁻¹", 0));
        aaa.add(new Functions("aexcsc(", "excsc⁻¹", 0));
        aaa.add(new Functions("hacov(", "hacov", 0));
        aaa.add(new Functions("hcc(", "hcc", 0));
        aaa.add(new Functions("ahacov(", "hacov⁻¹", 0));
        aaa.add(new Functions("ahcc(", "hcc⁻¹", 0));
        aaa.add(new Functions("sinc(", "sinc", 0));
        return aaa;
    }

}

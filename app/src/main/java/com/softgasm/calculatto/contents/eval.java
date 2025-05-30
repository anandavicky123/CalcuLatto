package com.softgasm.calculatto.contents;

import com.softgasm.calculatto.basic;

public class eval {



    public static double calculate(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('−')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('×')) x *= parseFactor(); // multiplication
                    else if (eat('÷')) x /= parseFactor(); // division
                    else return x;
                }
            }

            int angle = 0;
            double result_with_angle (double x){
                angle = basic.basic_angle();
                double result;

                if (angle == 1){
                    result = Math.toRadians(x);
                } else if (angle == 2){
                    result = Math2.turn_toRadians(x);
                } else if (angle == 3){
                    result = Math2.gradian_toRadians(x);
                } else if (angle == 4){
                    result = Math2.quadrant_toRadians(x);
                } else if (angle == 5){
                    result = Math2.pirad_toRadians(x);
                } else if (angle == 6){
                    result = Math2.milirad_toRadians(x);
                } else if (angle == 7){
                    result = Math2.compassp_toRadians(x);
                } else if (angle == 8){
                    result = Math2.hourangle_toRadians(x);
                } else if (angle == 9){
                    result = Math2.arcminute_toRadians(x);
                } else if (angle == 10){
                    result = Math2.arcsec_toRadians(x);
                }
                else {
                    result = x;
                }
                return result;
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.' || ch == ',') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.'|| ch == ',') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')'))
                            throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }

                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "cbrt":
                            x = Math.cbrt(x);
                            break;
                        case "sin":
                            x = Math.sin(result_with_angle(x));
                            break;
                        case "cos":
                            x = Math.cos(result_with_angle(x));
                            break;
                        case "tan":
                            x = Math.tan(result_with_angle(x));
                            break;
                        case "asin":
                            x = Math.asin(result_with_angle(x));
                            break;
                        case "acos":
                            x = Math.acos(result_with_angle(x));
                            break;
                        case "atan":
                            x = Math.atan(result_with_angle(x));
                            break;
                        case "sinh":
                            x = Math.sinh(result_with_angle(x));
                            break;
                        case "cosh":
                            x = Math.cosh(result_with_angle(x));
                            break;
                        case "tanh":
                            x = Math.tanh(result_with_angle(x));
                            break;
                        case "asinh":
                            x = Math2.asinh(result_with_angle(x));
                            break;
                        case "acosh":
                            x = Math2.acosh(result_with_angle(x));
                            break;
                        case "atanh":
                            x = Math2.atanh(result_with_angle(x));
                            break;
                        case "abs":
                            x = Math.abs(x);
                            break;
                        case "log":
                            x = Math.log(x);
                            break;
                        case "ceil":
                            x = Math.ceil(x);
                            break;
                        case "exp":
                            x = Math.exp(x);
                            break;
                        case "expm":
                            x = Math.expm1(x);
                            break;
                        case "floor":
                            x = Math.floor(x);
                            break;
                        case "ulp":
                            x = Math.ulp(x);
                            break;
                        case "logten":
                            x = Math.log10(x);
                            break;
                        case "logap":
                            x = Math.log1p(x);
                            break;
                        case "rint":
                            x = Math.rint(x);
                            break;
                        case "round":
                            x = Math.round(x);
                            break;
                        case "sfact":
                            x = Math2.subfactorial(x);
                            break;
                        case "sec":
                            x = Math2.sec(result_with_angle(x));
                            break;
                        case "cot":
                            x = Math2.cot(result_with_angle(x));
                            break;
                        case "csc":
                            x = Math2.csc(result_with_angle(x));
                            break;
                        case "asec":
                            x = Math2.asec(result_with_angle(x));
                            break;
                        case "acot":
                            x = Math2.acot(result_with_angle(x));
                            break;
                        case "acsc":
                            x = Math2.acsc(result_with_angle(x));
                            break;
                        case "sech":
                            x = Math2.sech(result_with_angle(x));
                            break;
                        case "coth":
                            x = Math2.coth(result_with_angle(x));
                            break;
                        case "csch":
                            x = Math2.csch(result_with_angle(x));
                            break;
                        case "asech":
                            x = Math2.asech(result_with_angle(x));
                            break;
                        case "acoth":
                            x = Math2.acoth(result_with_angle(x));
                            break;
                        case "acsch":
                            x = Math2.acsch(result_with_angle(x));
                            break;
                        case "exsec":
                            x = Math2.exsec(result_with_angle(x));
                            break;
                        case "aexsec":
                            x = Math2.aexsec(result_with_angle(x));
                            break;
                        case "vers":
                            x = Math2.vers(result_with_angle(x));
                            break;
                        case "avers":
                            x = Math2.avers(result_with_angle(x));
                            break;
                        case "acovers":
                            x = Math2.acovers(result_with_angle(x));
                            break;
                        case "covers":
                            x = Math2.covers(result_with_angle(x));
                            break;
                        case "hav":
                            x = Math2.hav(result_with_angle(x));
                            break;
                        case "ahav":
                            x = Math2.ahav(result_with_angle(x));
                            break;
                        case "sinc":
                            x = Math2.sinc(result_with_angle(x));
                            break;
                        case "nsinc":
                            x = Math2.nsinc(result_with_angle(x));
                            break;
                        case "vcs":
                            x = Math2.vcs(result_with_angle(x));
                            break;
                        case "cvc":
                            x = Math2.cvc(result_with_angle(x));
                            break;
                        case "hvc":
                            x = Math2.hvc(result_with_angle(x));
                            break;
                        case "excsc":
                            x = Math2.excsc(result_with_angle(x));
                            break;
                        case "avcs":
                            x = Math2.avcs(result_with_angle(x));
                            break;
                        case "acvc":
                            x = Math2.acvc(result_with_angle(x));
                            break;
                        case "ahvc":
                            x = Math2.ahvc(result_with_angle(x));
                            break;
                        case "aexcsc":
                            x = Math2.aexcsc(result_with_angle(x));
                            break;
                        case "hacov":
                            x = Math2.hacov(result_with_angle(x));
                            break;
                        case "hcc":
                            x = Math2.hcc(result_with_angle(x));
                            break;
                        case "ahacov":
                            x = Math2.ahacov(result_with_angle(x));
                            break;
                        case "ahcc":
                            x = Math2.ahcc(result_with_angle(x));
                            break;


                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
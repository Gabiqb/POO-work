package lab3;

import java.util.*;

//import java.lang.Math; 
public class pb2 {

    private static double fxn(double a, double b, double c, double x) {
        double res = 0.0;

        res = a * x * x + b * x + c;

        return res;

    }

    private static double fderxn(double a, double b, double c, double x) {
        double res = 0.0;

        res = 2.0 * a * x + b;

        return res;

    }

    private static double frac(double a, double b, double c, double xn) {
        double fr = 0.0;

        fr = fxn(a, b, c, xn) / fderxn(a, b, c, xn);

        return fr;
    }

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in);
        double a, b, c, x0;
        System.out.println("Introduceti coeficientii functiei de gradul 2: a b c ");

        a = inn.nextDouble();
        b = inn.nextDouble();
        c = inn.nextDouble();

        System.out.println("Introduceti primul termen al sirului xn : x0 ");

        x0 = inn.nextDouble(); /// xn

        double eps = 0.0001;

        double xp1 = x0 - frac(a, b, c, x0); /// xn+1

        double xnm = x0;

        int iter = 1;

        while (xp1 - xnm > eps) {
            xp1 = xnm - frac(a, b, c, xnm);
            xnm = xp1;

            iter++;
        }
        System.out.println(
                "Solutia polinomului este " + xp1 + " si numarul de iteratii executate pentru solutie este " + iter);

        inn.close();
    }

}

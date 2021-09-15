package lab4;

import java.awt.Color;

public class Autovehicul {
    static String marca;
    public static Color culoare;
    public static int vitcurenta;
    static int treaptac;
    final int vitezamax = 260;

    public static void accelerare(int acc) {
        if (getVitcurenta() + acc > 260)
            setVitcurenta(260);
        else
            setVitcurenta(getVitcurenta() + acc);

    }

    public void identificare(String m, Color c, int tr) {
        setMarca(m);
        setCuloare(c);
        setTreaptac(tr);
    }

    public static void decelerare(int dec) {
        if (getVitcurenta() - dec < 0)
            setVitcurenta(0);
        else
            setVitcurenta(getVitcurenta() - dec);
    }

    public static void orpire() {
        setVitcurenta(0);
        setTreaptac(0);
    }

    public static void pornire() {
        setVitcurenta(0);
        setTreaptac(1);
    }

    public static void schimbatreapta(int vit) {
        if (vit <= 20)
            setTreaptac(1);
        else if (vit > 20 && vit <= 40)
            setTreaptac(2);
        else if (vit > 40 && vit <= 70)
            setTreaptac(3);
        else if (vit > 70 && vit <= 90)
            setTreaptac(4);
        else if (vit > 90)
            setTreaptac(5);
        else
            setTreaptac(0);

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        Autovehicul.marca = marca;
    }

    public Color getCuloare() {
        return culoare;
    }

    public void setCuloare(Color culoare) {
        Autovehicul.culoare = culoare;
    }

    public static int getTreaptac() {
        return treaptac;
    }

    public static void setTreaptac(int treaptac) {
        Autovehicul.treaptac = treaptac;
    }

    public static int getVitcurenta() {
        return vitcurenta;
    }

    public static void setVitcurenta(int vitcurenta) {
        Autovehicul.vitcurenta = vitcurenta;
    }

}

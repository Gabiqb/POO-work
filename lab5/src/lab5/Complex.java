package lab5;

public class Complex {
    double a;
    double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double modul() {
        return getA() * getA() + getB() * getB();
    }

    public void conjugat() {
        setB(-getB());
    }

}

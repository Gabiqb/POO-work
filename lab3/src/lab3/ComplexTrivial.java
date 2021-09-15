package lab3;

public class ComplexTrivial {

    private double real;
    private double img;

    public ComplexTrivial(double r, double i) {
        real = r;
        img = i;
    }

    public void aduna(ComplexTrivial cvalue) {
        real = real + cvalue.real;
        img = img + cvalue.img;
    }

    public void scade(ComplexTrivial cvalue) {
        real = real - cvalue.real;
        img = img - cvalue.img;
    }

    public static void main(String[] args) {
        ComplexTrivial t = new ComplexTrivial(1.0, 5.0);

        t.aduna(t);

        System.out.println(t.img);

    }
}


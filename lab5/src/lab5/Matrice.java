package lab5;

public class Matrice {
    final static int nmax = 2;
    public static Complex[][] matrice = new Complex[nmax][nmax];

    public Complex[][] getMatrice() {
        return matrice;
    }

    public static void setMatrice(Complex[][] matrice) {
        Matrice.matrice = matrice;
    }

    public static void aduna(Complex[][] a, Complex[][] b) {

        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < nmax; j++) {
                a[i][j].setA(b[i][j].getA() + a[i][j].getA());
                a[i][j].setB(b[i][j].getB() + a[i][j].getB());
            }
        }
    }

    public static void scade(Complex[][] a, Complex[][] b) {

        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < nmax; j++) {
                a[i][j].setA(a[i][j].getA() - b[i][j].getA());
                a[i][j].setB(a[i][j].getB() - b[i][j].getB());
            }
        }
    }

    public static void inmscalar(Complex[][] a, double c) {

        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < nmax; j++) {
                a[i][j].setA(a[i][j].getA() * c);
                a[i][j].setB(a[i][j].getB() * c);
            }
        }
    }

    public static void init() {
        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < nmax; j++) {
                matrice[i][j] = new Complex();
                matrice[i][j].setA(Math.random() * 10);
                matrice[i][j].setB(Math.random() * 10);
            }
        }
    }

    public static Complex[][] produs(Complex[][] a, Complex[][] b) {
        Complex[][] c = new Complex[nmax][nmax];
        for (int i = 0; i < nmax; i++) {

            for (int j = 0; j < nmax; j++) {
                c[i][j] = new Complex();
                c[i][j].setA(0);
                c[i][j].setB(0);

                for (int t = 0; t < nmax; t++) {
                    double a1, a2, b1, b2;
                    double A, B;
                    a1 = a[i][t].getA(); // a de la primul nr complex
                    b1 = a[i][t].getB();// b de la primul nr complex
                    a2 = b[t][j].getA();// a de la al 2 lea nr complex
                    b2 = b[t][j].getB();// b de la al 2 lea nr complex
                    A = a1 * a2 - b1 * b2; //// a de la inmultirea nr complexe
                    B = a1 * b2 + a2 * b1; //// b de la inmultirea nr complexe
                    c[i][j].setA(c[i][j].getA() + A); /// adunam produsul in noua matrice ( pentru partea Re nr complex)
                    c[i][j].setB(c[i][j].getB() + B); /// adunam produsul in noua matrice ( pentru partea Im nr complex)

                }
            }
        }

        return c;
    }

    public static void printm(Complex[][] a) {
        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < nmax; j++) {
                System.out.print(String.format("%.2f + %.2fi      ", a[i][j].getA(), a[i][j].getB()));
            }
            System.out.println();

        }
        System.out.println();
    }

}

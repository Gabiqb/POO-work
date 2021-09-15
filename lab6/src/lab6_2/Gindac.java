package lab6_2;

public class Gindac extends Insecta {
    protected int k = printInit("Gindac.k initializat");

    public Gindac() {super();

        System.out.println("k = " + k);
        System.out.println("j = " + j);

    }

    private static int x2 = printInit("Gindac.x2 initializat");

    public static void main(String[] args) {
        System.out.println("Gindac constructor");
        Insecta b = new Gindac();
        // System.out.println(((Insecta) b).k);
        System.out.println(((Gindac) b).k);
        // Musca m = new Musca();
        Insecta g = new Gindac_de_colorado();
    }
}

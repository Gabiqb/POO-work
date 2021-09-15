package lab6_2;

class Insecta {
    private int i = 9;
    protected int j;
    public int k = 100;

    Insecta() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("Insecta.x1 initializata");

    static int printInit(String s) {
        System.out.println(s);
        // System.out.println(x1);
        return 47;
    }
}

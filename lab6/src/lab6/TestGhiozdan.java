package lab6;

public class TestGhiozdan {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Ghiozdan g = new Ghiozdan();
        Caiet c1 = new Caiet();
        Caiet c2 = new Caiet();
        c1.eticheta = "Pigna";
        c2.eticheta = "Alexandria";
        Manual m1 = new Manual();
        Manual m2 = new Manual();
        m1.eticheta = "Matematica";
        m2.eticheta = "Programare";
        g.addc(c1);
        g.addm(m2);
        g.addc(c2);
        g.addm(m1);
        g.listitems();
        g.listcaiet();
        g.listmanual();
    }

}

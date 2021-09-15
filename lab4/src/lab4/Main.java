package lab4;

//import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*
         * Autovehicul a1 = new Autovehicul(); a1.pornire();
         * System.out.println("pornire a1 in treapta " + a1.treaptac);
         * a1.accelerare(50); System.out.println("a1 are viteza  " +
         * a1.getVitcurenta()); a1.schimbatreapta(50);
         * System.out.println("a1 este in treapta " + a1.treaptac + " cu viteza 50");
         * a1.decelerare(50); a1.schimbatreapta(a1.getVitcurenta());
         * System.out.println("a1 este in treapta " + a1.treaptac + " cu viteza 0");
         * a1.identificare("MB", Color.BLACK, 1); System.out.println("Autovehiculul " +
         * a1.getMarca() + " are culoarea " + a1.getCuloare().toString() +
         * "aflat in treapta " + a1.getTreaptac()); Sofer s1 = new Sofer();
         * s1.setNume("Vlaicu"); s1.setPrenume("Aurel"); s1.setVarsta(101);
         * s1.setNr_permis(1003423);
         * System.out.println("Soferul s1 are numele si prenumele " + s1.getNume() + " "
         * + s1.getPrenume() + " " + "avand varsta de " + s1.getVarsta() + " ani " +
         * "si numarul de permis " + s1.getNr_permis());
         *
         */

        Client c1 = new Client();
        Magazin m1 = new Magazin();
        m1.setMag("Mega IMAGE");
        c1.setNume_client("Dorel");
        c1.setSuma_cont(1500);
        c1.setNr_card("5421 2345 5021 4412");
        Produse p1 = new Produse();
        Plata suma1 = new Plata();

        p1.setNr_produse(20);
        p1.setSumap(15);
        p1.aduna_comanda();

        c1 = suma1.plataproduse(c1, p1.getTotal(), m1);

        //////////////////////////////////////////////
        m1.setMag("GUCCI");
        c1.setNume_client("Vasile");
        c1.setSuma_cont(500);
        p1.setNr_produse(2);
        p1.setSumap(500);
        p1.aduna_comanda();

        c1 = suma1.plataproduse(c1, p1.getTotal(), m1);

    }

}

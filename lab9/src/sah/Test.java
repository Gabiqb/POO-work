package sah;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PiesaSah[][] tabla = new PiesaSah[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = new Nula();
                tabla[i][j].setNumePiesa(" ");

            }
        tabla[0][0] = new Tura();
        tabla[0][1] = new Cal();
        tabla[0][2] = new Nebun();
        tabla[0][3] = new Regina();
        tabla[0][4] = new Rege();
        tabla[0][5] = new Nebun();
        tabla[0][6] = new Cal();
        tabla[0][7] = new Tura();
        tabla[1][0] = new Pion();
        tabla[1][1] = new Pion();
        tabla[1][2] = new Pion();
        tabla[1][3] = new Pion();
        tabla[1][4] = new Pion();
        tabla[1][5] = new Pion();
        tabla[1][6] = new Pion();
        tabla[1][7] = new Pion();

        tabla[7][0] = new Tura();
        tabla[7][1] = new Cal();
        tabla[7][2] = new Nebun();
        tabla[7][3] = new Regina();
        tabla[7][4] = new Rege();
        tabla[7][5] = new Nebun();
        tabla[7][6] = new Cal();
        tabla[7][7] = new Tura();
        tabla[6][0] = new Pion();
        tabla[6][1] = new Pion();
        tabla[6][2] = new Pion();
        tabla[6][3] = new Pion();
        tabla[6][4] = new Pion();
        tabla[6][5] = new Pion();
        tabla[6][6] = new Pion();
        tabla[6][7] = new Pion();

        tabla[0][0].setNumePiesa("T");
        tabla[0][1].setNumePiesa("C");
        tabla[0][2].setNumePiesa("N");
        tabla[0][3].setNumePiesa("Q");
        tabla[0][4].setNumePiesa("K");
        tabla[0][5].setNumePiesa("N");
        tabla[0][6].setNumePiesa("C");
        tabla[0][7].setNumePiesa("T");
        tabla[1][0].setNumePiesa("P");
        tabla[1][1].setNumePiesa("P");
        tabla[1][2].setNumePiesa("P");
        tabla[1][3].setNumePiesa("P");
        tabla[1][4].setNumePiesa("P");
        tabla[1][5].setNumePiesa("P");
        tabla[1][6].setNumePiesa("P");
        tabla[1][7].setNumePiesa("P");

        tabla[7][0].setNumePiesa("t");
        tabla[7][1].setNumePiesa("c");
        tabla[7][2].setNumePiesa("n");
        tabla[7][3].setNumePiesa("q");
        tabla[7][4].setNumePiesa("k");
        tabla[7][5].setNumePiesa("n");
        tabla[7][6].setNumePiesa("c");
        tabla[7][7].setNumePiesa("t");
        tabla[6][0].setNumePiesa("p");
        tabla[6][1].setNumePiesa("p");
        tabla[6][2].setNumePiesa("p");
        tabla[6][3].setNumePiesa("p");
        tabla[6][4].setNumePiesa("p");
        tabla[6][5].setNumePiesa("p");
        tabla[6][6].setNumePiesa("p");
        tabla[6][7].setNumePiesa("p");

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {

                tabla[i][j].setX1(i);
                tabla[i][j].setY1(j);
            }

        tabla[7][1].mutaPiesa(5, 0, tabla);
        tabla[5][0].mutaPiesa(4, 2, tabla);
        tabla[6][1].mutaPiesa(4, 1, tabla);
        // tabla[5][1].mutaPiesa(4, 1, tabla);

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++)
                System.out.print(tabla[i][j].getNumePiesa() + " ");
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(tabla[i][j].getX1() + " ");
            System.out.println();
        }
    }

}

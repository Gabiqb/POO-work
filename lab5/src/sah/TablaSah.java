package sah;

import java.util.Arrays;

public class TablaSah {
    private static Character[][] tabla = new Character[8][8];

    public static Character[][] init() {
        for (Character[] linie : getTabla())
            Arrays.fill(linie, ' ');

        getTabla()[0][0] = 't';
        getTabla()[0][1] = 'c';
        getTabla()[0][2] = 'n';
        getTabla()[0][3] = 'q'; // regina piese negre
        getTabla()[0][4] = 'k'; // regele
        getTabla()[0][5] = 'n';
        getTabla()[0][6] = 'c';
        getTabla()[0][7] = 't';
        for (int i = 0; i < 8; i++)
            getTabla()[1][i] = 'p';

        for (int i = 0; i < 8; i++)
            getTabla()[6][i] = 'P';

        getTabla()[7][0] = 'T';
        getTabla()[7][1] = 'C';
        getTabla()[7][2] = 'N';
        getTabla()[7][3] = 'Q'; // regina piese albe
        getTabla()[7][4] = 'K'; // regele
        getTabla()[7][5] = 'N';
        getTabla()[7][6] = 'C';
        getTabla()[7][7] = 'T';
        return tabla;
    }

    public static void printt() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(String.format("%c ", getTabla()[i][j]));
            }
            System.out.println();

        }
        System.out.println();
    }

    public static Character[][] getTabla() {
        return tabla;
    }

    public static void setTabla(Character[][] tabla) {
        TablaSah.tabla = tabla;
    }

}

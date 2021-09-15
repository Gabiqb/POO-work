package sah;

public class Tura extends PiesaSah {
    public static boolean validt(int i1, int j1, int i2, int j2, PiesaSah[][] tabla) {
        if ((i1 == i2 || j1 == j2) && !(i1 == i2 && j1 == j2))
            if (checkpatht(i1, i2, j1, j2, tabla)) {
                if (tabla[i1][j1].getNumePiesa().charAt(0) == 'T')
                    if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0)))
                        return true;
                if (tabla[i1][j1].getNumePiesa().charAt(0) == 't')
                    if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0)))
                        return true;
            }
        return false;
    }

    public static boolean checkpatht(int i1, int j1, int i2, int j2, PiesaSah[][] tabla) {
        if (i1 == i2) {
            if (j1 > j2) {
                for (int i = 1; i < Math.abs(j1 - j2); i++)
                    if (tabla[i1][j1 - i].getNumePiesa().charAt(0) != ' ')
                        return false;
                return true;
            }

            if (j1 < j2) {
                for (int i = 1; i < Math.abs(j1 - j2); i++)
                    if (tabla[i1][j1 + i].getNumePiesa().charAt(0) != ' ')
                        return false;
                return true;
            }

        }
        if (j1 == j2) {
            if (i1 > i2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 - i][j1].getNumePiesa().charAt(0) != ' ')
                        return false;
                return true;
            }
            if (i1 < i2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 + i][j1].getNumePiesa().charAt(0) != ' ')
                        return false;
                return true;
            }

        }
        return false;

    }

    public void mutaPiesa(int x2, int y2, PiesaSah[][] tabla) {
        if (validt(x1, y1, x2, y2, tabla) == true) {
            tabla[x2][y2] = tabla[x1][y1];

            /// sterge piesa
            tabla[x1][y1] = new Nula();
            tabla[x1][y1].setNumePiesa(" ");
            tabla[x1][y1].x1 = x1;
            tabla[x1][y1].y1 = y1;
            tabla[x2][y2].setX1(x2);
            tabla[x2][y2].setY1(y2);

        }

    }
}

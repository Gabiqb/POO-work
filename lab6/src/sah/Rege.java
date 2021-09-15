package sah;

public class Rege extends PiesaSah {
    public static boolean validk(int i1, int j1, int i2, int j2, PiesaSah[][] tabla) {
        if (i1 - 1 == i2 && j1 - 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 + 1 == i2 && j1 - 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        } else if (i1 + 1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'K')
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
            if (tabla[i1][j1].getNumePiesa().charAt(0) == 'k')
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0))
                        || tabla[i2][j2].getNumePiesa().charAt(0) == ' ')
                    return true;
        }
        return false;
    }

    public void mutaPiesa(int x2, int y2, PiesaSah[][] tabla) {
        if (validk(x1, y1, x2, y2, tabla) == true) {
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

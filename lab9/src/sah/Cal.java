package sah;

public class Cal extends PiesaSah {
    public boolean validc(int i1, int j1, int i2, int j2, PiesaSah[][] tabla) {
        if (tabla[i1][j1].getNumePiesa().charAt(0) == 'C')
            if ((Math.abs(i1 - i2) == 2 && Math.abs(j1 - j2) == 1)
                    || (Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 2))
                if (!Character.isUpperCase(tabla[i2][j2].getNumePiesa().charAt(0)))
                    return true;
        if (tabla[i1][j1].getNumePiesa().charAt(0) == 'c')
            if ((Math.abs(i1 - i2) == 2 && Math.abs(j1 - j2) == 1)
                    || (Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 2))
                if (!Character.isLowerCase(tabla[i2][j2].getNumePiesa().charAt(0)))
                    return true;
        return false;
    }

    public void mutaPiesa(int x2, int y2, PiesaSah[][] tabla) {
        if (validc(x1, y1, x2, y2, tabla) == true) {
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

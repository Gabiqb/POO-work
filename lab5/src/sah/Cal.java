package sah;

public class Cal {
    public static boolean validc(int i1, int j1, int i2, int j2, Character[][] tabla) {
        if (tabla[i1][j1] == 'C')
            if ((Math.abs(i1 - i2) == 2 && Math.abs(j1 - j2) == 1)
                    || (Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 2))
                if (!Character.isUpperCase(tabla[i2][j2]))
                    return true;
        if (tabla[i1][j1] == 'c')
            if ((Math.abs(i1 - i2) == 2 && Math.abs(j1 - j2) == 1)
                    || (Math.abs(i1 - i2) == 1 && Math.abs(j1 - j2) == 2))
                if (!Character.isLowerCase(tabla[i2][j2]))
                    return true;
        return false;
    }
}

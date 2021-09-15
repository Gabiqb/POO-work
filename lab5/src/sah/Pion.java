package sah;

public class Pion {
    public static boolean validp(int i1, int j1, int i2, int j2, Character[][] tabla) {
        if (tabla[i1][j1] == 'p') {
            if (i2 == i1 + 1 && (j2 == j1 + 1 || j2 == j1 - 1))
                if (!Character.isLowerCase(tabla[i2][j2]))
                    return true;
            if (i1 == 1)
                if ((i2 == i1 + 1 && tabla[i2][j2] == ' ') || (i2 == i1 + 2 && tabla[i2][j2] == ' '))
                    return true;
                else if (i2 == i1 + 1 && tabla[i2][j2] == ' ')
                    return true;
        }
        if (tabla[i1][j1] == 'P') {
            if (i2 == i1 - 1 && (j2 == j1 + 1 || j2 == j1 - 1))
                if (!Character.isUpperCase(tabla[i2][j2]))
                    return true;
            if (i1 == 6)
                if ((i2 == i1 - 1 && tabla[i2][j2] == ' ') || (i2 == i1 - 2 && tabla[i2][j2] == ' '))
                    return true;
                else if (i2 == i1 - 1 && tabla[i2][j2] == ' ')
                    return true;
        }
        return false;
    }
}

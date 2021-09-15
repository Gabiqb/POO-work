package sah;

public class Regina {
    public static boolean validq(int i1, int j1, int i2, int j2, Character[][] tabla) {
        if (((i1 == i2 || j1 == j2) && !(i1 == i2 && j1 == j2)) || ((Math.abs(i1 - i2) == Math.abs(j1 - j2))))
            if (checkpathq(i1, j1, i2, j2, tabla)) {
                if (tabla[i1][j1] == 'Q')
                    if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                        return true;
                if (tabla[i1][j1] == 'q')
                    if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                        return true;
            }
        return false;
    }

    public static boolean checkpathq(int i1, int j1, int i2, int j2, Character[][] tabla) {
        if (i1 < i2) {
            if (j1 < j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 + i][j1 + i] != ' ')
                        return false;
                return true;
            }
            if (j1 > j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 + i][j1 - i] != ' ')
                        return false;
                return true;
            }
            if (j1 == j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 + i][j1 - i] != ' ')
                        return false;
                return true;
            }
        }
        if (i1 > i2) {
            if (j1 < j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 - i][j1 + i] != ' ')
                        return false;
                return true;
            }
            if (j1 > j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 - i][j1 - i] != ' ')
                        return false;
                return true;
            }
            if (j1 == j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 - i][j1 - i] != ' ')
                        return false;
                return true;
            }
        }
        if (i1 == i2) {
            if (j1 > j2) {
                for (int i = 1; i < Math.abs(j1 - j2); i++)
                    if (tabla[i1][j1 - i] != ' ')
                        return false;
                return true;
            }

            if (j1 < j2) {
                for (int i = 1; i < Math.abs(j1 - j2); i++)
                    if (tabla[i1][j1 + i] != ' ')
                        return false;
                return true;
            }
            if (j1 == j2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1][j1 + i] != ' ')
                        return false;
                return true;
            }

        }
        if (j1 == j2) {
            if (i1 > i2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 - i][j1] != ' ')
                        return false;
                return true;
            }
            if (i1 < i2) {
                for (int i = 1; i < Math.abs(i1 - i2); i++)
                    if (tabla[i1 + i][j1] != ' ')
                        return false;
                return true;
            }

        }
        return false;
    }
}

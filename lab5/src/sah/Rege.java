package sah;

public class Rege {
    public static boolean validk(int i1, int j1, int i2, int j2, Character[][] tabla) {
        if (i1 - 1 == i2 && j1 - 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 + 1 == i2 && j1 - 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 - 1 == i2 && j1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        } else if (i1 + 1 == i2 && j1 + 1 == j2) {
            if (tabla[i1][j1] == 'K')
                if (!Character.isUpperCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
            if (tabla[i1][j1] == 'k')
                if (!Character.isLowerCase(tabla[i2][j2]) || tabla[i2][j2] == ' ')
                    return true;
        }
        return false;
    }
}

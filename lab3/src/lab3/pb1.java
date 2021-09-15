package lab3;

//import java.lang.*;

import java.util.*;

public class pb1 {

    private static boolean testt(int a) {
        int d = 2;
        while (d <= a / 2) {
            if (a % d == 0)
                return false;
            d++;
        }

        return true;
    }

    private static boolean testc(int a) {
        if (testt(a) == true)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int m, n;
        Scanner inn = new Scanner(System.in);
        m = inn.nextInt();
        n = inn.nextInt();
        boolean ok = true;
        for (int i = m; i <= n; i++) {
            for (int d = 2; d < i; d++) {
                if (testt(d) == true)
                    if (testc(i - d) == true) {
                        ok = true;
                        d = i;
                    }
                if (d == i - 1)
                    ok = false;
            }
            if (ok == false)
                i = n + 1;

        }

        System.out.println("Conjectura pentru " + m + " si " + n + " dat este " + ok);
        inn.close();
    }

}

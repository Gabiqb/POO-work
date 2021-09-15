package lab3;

import java.util.*;

public class pb5 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Arrays.fill(arr, 0);
        boolean isr = false;
        int nr;
        for (int i = 0; i < 6; i++) {
            do {

                isr = false;
                nr = (int) (Math.random() * 49) + 1;
                for (int j = 0; j < 6; j++)
                    if (arr[j] == nr) {
                        isr = true;
                        break;
                    }
            } while (isr);
            arr[i] = nr;
        }

        System.out.println("Numerele castigatoare sunt " + Arrays.toString(arr));
    }
}

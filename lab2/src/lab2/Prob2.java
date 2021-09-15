package lab2;

import java.util.*;

public class Prob2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = Integer.MIN_VALUE;
        double b;
        Scanner inn = new Scanner(System.in);

        while (a != 0) {
            a = inn.nextInt();
            b = inn.nextDouble();
            System.out.println("Numarul intreg este " + a + "\nNumarul real este " + b);
        }
        inn.close();
    }

}

package lab2;

import java.util.*;

public class Prob4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner inn = new Scanner(System.in);
        int a;
        float b;
        while (true) {
            a = inn.nextInt();
            b = inn.nextFloat();
            if (a == 0) {
                System.out.println("Numarul intreg citit este " + a + "\nNumarul float citit este " + b);
                break;
            }
            System.out.println("Numarul intreg citit este " + a + "\nNumarul float citit este " + b);
        }
        inn.close();
    }

}

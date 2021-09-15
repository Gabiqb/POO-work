package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class pb3 {

    public static void main(String[] args) {
        String s;
        boolean[] data = new boolean[100];

        Arrays.fill(data, Boolean.FALSE);

        Scanner inn = new Scanner(System.in);

        s = inn.nextLine();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                    data[i] = true;
                    vowels++;

                } else
                    consonants++;
            }

        }
        System.out.println(
                "Numarul de consoane din sir este " + consonants + " si numarul de vocale din sir este " + vowels);
        System.out.println("Indicii corespunzatori vocalelor introduse de la linia de comanda sunt :");
        for (int i = 0; i < s.length(); i++) {
            if (data[i] == true)
                System.out.print(i + " ");
        }
        inn.close();
    }

}

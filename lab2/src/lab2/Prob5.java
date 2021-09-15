package lab2;

import java.math.*;

public class Prob5 {
    static BigInteger sumapatrate() {
        BigInteger sumaa = new BigInteger("0");
        BigInteger factor = new BigInteger("1");
        for (int i = 0; i <= 64; i++) {
            sumaa = sumaa.add(factor);
            factor = factor.multiply(BigInteger.valueOf(2));
        }
        return sumaa;
    }

    public static void main(String[] args) {
        System.out.println("Suma tabla este " + sumapatrate());
    }
}

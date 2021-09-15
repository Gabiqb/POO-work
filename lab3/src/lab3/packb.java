package lab3;

public class packb {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        byte a = 49;
        byte b = 1;
        byte c = 5;
        byte d = 7;
        int x = 0;
        x = (a << 24 | b << 16 | c << 8 | d);

        System.out.println(Integer.toBinaryString(x));
        System.out.println((byte) x + " " + (byte) (x >> 8) + " " + (byte) (x >> 16) + " " + (byte) (x >> 24));
    }

}

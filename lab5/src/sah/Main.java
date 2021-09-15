package sah;

public class Main {

    public static void main(String[] args) {
        TablaSah a = new TablaSah();
        TablaSah.setTabla(TablaSah.init());
        TablaSah.printt();

        TablaSah.getTabla()[1][1] = 'n';
        TablaSah.getTabla()[0][0] = ' ';
        boolean t = Nebun.validn(1, 1, 0, 0, TablaSah.getTabla());
        System.out.println(t);

    }
}

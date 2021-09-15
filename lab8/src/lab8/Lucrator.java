package lab8;

public class Lucrator {
    String nume;
    CalendarLucru c;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public CalendarLucru getC() {
        return c;
    }

    public void setC(CalendarLucru c) {
        this.c = c;
    }

    public void lucreaza(String zi) throws ExceptieZiNelucratoare {
        try {

            if (zi.equals("Sunday") || zi.equals("Saturday"))
                throw new ExceptieZiNelucratoare("zi nelucratoare");
            if (!zi.equals("Monday") && !zi.equals("Tuesday") && !zi.equals("Wednesday")
                    && !zi.equals("Thursday") && !zi.equals("Friday"))
                System.out.println(zi + " nu este o zi a saptamanii ");
            else
                System.out.println("Ziua este lucratoare ");
        } catch (ExceptieZiNelucratoare e) {
            System.out.println("Eroare, ziua este " + e.getMessage());

        }
    }

    @SuppressWarnings("serial")
    class ExceptieZiNelucratoare extends Exception {
        public ExceptieZiNelucratoare(String msg) {
            super(msg);
        }
    }
}

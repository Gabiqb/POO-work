package lab4;

public class Plata {

    private String data_ora;
    java.util.Date data = new java.util.Date();

    public String getData_ora() {
        return data_ora;
    }

    public void setData_ora(String data_ora) {
        this.data_ora = data_ora;
    }

    public Client plataproduse(Client c, int sumap, Magazin m) {
        if (sumap < c.getSuma_cont()) {
            c.setSuma_cont(c.getSuma_cont() - sumap);
            System.out.println(
                    "S-a platit suma de " + sumap + " lei de la clientul " + c.getNume_client() + " cu numarul de card "
                            + c.getNr_card() + " la data " + data + " " + "la magazinul " + m.getMag());
        } else
            System.out.println("Nu se poate efectua plata, fonduri insuficiente :( ");
        return c;
    }
}

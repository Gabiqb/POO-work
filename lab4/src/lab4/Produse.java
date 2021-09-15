package lab4;

public class Produse {
    private int nr_produse;
    private int sumap;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNr_produse() {
        return nr_produse;
    }

    public void setNr_produse(int nr_produse) {
        this.nr_produse = nr_produse;
    }

    public int getSumap() {
        return sumap;
    }

    public void setSumap(int sumap) {
        this.sumap = sumap;
    }

    public void aduna_comanda() {

        setTotal(getSumap() * getNr_produse());
        setNr_produse(0);
    }
}

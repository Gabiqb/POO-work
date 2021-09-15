public class Produs implements Comparable<Produs>{
    String nume;
    int cantitate;
    public Produs(String nume,int c)
    {
        this.nume=nume;
        this.cantitate=c;
    }

    @Override
    public int compareTo(Produs o) {
        if (this.cantitate < o.cantitate)
            return -1;
        else if (this.cantitate > o.cantitate)
            return 1;
        return 0;
    }
}
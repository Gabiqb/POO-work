import java.util.ArrayList;

public class Magazin implements Comparable<Magazin>{
    String nume;
    ArrayList<Produs> produse;
    public Magazin(String s)
    {
        this.nume=s;
        produse = new ArrayList<Produs>();
    }

    @Override
    public int compareTo(Magazin o) {
        if (this.produse.size() < o.produse.size())
            return 1;
        else if (this.produse.size() > o.produse.size())
            return -1;
        return 0;
    }

    public void afisareStoc(){
        System.out.println(this.nume);
        for(int i = 0; i < this.produse.size(); ++i)
            System.out.print(this.produse.get(i).nume + ":" + this.produse.get(i).cantitate + " ");
        System.out.println();
    }
}
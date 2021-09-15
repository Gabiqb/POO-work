package lab6;

class Ghiozdan extends Rechizita {
    public String getNume() {
        return this.getNume();
    }

    Rechizita[] lista = new Rechizita[100];
    int l;

    public void addc(Caiet c) {
        lista[l] = c;
        l++;
    }

    public void addm(Manual m) {
        lista[l] = m;
        l++;
    }

    public void listitems() {
        for (int i = 0; i < l; i++) {
            System.out.println(lista[i].getNume() + " ");
        }
        System.out.println();
    }

    public void listmanual() {
        System.out.println("Manualele din lista de rechizite sunt: ");
        for (int i = 0; i < l; i++) {
            if (lista[i].getClass().toString().equals("class lab6.Manual"))
                System.out.println(lista[i].getNume() + " ");
        }
        System.out.println();
    }

    public void listcaiet() {
        System.out.println("Caietele din lista de rechizite sunt: ");
        for (int i = 0; i < l; i++) {
            if (String.valueOf(lista[i].getClass()).equals("class lab6.Caiet"))
                System.out.println(lista[i].getNume() + " ");
        }
        System.out.println();

    }

    public int getNrRechizite() {
        return l;
    }

    public int getNrManuale() {
        int m = 0;
        for (int i = 0; i < l; i++)
            if (lista[i].getClass().toString() == "Manual")
                m++;
        return m;

    }

    public int getNrCaiete() {
        int c = 0;
        for (int i = 0; i < l; i++)
            if (lista[i].getClass().toString() == "Caiet")
                c++;
        return c;

    }

}

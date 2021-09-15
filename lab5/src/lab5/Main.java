package lab5;

public class Main {
    public static void main(String[] args) {
        Matrice a = new Matrice();
        Matrice.init();
        Matrice.printm(a.getMatrice());
        // aduna(a.getMatrice(), a.getMatrice());
        // printm(a.getMatrice());

        // inmscalar(a.getMatrice(), 5.0);
        // printm(a.getMatrice());

        Matrice.setMatrice(Matrice.produs(a.getMatrice(), a.getMatrice()));
        Matrice.printm(a.getMatrice());

    }
}

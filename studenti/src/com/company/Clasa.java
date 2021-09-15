package com.company;

public class Clasa implements Sortare{
    Grupa[] grupe;
    Student[] studenti;
    Clasa(int nrg,int nrs)
    {
        this.grupe=new Grupa[nrg];
        this.studenti=new Student[nrs];
    }

    @Override //trebuie scrise metodele, nu mai am timp....
    public void sortarestudmedie() {
        //sortare dupa medie, se face un for pentru fiecare student cu media( suma/nrnote) si dupa se fac swap uri
    }

    @Override
    public void afisarestud() {
        //for in lista de studenti, se afiseaza fiecare student cu nume prenume System.out.println(s.nume + " " +s.prenume);
    }

    @Override
    public void sortaregrupe() {
        //sortare grupe in ordine descrescatoare dupa nr de studenti.
        // for pentru fiecare grupa (iterator ) si swap uri in functie de nr de studenti.
    }
}

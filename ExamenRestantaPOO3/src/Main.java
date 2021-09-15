public class Main {
    public static void main(String[] args)
    {

        int grad1=3;
        Polinom p1=new Polinom(grad1);

        int grad2=3;
        Polinom p2=new Polinom(grad2);

        p1.coef[0]=new NumarComplex(1,2);
        p1.coef[1]=new NumarComplex(5,0); //real, nu are parte imaginara
        p1.coef[2]=new NumarComplex(4,0);//real, nu are parte imaginara
        p1.coef[3]=new NumarComplex(1,1);

        p2.coef[0]=new NumarComplex(1,1);
        p2.coef[1]=new NumarComplex(2,0); //real, nu are parte imaginara
        p2.coef[2]=new NumarComplex(3,0);//real, nu are parte imaginara
        p2.coef[3]=new NumarComplex(1,3);
        p1.afispolinom(p1);
        p2.afispolinom(p2);

        System.out.println("Adunare:");
        Polinom p3=p1.adunapolinom(p1,p2); //adunare
        p3.afispolinom(p3);

        System.out.println("Scadere:");
        p3=p1.scadepolinom(p1,p2); //scadere
        p3.afispolinom(p3);

        System.out.println("Inmultire:");
        p3=p1.inmultestepolinom(p1,p2); //inmultire
        p3.afispolinom(p3);


    }
}

public class Polinom implements Metode{
    Numar[] coef;
    int grad;
    public Polinom(int grad)
    {
        this.grad=grad;
        coef=new Numar[grad+1];
        for(int i=0;i<=grad;i++)
            coef[i]=new NumarComplex(0,0);
    }
    @Override
    public Polinom adunapolinom(Polinom p1, Polinom p2) {
        Polinom p3=null;

        if(p1.grad>p2.grad)
        {
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>p2.grad;i--)
                p3.coef[i]=p1.coef[i];
            for(int i=p2.grad;i>=0;i--)
            {
                p3.coef[i]=adunanr(p1.coef[i],p2.coef[i]);
            }
        }
        else if(p1.grad<p2.grad)
        {
            p3=new Polinom(p2.grad);
            for(int i=p2.grad;i>p1.grad;i--)
                p3.coef[i]=p2.coef[i];
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=adunanr(p1.coef[i],p2.coef[i]);
            }
        }
        else{
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=adunanr(p1.coef[i],p2.coef[i]);
            }
        }
        return p3;
    }

    @Override
    public Polinom scadepolinom(Polinom p1, Polinom p2) {
        Polinom p3=null;

        if(p1.grad>p2.grad)
        {
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>p2.grad;i--)
                p3.coef[i]=p1.coef[i];
            for(int i=p2.grad;i>=0;i--)
            {
                p3.coef[i]=scadenr(p1.coef[i],p2.coef[i]);
            }
        }
        else if(p1.grad<p2.grad)
        {
            p3=new Polinom(p2.grad);
            for(int i=p2.grad;i>p1.grad;i--)
                p3.coef[i]=p2.coef[i];
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=scadenr(p1.coef[i],p2.coef[i]);
            }
        }
        else{
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=scadenr(p1.coef[i],p2.coef[i]);
            }
        }
        return p3;
    }

    @Override
    public Polinom inmultestepolinom(Polinom p1, Polinom p2) {
        Polinom p3=null;

        if(p1.grad>p2.grad)
        {
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>p2.grad;i--)
                p3.coef[i]=p1.coef[i];
            for(int i=p2.grad;i>=0;i--)
            {
                p3.coef[i]=inmultestenr(p1.coef[i],p2.coef[i]);
            }
        }
        else if(p1.grad<p2.grad)
        {
            p3=new Polinom(p2.grad);
            for(int i=p2.grad;i>p1.grad;i--)
                p3.coef[i]=p2.coef[i];
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=inmultestenr(p1.coef[i],p2.coef[i]);
            }
        }
        else{
            p3=new Polinom(p1.grad);
            for(int i=p1.grad;i>=0;i--)
            {
                p3.coef[i]=inmultestenr(p1.coef[i],p2.coef[i]);
            }
        }
        return p3;
    }

    @Override
    public Numar adunanr(Numar n1, Numar n2) {
        NumarComplex n3=new NumarComplex(0,0);

            n3.i=((NumarComplex)n1).i + ((NumarComplex)n2).i;;
            n3.real=n2.real+n1.real;

        return n3;
    }

    @Override
    public Numar scadenr(Numar n1, Numar n2) {
        NumarComplex n3=new NumarComplex(0,0);
        n3.i=((NumarComplex)n1).i-((NumarComplex)n2).i;
        n3.real=n1.real-n2.real;

        return n3;
    }

    @Override
    public Numar inmultestenr(Numar n1, Numar n2) {
        NumarComplex n3=new NumarComplex(1,1);

            n3.real = n1.real*n2.real-((NumarComplex)n1).i*((NumarComplex)n2).i;
            n3.i=(n1.real*((NumarComplex)n2).i+n2.real*((NumarComplex)n1).i);

        return n3;
    }

    @Override
    public void afispolinom(Polinom p) {
        int x=1;
        System.out.print("("+p.coef[0].real + " + " +((NumarComplex)p.coef[0]).i + ")");
        for(int i=1;i<=p.grad;i++)
        {
            System.out.print(" + ("+ p.coef[i].real + " + " +((NumarComplex)p.coef[i]).i+"i)" +"x^"+x);
            x=x+1;
        }
        System.out.println();
    }
}

import java.util.ArrayList;

public class Activitate {
    int orainc;
    int orasf;
    int durata;
    String tip;
    Profesor p;
    Asistent a;
    ArrayList<Copil> copii;
    public Activitate(String t,int orainc,int orasf,Profesor p,Asistent a)
    {
        this.tip=t;
        copii=new ArrayList<Copil>();
        try {
            if(orainc<12 || orainc > 17 || orasf > 17)
                throw new ExceptieIntervalOrar();
            else {
                this.orainc = orainc;
                this.orasf = orasf;
            }
            try {

                if(orasf-orainc<1 || orasf-orainc>3)
                    throw new ExceptieDurataActivitate();
                else
                    this.durata=durata;
                this.p=p;
                this.a=a;
                System.out.println("Activitatea " + tip + " a fost creata");
            }
            catch(ExceptieDurataActivitate eq)
            {
                System.out.println(eq.getMessage());
            }

        }
        catch(ExceptieIntervalOrar ec)
        {
            System.out.println(ec.getMessage());
        }


    }
}

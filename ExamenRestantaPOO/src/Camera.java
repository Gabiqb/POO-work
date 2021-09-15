
public class Camera implements Activitati{
    int id;
    int lungime;
    int latime;
    Activitate a=null;
    public Camera(int lungime,int latime)
    {


                this.lungime = lungime;
                this.latime = latime;

    }
    @Override
    public void adaugareActivitate( Activitate a) {
        try{
             if(lungime*latime<40 && a.tip.equals("sport"))
             {
                 throw new CameraNepotrivitaPentruSport();
             }
             else
                 this.a=a;
        }
        catch(CameraNepotrivitaPentruSport exc)
        {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void determinareActivitate(Scoala s, Copil c) { //nr de activitati ale unui copil
        int nrac=0;
        for(int i=0;i<s.m;i++)
        {
            for(int j=0;j<s.n;j++)
                if(s.camere[i][j].a != null)
                    if(s.camere[i][j].a.copii.contains(c))
                         nrac++;
        }
        System.out.println("Copilul " + c.nume + " "+ c.prenume + " participa la " + nrac +" activitat/i/e");
    }

    @Override
    public void planificare() {

    }

    @Override
    public void afisaredate() {
        System.out.println("Camera "+ this.id+ " are ca profesor pe "+ a.p.nume+ " "+a.p.prenume+ " si asitent pe " + a.a.nume+ " " +a.a.prenume);
        System.out.println("Copii care participa la activitatea " + a.tip+ " din camera curenta sunt:");
        for(int i=0;i<a.copii.size();i++)
        {
            System.out.println(a.copii.get(i).nume + " " +a.copii.get(i).prenume);
        }
    }

}

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
        {
            int iduri[]=new int[160];
            Arrays.fill(iduri,0);
            Profesor p1=new Profesor("Popescu","Ion","profesor");
            Profesor p2=new Profesor("Pop","Doru","profesor");
            Profesor p6=new Profesor("Lates","Ioana","profesor");
            Asistent p7=new Asistent("Mircovici","Andreea","asistent");
            Asistent p3=new Asistent("Iarca","Alin","asistent");
            Asistent p5=new Asistent("Ivanov","Alex","asistent");
            Copil c1=new Copil("Ionescu","Andrei","elev");
            Copil c2=new Copil("Motrescu","Lavinia","elev");
            Copil c3=new Copil("Marcu","Sofia","elev");

            Activitate a1=new Activitate("sport",12,14,p1,p3); //activitatea sport cu profesor si asistent
            Activitate a2=new Activitate("muzica",16,18,p2,p5); //ora incorecta
            Activitate a3=new Activitate("volei",12,17,p6,p7); //durata incorecta

            Camera cam1=new Camera(10,4);
            int id=(int)(Math.random()*150)+1; //generare id unic
            while(iduri[id]!=0)
            {
                id=(int)(Math.random()*150)+1; //generare id unic
            }
            cam1.id=id; //atribuire id la camera
            cam1.adaugareActivitate(a1); //adauga activitatea in sala de clasa

            //a1 este valida deci adaugam la a1
            a1.copii.add(c1);
            a1.copii.add(c2);
            a1.copii.add(c3);
            System.out.println("Copii de la activitatea " + a1.tip + " sunt: ");
            for(int i=0;i<a1.copii.size();i++)
            {
                System.out.println(a1.copii.get(i).nume+ " "+a1.copii.get(i).prenume+ " ");
            }
            System.out.println();

            Scoala s=new Scoala(4,5);
            s.camere[0][0]=cam1;
            cam1.determinareActivitate(s,c1); //determina activitatile copilului c1
            cam1.afisaredate();


    }
}


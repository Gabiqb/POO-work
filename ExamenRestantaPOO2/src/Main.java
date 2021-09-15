import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LantMagazine l = new LantMagazine();
        Magazin m = null;
        Produs p;
        String mnume=null;
        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            String sir = null;
            String[] produs = null;
            int pcant = 0;
            if (s.hasNextLine()) {
                m = new Magazin(s.nextLine());
            }
            while (s.hasNextLine()) {
                boolean tr = false;
                for (int i = 0; i < l.magazine.size(); i++)
                    if (l.magazine.get(i).nume.equals(m.nume)) {
                        tr = true;
                        break;
                    }
                if (tr == false)
                    l.magazine.add(m);
                mnume=m.nume;
                sir = s.nextLine();
                produs = sir.split(":");
                while (produs.length > 1 && s.hasNextLine()) {
                    p = new Produs(produs[0], Integer.parseInt(produs[1]));
                    boolean ok = false;
                    int t = 0;
                    pcant = Integer.parseInt(produs[1]);
                    tr = false;
                    int mag=0;
                    for (int i = 0; i < l.magazine.size(); i++) {
                        if(l.magazine.get(i).nume.equals(mnume))
                            mag=i;
                        for (int j = 0; j < l.magazine.get(i).produse.size(); j++)
                            if (l.magazine.get(i).produse.get(j).nume.equals(produs[0]) && l.magazine.get(i).nume.equals(mnume)) {
                                tr = true;
                                mag = i;
                                break;
                            }
                    }
                    if(tr==false)
                        l.magazine.get(mag).produse.add(p);
                    else
                        for (int i = 0; i < l.magazine.size(); i++)
                            for(int j=0;j<l.magazine.get(i).produse.size();j++)
                                if (l.magazine.get(i).produse.get(j).nume.equals(produs[0]) && l.magazine.get(i).nume.equals(mnume)) {
                                    l.magazine.get(i).produse.get(j).cantitate+=pcant;
                                    break;
                                }
                    sir = s.nextLine();
                    produs = sir.split(":");
                }
                if (produs.length == 1)
                    m = new Magazin(sir);
                if(!s.hasNextLine())
                {
                    p = new Produs(produs[0], Integer.parseInt(produs[1]));
                    boolean ok = false;
                    int t = 0;
                    pcant = Integer.parseInt(produs[1]);
                    tr = false;
                    int mag=0;
                    for (int i = 0; i < l.magazine.size(); i++) {
                        if(l.magazine.get(i).nume.equals(mnume))
                            mag=i;
                        for (int j = 0; j < l.magazine.get(i).produse.size(); j++)
                            if (l.magazine.get(i).produse.get(j).nume.equals(produs[0]) && l.magazine.get(i).nume.equals(mnume)) {
                                tr = true;
                                mag = i;
                                break;
                            }
                    }

                    if(tr==false)
                        l.magazine.get(mag).produse.add(p);
                    else
                        for (int i = 0; i < l.magazine.size(); i++)
                            for(int j=0;j<l.magazine.get(i).produse.size();j++)
                                if (l.magazine.get(i).produse.get(j).nume.equals(produs[0]) && l.magazine.get(i).nume.equals(mnume)) {
                                    l.magazine.get(i).produse.get(j).cantitate+=pcant;
                                    break;
                                }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < l.magazine.size(); i++)
            l.magazine.get(i).afisareStoc();
            Collections.sort(l.magazine);
        for(int i=0;i<l.magazine.size();i++)
            l.magazine.get(i).afisareStoc();
        for(int i=0;i<l.magazine.size();i++)
            Collections.sort(l.magazine.get(i).produse);
        for(int i=0;i<l.magazine.size();i++)
            l.magazine.get(i).afisareStoc();



    }
}
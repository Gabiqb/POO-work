package lab9_2;

public class TestCaine {
   public static void main(String[] args)
   {
	   Caine c=new Caine("Sasha","Bichon");
	   Caine c1=new Caine("Rex","Pitbull");
	   Caine c2=new Caine("Tuck","Corgi");
	   
	   c.adaugacaine(c1);
	   System.out.println();
	   c.adaugacaine(c2);
	   System.out.println();
	   c.adaugacaine(c);
	   System.out.println();
	   c.afiseazacaini();
	   System.out.println();
	   c.elibereaza(c);
	   System.out.println(); 
	   c.afiseazacaini();
   }
}

package lab9_2;

public class Main {
    public static void main(String[] args)
    {
    	FacebookAccount a=new FacebookAccount("Ionescu","Andrei",25,"Romania");
    	FacebookAccount a1=new FacebookAccount("Jimmy","Choo",26,"USA");
    	FacebookAccount a2=new FacebookAccount("Carlos","Vives",35,"Mexico");
    	FacebookAccount a3=new FacebookAccount("Rio","De la Vega",28,"USA");
    	
    	a.addprieteni(a1);
    	a.addprieteni(a2);
    	a.addprieteni(a3);
    	
    	
    	a.cautaprieteni("USA");
    	
    	a.stergeprieteni(a3);
    	System.out.println();
    	a.cautaprieteni("USA");
    }
}

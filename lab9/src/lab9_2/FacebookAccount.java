package lab9_2;

import java.util.*;

public class FacebookAccount {
    private String nume;
     private String prenume;
     private int varsta;
     private String adresa;
     private Set<FacebookAccount> prieteni = new HashSet<FacebookAccount>();
     public FacebookAccount(String nume,String prenume, int varsta,String adresa)
     {
    	 this.nume=nume;
    	 this.prenume=prenume;
    	 this.varsta=varsta;
    	 this.adresa=adresa;
     }
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set<FacebookAccount> getPrieteni() {
		return prieteni;
	}
	public void setPrieteni(HashSet<FacebookAccount> prieteni) {
		this.prieteni = prieteni;
	}

	public void addprieteni(FacebookAccount a1)
	{
		this.prieteni.add(a1);
		a1.prieteni.add(this);
	}
	public void stergeprieteni(FacebookAccount a1)
	{
		if(getPrieteni().contains(a1));
			this.prieteni.remove(a1);
	}
	public void cautaprieteni(String adresa)
	{
		System.out.println("Prietenii care se afla la adresa " + adresa +" sunt:");
		for(FacebookAccount it:prieteni)
		{
			if(it.adresa.equals(adresa))
			    System.out.print(it.getNume() + " " + it.getPrenume() + "\n");
			
		}
	}
}

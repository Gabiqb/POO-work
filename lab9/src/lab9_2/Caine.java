package lab9_2;

import java.time.LocalDateTime;

public class Caine extends PetHotel{

	public Caine(String nume,String rasa)
	{
		this.nume=nume;
		this.rasa=rasa;
	}
	public void afiseazacaini() {
		System.out.println("Animalele cazate la hotel sunt: ");
		for(PetHotel it:animale)
		{
			if(it instanceof Caine)
				System.out.println(it.getNume() + " " + it.getRasa());
		}
	}
	
	public void adaugacaine(Caine c)
	{
	   System.out.println("Cainele " + c.getNume() + " "+ c.getRasa() + " a fost cazat la data " + LocalDateTime.now());
	   this.animale.add(c);
	}
	public void elibereaza(Caine c)
	{
		if(this.animale.contains(c))
		 {
			System.out.println("Cainele " + c.getNume() + " "+ c.getRasa() + " a plecat la data " + LocalDateTime.now());
			this.animale.remove(c);
		 }
		else
			System.out.println("Nu este cazat ");
	}
	
}

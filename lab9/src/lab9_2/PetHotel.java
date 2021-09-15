package lab9_2;
import java.util.*;
abstract class PetHotel {
     String nume;
     String rasa;
     List <PetHotel> animale=new ArrayList<PetHotel>();
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getRasa() {
		return rasa;
	}
	public void setRasa(String rasa) {
		this.rasa = rasa;
	}
	
	
}

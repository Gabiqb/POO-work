package lab8;

public class Zi {
	String nume;
	boolean estelucratoare;

	public Zi(String n, boolean is)
		{
			this.nume = n;
			this.estelucratoare = is;
		}

	public String getNume()
		{
			return nume;
		}

	public void setNume(String nume)
		{
			this.nume = nume;
		}

	public boolean getEstelucratoare()
		{
			return estelucratoare;
		}

	public void setEstelucratoare(boolean estelucratoare)
		{
			this.estelucratoare = estelucratoare;
		}

}

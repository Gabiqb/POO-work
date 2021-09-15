package labb8;

public class Main5 {

	String[] a = new String[2];

	public void afisare() throws StringIndexOut
		{
			try
				{
					for (int i = 0; i <= a.length; i++)
						{
							if (i == a.length)
								throw new StringIndexOut("nu se poate accesa al " + i + " lea string ");
							System.out.println(a[i]);
						}
				}
			catch (StringIndexOut e)
				{
					System.out.println(e.getMessage());
				}
		}

	@SuppressWarnings("serial")
	public class StringIndexOut extends Exception {
		public StringIndexOut(String s)
			{
				super(s);
			}

	}

	public static void main(String[] args) throws StringIndexOut
		{
			Main5 a = new Main5();
			a.a[0] = "Str1";
			a.a[1] = "Str2";
			a.afisare();
		}
}

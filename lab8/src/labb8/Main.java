package labb8;

public class Main {

	public void trynullptr(String n) throws NullPointerException
		{
			try
				{
					if (n == null)
						throw new NullPointerException("referinta este nullptr");
					else
						System.out.println(n);
				}
			catch (NullPointerException e)
				{
					System.out.println(e.getMessage());
				}
		}

	@SuppressWarnings("serial")
	class NullPointerException extends Exception {
		public NullPointerException(String msj)
			{
				super(msj);
			}
	}

	public static void main(String[] args) throws NullPointerException
		{
			String nume = null;
			Main m = new Main();
			m.trynullptr(nume);

			nume = "Marcel";
			m.trynullptr(nume);
		}
}

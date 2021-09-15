package labb8;

public class Main2 {

	public void tryarray(int[] a) throws ArrayIndexOutOfBoundsException
		{
			try
				{
					for (int i = 0; i <= a.length; i++)
						{
							System.out.print(a[i] + " ");
						}
				}
			catch (Exception e)
				{
					System.out.println(e.getMessage());
				}

		}

	public void throwexc() throws Exception
		{
			try
				{
					int a = 1;
					System.out.println(a / 0);
					// throw new Exception("invalid division");
				}
			catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			finally
				{
					System.out.println("finalul blocului try ");
				}
		}

	public static void main(String[] args) throws Exception
		{
			Main2 m2 = new Main2();
			int[] a = new int[5];
			a[0] = 1;
			a[1] = 2;
			a[2] = 3;
			a[3] = 6;
			a[4] = 8;

			m2.tryarray(a);
			m2.throwexc();
		}
}

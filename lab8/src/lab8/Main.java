package lab8;

import lab8.Lucrator.ExceptieZiNelucratoare;

public class Main {
	public static void main(String[] args) throws ExceptieZiNelucratoare
		{
			Lucrator l1 = new Lucrator();
			l1.setNume("Dorel");
			CalendarLucru c1 = new CalendarLucru();
			l1.setC(c1);

			l1.lucreaza("Monday");
			l1.lucreaza("Sunday");
		}
}

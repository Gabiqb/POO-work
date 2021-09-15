package lab8;

public class CalendarLucru {
	Zi[] a = new Zi[7];

	public CalendarLucru()
		{
			for (int i = 0; i < 7; i++)
				this.a[i] = new Zi("", false);
			this.a[5].setEstelucratoare(false);
			this.a[5].setNume("Saturday");
			this.a[6].setEstelucratoare(false);
			this.a[6].setNume("Sunday");
			for (int i = 0; i < 5; i++)
				this.a[i].setEstelucratoare(true);

			this.a[0].setNume("Monday");
			this.a[1].setNume("Tuesday");
			this.a[2].setNume("Wednesday");
			this.a[3].setNume("Thursday");
			this.a[4].setNume("Friday");
		}

}

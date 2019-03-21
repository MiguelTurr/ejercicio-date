package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date dia1, dia2;
		try {
			dia1 = new Date(10, 3, 2017);
			dia2 = new Date(10, 11, 2017);

			System.out.println(dia1.IsSameDate(dia2));
			System.out.println(dia1.getMonthSeason());
			System.out.println(dia2.getMonthSeason());
			System.out.println(dia1.getSameDaysMonth());
			System.out.println(dia2.getSameDaysMonth());
			System.out.println(dia1.getMonthEndYear());
			System.out.println(dia2.getMonthEndYear());
			System.out.println(dia1.getDaysEndMonth());
			System.out.println(dia2.getDaysEndMonth());
			System.out.println(dia1.getDaysSinceStartYear());
			System.out.println(dia2.getDaysSinceStartYear());

		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

		Date today;

		try {
			today = new Date(99, 14, 2017);
			System.out.println(today.toString());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}

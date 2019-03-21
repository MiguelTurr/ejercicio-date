package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date dia1, dia2;
		try {
			dia1 = new Date(10, 3, 2017);

			System.out.println(dia1);
			System.out.println("Estacion: "+dia1.getMonthSeason());		
			System.out.println(dia1.getSameDaysMonth());
			System.out.println(dia1.getMonthEndYear());
			System.out.println(dia1.getDaysEndMonth());
			System.out.println("Días desde el inicio del año: "+dia1.getDaysSinceStartYear());
			System.out.println("Semana del año: "+dia1.getWeekDate());
			System.out.println("Intentos (while): "+dia1.GenerateRandomDateWhile());
			System.out.println("Intentos (do-while): "+dia1.GenerateRandomDateDoWhile());

			dia2 = new Date(10, 11, 2017);

			System.out.println("\n\n");
			System.out.println(dia2);
			System.out.println("Estacion: "+dia2.getMonthSeason());		
			System.out.println(dia2.getSameDaysMonth());
			System.out.println(dia2.getMonthEndYear());
			System.out.println(dia2.getDaysEndMonth());
			System.out.println("Días desde el inicio del año: "+dia2.getDaysSinceStartYear());
			System.out.println("Semana del año: "+dia2.getWeekDate());
			System.out.println("Intentos (while): "+dia2.GenerateRandomDateWhile());
			System.out.println("Intentos (do-while): "+dia2.GenerateRandomDateDoWhile());

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

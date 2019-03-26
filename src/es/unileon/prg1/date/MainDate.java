package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {

		/*Date dia1, dia2;
		try {
			dia1 = new Date(31, 12, 2017);

			System.out.println(dia1);
			System.out.println("Estacion: "+dia1.getSeasonName());		
			System.out.println(dia1.getSameDaysMonth());
			System.out.println(dia1.getMonthEndYear());
			System.out.println(dia1.getDaysEndMonth());
			System.out.println("Días desde el inicio del año: "+dia1.getDaysSinceStartYear());
			System.out.println("Día de la semana: "+dia1.dayOfWeek(1));
			System.out.println("Intentos (while): "+dia1.GenerateRandomDateWhile());
			System.out.println("Intentos (do-while): "+dia1.GenerateRandomDateDoWhile());

			dia2 = new Date(10, 11, 2017);

			System.out.println("\n\n");
			System.out.println(dia2);
			System.out.println("Estacion: "+dia2.getSeasonName());		
			System.out.println(dia2.getSameDaysMonth());
			System.out.println(dia2.getMonthEndYear());
			System.out.println(dia2.getDaysEndMonth());
			System.out.println("Días desde el inicio del año: "+dia2.getDaysSinceStartYear());
			System.out.println("Día de la semana: "+dia2.dayOfWeek(1));
			System.out.println("Intentos (while): "+dia2.GenerateRandomDateWhile());
			System.out.println("Intentos (do-while): "+dia2.GenerateRandomDateDoWhile());
			
			Date dia3 = dia1.tomorrow();
			System.out.println(dia3);

		} catch (DateException e) {
			System.out.println(e.getMessage());
		}*/

		Date today;

		try {
			today = new Date(99, 14, 2017);
			System.out.println(today.toString());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}

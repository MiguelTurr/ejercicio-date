package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}

		//TODO falta comprobar el dia

		if(isValidDay(month, day) == false) {
			throw new DateException("Día " + day + " no valido" +
					" ese mes no puede tener esos días.");

		} else {
			this.day = day;
		}
	}

	// Metodo que devuelve el año del objeto
	public int getYear() {
		return this.year;
	}	

	// Metodo que devuelve el mes del objeto
	public int getMonth() {
		return this.month;
	}

	// Metodo que devuelve el día del objeto
	public int getDay() {
		return this.day;
	}

	// Metodo que compara si dos años son iguales
	public boolean IsSameYear(Date anotherYear) {
		return (this.year == anotherYear.getYear());
	}

	// Metodo que compara si dos meses son iguales
	public boolean IsSameMonth(Date anotherMonth) {
		return (this.month == anotherMonth.getMonth());
	}

	// Metodo que compara si dos días son iguales
	public boolean IsSameDay(Date anotherDay) {
		return (this.day == anotherDay.getDay());
	}
	
	// Metodo que compara dos objetos date
	public boolean IsSameDate(Date anotherDate) {
		return (IsSameYear(anotherDate) && IsSameMonth(anotherDate) && IsSameDay(anotherDate));
	}

	// Metodo que indica si un dia es válido o no
	private boolean isValidDay(int anotherMonth, int anotherDay) {
		boolean validDay = true;

		if(anotherDay <= 0 || anotherDay > getDaysMonth(anotherMonth)) {
			validDay = false;
		}

		/*switch(anotherMonth)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: {

				if(anotherDay <= 0 || anotherDay > 31) {
					validDay = false;
				}
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11: {

				if(anotherDay <= 0 || anotherDay > 30) {
					validDay = false;
				}
				break;
			}
			case 2: {

				if((anotherDay % 4) == 0) {
					if(anotherDay <= 0 || anotherDay > 29) {
						validDay = false;
					}
				} else {
					if(anotherDay <= 0 || anotherDay > 28) {
						validDay = false;
					}
				}
				break;
			}
			default: {

				validDay = false;
			}
		}*/
		return validDay;
	}

	// Metodo que devuelve la estación de un mes
	public String getMonthSeason() {

		String season = "";
		switch(getMonth())
		{
			case 3:
			case 4:
 			case 5: {
				season = "Primavera";
				break;
			}
			case 6:
			case 7:
 			case 8: {
				season = "Verano";
				break;
			}
			case 9:
			case 10:
 			case 11: {
				season = "Otoño";
				break;
			}
			case 12:
			case 1:
 			case 2: {
				season = "Invierno";
				break;
			}
	
		}
		return season;
	}

	// Metodo que devuelve el nombre de un mes
	private String getMonthName(int anotherMonth) {

		String name = "";
		switch(anotherMonth)
		{
			case 1: {
				name = "Enero";
				break;
			}
			case 2: {
				name = "Febrero";
				break;
			}
			case 3: {
				name = "Marzo";
				break;
			}
			case 4: {
				name = "Abril";
				break;
			}
			case 5: {
				name = "Mayo";
				break;
			}
			case 6: {
				name = "Junio";
				break;
			}
			case 7: {
				name = "Julio";
				break;
			}
			case 8: {
				name = "Agosto";
				break;
			}
			case 9: {
				name = "Septiembre";
				break;
			}
			case 10: {
				name = "Octubre";
				break;
			}
			case 11: {
				name = "Noviembre";
				break;
			}
			case 12: {
				name = "Diciembre";
				break;
			}
		}
		return name;
	}

	// Metodo que devuelve el número de días que tiene un mes
	private int getDaysMonth(int anotherMonth) {

		int days = 0;

		switch(anotherMonth)
		{	
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: {

				days = 31;
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11: {

				days = 30;
				break;
			}
			case 2: {

				days = 28;
				break;
			}
		}
		return days;
	}
	
	// Metodo que devuelve los meses que tienen el mismo número de días
	public String getSameDaysMonth() {

		StringBuilder output = new StringBuilder();
		int daysMonth = getDaysMonth(this.month);

		output.append("Meses que tienen los mismos días que ");
		output.append(getMonthName(this.month));
		output.append(" (" +daysMonth+ ")");
		output.append(":\n");

		for(int i = 1; i <= 12; i++)
		{
			if(this.month != i)
			{
				if(daysMonth == getDaysMonth(i)) {
					output.append(getMonthName(i));
					output.append(" ");
				}
			}
		}

		return output.toString();
	}

	// Metodo que devuelve los meses que quedan para acabar el año
	public String getMonthEndYear() {
	
		StringBuilder output = new StringBuilder();

		output.append("Meses para acabar el año desde ");
		output.append(getMonthName(this.month));
		output.append(":\n");

		for(int i = this.month + 1; i <= 12; i++) {
			output.append(getMonthName(i));
			output.append(" ");
		}

		return output.toString();
	}

	// Metodo que devuelve los días que quedan para acabar el mes
	public String getDaysEndMonth() {
	
		StringBuilder output = new StringBuilder();

		output.append("Días para acabar el mes desde el día ");
		output.append(this.day);
		output.append(":\n");

		for(int i = this.day; i <= getDaysMonth(this.month); i++) {
			output.append(i);
			output.append(" ");
		}

		return output.toString();
	}

	// Metodo que cuenta el número de días desde el inicio del año hasta la fecha
	public int getDaysSinceStartYear() {
		int numberDays = this.day;
		
		for(int i = 0; i < this.month; i++) {

			numberDays += getDaysMonth(this.month);
		}
		return numberDays;
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

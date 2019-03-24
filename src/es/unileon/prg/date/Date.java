package es.unileon.prg.date;

import java.util.Random;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		this.setMonth(month);
		this.setDay(day);
	}

	// Metodo que asigna un valor a month si el mes es válido
	private void setMonth(int month) throws DateException{

		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" (valores posibles entre 1 y 12)");
		} else {
			this.month = month;
		}
	}

	// Metodo que asigna un valor a day si el día es válido
	private void setDay(int day) throws DateException{

		if(isValidDay(month, day) == false) {
			throw new DateException("Día " + day + " no valido" +
					" (el mes "+getMonthName(month)+" debe tener entre 0 y "+getMonthDays(month)+" días)");

		} else {
			this.day = day;
		}
	}

	// Metodo que devuelve el año del objeto
	private int getYear() {
		return this.year;
	}	

	// Metodo que devuelve el mes del objeto
	private int getMonth() {
		return this.month;
	}

	// Metodo que devuelve el día del objeto
	private int getDay() {
		return this.day;
	}
	
	/**
		* IsSameYear(Date anotherYear)
 		* Metodo que compara si dos años son iguales

 	*/
	public boolean IsSameYear(Date anotherYear) {
		return (this.year == anotherYear.getYear());
	}
	
	/**
		* IsSameMonth(Date anotherYear)
 		* Metodo que compara si dos meses son iguales

 	*/
	
	public boolean IsSameMonth(Date anotherMonth) {
		return (this.month == anotherMonth.getMonth());
	}
	
	/**
		* IsSameDay(Date anotherYear)
 		* Metodo que compara si dos días son iguales

 	*/

	public boolean IsSameDay(Date anotherDay) {
		return (this.day == anotherDay.getDay());
	}
	
	/**
		* IsSameDate(Date anotherDate)
 		* Metodo que compara dos objetos date

 	*/
	
	public boolean IsSameDate(Date anotherDate) {
		return (IsSameYear(anotherDate) && IsSameMonth(anotherDate) && IsSameDay(anotherDate));
	}

	// Metodo que indica si un dia es válido o no
	private boolean isValidDay(int anotherMonth, int anotherDay) {
		boolean validDay = true;

		if(anotherDay <= 0 || anotherDay > getMonthDays(anotherMonth)) {
			validDay = false;
		}
		return validDay;
	}

	/**
		* getMonthSeason()
 		* Metodo que devuelve la estación de un mes

 	*/
	
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
	private int getMonthDays(int anotherMonth) {

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
	
	/**
		* getSameDaysMonth()
 		* Metodo que devuelve los meses que tienen el mismo número de días

 	*/
	
	public String getSameDaysMonth() {

		StringBuilder output = new StringBuilder();
		int daysMonth = getMonthDays(this.month);

		output.append("Meses que tienen los mismos días que ");
		output.append(getMonthName(this.month));
		output.append(" (" +daysMonth+ ")");
		output.append(":\n");

		for(int i = 1; i <= 12; i++)
		{
			if(this.month != i)
			{
				if(daysMonth == getMonthDays(i)) {
					output.append(getMonthName(i));
					output.append(" ");
				}
			}
		}

		return output.toString();
	}

	/**
		* getMonthEndYear()
 		* Metodo que devuelve los meses que quedan para acabar el año desde una fecha concreta

 	*/
	
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

	/**
		* getDaysEndMonth()
 		* Metodo que devuelve los días que quedan para acabar el mes desde una fecha concreta

 	*/
	
	public String getDaysEndMonth() {
	
		StringBuilder output = new StringBuilder();

		output.append("Días para acabar el mes desde el día ");
		output.append(this.day);
		output.append(":\n");

		for(int i = this.day; i <= getMonthDays(this.month); i++) {
			output.append(i);
			output.append(" ");
		}

		return output.toString();
	}

	/**
		* getDaysSinceStartYear()
 		* Metodo que cuenta el número de días desde el inicio del año hasta la fecha

 	*/
	
	public int getDaysSinceStartYear() {
		int numberDays = this.day;
		
		for(int i = 0; i < this.month; i++) {

			numberDays += getMonthDays(this.month);
		}
		return numberDays;
	}

	/**
		* GenerateRandomDateWhile()
 		* Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (while)

 	*/
	
	public int GenerateRandomDateWhile() {
		int intentos = 0, day, month;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		while(end == false) {
				
			day = generador.nextInt(31) + 1;
			month = generador.nextInt(12) + 1;

			try {
				fecha = new Date(day, month, this.year);

				if(IsSameDate(fecha) == false) {
					intentos ++;
				} else {
					end = true;
				}
			} catch (DateException e) {
				intentos ++;
			}
		}

		return intentos;
	}

	/**
		* GenerateRandomDateDoWhile()
 		* Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (do while)

 	*/
	
	public int GenerateRandomDateDoWhile() {
		int intentos = 0, day, month;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		do {
				
			day = generador.nextInt(31) + 1;
			month = generador.nextInt(12) + 1;

			try {
				fecha = new Date(day, month, this.year);

				if(IsSameDate(fecha) == false) {
					intentos ++;
				} else {
					end = true;
				}
			} catch (DateException e) {
				intentos ++;
			}
		} while(end == false);

		return intentos;
	}


	/**
		* getWeekDate()
 		* Método que devuelve la semana que estás según una fecha concreta

 	*/
	
	public int getWeekDate() {
		return (int) getDaysSinceStartYear() / 7;
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

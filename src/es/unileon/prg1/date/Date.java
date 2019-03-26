package es.unileon.prg1.date;

import java.util.Random;

/**
 * Esta clase define objetos que contienen una fecha
 * @author: Miguel Turrión Gutiérrez
 * @version: 25/03/2019
 */

public class Date {

	private int day;
	private int month;
	private int year;

	Date() {
		this.year = 2017;
		this.month = 1;
		this.day = 1;
	}
	
	Date(Date today) {
		this.year = today.getYear();
		this.month = today.getMonth();
		this.day = today.getDay();
	}
	
	Date(int day, int month, int year) throws DateException{
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}

	/**
	*	setMonth(int month)
	*	Metodo que asigna un valor a month si el mes es válido
	*	@param month El parámetro month es el mes que se le asigna
	*/

	public void setMonth(int month) throws DateException{

		if ((month < 1) || (month > 12)) {
			throw new DateException("Mes " + month + " no valido" +
					" (valores posibles entre 1 y 12)");
		} else {
			this.month = month;
		}
	}

	/**
	*	setDay(int day)
	*	Metodo que asigna un valor a day si el día es válido
	*	@param day El parámetro day es el día que se le asigna
	*/

	public void setDay(int day) throws DateException{

		if(isValidDay(this.month, day) == false) {
			throw new DateException("Día " + day + " no valido" +
					" (el mes "+this.getMonthName()+" debe tener entre 0 y "+this.daysOfMonth()+" días)");

		} else {
			this.day = day;
		}
	}

	/**
	*	setYear(int year)
	*	Metodo que asigna un valor a year si el año es válido
	*	@param year El parámetro year es el año que se le asigna
	*/

	public void setYear(int year) throws DateException{
		
		if(year < 0) {
			throw new DateException("Año " + year + " no valido" +
					" (los años no deben ser menor a 0)");
		} else {
			this.year = year;
		}
	}
	
	/**
	*	getYear()
	*	Metodo que devuelve el año del objeto
	*	@return Devuelve el año del objeto de la clase Date
	*/

	public int getYear() {
		return this.year;
	}	

	/**
	*	getMonth()
	*	Metodo que devuelve el mes del objeto
	*	@return Devuelve el mes del objeto de la clase Date
	*/

	public int getMonth() {
		return this.month;
	}
	
	/**
	*	getDay()
	*	Metodo que devuelve el día del objeto
	*	@return Devuelve el día del objeto de la clase Date
	*/

	public int getDay() {
		return this.day;
	}
	
	/**
	* 	IsSameYear(Date anotherYear)
 	* 	Metodo que compara si dos años son iguales
	*	@param anotherYear El parámetro anotherYear es un objeto de la clase Date
	*	@return Si ambos años coinciden o no
 	*/
	public boolean isSameYear(Date anotherYear) {
		return (this.year == anotherYear.getYear());
	}
	
	/**
	* 	IsSameMonth(Date anotherYear)
 	* 	Metodo que compara si dos meses son iguales
	*	@param anotherMonth El parámetro anotherMonth es un objeto de la clase Date
	*	@return Si ambos meses coinciden o no
 	*/
	
	public boolean isSameMonth(Date anotherMonth) {
		return (this.month == anotherMonth.getMonth());
	}
	
	/**
	* 	IsSameDay(Date anotherYear)
 	* 	Metodo que compara si dos días son iguales
	*	@param anotherDay El parámetro anotherDayanotherDay es un objeto de la clase Date
	*	@return Si ambos días coinciden o no
 	*/

	public boolean isSameDay(Date anotherDay) {
		return (this.day == anotherDay.getDay());
	}
	
	/**
	* 	IsSameDate(Date anotherDate)
 	* 	Metodo que compara dos objetos date
	*	@param anotherDate El parámetro anotherDate es un objeto de la clase Date
	*	@return Si ambas fechas coinciden
 	*/
	
	public boolean isSame(Date anotherDate) {
		return (isSameYear(anotherDate) && isSameMonth(anotherDate) && isSameDay(anotherDate));
	}

	// Metodo que indica si un dia es válido o no
	private boolean isValidDay(int anotherMonth, int anotherDay) {
		boolean validDay = true;

		if(anotherDay <= 0 || anotherDay > this.daysOfMonth()) {
			validDay = false;
		}
		return validDay;
	}

	/**
	* 	getMonthSeason()
 	* 	Metodo que devuelve la estación de un mes
	*	@return El nombre de la estación del año	
 	*/
	
	public String getSeasonName() {

		String season = "";
		switch(this.getMonth())
		{
			case 3:
			case 4:
 			case 5: {
				season = "Spring";
				break;
			}
			case 6:
			case 7:
 			case 8: {
				season = "Summer";
				break;
			}
			case 9:
			case 10:
 			case 11: {
				season = "Autumn";
				break;
			}
			case 12:
			case 1:
 			case 2: {
				season = "Winter";
				break;
			}
	
		}
		return season;
	}


	/**
	* 	getMonthName()
 	* 	Metodo que devuelve el nombre de un mes
	*	@return El nombre del mes	
 	*/

	public String getMonthName() {

		String name = "";
		switch(this.getMonth())
		{
			case 1: {
				name = "January";
				break;
			}
			case 2: {
				name = "February";
				break;
			}
			case 3: {
				name = "March";
				break;
			}
			case 4: {
				name = "April";
				break;
			}
			case 5: {
				name = "May";
				break;
			}
			case 6: {
				name = "June";
				break;
			}
			case 7: {
				name = "July";
				break;
			}
			case 8: {
				name = "August";
				break;
			}
			case 9: {
				name = "September";
				break;
			}
			case 10: {
				name = "October";
				break;
			}
			case 11: {
				name = "November";
				break;
			}
			case 12: {
				name = "December";
				break;
			}
		}
		return name;
	}
	
	/**
	* 	daysOfMonth()
 	* 	Metodo que devuelve el número de días que tiene un mes
	*	@return Devuelve el número de días que tiene un mes
 	*/

	public int daysOfMonth() {

		int days = 0;

		switch(this.month)
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
	* 	getMonthsSameDays()
 	* 	Metodo que devuelve los meses que tienen el mismo número de días
	*	@return Devuelve el nombre de los meses que tengan el mismo número de días
 	*/
	
	public String getMonthsSameDays() {

		StringBuilder output = new StringBuilder();
		int daysMonth = this.daysOfMonth();

		Date fecha;

		try {
			fecha = new Date(1, 1, 1990);

			for(int i = 1; i <= 12; i++)
			{
				fecha.setMonth(i);
				if(daysMonth == fecha.daysOfMonth()) {
						output.append(fecha.getMonthName());
					output.append(" ");
				}
			}
		} catch (DateException e) {
		}

		return output.toString();
	}

	/**
	* 	getMonthsLeft()
 	* 	Metodo que devuelve los meses que quedan para acabar el año desde una fecha concreta
	*	@return Devuelve el nombre de los meses que quedan para acabar el año
 	*/
	
	public String getMonthsLeft() {
	
		StringBuilder output = new StringBuilder();

		Date fecha;

		try {
			fecha = new Date(1, 1, 1990);

			for(int i = this.month + 1; i <= 12; i++) {
				fecha.setMonth(i);
				output.append(fecha.getMonthName());
				output.append(" ");
			}
		} catch(DateException e) {
		}

		return output.toString();
	}

	/**
	* 	getDaysLeftOfMonth()
 	* 	Metodo que devuelve los días que quedan para acabar el mes desde una fecha concreta
	*	@return Devuelve los días que quedan para acabar el mes
 	*/
	
	public String getDaysLeftOfMonth() {

		StringBuilder output = new StringBuilder();
		Date fecha; 

		try {
			fecha = new Date(this.day, this.month, this.year);

			for(int i = this.day + 1; i <= this.daysOfMonth(); i++) {
				
				fecha.setDay(i);
				output.append(fecha);
				output.append(" ");
			}
		} catch(DateException e) {
		}

		return output.toString();
	}

	/**
	* 	daysPast()
 	* 	Metodo que cuenta el número de días desde el inicio del año hasta la fecha
	*	@return Devuelve los días que han pasado desde el inicio del año
 	*/
	
	public int daysPast() {

		Date fecha;
		int numberDays = this.day - 1;

		try {
			fecha = new Date(1, 1, this.year);

			for(int i = 1; i < this.month; i++) {
				fecha.setMonth(i);
				numberDays += fecha.daysOfMonth();
			}
		} catch(DateException e) {
		}
		
		return numberDays;
	}

	/**
	* 	GenerateRandomDateWhile()
 	* 	Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (while)
	*	@return Devuelve el número de intentos que se han realizado hasta que la fecha a coincidido
 	*/
	
	public int GenerateRandomDateWhile() {
		int intentos = 0, day = 1, month = 1;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		while(end == false) {
			try {
				fecha = new Date(day, month, this.year);

				month = generador.nextInt(12) + 1;
				fecha.setMonth(month);
				day = generador.nextInt(fecha.daysOfMonth()) + 1;
				fecha.setDay(day);
				
				if(isSame(fecha) == false) {
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
	* 	numRandomTriesEqualDate()
 	* 	Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (do while)
	*	@return Devuelve el número de intentos que se han realizado hasta que la fecha a coincidido
 	*/
	
	public int numRandomTriesEqualDate() {
		int intentos = 0, day = 1, month = 1;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		do {
			try {
				fecha = new Date(day, month, this.year);

				month = generador.nextInt(12) + 1;
				fecha.setMonth(month);
				day = generador.nextInt(fecha.daysOfMonth()) + 1;
				fecha.setDay(day);

				if(isSame(fecha) == false) {
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
	* 	tomorrow()
 	* 	Metodo que da la fecha siguiente a la fecha introducida
	*	@return Devuelve un objeto de la clase Date que es el siguiente día a la fecha introducida
 	*/
	
	public Date tomorrow() {

		int tyear = this.year, tmonth = this.month, tday = this.day;
		Date otherDay;

		try {
			otherDay = new Date(tday, tmonth, tyear);
			tday++;

			if(tday > otherDay.daysOfMonth()) {
				otherDay.setDay(1);
				tmonth++;

				if(tmonth > 12) {
			
					otherDay.setMonth(1);
					tyear++;
					otherDay.setYear(tyear);
				} else {
					otherDay.setMonth(tmonth);
				}
			} else {
				otherDay.setDay(tday);
			}

		} catch (DateException e) {	
			otherDay = this;
		}

		return otherDay;
	}

	/**
	* 	dayOfWeek()
 	* 	Método que devuelve que día de la semana es
	* 	@param firstOfJanuary El parámetro firstOfJanuary es el día de la semana que se empezó el año
	*	@return Devuelve el nombre del día de la semana que coincide con la fecha
 	*/
	
	public String dayOfWeek(int firstOfJanuary) {

		String diaNombre = "";

		int dia = firstOfJanuary + (daysPast() % 7);

		switch(dia) {
			case 1: {
				diaNombre = "Monday";
				break;
			}
			case 2: {
				diaNombre = "Tuesday";
				break;
			}
			case 3: {
				diaNombre = "Wednesday";
				break;
			}
			case 4: {
				diaNombre = "Thursday";
				break;
			}
			case 5: {
				diaNombre = "Friday";
				break;
			}
			case 6: {
				diaNombre = "Saturday";
				break;
			}
			case 7: {
				diaNombre = "Sunday";
				break;
			}
			default: {
				diaNombre = "Desconocido";
			}
		}
		return diaNombre;
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}

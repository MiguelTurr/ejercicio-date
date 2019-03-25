package es.unileon.prg.date;

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
	* 	IsSameYear(Date anotherYear)
 	* 	Metodo que compara si dos años son iguales
	*	@param anotherYear El parámetro anotherYear es un objeto de la clase Date
	*	@return Si ambos años coinciden o no
 	*/
	public boolean IsSameYear(Date anotherYear) {
		return (this.year == anotherYear.getYear());
	}
	
	/**
	* 	IsSameMonth(Date anotherYear)
 	* 	Metodo que compara si dos meses son iguales
	*	@param anotherMonth El parámetro anotherMonth es un objeto de la clase Date
	*	@return Si ambos meses coinciden o no
 	*/
	
	public boolean IsSameMonth(Date anotherMonth) {
		return (this.month == anotherMonth.getMonth());
	}
	
	/**
	* 	IsSameDay(Date anotherYear)
 	* 	Metodo que compara si dos días son iguales
	*	@param anotherDay El parámetro anotherDayanotherDay es un objeto de la clase Date
	*	@return Si ambos días coinciden o no
 	*/

	public boolean IsSameDay(Date anotherDay) {
		return (this.day == anotherDay.getDay());
	}
	
	/**
	* 	IsSameDate(Date anotherDate)
 	* 	Metodo que compara dos objetos date
	*	@param anotherDate El parámetro anotherDate es un objeto de la clase Date
	*	@return Si ambas fechas coinciden
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
	* 	getMonthSeason()
 	* 	Metodo que devuelve la estación de un mes
	*	@return El nombre de la estación del año	
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
	* 	getSameDaysMonth()
 	* 	Metodo que devuelve los meses que tienen el mismo número de días
	*	@return Devuelve el nombre de los meses que tengan el mismo número de días
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
	* 	getMonthEndYear()
 	* 	Metodo que devuelve los meses que quedan para acabar el año desde una fecha concreta
	*	@return Devuelve el nombre de los meses que quedan para acabar el año
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
	* 	getDaysEndMonth()
 	* 	Metodo que devuelve los días que quedan para acabar el mes desde una fecha concreta
	*	@return Devuelve los días que quedan para acabar el mes
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
	* 	getDaysSinceStartYear()
 	* 	Metodo que cuenta el número de días desde el inicio del año hasta la fecha
	*	@return Devuelve los días que han pasado desde el inicio del año
 	*/
	
	public int getDaysSinceStartYear() {
		int numberDays = this.day;
		
		for(int i = 0; i < this.month; i++) {

			numberDays += getMonthDays(i);
		}
		return numberDays;
	}

	/**
	* 	GenerateRandomDateWhile()
 	* 	Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (while)
	*	@return Devuelve el número de intentos que se han realizado hasta que la fecha a coincidido
 	*/
	
	public int GenerateRandomDateWhile() {
		int intentos = 0, day, month;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		while(end == false) {
				
			month = generador.nextInt(12) + 1;
			day = generador.nextInt(getMonthDays(month)) + 1;

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
	* 	GenerateRandomDateDoWhile()
 	* 	Metodo que devuelve los intentos hasta que la fecha aleatoria generada coincide con la introducida (do while)
	*	@return Devuelve el número de intentos que se han realizado hasta que la fecha a coincidido
 	*/
	
	public int GenerateRandomDateDoWhile() {
		int intentos = 0, day, month;
		boolean end = false;
		Date fecha;
		Random generador = new Random(System.currentTimeMillis());

		do {
				
			month = generador.nextInt(12) + 1;
			day = generador.nextInt(getMonthDays(month)) + 1;

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
	* 	tomorrow()
 	* 	Metodo que da la fecha siguiente a la fecha introducida
	*	@return Devuelve un objeto de la clase Date que es el siguiente día a la fecha introducida
 	*/
	
	public Date tomorrow() {

		int tyear = this.year, tmonth = this.month, tday = this.day + 1;
		Date otherDay;

		if(tday > getMonthDays(tmonth)) {
			tday = 1;
			tmonth++;

			if(tmonth > 12) {
				tmonth = 1;
				tyear++;
			}
		}

		try {
			otherDay = new Date(tday, tmonth, tyear);
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

		int dia = firstOfJanuary + (getDaysSinceStartYear() % 7);

		switch(dia) {
			case 1: {
				diaNombre = "Lunes";
				break;
			}
			case 2: {
				diaNombre = "Martes";
				break;
			}
			case 3: {
				diaNombre = "Miercoles";
				break;
			}
			case 4: {
				diaNombre = "Jueves";
				break;
			}
			case 5: {
				diaNombre = "Viernes";
				break;
			}
			case 6: {
				diaNombre = "Sábado";
				break;
			}
			case 7: {
				diaNombre = "Domingo";
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

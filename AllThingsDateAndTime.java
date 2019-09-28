import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AllThingsDateAndTime {
	public static void main(String[] argv) throws ParseException {
		//Get today's day of the year #1 method
		Calendar calendar = Calendar.getInstance();
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(dayOfYear);

		//Get today's day of the year #2 method
		int dayOfYear2 = LocalDate.now().getDayOfYear();
		System.out.println(dayOfYear2);


		System.out.println();

		
		//Subtract years from a day, add days, and minus days
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.parse("01/31/2015", formatter2);
		LocalDate yearBefore = localDate.minusYears(2).plusDays(5).minusDays(1);
		System.out.println(yearBefore);


		System.out.println


		//Create a specific date and time from scratch, subtract X days from it, then format it to yyyy-MM-ddThh:mm:ssZ
		String previousTime = DateTimeFormatter.ISO_INSTANT.format(Instant.now().minus(180, ChronoUnit.DAYS));
		System.out.println(previousTime);


		System.out.println();


		//Create a specific date and time from scratch, add a day to it, then format it
		SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM/dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2013);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		c.add(Calendar.DATE, 22);
		Date startDate = c.getTime();
		String startDateMMdd = monthDateFormat.format(startDate);
		System.out.println(startDate);
		System.out.println(startDateMMdd);


		//Loop thru every day of a year
		for (int y = 0; y < 365; y++) {
			//System.out.println("y " + y);
			Calendar d = Calendar.getInstance();
			d.set(Calendar.YEAR, 2013);
			d.set(Calendar.MONTH, Calendar.JANUARY);
			d.set(Calendar.DATE, 1);
			d.set(Calendar.HOUR, 0);
			d.set(Calendar.MINUTE, 0);
			d.set(Calendar.SECOND, 0);
			d.set(Calendar.MILLISECOND, 0);
			d.add(Calendar.DATE, y);
			Date endDate = d.getTime();
			String endDateMMdd = monthDateFormat.format(endDate);
			System.out.println(endDateMMdd);
		}


		System.out.println();


		//Get number of days in a month
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		int lastdayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(lastdayOfMonth);

		//Loop thru all days in a month
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		int myMonth=cal2.get(Calendar.MONTH);

		while (myMonth==cal2.get(Calendar.MONTH)) {
			//System.out.print(cal.getTime());
			cal2.add(Calendar.DAY_OF_MONTH, 1);
		}


		System.out.println();


		//Convert day of year to day of month, printing the int day of month, and int day of week
		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.YEAR, 2007);
		cal3.set(Calendar.DAY_OF_YEAR, 100);
		System.out.println("Calendar date is: " + cal3.getTime());
		int dayOfMonth = cal3.get(Calendar.DAY_OF_MONTH);
		System.out.println("Calendar day of month: " + dayOfMonth);
		int dayOfWeek = cal3.get(Calendar.DAY_OF_WEEK);
		System.out.println("Calendar day of week: " + dayOfWeek);


		System.out.println();


		//Create a specific date based on day of year this year
		LocalDate localDateOfYear = LocalDate.now().withDayOfYear(12);
		System.out.println(localDateOfYear);


		System.out.println();


		//#1 method to get the last day of the year passed as a string, and format it. Also get the first day of year
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate start = LocalDate.parse("05/20/2013", formatter);
		LocalDate lastDay = start.with(lastDayOfYear());
		LocalDate firstDay = start.with(firstDayOfYear());
		String lastDayOfYear = formatter.format(lastDay);
		System.out.println(start);
		System.out.println(lastDay);
		System.out.println(lastDayOfYear);
		System.out.println(firstDay);


		System.out.println();


		//#2 method to get the last day of the year passed as a string. Also get the first day of year
		//Not as good, doesn't account for leap years
		Calendar cal4 = Calendar.getInstance();
		cal4.set(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal4.getTime().toString());
		cal4.set(Calendar.DAY_OF_YEAR, 366);
		System.out.println(cal4.getTime().toString());


		System.out.println();


		//Compare two dates, checking if its equal, before, or after #1
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		Date currentDate = sdf.parse("04/28/2018");
		Date desiredDate = sdf.parse("10/21/2018");

		if (currentDate.before(desiredDate)) {
			System.out.println("currentDate is before desiredDate");
		}
		if (currentDate.equals(desiredDate)) {
			System.out.println("currentDate is equal to desiredDate");
		}
		else if (currentDate.after(desiredDate)) {
			System.out.println("currentDate is after desiredDate");
		}


		System.out.println();


		//Compare two dates, checking if its equal, before, or after #2
		SimpleDateFormat forexFormat = new SimpleDateFormat("MMM dd yyyy");

		Date todayForexDate = new Date();
		String todayDateStringFormatted = forexFormat.format(todayForexDate);

		Date forexDateParsed = forexFormat.parse("Mar 30 2010");
		Date todayDateParsed = forexFormat.parse(todayDateStringFormatted);

		long forexDiff = todayDateParsed.getTime() - forexDateParsed.getTime();

		if (forexDiff < 0) {
			System.out.println("BEFORE");
		}
		else if (forexDiff == 0) {
			System.out.println("EQUAL");
		}
		else if (forexDiff > 0) {
			System.out.println("AFTER");
		}



		//Convert date to day of week
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		Date dt1 = format1.parse("10/28/1995");
		DateFormat format2 = new SimpleDateFormat("EE");
		String finalDay = format2.format(dt1);
		System.out.println(finalDay);


		System.out.println();


		//Check if two dates are within a specific range of each other
		datesWithinRange("05/05/2018", "05/07/2018", -5, true);


		System.out.println();


		//Convert am/pm time to 24 hour
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mma");
		SimpleDateFormat time24HFormat = new SimpleDateFormat("HH:mm");
		Date time1 = timeFormat.parse("6:30pm");
		String event24Hr = time24HFormat.format(time1);
		System.out.println(event24Hr);


		System.out.println();


		//Create a raw Calendar object and a raw Date object
		Calendar todayCal = Calendar.getInstance();
		Date todayDate = new Date();
		System.out.println(todayCal.getTime());
		System.out.println(todayDate);


		System.out.println();


		//Get difference in time between a date and now
		timeBetween();


		System.out.println();


		//Convert epoch value to usable timestamp #1 method
		Instant testInstant = Instant.now();
		System.out.println(testInstant.getEpochSecond());
		System.out.println("TI: " + testInstant.toString());
		Instant accountInstant = Instant.ofEpochMilli(todayDate.getTime() - 3600 * 1000);
		System.out.println(accountInstant);


		System.out.println();


		//Convert epoch value to usable timestamp #2 method
		long createDate = System.currentTimeMillis();
		Date date = new Date(createDate);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = format.format(date);
		System.out.println(formatted);
		format.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
		formatted = format.format(date);
		System.out.println(formatted);


		System.out.println();


		//Use GregorianCalendar to get the current hour of the day in Los Angeles
		GregorianCalendar gc = new GregorianCalendar();
		int hour = gc.get(Calendar.HOUR_OF_DAY);
		gc.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		hour = gc.get(Calendar.HOUR_OF_DAY);
		System.out.println("oncePerSchedule hour: " + hour);


		System.out.println();


		//Convert business day of year to overall day of year
		String firstDayOfYear = "Jan 01";
		SimpleDateFormat businessFormat = new SimpleDateFormat("MMM dd");
		Date businessFirstDay = businessFormat.parse(firstDayOfYear);
		System.out.println(calculateEndDate(businessFirstDay, 120));


		System.out.println();


		//Get number of business days between two Dates
		Date presentDate = new Date();
		SimpleDateFormat futureFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date futureDate = futureFormat.parse("08/08/2020");
		System.out.println(calculateDuration(presentDate, futureDate));

	}


	private static boolean datesWithinRange(String currentDateString, String desiredDateString, int maxDayAmount, boolean absoluteRange) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		Date currentDate = sdf.parse(currentDateString);
		Date desiredDate = sdf.parse(desiredDateString);

		long diff = currentDate.getTime() - desiredDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		if (maxDayAmount > 0) {
			if (diffDays >= 0 && diffDays <= maxDayAmount) {
				return true;
			}
		}
		else {
			if (diffDays <= 0 && diffDays >= maxDayAmount) {
				return true;
			}
			else if (absoluteRange && (diffDays >= 0 && diffDays <= Math.abs(maxDayAmount))) {
				return true;
			}
		}

		return false;
	}

	public static void timeBetween() {
		Date startDate = new Date();
		String dateStop = "06/12/2015 20:30:00";//"05/16/2015 09:00:00";

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateStart = format.format(startDate);
		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			System.out.println("\n" + "total seconds " + (diff / 1000.0));
			System.out.println("total minutes " + (diff / (60 * 1000.0)));
			System.out.println("total hours " + (diff / (60 * 60 * 1000.0)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String calculateEndDate(Date startDate, int duration) {      
		Calendar startCal = Calendar.getInstance();

		startCal.setTime(startDate);

		for (int i = 1; i < duration; i++)
		{
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			while (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			{
				startCal.add(Calendar.DAY_OF_MONTH, 1);
			}
		}

		SimpleDateFormat monthDateFormat = new SimpleDateFormat("MMM dd");

		Date finalBizDay = startCal.getTime();
		String finalBixDayMMMdd = monthDateFormat.format(finalBizDay);

		return finalBixDayMMMdd;
	}

	public static int calculateDuration(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis())
		{
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do
		{
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
			{
				workDays++;
			}
		}
		while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

		return workDays;
	}
}

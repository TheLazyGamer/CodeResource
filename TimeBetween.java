import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBetween {
	public static void main(String[] argv) {
		Date startDate = new Date();
		String dateStop = "08/08/2020 12:00:00";

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateStart = format.format(startDate);

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			double diffSeconds = diff / 1000 % 60;
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
}
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WaterReminder {
	public static void main(String[] argv) {
		while (true) {
			GregorianCalendar gc = new GregorianCalendar();
			int minutes = gc.get(Calendar.MINUTE); // gets the minutes

			if (minutes == 0 || minutes == 30) {
				for (int x = 0; x < 5; x++) {
					Toolkit.getDefaultToolkit().beep();
					sleepMode(500);
				}
				sleepMode(120000);
			}
			else {
				sleepMode(10000);
			}
		}
	}

	/**
	 * Pauses the current thread for the specified number of milliseconds.
	 * @param pauseLen The length of time to pause in milliseconds
	 */
	private static void sleepMode(int pauseLen) {
		try {
			Thread.sleep(pauseLen);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}

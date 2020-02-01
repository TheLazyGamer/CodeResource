import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class LogMessage {
	public static void main(String[] argv) {
		//getStackTrace may need to be changed to 1 or 2 depending on your environment (Android, VM, Server, etc.)
		logMessage("System Initiation", "info", new Throwable().getStackTrace()[0].getMethodName());
		logMessage("System Termination", "debug", new Throwable().getStackTrace()[0].getMethodName());
	}


	/*
	 * 
	 * ALL
	 * All levels including custom levels.
	 * 
	 * DEBUG
	 * Designates fine-grained informational events that are most useful to debug an application.
	 * 
	 * ERROR
	 * Designates error events that might still allow the application to continue running.
	 * 
	 * FATAL
	 * Designates very severe error events that will presumably lead the application to abort.
	 * 
	 * INFO
	 * Designates informational messages that highlight the progress of the application at coarse-grained level.
	 * 
	 * OFF
	 * The highest possible rank and is intended to turn off logging.
	 * 
	 * TRACE
	 * Designates finer-grained informational events than the DEBUG.
	 * 
	 * WARN
	 * Designates potentially harmful situations.
	 * 
	 */
	private static boolean logMessage(String message, String messageLevel, String callingMethod) {
		String outputString = Instant.now().toString() + " | " + messageLevel.toUpperCase() + " | " + Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + " | " + new Throwable().getStackTrace()[0].getClassName() + " | " + callingMethod + "() | " + message + "\n";

		File resultFile = new File("output.log");

		try {
			System.out.println(outputString);
			FileWriter resultWriter = new FileWriter(resultFile, true);
			resultWriter.append(outputString);
			resultWriter.flush();
			resultWriter.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}
}
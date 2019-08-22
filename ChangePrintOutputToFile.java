import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ChangePrintOutputToFile {
	public static void main(String[] argv) throws FileNotFoundException {
		File logFile = new File("/Users/USERNAME/Documents/reportLog.log");
		FileOutputStream fos = new FileOutputStream(logFile);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		System.out.println("This goes to logFile");
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotResponding {
	public static void main(String[] argv) throws IOException {
		Process respondingCmd = Runtime.getRuntime().exec("tasklist /FI \"STATUS eq not responding\"");

		BufferedReader programsResponding = new BufferedReader(new InputStreamReader(respondingCmd.getInputStream()));
		String respondingLog = "";

		while ((respondingLog = programsResponding.readLine()) != null) {
			respondingLog = respondingLog.trim();
			System.out.println(respondingLog);
		}

		programsResponding.close();
	}
}

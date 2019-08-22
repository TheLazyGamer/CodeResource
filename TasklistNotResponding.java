import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TasklistNotResponding {
	public static void main(String[] argv) throws IOException {

		Process runningCmd = Runtime.getRuntime().exec("tasklist");

		BufferedReader programsRunning = new BufferedReader(new InputStreamReader(runningCmd.getInputStream()));
		String runningLog = "";

		while ((runningLog = programsRunning.readLine()) != null) {
			runningLog = runningLog.trim();
			if (runningLog.contains("AutoIt3")) {
				System.out.println("Found1 " + runningLog);
			}
		}

		programsRunning.close();

		Process respondingCmd = Runtime.getRuntime().exec("tasklist /FI \"STATUS eq not responding\"");

		BufferedReader programsResponding = new BufferedReader(new InputStreamReader(respondingCmd.getInputStream()));
		String respondingLog = "";

		while ((respondingLog = programsResponding.readLine()) != null) {
			respondingLog = respondingLog.trim();
			if (respondingLog.contains("jusched")) {
				System.out.println("Found2 " + respondingLog);
			}
		}

		programsResponding.close();
	}
}
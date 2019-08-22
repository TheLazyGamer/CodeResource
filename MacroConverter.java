import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Converts a Logitech Gaming Software Macro XML to an AutoIT Script
public class MacroConverter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String lineRead = "";

		System.out.println("HotKeySet(\"{ESC}\", \"KillSwitch\")");
		System.out.println("");
		System.out.println("while 1 = 1");


		try (BufferedReader br = new BufferedReader(new FileReader("LogiMacro.txt"))) {
			while((lineRead = br.readLine()) != null) {
				if (lineRead.contains("<key value") && lineRead.contains("direction=\"up\"")) { //button being pressed down
					lineRead = lineRead.substring(lineRead.indexOf("\"") + 1, lineRead.lastIndexOf("r") - 4);
					System.out.println("    Send(\"{" + lineRead + " UP}\")");
				}

				else if (lineRead.contains(" value=") && lineRead.contains("key direction=\"up\"")) { //button being pressed down
					lineRead = lineRead.substring(lineRead.lastIndexOf("=") + 2, lineRead.lastIndexOf("\""));
					System.out.println("    Send(\"{" + lineRead + " UP}\")");
				}

				else if (lineRead.contains("<key value") && lineRead.contains("direction=\"down\"")) {
					lineRead = lineRead.substring(lineRead.indexOf("\"") + 1, lineRead.lastIndexOf("r") - 4);
					System.out.println("    Send(\"{" + lineRead + " DOWN}\")");
				}

				else if (lineRead.contains(" value=") && lineRead.contains("key direction=\"down\"")) { //button being pressed down
					lineRead = lineRead.substring(lineRead.lastIndexOf("=") + 2, lineRead.lastIndexOf("\""));
					System.out.println("    Send(\"{" + lineRead + " DOWN}\")");
				}

				else if (lineRead.contains("<delay milliseconds")) {
					lineRead = lineRead.substring(lineRead.indexOf("\"") + 1, lineRead.lastIndexOf("\""));
					System.out.println("    Sleep(" + lineRead + ")");
				}
			}
			System.out.println("Wend");
		}

		System.out.println("");
		System.out.println("Func KillSwitch()");
		System.out.println("    Exit");
		System.out.println("EndFunc");
	}
}
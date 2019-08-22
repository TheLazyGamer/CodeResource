import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingWritingFile {
	public static void main(String[] argv) throws IOException {
		String fileLine = "";

		File resultFile = new File("/Users/USERNAME/Documents/Program_Result.txt");
		@SuppressWarnings("resource")
		FileWriter resultWriter = new FileWriter(resultFile, true);

		try (BufferedReader br = new BufferedReader(new FileReader("/Users/USERNAME/Documents/Program_Read.txt"))) {
			while ((fileLine = br.readLine()) != null) {
				System.out.println(fileLine);
				resultWriter.append(fileLine + "\n");
				resultWriter.flush();
			}
		}
	}
}
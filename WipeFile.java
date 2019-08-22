import java.io.FileNotFoundException;
import java.io.PrintWriter;
 
public class WipeFile {
    public static void main(String[] argv) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("filepath.txt");
        pw.close();
    }
}
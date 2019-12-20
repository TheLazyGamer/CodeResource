import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionsErrorSample {
	public static void main(String[] argv) throws NothingExistsException {
		FileReader fr = null;	
		int count = 0;
		if (count == 0) {
			throw new NothingExistsException("Kablooey");
		}

		try {
			System.out.println(1 / 0);
			int[] myArr = new int[10];
			myArr[11] = 1;
			myArr[0] = Integer.parseInt("Example");

			File file = new File("file.txt");
			fr = new FileReader(file);
			char [] a = new char[50];
			fr.read(a);   // reads the content to the array
			for(char c : a) {
				System.out.print(c);   // prints the characters one by one
			}
		}
		catch (ArithmeticException ex) {
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			System.out.println("111 " + exceptionAsString + " 222");
			System.out.println("333 " + ex + " 444");
			System.out.print("555 ");
			ex.printStackTrace();
			System.out.println(" 666");
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException | IOException ex) {
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			System.out.println("111 " + exceptionAsString + " 222");
			System.out.println("333 " + ex + " 444");
			System.out.print("555 ");
			ex.printStackTrace();
			System.out.println(" 666");
		}
		finally {
			System.out.println("In the finally");
			try {
				fr.close();
			} catch (IOException ex) {		
				ex.printStackTrace();
			}
		}
	}
}

class NothingExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7999684663622192899L;

	public NothingExistsException(String errorMessage) {
		super(errorMessage);
	}

}


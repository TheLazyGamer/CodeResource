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
			//throw new NothingExistsException("Kablooey"); //Uncomment this for custom exception
			sleepMode(100);
		}

		try {
			//System.out.println(1 / 0); //Uncomment this for ArithmeticException
			sleepMode(100);
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
			sleepMode(100);
		}
		catch (ArithmeticException ex) {
			StringWriter sw = new StringWriter();
			sleepMode(100);
			ex.printStackTrace(new PrintWriter(sw));
			sleepMode(100);
			String exceptionAsString = sw.toString();
			String exceptionMessage = ex.getMessage();
			String exceptionLocalizedMessage = ex.getLocalizedMessage();
			System.out.println("111");
			System.out.println(exceptionAsString);
			System.out.println("222");
			System.out.println(exceptionMessage);
			System.out.println("333");
			System.out.println(exceptionLocalizedMessage);
			System.out.println("444");
			System.out.println(ex);
			System.out.println("555");
			sleepMode(100);
			ex.printStackTrace();
			sleepMode(100);
			System.out.println("666");
			sleepMode(100);
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException | IOException ex) {
			StringWriter sw = new StringWriter();
			sleepMode(100);
			ex.printStackTrace(new PrintWriter(sw));
			sleepMode(100);
			String exceptionAsString = sw.toString();
			String exceptionMessage = ex.getMessage();
			String exceptionLocalizedMessage = ex.getLocalizedMessage();
			System.out.println("111");
			System.out.println(exceptionAsString);
			System.out.println("222");
			System.out.println(exceptionMessage);
			System.out.println("333");
			System.out.println(exceptionLocalizedMessage);
			System.out.println("444");
			System.out.println(ex);
			System.out.println("555");
			sleepMode(100);
			ex.printStackTrace();
			sleepMode(100);
			System.out.println("666");
			sleepMode(100);
		}
		finally {
			sleepMode(100);
			System.out.println("In the finally");
			sleepMode(100);
			try {
				fr.close();
			} catch (IOException ex) {		
				ex.printStackTrace();
			}
		}
	}

	public static void sleepMode(int pauseLen) {
		try {
			Thread.sleep(pauseLen);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
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

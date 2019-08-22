public class PrintPaddedZeros {
	public static void main(String[] argv) {
		String original = "0001";
		for (int x = 1; x <= 200; x++) {
		    System.out.println(original);
		    original = String.format("%0" + original.length() + "d", Integer.parseInt(original) + 1);
		}
	}
}

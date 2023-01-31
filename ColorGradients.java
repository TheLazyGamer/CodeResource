
public class ColorGradients {
	public static void main(String[] argv) {
		getCellRgbGradient(0, 100, 43);
	}

	private static void getCellRgbGradient(int min, int max, int cellValue) {		
		/*
        The weight can be between 0 (when value === min)
        and 1 (when value === max)
		 */
		double weight = (cellValue - min * 1.0)/(max - min * 1.0);

		// We want red === 255 at min, and 0 at max
		int red = (int) ((1-weight) * 255);

		// Conversly, we want green === 0 at min, and 255 at max
		int green = (int) (weight * 255);

		// Return backgroundColor value
		System.out.println(red + "," + green + ", 0");
	}
}

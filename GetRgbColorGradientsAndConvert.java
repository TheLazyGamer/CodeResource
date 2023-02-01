public class GetRgbColorGradientsAndConvert {
	public static void main(String[] argv) {
		int maxRedForBiggestWin = 2;
		int maxGreenForBiggestWin = 176;
		int maxBlueForBiggestWin = 0;

		int minRedForSmallestWin = 255;
		int minGreenForSmallestWin = 255;
		int minBlueForSmallestWin = 255;

		int smallestWinPctInDataset = 0;
		int largestWinPctInDataset = 100;


		int maxRedForBiggestLoss = 2;
		int maxGreenForBiggestLoss = 176;
		int maxBlueForBiggestLoss = 0;

		int minRedForSmallestLoss = 255;
		int minGreenForSmallestLoss = 255;
		int minBlueForSmallestLoss = 255;

		int smallestLossPctInDataset = 0;
		int largestLossPctInDataset = -100;

		int cellValue = 43;

		/*
		 * Find the minimum and maximum values of the column you wish to style.
In the column you want to style add a function that:
Calculates the weight which tells us how close we are to the maximum value.
0 means that the value is the smallest possible, 1 means that the value is the highest possible.

Applies weight to each 1 of the 3 RGB channels, like this:

weight * finalChannelValue + (1 - weight) * initialChannelValue

For instance: if you want to color the minimum value's background with rgb(198, 57, 9), and the maximum value with rgb(36, 114, 76), write this:

let red = weight * 36 + (1 - weight) * 198;
let green = weight * 114 + (1 - weight) * 57;
let blue = weight * 76 + (1 - weight) * 9;
		 */
		runConversion(smallestWinPctInDataset, largestWinPctInDataset, cellValue,
				maxRedForBiggestWin,
				maxGreenForBiggestWin,
				maxBlueForBiggestWin,
				minRedForSmallestWin,
				minGreenForSmallestWin,
				minBlueForSmallestWin);
	}

	private static void runConversion(int min, int max, int cellValue,
			int maxRedForBiggest, int maxGreenForBiggest, int maxBlueForBiggest,
			int minRedForSmallest, int minGreenForSmallest, int minBlueForSmallest) {		
		/*
        The weight can be between 0 (when value === min)
        and 1 (when value === max)
		 */
		double weight = (Math.abs(cellValue) - min * 1.0)/(max - min * 1.0);

		int red = (int) (weight * maxRedForBiggest + (1 - weight) * minRedForSmallest);
		int green = (int) (weight * maxGreenForBiggest + (1 - weight) * minGreenForSmallest);
		int blue = (int) (weight * maxBlueForBiggest + (1 - weight) * minBlueForSmallest);

		// Return backgroundColor value
		System.out.println(red + "," + green + "," + blue);

		String hex = String.format("0x%02X%02X%02X", red, green, blue);
		System.out.println(hex);

		int decimal = (red * 65536) + (green * 256) + 0;
		System.out.println("" + decimal);
	}
}

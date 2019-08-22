import java.util.ArrayList;
import java.util.Random;

public class Random2DArray {
	public static void main(String[] argv) {
		int[][] chart = new int[5][5];
		ArrayList<Integer> numbersArr = new ArrayList<Integer>();

		for (int n = 1; n < 26; n++) {
			numbersArr.add(n);
		}

		Random generator = new Random();

		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[i].length; j++) {
				int ran = numbersArr.size() - 1 - generator.nextInt(numbersArr.size());
				chart[i][j] = numbersArr.get(ran);
				numbersArr.remove(ran);
			}
		}

		int totalRows = chart.length;
		int totalColumns = chart[0].length;

		for (int x = 0; x < totalRows; x++) {
			for (int y = 0; y < totalColumns; y++) {
				if (y != 0) {
					System.out.print(" ");
				}
				System.out.print(chart[x][y]);
			}

			System.out.println();
		}
	}
}
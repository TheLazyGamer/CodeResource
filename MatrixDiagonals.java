public class MatrixDiagonals {
	public static void main(String[] argv) {

		String returnString = "";

		int[][] ourMatrix = randomZeroOneMatrix(3);

		int totalRows = ourMatrix.length;
		int totalColumns = ourMatrix[0].length;
		for (int c = 0 ; c < totalRows ; c++ ) {

			for (int d = 0; d < totalColumns; d++) {
				returnString = returnString + (ourMatrix[c][d])+ " ";
			}

			returnString = returnString + "\n";
		}

		System.out.println(returnString);

		rowChecks(ourMatrix);
		System.out.println("");
		checkSubDiagonal(ourMatrix);
		System.out.println("");
		checkDiagonal(ourMatrix);
	}

	public static int[][] randomZeroOneMatrix(int n) {
		// Generate an nxn matrix randomly filled
		// with zeroes and ones.
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int)(Math.random() + 0.5);
			}
		}
		return matrix;
	}

	public static int checkRowForSameness(int[][] matrix, int i) {
		int testValue = matrix[i][0];
		// If all values in row i are the same, then return that value.
		// Otherwise, return -1.
		for (int j = 1; j < matrix[i].length; j++) {
			if (testValue != matrix[i][j]) {
				return -1;
			}
		}

		return matrix[i][0];
	}

	public static void rowChecks(int[][] matrix) {
		// Check which rows have all of the same entries.
		// Display a message for each such row.
		// Display a different message if none of the rows
		// have all the same entries.
		// Precondition:  none of the entries are -1.
		for (int i = 0; i < matrix.length; i++) {
			//Call checkRowForSameness
			int rowSame = checkRowForSameness(matrix, i);
			if (rowSame == -1) {
				System.out.println("Not same numbers on row " + i);
			}

			else if (rowSame == 1) {
				System.out.println("All 1s on row " + i);
			}

			else {
				System.out.println("All 0s on row " + i);
			}
		}
	}

	public static void checkSubDiagonal(int[][] matrix) {
		// Check whether all values along the sub-diagonal (bottom left to top right)
		// of the matrix are the same.
		// Print a message accordingly.

		int topRight = matrix[0][matrix.length - 1];
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			if ((matrix[i][matrix.length - (i + 1)] == topRight)) {
				count++;
			}
		}

		if(count == matrix.length) {
			System.out.println("All same numbers on the sub-diagonal");
		}

		else {
			System.out.println("Not same number on sub-diagonal");
		}
	}

	public static void checkDiagonal(int[][] matrix) {
		// Check whether all values along the diagonal (bottom right to top left)
		// of the matrix are the same.
		// Print a message accordingly.

		int topLeft = matrix[0][0];
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			if ((matrix[i][i] == topLeft)) {
				count++;
			}
		}

		if(count == matrix.length) {
			System.out.println("All same numbers on the diagonal");
		}

		else {
			System.out.println("Not same number on diagonal");
		}
	}

}
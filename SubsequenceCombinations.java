import java.util.ArrayList;

public class SubsequenceCombinations { 

	static ArrayList<String> searchCombos = new ArrayList<String>();

	private static void print(String prefix, ArrayList<String> tickers, int remainingStringLen, String message) {
		//System.out.println(message + " with tickers left: " + tickers.size() + " and remainingStringLen: " + remainingStringLen);


		if (remainingStringLen == 0) {
			System.out.println(prefix);
			return;
		}
		if (tickers.size() == 0) {
			//System.out.println("hit zero");
			return;

		}


		String ticker = tickers.remove(0);
		double time = Math.random();
		ArrayList<String> backup = new ArrayList<String>();
		for (int x = 0; x < tickers.size(); x++) {
			backup.add(tickers.get(x));
		}
		//System.out.println("Stage 1 for " + time + " with " + tickers);

		print(prefix + "," + ticker, tickers, remainingStringLen-1, "Append");
		//System.out.println("Stage 2 for " + time + " with " + tickers);
		print(prefix, backup, remainingStringLen, "Normal");
	}


	public static void main(String[] args) {
		ArrayList<String> tickers = new ArrayList<String>();
		tickers.add("SNAP");
		tickers.add("AAPL");
		tickers.add("FANG");
		tickers.add("MSFT");
		tickers.add("GOOGL");
		tickers.add("PENG");
		tickers.add("AMZN");
		tickers.add("IKEA");
		int remainingStringLen = 6;
		print("", tickers, remainingStringLen, "Start");
		System.out.println("finally");
		System.out.println(tickers);
		destroy(tickers);
		System.out.println(tickers);

		String[] tickersArr = {"RHS", "QQQ", "IEF", "TLT", "GLD"};
		int n = tickersArr.length; 
		for (int r = 2; r <= tickersArr.length; r++) {
			printCombination(tickersArr, n, r); 
		}
	}


	private static void destroy(ArrayList<String> tickers) {
		// TODO Auto-generated method stub
		String ticker = tickers.remove(0);
		String ticker2 = tickers.remove(0);
	}

	/* arr[] ---> Input Array 
	data[] ---> Temporary array to store current combination 
	start & end ---> Staring and Ending indexes in arr[] 
	index ---> Current index in data[] 
	r ---> Size of a combination to be printed */
	static void combinationUtil(String[] tickers, String[] data, int start, int end, int index, int r) 
	{ 
		// Current combination is ready to be printed, print it 
		if (index == r) 
		{ 
			String tickerString = "";
			for (int j=0; j<r; j++) {
				//System.out.print(data[j]+" ");
				tickerString = tickerString + data[j] + " ";
			}
			searchCombos.add(tickerString.trim());
			//System.out.println(""); 
			return; 
		} 

		// replace index with all possible elements. The condition 
		// "end-i+1 >= r-index" makes sure that including one element 
		// at index will make a combination with remaining elements 
		// at remaining positions 
		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{ 
			data[index] = tickers[i]; 
			combinationUtil(tickers, data, i+1, end, index+1, r); 
		} 
	} 

	// The main function that prints all combinations of size r 
	// in arr[] of size n. This function mainly uses combinationUtil() 
	static void printCombination(String[] tickers, int n, int r) 
	{ 
		// A temporary array to store all combination one by one 
		String[] data = new String[r]; 

		// Print all combination using temporary array 'data[]' 
		combinationUtil(tickers, data, 0, n-1, 0, r); 
	}

}

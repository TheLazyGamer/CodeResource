import java.util.ArrayList;

public class Subsequence { 

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
	}


	private static void destroy(ArrayList<String> tickers) {
		// TODO Auto-generated method stub
		String ticker = tickers.remove(0);
		String ticker2 = tickers.remove(0);
	}

}
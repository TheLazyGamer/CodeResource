import java.util.ArrayList;

public class StatisticCalculations {

	public static void main (String[] args) {

	}

	/**
	 *  Finds the mode of a given sorted Integer ArrayList
	 *  
	 *  @param responseTimes The sorted ArrayList containing
	 *  the response times in milliseconds
	 *  @return The mode of the list
	 *  @since 1.0
	 */
	public static int findMode(ArrayList<Integer> responseTimes) {
		int maxValue = 0;
		int maxCount = 0;

		for (int i = 0; i < responseTimes.size(); i++) {
			int count = 0;
			int trackedResponse = responseTimes.get(i);
			for (int j = 0; j < responseTimes.size(); j++) {
				if (responseTimes.get(j) == trackedResponse) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = responseTimes.get(i);
			}
		}

		return maxValue;
	}


	/**
	 *  Finds the median of a given sorted Integer ArrayList
	 *  
	 *  @param responseTimes The sorted ArrayList containing
	 *  the response times in milliseconds
	 *  @return The median of the list
	 *  @since 1.0
	 */
	public static int findMedian(ArrayList<Integer> responseTimes) {
		int middle = responseTimes.size() / 2;
		if (responseTimes.size() % 2 == 1) {
			return (int)responseTimes.get(middle);
		} else {
			return (int)((responseTimes.get(middle-1) + responseTimes.get(middle)) / 2.0);
		}
	}


	/**
	 *  Finds the mean of a given sorted Integer ArrayList
	 *  
	 *  @param responseTimes The sorted ArrayList containing
	 *  the response times in milliseconds
	 *  @return The mean of the list
	 *  @since 1.0
	 */
	public static int findMean(ArrayList<Integer> responseTimes) {
		double sum = 0;
		for (int i = 0; i < responseTimes.size(); i++) {
			sum += responseTimes.get(i);
		}
		return (int)(sum / responseTimes.size());
	}


	/**
	 *  Finds the X percentile of a given sorted Integer ArrayList
	 *  
	 *  @param responseTimes The sorted ArrayList containing
	 *  the response times in milliseconds
	 *  @param percentile The X percentile we want to grab
	 *  @return The mean of the list
	 *  @since 1.0
	 */
	public static int findPercentile(ArrayList<Integer> responseTimes, double percentile) {
		int index = (int) Math.ceil(percentile / 100.0 * responseTimes.size());
		return responseTimes.get(index-1);
	}



}

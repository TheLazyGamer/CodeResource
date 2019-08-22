
public class CleanPercentages {
public static void main(String[] argv) {
	double cleanPct = generateCleanPercentages(7, 3);
	System.out.println(cleanPct);
}
private static double generateCleanPercentages(double dividend, double divisor) {
    double dirtyPct = dividend / divisor * 100.0;
    System.out.println(dirtyPct);
    return Math.round(dirtyPct * 100.0) / 100.0;
}
}

public class RemoveWhitespace {
	public static void main(String[] argv) {
		String sample = "	The  Quick   Brown Fox Jumped Over the Lazy Dog  	";
		sample = sample.toLowerCase().replace("\u00A0", "").replace("&nbsp;", "").replaceAll("  ", " ").trim();
		System.out.println(sample);
	}
}

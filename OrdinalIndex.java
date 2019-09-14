public class OrdinalIndex {
	public static void main(String[] argv) {
		String sampleText = "The quick brown fox jumped over the lazy dog.";
		int fourthSpace = ordinalIndexOf(sampleText, ' ', 4);
		System.out.println(fourthSpace);
		String subSampleText = sampleText.substring(fourthSpace, sampleText.length());
		System.out.println(subSampleText); //prints " over the lazy dog."
	}

	public static int ordinalIndexOf(String str, char c, int n) {
		int pos = str.indexOf(c, 0);
		while (n-- > 0 && pos != -1) {
			pos = str.indexOf(c, pos+1);
		}
		return pos;
	}

}
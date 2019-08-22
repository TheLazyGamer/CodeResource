public class RemoveHTMLTags {
	public static void main(String[] argv) {
		String uglyHTML = "<p>This is sample <i>text</i></p>";
		String cleanHTML = removeHTML(uglyHTML);
		System.out.println(cleanHTML);
	}
	
	public static String removeHTML(String rawHtml) {
		while (rawHtml.contains(">")) {
			try {
				int firstLessThanIndex = rawHtml.indexOf("<");
				int firstGreaterThanIndex = rawHtml.indexOf(">")+1;
				StringBuffer buf = new StringBuffer(rawHtml);
				buf.replace(firstLessThanIndex, firstGreaterThanIndex, "");
				rawHtml = buf.toString();
			}
			catch (StringIndexOutOfBoundsException ex) {
				try {
					int lastLessThanIndex = rawHtml.lastIndexOf("<");
					int lastGreaterThanIndex = rawHtml.lastIndexOf(">")+1;
					StringBuffer buf = new StringBuffer(rawHtml);
					buf.replace(lastLessThanIndex, lastGreaterThanIndex, "");
					rawHtml = buf.toString();
				}
				catch (StringIndexOutOfBoundsException e) {
					//ex.printStackTrace();
					break;
				}
			}
		}

		return rawHtml.trim();
	}
}



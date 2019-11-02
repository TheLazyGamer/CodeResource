public class ParseQuotedCSV {
	public static void main(String[] argv) {
		String line1 = "987663,seepzBranch,\"Seepz mumbai,andheri\",\"near infra, flat no 23,raghilla mall thane\",seepz,";
		String line2 = "Sachin,,M,\"Maths,Science,English\",Need to improve in these subjects.";
		String line3 = "foo,bar,c;qual=\"baz,blurb\",d;junk=\"quux,syzygy\"";
		String line4 = "a1, a2, a3, \"a4,a5\", a6";
		String line5 = "abc,foo,c;bar=\"this,demo\",hello\"world,syzygy\"";


		splitMethod(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", line1);
		splitMethod(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", line2);
		splitMethod(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", line3);
		splitMethod(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", line4);
		splitMethod(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", line5);
		System.out.println("\n\n\n");
		splitMethod("^\\s*\"((?:[^\"]|(?:\"\"))*?)\"\\s*,", line1);
		splitMethod("^\\s*\"((?:[^\"]|(?:\"\"))*?)\"\\s*,", line2);
		splitMethod("^\\s*\"((?:[^\"]|(?:\"\"))*?)\"\\s*,", line3);
		splitMethod("^\\s*\"((?:[^\"]|(?:\"\"))*?)\"\\s*,", line4);
		splitMethod("^\\s*\"((?:[^\"]|(?:\"\"))*?)\"\\s*,", line5);
		System.out.println("\n\n\n");
		splitMethod("(\",)?\"", line1);
		splitMethod("(\",)?\"", line2);
		splitMethod("(\",)?\"", line3);
		splitMethod("(\",)?\"", line4);
		splitMethod("(\",)?\"", line5);

	}

	private static void splitMethod(String regex, String csvLine) {
		String[] splitted = csvLine.split(regex, -1);
		System.out.print('[');
		for (int x = 0; x < splitted.length; x++) {
			System.out.print(splitted[x].trim());
			if (x < splitted.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print(']');
		System.out.println("\n");
	}
}

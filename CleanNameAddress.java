
public class CleanNameAddress {
	public static void main(String[] argv) {
		cleanName1("Doe, John U S A MD");
		cleanAddr1("598 Columbia Turnpike<br>Hannaford Plaza<br>East Greenbush, NY 12061<br>Rensselaer<br>(555) 555-5555");
		cleanAddr1("81 Miller Rd Ste 800<br>Castleton, NY 12033<br>Rensselaer<br>(555) 555-5555");
		cleanAddr2("801 St. Mary's Drive, Suite 300 West<br>Evansville<br>IN, 4771");
		cleanAddr2("St. Mary's Anesthesia Department<br>3700 Washington Avenue<br>Evansville<br>IN, 47750");
		cleanName2("John USA Doe, M.D.");
		cleanName2("John Doe, M.D.");
		cleanAddr3("Nephrology Specialists, P.C.<br>3229 Broadway Ave.<br>Suite 205<br>Gary, IN 46409<br>(555) 555-5555");
		cleanAddr3("Pain Control Associates<br>7280 W. Lincoln Hwy.<br>Crown Point, IN 46307<br>(555) 555-5555");
		cleanAddr3("Radiation Medicine Associates, P.C.<br>901 MacArthur Blvd<br>Attn: Radiation Oncology Dept.<br>Munster, IN 46321<br>(555) 555-5555");
		cleanAddr3("1509 State St.<br>LaPorte, IN 46352<br>(555) 555-5555");
		System.out.println(cleanNameAddr1("JOHN AMERICA DOE"));
		System.out.println(cleanNameAddr1("1234 MAIN street"));
	}


	private static String cleanNameAddr1(String uglyNameAddr) {
		char[] chars = uglyNameAddr.toLowerCase().toCharArray();
		boolean found = false;

		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			}
			else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
				found = false;
			}
		}

		return String.valueOf(chars);

	}


	private static void cleanAddr3(String addressFull) {

		String providerGroupName = "";
		String department = "";
		String streetAddress = "";
		String cityStateZip = "";
		String city = "";
		String state = "";
		String zip = "";
		String phone = "";


		String[] addressArr = addressFull.split("<br>");

		if (addressArr.length > 1) {

			phone = addressArr[addressArr.length - 1];

			cityStateZip = addressArr[addressArr.length - 2];

			String cszTemp = cityStateZip;
			zip = cszTemp.substring(cszTemp.lastIndexOf(" ") + 1, cszTemp.length());
			cszTemp = cszTemp.substring(0, cszTemp.lastIndexOf(" "));
			state = cszTemp.substring(cszTemp.lastIndexOf(" ") + 1, cszTemp.length());
			city = cszTemp.substring(0, cszTemp.lastIndexOf(" "));
			if (city.endsWith(",")) {
				city = city.substring(0, city.length() - 1); }

			String streetOrAttn = addressArr[addressArr.length - 3];


			if (streetOrAttn.toLowerCase().contains("attn") || streetOrAttn.toLowerCase().contains("dept")) {
				department = streetOrAttn;
				streetAddress = addressArr[addressArr.length - 4];
				try {
					providerGroupName = addressArr[addressArr.length - 5];
				}
				catch (Exception ex) {

				}

			}
			else {
				streetAddress = streetOrAttn;
				if (addressArr.length > 3) {
					String firstLineOrPGN = addressArr[addressArr.length - 4];
					try {
						providerGroupName = addressArr[addressArr.length - 5];
						streetAddress = firstLineOrPGN + "<br>" + streetAddress;
					}
					catch (Exception ex) {
						providerGroupName = firstLineOrPGN;
					}
				}
			}

			System.out.println(providerGroupName + "|" + department + "|" + streetAddress + "|" + city + "|" + state + "|" + zip + "|" + phone);

		}
	}


	private static void cleanName2(String docFullName) {
		String credentialText = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String doctorType = "";

		String nameTemp = docFullName;
		if (nameTemp.contains(",")) {
			credentialText = nameTemp.substring(nameTemp.indexOf(",") + 1, nameTemp.length()).trim();
			nameTemp = nameTemp.substring(0, nameTemp.indexOf(",")); }
		if (nameTemp.contains(" ")) {
			firstName = nameTemp.substring(0, nameTemp.indexOf(" "));
			nameTemp = nameTemp.substring(nameTemp.indexOf(" ") + 1, nameTemp.length()).trim();
			if (nameTemp.contains(" ")) {

				middleName = nameTemp.substring(0, nameTemp.indexOf(" "));
				lastName = nameTemp.substring(nameTemp.indexOf(" ") + 1, nameTemp.length()); }

			else {
				lastName = nameTemp;
			}

		}

		if (credentialText.contains("MD") || credentialText.contains("M.D.")) {
			doctorType = "MD"; }
		else if (credentialText.contains("DO") || credentialText.contains("D.O.")) {
			doctorType = "DO"; }

		System.out.println(firstName + "|" + middleName + "|" + lastName + "|" + credentialText + "|" + doctorType);

	}

	private static void cleanAddr2(String fullAddress) {

		String department = "";
		String streetAddress = "";
		String cityStateZip = "";
		String city = "";
		String state = "";
		String zip = "";

		String[] addressArr = fullAddress.split("<br>");

		if (addressArr.length > 1) {
			city = addressArr[addressArr.length - 2];
			state = addressArr[addressArr.length - 1];
			cityStateZip = city + " " + state;
			zip = state.substring(state.indexOf(",")+1, state.length()).trim();
			state = state.substring(0, state.indexOf(","));

			streetAddress = addressArr[addressArr.length - 3];
			try {
				department = addressArr[addressArr.length - 4]; }
			catch (ArrayIndexOutOfBoundsException ex) {

			}

			System.out.println(department + "|" + streetAddress + "|" + cityStateZip + "|" + city +  "|" + state +  "|" + zip);
		}

	}

	private static void cleanAddr1(String addressFull) {
		String streetAddressLines = "";
		String streetAddressLine2 = "";
		String streetAddressLine1 = "";
		String cityStateZip = "";
		String county = "";
		String city = "";
		String state = "";
		String zip = "";
		String phone = "";


		String[] addressArr = addressFull.split("<br>");

		if (addressArr.length > 1) {

			String possiblyPhone = addressArr[addressArr.length - 1];

			phone = possiblyPhone;

			county = addressArr[addressArr.length - 2];

			cityStateZip = addressArr[addressArr.length - 3];

			if (cityStateZip.contains(", ") && Character.isDigit(cityStateZip.charAt(cityStateZip.length()-1))) {
				String cszTemp = cityStateZip;
				zip = cszTemp.substring(cszTemp.lastIndexOf(" ") + 1, cszTemp.length());
				cszTemp = cszTemp.substring(0, cszTemp.lastIndexOf(" "));
				state = cszTemp.substring(cszTemp.lastIndexOf(" ") + 1, cszTemp.length());
				city = cszTemp.substring(0, cszTemp.lastIndexOf(" "));
				if (city.endsWith(",")) {
					city = city.substring(0, city.length() - 1);
				}
				if (city.contains(",")) {
					cityStateZip = city.substring(0, city.indexOf(","));
					city = city.substring(city.indexOf(",") + 1, city.length());
				}
			}


			streetAddressLine2 = addressArr[addressArr.length - 4];

			try {
				String addressLocationPrim = addressArr[addressArr.length - 5];
				streetAddressLine1 = addressLocationPrim;
			}
			catch (Exception ex) {
				streetAddressLine1 = streetAddressLine2;
				streetAddressLine2 = "";
			}

			try {
				//This never works, but just in case for future scrapes
				String addressLocationPrim = addressArr[addressArr.length - 6];
				streetAddressLines = addressLocationPrim + "<pt>" + streetAddressLines;
			}
			catch (Exception ex) {
			}
		}

		System.out.println(streetAddressLine1 + "|" + streetAddressLine2 + "|" + county + "|" + city + "|" + state + "|" + zip + "|" + phone);

	}

	private static void cleanName1(String docFullName) {
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String docType = "";

		String nameTemp = docFullName;

		if (nameTemp.contains(" ") && nameTemp.contains(",")) {
			lastName = nameTemp.substring(0, nameTemp.indexOf(","));
			nameTemp = nameTemp.substring(nameTemp.indexOf(",") + 1, nameTemp.length()).trim();

			if (nameTemp.contains(" ")) {
				docType = nameTemp.substring(nameTemp.lastIndexOf(" ") + 1, nameTemp.length());
				nameTemp = nameTemp.substring(0, nameTemp.lastIndexOf(" ")).trim(); }
			if (nameTemp.contains(" ")) {
				firstName = nameTemp.substring(0, nameTemp.indexOf(" "));
				middleName = nameTemp.substring(nameTemp.indexOf(" ") + 1, nameTemp.length()); }
			else {
				firstName=  nameTemp; }

		}

		System.out.println(firstName + "|" + middleName + "|" + lastName + "|" + docType);

	}
}

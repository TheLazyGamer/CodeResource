import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseBrailleNATOPhone {
	//TODO somehow add International Code of Signals https://en.wikipedia.org/wiki/International_Code_of_Signals 
	public static String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
	public static String[] letters = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", ""};
	public static ArrayList<String> allEnglishWordsList = new ArrayList<String>();
	public static void main(String[] argv) throws FileNotFoundException, IOException {

		char[] alphaArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1',
				'2', '3', '4', '5', '6', '7', '8', '9', '0'};

		char[] alphaBrailleArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1',
				'2', '3', '4', '5', '6', '7', '8', '9', '0',
				'.', ',', ';', ':', '/', '?', '!', '@', '#',
				'+', '-', '*', '"', '\'', '<', '>', '(', ')',
		'_'};

		String[] semaphoreArr = {
				"Right-hand: Bottom right. Left-hand: Down.", //A
				"Right-hand: Right. Left-hand: Down.", //B
				"Right-hand: Top right. Left-hand: Down.", //C
				"Right-hand: Up. Left-hand: Down.", //D
				"Right-hand: Down. Left-hand: Top left.", //E
				"Right-hand: Down. Left-hand: Left.", //F
				"Right-hand: Down. Left-hand: Bottom left.", //G
				"Right-hand: Right. Left-hand: Bottom right.", //H
				"Right-hand: Top right. Left-hand: Bottom right.", //I
				"Right-hand: Up. Left-hand: Left.", //J
				"Right-hand: Bottom right. Left-hand: Up.", //K
				"Right-hand: Bottom right. Left-hand: Top left.", //L
				"Right-hand: Bottom right. Left-hand: Left.", //M
				"Right-hand: Bottom right. Left-hand: Bottom left.", //N
				"Right-hand: Top right. Left-hand: Right.", //O
				"Right-hand: Right. Left-hand: Up.", //P
				"Right-hand: Right. Left-hand: Top left.", //Q
				"Right-hand: Right. Left-hand: Left.", //R
				"Right-hand: Right. Left-hand: Bottom left.", //S
				"Right-hand: Top right. Left-hand: Up.", //T
				"Right-hand: Top right. Left-hand: Top left.", //U
				"Right-hand: Up. Left-hand: Bottom Left.", //V
				"Right-hand: Left. Left-hand: Top left.", //W
				"Right-hand: Bottom left. Left-hand: Top left.", //X
				"Right-hand: Top right. Left-hand: Left.", //Y
				"Right-hand: Bottom left. Left-hand: Left.", //Z
				"Right-hand: Bottom right. Left-hand: Down.", //1
				"Right-hand: Right. Left-hand: Down.", //2
				"Right-hand: Top right. Left-hand: Down.", //3
				"Right-hand: Up. Left-hand: Down.", //4
				"Right-hand: Down. Left-hand: Top left.", //5
				"Right-hand: Down. Left-hand: Left.", //6
				"Right-hand: Down. Left-hand: Bottom left.", //7
				"Right-hand: Right. Left-hand: Bottom right.", //8
				"Right-hand: Top right. Left-hand: Bottom right.", //9
				"Right-hand: Bottom right. Left-hand: Up.", //0
		};

		String[] numberBrailleArr = {"100000", "101000", "110000", "110100", "100100", "111000", "111100", "101100", "011000"
				, "011100", "100010", "101010", "110010", "110110", "100110", "111010", "111110", "101110"
				, "011010", "011110", "100011", "101011", "011101", "110011", "110111", "100111Z", "100000",
				"101000", "110000", "110100", "100100", "111000", "111100", "101100", "011000", "011100",
				"001101", "001000", "001010", "001100", "010010", "001011", "001110", "010110", "010111",
				"001110", "001100", "000110", "001011", "000010", "101001", "010110", "001111", "001111",
		"000011"};

		String[] morseArr = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**",
				"*---", "-*-", "*-**", "--", "-*", "---", "*--*", "--*-", "*-*",
				"***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**", "*----",
				"**---", "***--", "****-", "*****", "-****", "--***", "---**", "----*", "-----"};

		String[] telephoneArr = {"Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India",
				"Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo",
				"Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu", "One",
				"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Niner", "Zero"};

		String fileLine = "";

		try (BufferedReader br = new BufferedReader(new FileReader("EveryWord.txt"))) {
			while ((fileLine = br.readLine()) != null) {
				allEnglishWordsList.add(fileLine.toLowerCase());
			}
		}

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the string you want converted: ");
		String originalString = input.nextLine();
		String userString = originalString.toLowerCase();
		input.close();

		char[] userChars = userString.toCharArray();
		char[] originalChars = originalString.toCharArray();

		String morseString = "";
		String telephString = "";
		String brailleString1 = "";
		String brailleString2 = "";
		String brailleString3 = "";
		for (int x = 0; x < userChars.length; x++) {
			char userChar = userChars[x];

			if (userChar == ' ') {
				if (morseString == "") {
					morseString = " ";
					telephString = " ";
					brailleString1 = " ";
					brailleString2 = " ";
					brailleString3 = " ";
				}

				morseString = morseString.substring(0, morseString.length() - 1) + "    ";
				telephString = telephString.substring(0, telephString.length() - 1) + "    ";
				brailleString1 = brailleString1.substring(0, brailleString1.length() - 1) + "    ";
				brailleString2 = brailleString2.substring(0, brailleString2.length() - 1) + "    ";
				brailleString3 = brailleString3.substring(0, brailleString3.length() - 1) + "    ";
			}

			else {
				int alphaArrLen = alphaArr.length;
				int y = 0;
				boolean noMatch = true;
				for (; y < alphaArrLen; y++) {
					if (alphaArr[y] == userChar) {
						morseString = morseString + morseArr[y] + ",";
						telephString = telephString + telephoneArr[y] + ",";
						noMatch = false;
					}
				}
				if (noMatch) {
					morseString = morseString + userChar + ",";
					telephString = telephString + userChar + ",";
				}


				int alphaBrailleArrLen = alphaBrailleArr.length;
				boolean noBraille = true;
				int z = 0;
				for (; z < alphaBrailleArrLen; z++) {
					if (alphaBrailleArr[z] == userChar) {
						String userBraille = numberBrailleArr[z];

						if (Character.isUpperCase(originalChars[x])) {
							brailleString1 = brailleString1 + "oo,";
							brailleString2 = brailleString2 + "oo,";
							brailleString3 = brailleString3 + "o@,";
						}

						brailleString1 = brailleString1 + userBraille.substring(0, 2).replace("0", "o").replace("1", "@") + ",";
						brailleString2 = brailleString2 + userBraille.substring(2, 4).replace("0", "o").replace("1", "@") + ",";
						brailleString3 = brailleString3 + userBraille.substring(4, 6).replace("0", "o").replace("1", "@") + ",";
						noBraille = false;
					}
				}
				if (noBraille) {
					brailleString1 = brailleString1 + " ,";
					brailleString2 = brailleString2 + userChar + ",";
					brailleString1 = brailleString1 + " ,";
				}
			}
		}

		System.out.println("\nYour string in morse: \n" + morseString.substring(0, morseString.length() - 1));
		System.out.println();
		System.out.println("Your string in NATO: \n" + telephString.substring(0, telephString.length() - 1));
		System.out.println();
		System.out.println("Your string in braille:");
		System.out.println(brailleString1.substring(0, brailleString1.length() - 1));
		System.out.println(brailleString2.substring(0, brailleString2.length() - 1));
		System.out.println(brailleString3.substring(0, brailleString3.length() - 1));

		System.out.println();
		processPhoneWords(userString);
		System.out.println();
		processBinary(userString);
		System.out.println();
		processSemaphore(userString, alphaArr, semaphoreArr);
	}

	private static void processSemaphore(String userString, char[] alphaArr, String[] semaphoreArr) {
		System.out.println("Your string in semaphore:");
		String cleanedString = userString.replaceAll("[^a-zA-Z 0-9]", "");
		cleanedString = cleanedString.toLowerCase();
		cleanedString = cleanedString.replace("  ", " ");
		String[] cleanedArr = cleanedString.split("(?!^)");
		for (int x = 0; x < cleanedArr.length; x++) {
			String cleanedAlphaNum = cleanedArr[x];
			char[] userChars = cleanedAlphaNum.toCharArray();
			char userChar = userChars[0];

			if (cleanedAlphaNum.equals(" ")) {
				System.out.println("Right-hand: Down. Left-hand: Down."); //Space
			}
			else if (cleanedAlphaNum.matches("[0-9]+")) {

				//Check if we need to announce we are now using a number
				if (x == 0 || cleanedArr[x-1].matches("[a-zA-Z]+") || (x > 1 && cleanedArr[x-2].matches("[a-zA-Z]+") && cleanedArr[x-1].equals(" "))) {
					System.out.println("Right-hand: Up. Left-hand: Top left."); //#
				}

				for (int y = 0; y < alphaArr.length; y++) {
					if (alphaArr[y] == userChar) {
						System.out.println(semaphoreArr[y]);
						break;
					}
				}
			}
			else if (cleanedAlphaNum.matches("[a-zA-Z]+")) {

				//Check if we need to announce we are now using a letter
				if (x == 0 || cleanedArr[x-1].matches("[0-9]+") || (x > 1 && cleanedArr[x-2].matches("[0-9]+") && cleanedArr[x-1].equals(" "))) {
					System.out.println("Right-hand: Up. Left-hand: Left."); //Letter
				}

				for (int y = 0; y < alphaArr.length; y++) {
					if (alphaArr[y] == userChar) {
						System.out.println(semaphoreArr[y]);
						break;
					}
				}
			}
		}

	}

	private static void processBinary(String userString) {

		boolean binaryString = true;
		for (int i = 0; i < userString.length() && binaryString; i++) {
			char c = userString.charAt(i);
			if (c != '0' && c != '1' && c != ' ') {
				binaryString = false;
			}
		}


		if (binaryString) {
			userString = userString.trim();

			if (!userString.contains(" ")) {
				userString = insertPeriodically(userString, " ", 8);
			}

			String translation = "";

			try {
				for (int index = 0; index < userString.length(); index+=9) {
					String temp = userString.substring(index, index+8);
					int num = Integer.parseInt(temp,2);
					char letter = (char) num;
					translation = translation + letter;
				}

				System.out.print("Your binary in string:\n" + translation);
			}
			catch (StringIndexOutOfBoundsException ex) {
				System.out.println("Invalid binary. Added or missing numbers.");
			}
		}
		else {
			byte[] bytes = userString.getBytes();
			StringBuilder binary = new StringBuilder();
			for (byte b : bytes) {
				int val = b;
				for (int i = 0; i < 8; i++) {
					binary.append((val & 128) == 0 ? 0 : 1);
					val <<= 1;
				}
				binary.append(' ');
			}
			System.out.println("Your string in binary:\n" + binary);
		}
	}

	private static void processPhoneWords(String userString) {
		String cleanedString = userString.replaceAll("[^a-zA-Z0-9]", "");
		cleanedString = cleanedString.toLowerCase();
		String[] cleanedArr = cleanedString.split("(?!^)");

		if (cleanedString.matches("[0-9]+")) {
			getFittingWords(cleanedString, "");
		}
		else if (cleanedString.matches("[a-zA-Z]+")) {
			String number = "";

			for (int x = 0; x < cleanedArr.length; x++) {
				String xLetter = cleanedArr[x];

				for (int n = 0; n < letters.length; n++) {
					if (letters[n].contains(xLetter)) {
						number = number + numbers[n];
						break;
					}
				}
			}

			System.out.println("Your word converted to a phone number: " + number);
		}
	}
	private static void getFittingWords(String remainingNumber, String builtPhrase) {
		//System.out.println("Queue getFittingWords " + remainingNumber + " and " + builtPhrase);

		//Start comparing our remaining number to all English words to see if we can find a fit
		for (int engWordIndex = 0; engWordIndex < allEnglishWordsList.size(); engWordIndex++) {
			String potEngWord = allEnglishWordsList.get(engWordIndex);

			//We have a random English word whose length fits our remaining letters
			if (potEngWord.length() <= remainingNumber.length() && (potEngWord.length() > 1 || (potEngWord.equals("a") || potEngWord.equals("i")))) {

				String[] remainingNumberArr = remainingNumber.split("(?!^)");
				String[] potEngWordArr = potEngWord.split("(?!^)");

				boolean foundValidWord = true;
				//Loop thru the fitting English word, and check if its letters match our number's linked letters
				for (int n = 0; n < potEngWordArr.length; n++) {
					if (!letters[find(remainingNumberArr[n])].contains(potEngWordArr[n])) {
						foundValidWord = false;
						break;
					}
				}
				if (foundValidWord) {
					//System.out.println("This word fits " + potEngWord);

					//We found a fitting word, great! Let's subtract the letters from remainingNumber and add the letters to our built phrase 
					String backupRemainingNumber = remainingNumber.substring(potEngWord.length(), remainingNumber.length());
					String backupBuiltPhrase = builtPhrase + potEngWord + " ";


					//Are there no more letters remaining? Let's print out a finished phrase and not recursive again
					if (backupRemainingNumber.length() == 0) {
						System.out.println("Your phrase: " + backupBuiltPhrase);
					}

					else {
						//There are letters remaining, meaning we must go deeper!
						getFittingWords(remainingNumber.substring(potEngWord.length(), remainingNumber.length()), builtPhrase + potEngWord + " ");
					}
				}
			}
		}
	}

	// Generic function to find the index of an element in an object array in Java
	public static int find(String target)
	{//numbers.indexOf(remainingNumberArr[n])])
		for (int i = 0; i < numbers.length; i++)
			if (target.equals(numbers[i])) {
				//System.out.println("Found " + target + " with " + numbers[i] + " at " + i);
				return i;
			}
		return -1;
	}

	public static String insertPeriodically(String text, String insert, int period) {
		StringBuilder builder = new StringBuilder(text.length() + insert.length() * (text.length()/period)+1);

		int index = 0;
		String prefix = "";
		while (index < text.length()) {
			// Don't put the insert in the very first iteration.
			// This is easier than appending it *after* each substring
			builder.append(prefix);
			prefix = insert;
			builder.append(text.substring(index, Math.min(index + period, text.length())));
			index += period;
		}
		return builder.toString();
	}

}

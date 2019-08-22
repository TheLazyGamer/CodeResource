
public class BestPractices {
	public static void main(String[] argv) {
		String myDog = "Fat";
		boolean myDogIsFat = false;
		//Instead of...
		if (myDog.equals("Fat")) {
			myDogIsFat = true;
		}
		else {
			myDogIsFat = false;
		}

		//Do...
		myDogIsFat = myDog.equals("Fat");

		System.out.println(myDogIsFat);
	}
}

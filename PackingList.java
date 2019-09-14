import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PackingList {
	public static void main(String[] argv) {
		String[] stableItems = {"Toothpaste", "Electric Toothbrush", "Toothbrush", "Floss", "2 USB Cables",
				"Donut Charger", "Laptop", "Laptop Charger", "Headphones", "Chapstik", "Mouthwash",
				"Q-tips", "Gum Pick", "Wallet", "Keys", "Phone", "Toilet Paper",
				"Nail Clippers", "Comb", "Nightpants/Nightshorts", "Shoes", "Medicine/Drug Kit", "Shaver",
				"Belt", "Pants/Jeans", "Backup Battery Charged", "Glasses", "Glasses Case", "Travel Snacks",
				"Tip Money", "Jacket", "Handkerchiefs", "Deodorant", "Tissues", "Hand Sanitizer", "Trash Bag (dirty clothes)",
				"Rubberbands", "Wax", "WaterPik", "Retainers", "Toiletry Bag", "Tongue Brush", "Bank Travel Notice",
				"Computer Reboot and TeamViewer check", "Medications (if any)", "USB Flash Drive"};
		List<String> convertList = Arrays.asList(stableItems);
		ArrayList<String> finalList = new ArrayList<String>(convertList);
		Scanner input = new Scanner(System.in);

		System.out.println("How many nights are you staying?");
		int totalNights = input.nextInt();
		finalList.add((totalNights*2) + " Pairs of Underwear"); finalList.add((totalNights+1) + " Pairs of Socks");
		finalList.add((totalNights+1) + " Vitamins"); finalList.add((totalNights+1) + " Night Shirts");
		finalList.add((totalNights+1) + " Day Shirts");

		System.out.println("Will your destination be hot? true/false (adds Days Shorts)");
		boolean isHot = input.nextBoolean();
		if (isHot) {
			finalList.add((totalNights+1) + " Day Shorts");
		}

		System.out.println("Is this a business trip? true/false (adds Dress Shoes, Dress Shirts)");
		boolean isBusiness = input.nextBoolean();
		if (isBusiness) {
			finalList.add("Dress Shoes");
			finalList.add((totalNights+1) + " Dress Shirts");
		}

		System.out.println("Are you seeing your partner? true/false (adds Condoms, Lube)");
		boolean seeingPartner = input.nextBoolean();
		if (seeingPartner) {
			finalList.add("Condoms");
			finalList.add("Lube");
		}

		System.out.println("Going swimming? true/false (adds Swimsuit)");
		boolean isSwimming = input.nextBoolean();
		if (isSwimming) {
			finalList.add("Swimsuit");
		}

		System.out.println("Exercising? true/false (adds Gym Shorts, Exercise Shoes, Exercise Shirts)");
		boolean isExercising = input.nextBoolean();
		if (isExercising) {
			finalList.add((totalNights+1) + " Gym Shorts");
			finalList.add("Exercise Shoes");
			finalList.add((totalNights+1) + " Exercise Shirts");
		}

		System.out.println("Outdoors? true/false (adds Hat, Sunscreen)");
		boolean isOutdoors = input.nextBoolean();
		if (isOutdoors) {
			finalList.add("Hat");
			finalList.add("Sunscreen");
		}

		System.out.println("Will your room have toiletries? true/false (adds Shampoo and Conditioner, Body Wash)");
		boolean isToilet = input.nextBoolean();
		if (!isToilet) {
			finalList.add("Shampoo and Conditioner");
			finalList.add("Body Wash");
		}

		System.out.println("Are you driving? true/false (adds Water Bottle, Pocketknife, Nose Lotion ~else~ Plane Ticket)");
		boolean isDriving = input.nextBoolean();
		if (isDriving) {
			finalList.add("Water Bottle");
			finalList.add("Pocketknife (for needle)");
			finalList.add("Nose Lotion");
		}
		else {
			finalList.add("Plane Ticket");
			finalList.add("Google Calendar check in for arrival and departure");
		}

		System.out.println("Going international? true/false (adds Passport)");
		boolean isInternational = input.nextBoolean();
		if (isInternational) {
			finalList.add("Passport");
		}

		if (totalNights > 3) {
			finalList.add("Electric toothbrush charger");
		}


		Collections.sort(finalList);
		System.out.println();

		for (int x = 0; x < finalList.size(); x++) {
			System.out.println(finalList.get(x));
		}
		System.out.println();
		if (totalNights <= 3) {
			System.out.println("Don't bother bringing your electric toothbrush charger.");
		}
		System.out.println("Please manually include any special scenario items");
	}
}
//Made on 3/9/14

import java.util.Scanner;

public class Slots {
	public static void main(String[] argv){
		Scanner input = new Scanner(System.in);
		int credits = 100;
		int prize = 0;
		String output = ("");
		StringBuffer output1 = new StringBuffer(output);
		String all1 = new String("111");
		String all2 = new String("222");
		String all3 = new String("333");
		String all4 = new String("444");
		String all5 = new String("555");

		while (credits > 0) {
			System.out.println("Current credits: " + credits);
			System.out.println("Place your bet: ");
			int bet = input.nextInt();
			double a = Math.random();
			if (a < 0.01) {
				a = 0.01;
			}
			int aa = (int) (a * 100);
			int aaCount = 0;
			while (aaCount < aa) {
				double b = Math.random();
				aaCount++;
				if (aaCount == aa) {
					if (b < 0.3) {
						output1.insert(0, 1);
					} //INJECT 1 TO STRING

					else if (b > 0.3 && b <= 0.55) {
						output1.insert(0, 2);
					} //INJECT 2 TO STRING

					else if (b > 0.55 && b <= 0.75) {
						output1.insert(0, 3);
					} //INJECT 3 TO STRING

					else if (b > 0.75 && b <= 0.90) {
						output1.insert(0, 4);
					} //INJECT 4 TO STRING

					else if (b > 0.90 && b <= 1.00) {
						output1.insert(0, 5);
					} //INJECT 5 TO STRING

				} //end successful first number insert
			} //end first number entirely

			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			System.out.println(output1);

			double c = Math.random();
			if (c < 0.01) {
				c = 0.01;
			}
			int cc = (int) (c * 100);
			int ccCount = 0;
			while (ccCount < cc) {
				double d = Math.random();
				ccCount++;
				if (ccCount == cc) {
					if (d <= 0.3) {
						output1.insert(1, 1);
					} //INJECT 1 TO STRING

					else if (d > 0.3 && d <= 0.55) {
						output1.insert(1, 2);
					} //INJECT 2 TO STRING

					else if (d > 0.55 && d <= 0.75) {
						output1.insert(1, 3);
					} //INJECT 3 TO STRING

					else if (d > 0.75 && d <= 0.90) {
						output1.insert(1, 4);
					} //INJECT 4 TO STRING

					else if (d > 0.90 && d <= 1.00) {
						output1.insert(1, 5);
					} //INJECT 5 TO STRING

				} //end successful second number insert
			} //end second number entirely

			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			System.out.println(output1);

			double e = Math.random();
			if (e < 0.01) {
				e = 0.01;
			}
			int ee = (int) (e * 100);
			int eeCount = 0;
			while (eeCount < ee) {
				double f = Math.random();
				eeCount++;
				if (eeCount == ee) {
					if (f <= 0.3) {
						output1.insert(2, 1);
					} //INJECT 1 TO STRING

					else if (f > 0.3 && f <= 0.55) {
						output1.insert(2, 2);
					} //INJECT 2 TO STRING

					else if (f > 0.55 && f <= 0.75) {
						output1.insert(2, 3);
					} //INJECT 3 TO STRING

					else if (f > 0.75 && f <= 0.90) {
						output1.insert(2, 4);
					} //INJECT 4 TO STRING

					else if (f > 0.90 && f <= 1.00) {
						output1.insert(2, 5);
					} //INJECT 5 TO STRING

				} //end successful third number insert
			} //end third number entirely

			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			System.out.println(output1);
			String test = new String(output1);
			if (test.equals(all1)) {
				prize = prize + (bet * 10);
				credits += prize;
				System.out.println("We have a winner! You win " + prize + " credits!");
			}
			else if (test.equals(all2)) {
				prize = prize + (bet * 20);
				credits += prize;
				System.out.println("We have a winner! You win " + prize + " credits!");
			}
			else if (test.equals(all3)) {
				prize = prize + (bet * 30);
				credits += prize;
				System.out.println("We have a winner! You win " + prize + " credits!");
			}
			else if (test.equals(all4)) {
				prize = prize + (bet * 40);
				credits += prize;
				System.out.println("We have a winner! You win " + prize + " credits!");
			}
			else if (test.equals(all5)) {
				prize = prize + (bet * 50);
				credits += prize;
				System.out.println("We have a winner! You win " + prize + " credits!");
			}

			output1.delete(0, output1.length());
			credits = credits - bet;
			prize = 0;
			System.out.println();

			try {
				Thread.sleep(500);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		} //end complete slot cycle

		input.close();
	}
}
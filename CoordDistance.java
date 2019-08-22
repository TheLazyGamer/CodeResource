import java.util.Scanner;

public class CoordDistance {
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter x1 and y1");
		String coords1 = input.nextLine();
		double x1 = Double.parseDouble(coords1.substring(0, coords1.indexOf(" ")));
		double y1 = Double.parseDouble(coords1.substring(coords1.indexOf(" "), coords1.length()));
		System.out.println("Enter x2 and y2: ");
		String coords2 = input.nextLine();
		input.close();
		double x2 = Double.parseDouble(coords2.substring(0, coords2.indexOf(" ")));
		double y2 = Double.parseDouble(coords2.substring(coords2.indexOf(" "), coords2.length()));
		System.out.println("The distance between the two points is " + Math.sqrt((Math.pow(x2 - x1,  2)) + (Math.pow(y2 - y1, 2))));
	}
}
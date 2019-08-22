public class ConvertRGB {
	public static void main(String[] argv) {
		int r = 45;
		int g = 101;
		int b = 12;

		String hex = String.format("0x%02X%02X%02X", r, g, b);
		System.out.println(hex);

		int decimal = (r * 65536) + (g * 256) + b;
		System.out.println("" + decimal);
	}
}
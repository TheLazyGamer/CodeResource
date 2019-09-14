import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class GetPixelRGBColor {
	public static void main(String[] argv) throws AWTException {
		Robot bot = new Robot();
		while(true) {
			System.out.println(MouseInfo.getPointerInfo().getLocation());
			Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			double x = mouseLoc.getX();
			double y = mouseLoc.getY();
			System.out.println("x " + x);
			System.out.println("y " + y);
			int newPixel = capture.getRGB((int) x, (int) y);
			printPixelARGB(newPixel, bot);
		}
	}


	public static void printPixelARGB(int pixel, Robot bot) {
		int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);

		if (red == 0 && green == 153 && blue == 0) {
			bot.keyPress(KeyEvent.VK_SPACE); bot.keyRelease(KeyEvent.VK_SPACE);
		}
		sleepMode(1000);
	}


	public static void sleepMode(int pauseLen) {
		try {
			Thread.sleep(pauseLen);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}
}

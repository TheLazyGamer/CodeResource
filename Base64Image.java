import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Base64Image {
	public static void main(String[] argv) throws IOException {
		String imageDir = "Image.png";
		BufferedImage originalImage = ImageIO.read(new File(imageDir));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		String encoded = Base64.getEncoder().encodeToString(imageInByte);
		//change image/png to image/jpg or image/jpeg depending on converted image type
		String html = "	<img style=\"display:block; width:600px;\" class=\"b64img\" src=\"data:image/png;charset=utf-8;base64," + encoded + "\"/>";
		System.out.println(html);
	}
}

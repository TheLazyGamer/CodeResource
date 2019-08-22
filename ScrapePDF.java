import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

//Look into iText vs Apache pdfbox (which is what this uses pdfbox-app-2.0.4.jar)
public class ScrapePDF {
	public static void main(String[] argv) throws FileNotFoundException, IOException {
		File file = new File("nutritionfacts.pdf");
		PDFParser parser = new PDFParser(new RandomAccessFile(file,"r")); // update for PDFBox V 2.0

		parser.parse();
		COSDocument cosDoc = parser.getDocument();
		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);
		pdDoc.getNumberOfPages();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(22);

		// reading text from page 1 to 10
		// if you want to get text from full pdf file use this code
		// pdfStripper.setEndPage(pdDoc.getNumberOfPages());

		String output = pdfStripper.getText(pdDoc);
		System.out.println(output);
	}
}
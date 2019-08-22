import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SimpleFileChooser {
	public static void main(String[] argv) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			File testFile = fileChooser.getCurrentDirectory();
			System.out.println(selectedFile.getName());
			System.out.println(testFile);
			System.out.println(testFile.getName());
		}
	}
}

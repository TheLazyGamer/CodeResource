import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DeleteFilesAndFolders {
	public static void main(String[] argv) throws IOException {
		//deleting old files in main directory
		ArrayList<String> oldFileNamesList = new ArrayList<String>();
		oldFileNamesList.add("_PortUsage"); oldFileNamesList.add("LoadResponseTests"); oldFileNamesList.add("Portal_Report");
		File[] filesArr = new File(".").listFiles();
		for (int i = 0; i < filesArr.length; i++) {
			if (filesArr[i].isFile()) {
				String fileName = filesArr[i].getName();
				for (int x = 0; x < oldFileNamesList.size(); x++) {
					if (fileName.contains(oldFileNamesList.get(x))) {
						Path p = Paths.get(fileName);
						Files.deleteIfExists(p);
					}
				}
			}
		}

		//Deleting temp files
		String dataFolder = System.getenv("APPDATA");
		dataFolder = dataFolder.substring(0, dataFolder.lastIndexOf("\\")) + "\\Local\\Temp\\";
		File[] tempFilesArr = new File(dataFolder).listFiles();

		for (int x = 0; x < tempFilesArr.length; x++) {
			String tempDirectory = tempFilesArr[x].getName();
			if ((tempDirectory.contains("anonymous") && tempDirectory.contains("webdriver-profile")) || (tempDirectory.contains("userprofile") && tempDirectory.contains("copy"))) {
				deleteDirectory(new File(dataFolder + tempDirectory));
			}
			else if (tempDirectory.contains("screenshot")) {
				if (tempFilesArr[x].isFile()) {
					Path p = Paths.get(dataFolder + tempDirectory);
					Files.deleteIfExists(p);
				}
			}
		}
	}


	public static boolean deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDirectory(children[i]);
				if (!success) {
					return false;
				}
			}
		}
		/* either file or an empty directory*/
		System.out.println("removing file or directory : " + dir.getName());
		return dir.delete();
	}
}

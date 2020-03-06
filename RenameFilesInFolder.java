// Java program to illustrate 
// how to rename Multiple Files 
// together using single program 
import java.io.File; 
import java.io.IOException; 

public class RenameFilesInFolder 
{ 
	public static void main(String[] argv) throws IOException 
	{ 
		// Path of folder where files are located 
		String folder_path = 
				"C:\\Users\\USERNAME\\Music"; 

		// creating new folder 
		File myfolder = new File(folder_path); 

		File[] file_array = myfolder.listFiles(); 
		for (int i = 0; i < file_array.length; i++) 
		{ 

			if (file_array[i].isFile()) 
			{ 

				File myfile = new File(folder_path + "\\" + file_array[i].getName()); 
				String oldFileName = file_array[i].getName();
				System.out.println(oldFileName); 
				String oldFileType = oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
				oldFileName = oldFileName.substring(0, oldFileName.lastIndexOf("."));
				String newFileName = oldFileName.replaceAll("_", " ").replaceAll("[^A-Za-z0-9]", "_");
				while (newFileName.contains("__")) {
					newFileName = newFileName.replace("__", "_");
				}

				System.out.println(newFileName + oldFileType); 
				System.out.println();

				myfile.renameTo(new File(folder_path +  "\\" + newFileName + oldFileType)); 
			} 
		} 
	} 
} 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessYoutubePlaylist {
	public static void main(String[] argv) throws IOException {
		String fileLine = "";

		boolean atNewVid = false;
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/USERNAME/Documents/playlist.html"))) {
			while ((fileLine = br.readLine()) != null) {
				if (atNewVid) {
					if (fileLine.contains("watch?v=")) {
						fileLine = fileLine.substring(fileLine.indexOf("/watch"), fileLine.indexOf("&amp;"));
						System.out.println("https://www.youtube.com" + fileLine);

						atNewVid = false;
					}
				}
				else {
					if (fileLine.contains("<yt-formatted-string id=\"index\" class=\"style-scope ytd-playlist-video-renderer\">")) {
						atNewVid = true;
					}
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

public class ConvertToCurl {
	public static void main(String[] argv) throws IOException {
		String resultLine = "";
		URL apiUrl = new URL("https://www.example.org/");
		HttpsURLConnection apiCon = (HttpsURLConnection) apiUrl.openConnection();
		apiCon.setRequestProperty("Accept", "application/xml");
		apiCon.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		InputStream apiInStream = apiCon.getInputStream();
		InputStreamReader apiInStreamReader = new InputStreamReader(apiInStream);
		BufferedReader apiBufRead = new BufferedReader(apiInStreamReader);

		while ((resultLine = apiBufRead.readLine()) != null) {
			System.out.println(resultLine);
		}

		int code = apiCon.getResponseCode();
		System.out.println(code);
		apiCon.disconnect();
		apiBufRead.close();

		System.out.println(toCurlRequest(apiCon, null));
	}

	public static String toCurlRequest(HttpsURLConnection connection, byte[] body) {
		StringBuilder builder = new StringBuilder("curl -v ");

		// Method
		builder.append("-X ").append(connection.getRequestMethod()).append(" \\\n  ");

		// Headers
		for (Entry<String, List<String>> entry : connection.getRequestProperties().entrySet()) {
			builder.append("-H \"").append(entry.getKey()).append(":");
			for (String value : entry.getValue()) {
				builder.append(" ").append(value);
			}
			builder.append("\" \\\n  ");
		}

		// Body
		if (body != null)
			builder.append("-d '").append(new String(body)).append("' \\\n  ");

		// URL
		builder.append("\"").append(connection.getURL()).append("\"");

		return builder.toString();
	}
}


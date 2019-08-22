import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SimpleHTTPGets {
	public static void main(String[] argv) {
		runHttpConnection();
		System.out.println();
		runHttpsConnection();
	}

	private static void runHttpConnection() {
		String resultLine = "";
		String apiCall = "http://www.example.org";

		try {
			URL apiUrl = new URL(apiCall);
			HttpURLConnection apiCon = (HttpURLConnection) apiUrl.openConnection();
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
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void runHttpsConnection() {
		String resultLine = "";
		String apiCall = "https://www.example.org";

		try {
			URL apiUrl = new URL(apiCall);
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
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
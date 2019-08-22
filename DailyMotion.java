import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
 
import javax.net.ssl.HttpsURLConnection;
 
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
 
public class DailyMotion {
    public static void main(String[] argv) {
 
        String username = "CHANGE_ME";
        int pageCounter = 1;
 
 
        while (true) {
 
            String apiCall = "https://api.dailymotion.com/user/" + username + "/videos?limit=100&page=" + pageCounter;
            String resultLine = "";
 
            String apiOutput = "";
            try {
                URL apiUrl = new URL(apiCall);
                HttpsURLConnection apiCon = (HttpsURLConnection) apiUrl.openConnection();
 
                apiCon.setRequestProperty("Accept", "application/xml");
                apiCon.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
 
                InputStream apiInStream = apiCon.getInputStream();
                InputStreamReader apiInStreamReader = new InputStreamReader(apiInStream);
                BufferedReader apiBufRead = new BufferedReader(apiInStreamReader);
 
                while ((resultLine = apiBufRead.readLine()) != null) {
                    //System.out.println(resultLine);
                    apiOutput = apiOutput + resultLine;
                }
 
                apiCon.disconnect();
                apiBufRead.close();
 
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
 
            apiOutput = apiOutput.trim();
 
            JsonObject apiJson = convertAPIOutputToJson(apiOutput);
 
 
            JsonArray videosArr = apiJson.getJsonArray("list");
 
            for (int x = 0; x < videosArr.size(); x++) {
                JsonObject video = videosArr.getJsonObject(x);
 
                String videoID = video.getString("id");
                String videoTitle = video.getString("title").toLowerCase();
 
                if (videoTitle.contains("CHANGE_ME")) {
                    System.out.println("https://www.dailymotion.com/video/" + videoID);
                }
 
            }
 
            if (apiOutput.contains("\"has_more\":true")) {
                pageCounter++;
                sleepMode(1000);
            }
            else {
                break;
            }
        }
 
    }
 
 
    private static JsonObject convertAPIOutputToJson(String apiString) {
        //System.out.println("Starting convertAPIOutputToJson");
 
        JsonReader apiReader = Json.createReader(new StringReader(apiString));
        JsonObject apiObject = apiReader.readObject();
        apiReader.close();
 
        //System.out.println("Ending convertAPIOutputToJson");
        return apiObject;
    }
 
    public static void sleepMode(int pauseLen) {
        try {
            Thread.sleep(pauseLen);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
 
    }
}
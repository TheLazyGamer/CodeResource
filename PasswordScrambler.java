import java.util.ArrayList;
import java.util.Random;
 
public class PasswordScrambler {
    public static void main(String[] argv) {
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> passwords = new ArrayList<String>();
       
        values.add("Word!");
        values.add("Example");
        values.add("TheTest!");
        values.add("PlaceHolder");
        values.add("SampleText!");
        values.add("LoremIpsum");
       
        values.add("345567");
        values.add("345678");
        values.add("857962354");
        values.add("23546");
        values.add("22567645");
        values.add("7980");
        values.add("4563");
 
        for (int x = 0; x < 10000; x++) {
            Random r = new Random();
            int randInt = Math.abs(r.nextInt()) % 6; //Generate how many words/numbers
            if (randInt > 1) {
                String makingPW = "";
                for (int n = 0; n < randInt; n++) {
                    int randEle = Math.abs(r.nextInt()) % 13;
                    makingPW = makingPW + values.get(randEle);
                }
                if (!passwords.contains(makingPW) && (makingPW.contains("4") || makingPW.contains("0")) && makingPW.length() < 25 && makingPW.length() > 12) {
                    passwords.add(makingPW);
                }
            }
        }
 
        for (int x = 0; x < passwords.size(); x++) {
            System.out.println(passwords.get(x));
        }
 
    }
}
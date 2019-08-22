import java.io.UnsupportedEncodingException;

public class DecodeURLHex {
	public static void main(String[] argv) throws UnsupportedEncodingException {
		String myToken = "%246pZlJ2dWYmnadTqp6P5kkqr%24tOa8%28%26%2AA4";
		myToken = java.net.URLDecoder.decode(myToken, "UTF-8");
		System.out.println(myToken);
		//spits out $6pZlJ2dWYmnadTqp6P5kkqr$tOa8(&*A4
	}
}

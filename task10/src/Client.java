import java.util.Random;

/** Class-simulator of the client that genereates a requests to server for response delay
 * @version 1.0
 */
public class Client {
	/** Min an max values of delay */
	private final int MIN_VALUE = 10;
	private final int MAX_VALUE = 500;
  
	/** Emulates sending request to server
	 * @return ping in ms
	 */
	public int sendRequest() {
		Random random = new Random();
		return random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
	}
}


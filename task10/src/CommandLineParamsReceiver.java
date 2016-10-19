import java.util.ArrayList;

/** Receives a params from command line
 * @version 1.0
 */
public class CommandLineParamsReceiver {
	/** Array of ip-addresses, will be return with values of ip-addesses */
	private ArrayList<String> ipAddresses;
	
	/** Takes params from command-line
	 */
	public CommandLineParamsReceiver(String[] args) {
		for (int i = 0; i < ipAddresses.size(); i++) {
			ipAddresses.add(args[i]);
		}
	}
	
	public ArrayList<String> getAddr() {
		return ipAddresses;
	}
}

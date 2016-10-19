
/** Class-server simulator
 * @version 1.0
 */
public class Server {
	/** Field-property, contains an ip-address*/
	private String ipAddress;
	/**
	 * Constructs a valid ip-address
	 * @param _ipAddress - ip address
	 * @throws Exception if ip is not valid
	 */
	public Server(String _ipAddress) throws Exception {
		final String PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5]) +" +
								"\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		if (!_ipAddress.matches(PATTERN)) {
			throw new Exception("IP address is invalid");
		}
		ipAddress = _ipAddress;
	}
	
	/** Gets an ipAddress
	 * @return ipAddress - address of server
	 */
	public String getIP() {
		return ipAddress;
	}
}

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/** An entry point to application, forms list of servers, delays, html table
 *  and writes all info into .html file
 *  @version 1.0
 */
public class Runner {
	/** Gets the info about servers and delays and writes them into .html file
	 * @throws IOException - if errors while writing file occurs
	 * @param args command line arguments, a source of information
	 */
	public static void main(String[] args) {
		CommandLineParamsReceiver listOfIP = new CommandLineParamsReceiver(args);
		ArrayList<Server> serversList = getServers(listOfIP.getAddr());
		int[] responseTimes = getResponses(serversList);
		int maxResponse = getMaxResponse(responseTimes);
		HTMLBuilder table = new HTMLBuilder();

		for (int i = 0; i < serversList.size(); i++) {
			table.addRow(serversList.get(i).getIP(), responseTimes[i],
						responseTimes[i] == maxResponse);
		}

		File responsesFile = new File("responses.html");
		try {
			table.saveToFile(responsesFile);
		} catch (IOException e) {
			System.out.print("An I/O error occurred. Can't save to this file");
		}
	}

	/** Forms a list of servers
	 * @param ipAddresses list of ip-addresses
	 * @return list of servers
	 */
	public static ArrayList<Server> getServers(ArrayList<String> ipAddresses) {
		ArrayList<Server> serversList = new ArrayList<>();
		for (String ip : ipAddresses) {
			try {
				serversList.add(new Server(ip));
			} catch (Exception e) {
				System.out.println(e.getMessage() + ip);
			}
		}
		return serversList;
	}

	/** Sends requests to the server, gets count of responces
	 * @param serversList list of servers
	 * @return array of responses in ms
	 */
	public static int[] getResponses(ArrayList<Server> serversList) {
		int[] responseTimes = new int[serversList.size()];
		Client responceSimulator = new Client();
		for (int i = 0; i < serversList.size(); i++) {
			responseTimes[i] = responceSimulator.sendRequest();
		}
		return responseTimes;
	}

	/** Calculates max response from list of responses
	 * @param responseTimes array of responses
	 * @return max value
	 */
	public static int getMaxResponse(int[] responseTimes) {
		int maxResponse = 0;
		for (int response : responseTimes) {
			if (response > maxResponse) {
				maxResponse = response;
			}
		}
		return maxResponse;
	}
}
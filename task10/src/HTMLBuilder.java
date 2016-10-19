import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** Class-builder of a HTML file.
 */
public class HTMLBuilder {
	/** Fields-color constants */
	private static final String MEDIUM_GREY_COLOR = "rgb(239,239,239)";
	private static final String LIGHT_GREY_COLOR = "rgb(247,247,247)";
	private static final String RED_COLOR = "rgb(255,0,0)";
	/** Field-container of header and footer mark-up */
	private static final String HEADER = "<html>\n"
			+ "<head>\n"
			+ "<meta charset=\"utf-8\">\n"
			+ "<title>Contents</title>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "<table style=\"border-collapse:collapse\" border=1 bordercolor=white>\n"
			+ "<col width=\"150\">"
			+ "<col width=\"150\">"
			+ "<tr style=\"background-color : rgb(206,206,206)\">\n"
			+ "<td style=\"text-align:center\">Server</td>\n"
			+ "<td style=\"text-align:center\">Response, ms</td>\n"
			+ "</tr>\n";
	private static final String FOOTER = "</table> \n" + "</body>\n" + "</html>";
	private ArrayList<String> table = new ArrayList<>();

	/** Adds a row into the table
	 * @param ipAddress - the address of a server
	 * @param responseTime - response time of a server
	 * @param isMaxResponse - if it is true than the row will be highlighted in red
	 */
	public void addRow(String ipAddress, int responseTime, boolean isMaxResponse) {
		String color;
		if (isMaxResponse) {
			color = RED_COLOR;
		} else if (table.size() % 2 == 0) {
			color = MEDIUM_GREY_COLOR;
		} else {
			color = LIGHT_GREY_COLOR;
		}
		String newRow =
				"<tr style=\"background-color : " + color + "\">\n" + "<td>" + ipAddress + "</td>\n"
						+ "<td>" + responseTime + "</td>\n" + "</tr>\n";
		table.add(newRow);
	}

	/** Saves the finalized table into file
	 * @param file a file where table should be saved
	 * @throws IOException when I/O error occurred
	 */
	public void saveToFile(File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(HEADER);
		for (String row : table) {
			bw.write(row);
		}
		bw.write(FOOTER);
		bw.close();
	}
}
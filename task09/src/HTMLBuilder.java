/** Following class builds a HTML table with
 * information about the files in current directory
 * @version 1.0
 */
public class HTMLBuilder {
	
	/** Head of the table, it's constant */
	private final String HEADER = "<html>" +
            "<head>" +
            "<meta charset=\"utf-8\"> " +
            "<title>Info about files in your current directory</title>" +
            "</head>" +
            "<body>" +
            "<table border=\"0\"  align=\"center\" >\n" +
            "<tr bgcolor=\"#cecfce\" align=\"center\" valign=\"top\" >\n" +
            "<th width=\"20%\" >ИМЯ</th>\n" +
            "<th width=\"20%\">ТИП</th>\n" +
            "<th width=\"20%\">ДАТА <br> СОЗДАНИЯ</th>\n" +
            "<th width=\"20%\">РАЗМЕР (в Kb)</th>\n" +
            "</tr>";
	/** Footer of the table, constant too */
	private final String FOOTER = "</table>" +
	        "</body>" +
	        "</html>";
	/** Field-container of the final HTML table */    
	private String html = HEADER;
    /** Field-switcher of the color of the row in the table */
    private boolean colorSwitcher = true;

    /** This method adds a new row in the table
     * @param name - name of the file/directory
     * @param type - type of the file
     * @param date - creation date of the file
     * @param size - size of the file/directory (also contains the size of the subdirectories)
     */
    public void addRow(String name, String type, String date, long size) {
        if (colorSwitcher) {
            html += "<tr bgcolor=\"#efefef\">\n";
        } else {
            html += "<tr bgcolor=\"#f7f7f7\">\n";
        }
            html += "<td>" + name + "</td>\n"
                    + "<td>" + type + "</td>\n"
                    + "<td>" + date + "</td>\n"
                    + "<td>" + size + "</td>\n"
                    + "</tr>\n";
        colorSwitcher = !colorSwitcher;
    }

    /** This method gets a full HTML table 
     * @return HTML mark-up of the table
     */
    public String getResult() {
        return html + FOOTER;
    }
}

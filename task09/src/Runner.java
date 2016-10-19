import java.io.*;

/** An entry point of the application, generates a HTML table 
 * with information about files in current directory
 * @version 1.0
 */
public class Runner {
    /** Main method of the application, generates a HTML table, output .html file
     * and fills this table information 
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"));   
        File outputFile = new File("output.html");
        HTMLBuilder table = new HTMLBuilder();
        fillTheTable(file, table);
        saveToFile(outputFile, table.getResult());
    }
    
    /** Method, that fill the table information from the current directory
     * @param file - files in current directory
     * @param table - template of the table
     */
    private static void fillTheTable(File file, HTMLBuilder table) {
    	File[] filesList = file.listFiles();
        for (File fileInDirectory : filesList) {
            FileStorage provider = new FileStorage(fileInDirectory);
            table.addRow(fileInDirectory.getName()
                                  , provider.getType()
                                  , provider.getDateOfCreation()
                                  , provider.getSize() / 1024);
        }
    }

    /** Method generates output file and saves to this file information about files
     * and catches an exceptions, such as unexisting the file, or incorrect encoding
     * @throws FileNotFoundException, UnsupportedEncodingException
     * @param file - output file, where the information saves
     * @param information - final template, contains all info about files
     */
    private static void saveToFile(File file, String information) {
        try {
            String encoding = System.getProperty("console.encoding", "utf-8");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(file), encoding));
            pw.write(information);
            pw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error while writing file.");
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/** Class, that stores a file attributes and provides methods to work with it
 * @version 1.0
 */
public class FileStorage {
   
	/** Enumeration that contains probably variations of type of the file */
	private enum Type {
    	FILE, DIR, OTHER
    }
    /** A File class example, provides information about the file */
    private File file;

    /** This constructor creates a new object 
     * @param file - file to provide information about.
     */
    public FileStorage(File file) {
        this.file = file;
    }

    /** A method, that gets a date of creation of file
     * @throws IOException
     * @return normalized date
     */
    public String getDateOfCreation() {
        Path path = file.toPath();
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime time = attributes.creationTime();
            return formalizeDate(time);
        } catch (IOException ex) {
            return "";
        }
    }

    /** Method gets size of the file, if current file is folder, 
     * method counts size of containing subfolders too
     * @return size of file in bytes.
     */
    public long getSize() {
        long size = 0;
        if (file.isDirectory()) {
            File[] filesList = file.listFiles();
            for (File fileInDirectory : filesList) {
                size += new FileStorage(fileInDirectory).getSize();
            }
            return size;
        }
        return file.length();
    }

    /** Method gets a type of the file
     * @return DIR if directory, FILE if file,
     * OTHER if not directory or file.
     */
    public String getType() {
        if (file.isDirectory()) {
            return Type.DIR.toString();
        }
        if (file.isFile()) {
            return Type.FILE.toString();
        }
        return Type.OTHER.toString();
    }

    /** This method normalizes date in DD.MM.YYYY
     * @param fileTime - time to normalize
     * @return date - normal date format
     */
    private static String formalizeDate(FileTime fileTime) {
        String date = fileTime.toString()
                .substring(0, fileTime.toString().indexOf('T'));
        int separatorIndex = date.indexOf('-');
        String formalizedDate = "";
        while (separatorIndex != -1) {
            formalizedDate = "." + date.substring(0, separatorIndex) + formalizedDate;
            date = date.substring(separatorIndex + 1, date.length());
            separatorIndex = date.indexOf('-');
        }
        return date + formalizedDate;
    }
}
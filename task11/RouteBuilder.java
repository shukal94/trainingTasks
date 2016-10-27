import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Builds a route from a checkpoints
 * @version 1.0
 * @author shukal
 */
public class RouteBuilder {
	/**Field-container of set of points*/
	private ArrayList<Point> route = new ArrayList<Point>();
	
	/**
	 * Builds a route from checkpoints in the file
	 * @param fileName - file where checkpoints are contains
	 * @throws IOException - if IO error occurs
	 * @return a route
	 */
	public ArrayList<Point> buildRoute(File checkpointFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(checkpointFile));
		String currentLine;
	    while (((currentLine = reader.readLine()) != null)) {
	    	String[] lineParts = currentLine.split("\\s+");
	    	if (lineParts.length != 2) {
	    		System.out.println("Invalid number of coordinates on line: " + currentLine);
	    		System.out.println("This line will be ignored");
	    		continue;
	    	}
	    	double x;
	    	double y;
	    	try {
	    		x = Double.parseDouble(lineParts[0]);
	    		y = Double.parseDouble(lineParts[1]);
	    		route.add(new Point(x, y));
	    	} catch (NumberFormatException e) {
	    		System.out.println("Invalid input: not a number as coordinate on line: " + currentLine);
	    		System.out.println("This line will be ignored");
	    	}
	    }
	    if (route.size() < 2 || route.get(0)
	    		.equals(route.get(route.size() - 1))) {
	   	   System.exit(0);
	    }
		return route;
	}
}

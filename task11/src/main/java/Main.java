import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Contains an entry point of the application
 */
public class Main {
	/**
	 * Entry point of application
	 * @param args - command line args
	 */
	public static void main(String[] args) {
		RouteBuilder builder = new RouteBuilder();
		File routeFile = new File("points.txt");
		ArrayList<Point> checkpointsList = new ArrayList<Point>();

		try {
			checkpointsList = builder.buildRoute(routeFile);
		}	catch(BadRouteException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}	catch (IOException e) {
			System.out.println("I/O error occurred, can't read the file");
			System.exit(1);
		}

		TravelStatProvider travelStatProvider =
				new TravelStatProvider().add(new Bicycle()).add(new Walker()).add(new Car()).add(new Bus());

		travelStatProvider.goOnRoute(checkpointsList);
		travelStatProvider.getStatistics();
	}
}
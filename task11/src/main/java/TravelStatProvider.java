import java.util.ArrayList;

/**
 * Class that performs the travel along the route and prints out the needed statistics about the travel
 * 
 * @version 1.1
 * @author shukal
 */
public class TravelStatProvider {
	ArrayList<Movable> vehicles = new ArrayList<Movable>();

	/**
	 * Adds a vehicle to list
	 *
	 * @param traveller vehicle to add
	 * @return this object
	 */
	public TravelStatProvider add(Movable vehicle) {
		vehicles.add(vehicle);
		return this;
	}

	/**
	 * Realizes going along the route
	 *
	 * @param route list of checkpoints
	 */
	public void goOnRoute(ArrayList<Point> route) {
		for (Movable t : vehicles) {
			t.setStartingPoint(route.get(0));
		}
		for (int i = 1; i < route.size(); i++) {
			for (Movable t : vehicles) {
				try {
					t.move(route.get(i));
				}	catch(OutOfDoubleException ex) {
					break;
				}
			}
		}
	}
	
	/**
	 * Prints a statistics about moving
	 */
	public void getStatistics() {
		for (Movable t : vehicles) {
			System.out.println(t.getName() + ": ");
			System.out.println("Travel time: " + t.getTime() + " hours");
			System.out.println("Travel cost: " + t.getCost() + " USD");
		 }
	}
}
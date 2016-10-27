import java.util.ArrayList;

/**
 * Class that performs the travel along the route and prints out the needed statistics about the travel
 */
public class TravelBuilder {
	ArrayList<Movable> vehicles = new ArrayList<>();

	/**
	 * Adds a vehicle to list
	 *
	 * @param traveller vehicle to add
	 * @return this object
	 */
	public TravelBuilder add(Movable vehicle) {
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
				t.move(route.get(i));
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
/**
 * Describes a moving of car
 * 
 * @version 1.1
 * @author shukal
 */
public class Car implements Movable {
	private final double FUEL_COST = 0.5;
	private double distance = 0;
	private Point currentPoint;
	private Point startPoint;
	private final int NUMBER_OF_PASSENGERS = 4;
	/** Speed in km/h */
	private final double SPEED = 120;
	/**
	 * Fuel consumption liter/100 km
	 */
	private final double FUEL_CONSUMPTION = 6.5;

	/**
	 * Sets the start point
	 * @param pt - start point
	 */
	@Override
	public void setStartingPoint(Point pt) {
		startPoint = pt;
		currentPoint = startPoint;
	}
	/**
	 * Moves an object along the route from a starting point
	 * @param pt - starting point
	 */
	@Override
	public void move(Point nextPoint) {
		distance += currentPoint.getDistanceBetweenPoints(nextPoint);
		currentPoint = nextPoint;
	}
	
	@Override
	public double getTime() {
		return distance / SPEED;
	}
	
	/**
	 * Calculates travel cost and divides it by the number of passengers
	 * @return travel cost for a single passenger
	 */
	@Override
	public double getCost() {
	    return distance * FUEL_COST * FUEL_CONSUMPTION / 100 * NUMBER_OF_PASSENGERS;
	}
	
	@Override
	public String getName() {
		return "Traveling by a car";
	}
}

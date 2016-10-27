/**
 * Describes a moving of bicycle
 * 
 * @version 1.0
 * @author shukal
 */
public class Bicycle implements Movable {
	private double distance = 0;
	private Point currentPoint;
	private Point startPoint;
	/** Speed in km/h */
	private double speed = 20;
	
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
	
	/**
	 * @return time of moving
	 */
	@Override
	public double getTime() {
		return distance / speed;
	}
	
	/**
	 * Calculates travel cost and divides it by the number of passengers
	 * @return travel cost for a single passenger
	 */
	@Override
	public double getCost() {
	    return 0;
	}
	
	/**
	 * @return name of vehicle
	 */
	@Override
	public String getName() {
		return "Traveling by bike-tour";
	}
}

/**
 * Describes a moving of walker
 * 
 * @version 1.0
 * @author shukal
 */
public class Walker implements Movable {
	private double speed = 3.5;
	private double distance = 0;
	private Point currentPoint;
	private Point startPoint;
	
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
	 * @return cost of moving
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
		return "Traveling by walk on";
	}
}

/**
 * Describes a moving of bicycle
 * 
 * @version 1.1
 * @author shukal
 */
public class Bicycle implements Movable {
	private double distance = 0;
	private Point currentPoint;
	private Point startPoint;
	/** Speed in km/h */
	private final double SPEED = 20;
	
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
	
	@Override
	public double getCost() {
	    return 0;
	}
	
	@Override
	public String getName() {
		return "Traveling by bike-tour";
	}
}

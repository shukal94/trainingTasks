/**
 * Describes a some object that able to move
 * @version 1.0
 * @author shukal
 */
public interface Movable {
	String getName();
	/**
	 * Sets the start point
	 * @param pt - start point
	 */
	void setStartingPoint(Point pt);
	
	/**
	 * Moves an object along the route from a starting point
	 * @param pt - next point
	 */
	void move(Point pt);
	
	/**
	 * @return time of moving
	 */
	double getTime();
	
	/**
	 * @return cost of moving
	 */
	double getCost();
}

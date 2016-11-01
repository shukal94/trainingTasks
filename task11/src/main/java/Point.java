/**
 * Stores information about checkpoint
 * @version 1.0
 * @author shukal
 */
public class Point {
	/**Fields-containers of coordinates*/
	private double x;
	private double y;
	
	/**
	 * Constructs an exemplar of point
	 * @param x - x-axis coordinate
	 * @param y - y-axis coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** 
	 * @return x - x-coordinate of point
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * return y - y-coordinate of point
	 */
	public double getY() {
		return y;
	}
	
	/**
	   * Calculates distance between two checkpoints
	   *s
	   * @param c checkpoint for calculation
	   * @return distance
	   */
	  public double getDistanceBetweenPoints(Point pt) {
	    double xDistance = Math.abs(this.x - pt.x);
	    double yDistance = Math.abs(this.y - pt.y);
	    return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
	}
	
	/**
	 * Checks for equality between the different points
	 * @param pt - point where comparing will be
	 * @return true if points are equal, false if not
	 */
	public boolean equals(Point pt) {
		return (this.x == pt.x && this.y == pt.y);
	}
}

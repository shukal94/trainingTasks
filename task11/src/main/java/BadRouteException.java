/**
 * Generates an exception, when route contains only one check point
 * or start and end checkpoints are equal
 * 
 * @version 1.0
 * @author shukal
 *
 */
public class BadRouteException extends Exception {
	public BadRouteException() {
		super("Bad route, please - reenter your checkpoints");
	}
}

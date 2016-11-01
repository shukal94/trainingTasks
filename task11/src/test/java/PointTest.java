import static org.testng.Assert.*;

import org.testng.annotations.Test;


public class PointTest {
	@Test
	public void testGetDistanceBetweenPointsMoreOrEqualsZero() {
		Point startPoint = new Point(0, 0);
		Point currentPoint = new Point(1, 2);
		assertTrue(startPoint.getDistanceBetweenPoints(currentPoint) >= 0);
	}
	
	@Test
	public void testMoveOutOfDouble() {
		Point startPoint = new Point(0, 0);
		Point currentPoint = new Point(Double.MAX_VALUE, 2);
		assertTrue(startPoint.getDistanceBetweenPoints(currentPoint) > Double.MAX_VALUE);
	}

	@Test
	public void testEqualsPoint() {
		Point startPoint = new Point(0, 0);
		Point currentPoint = new Point(0,0);
		assertTrue(startPoint.equals(currentPoint));
	}

}

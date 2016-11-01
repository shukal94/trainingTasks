import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BicycleTest {
	Bicycle simpleBicycle = new Bicycle();
	private final double PRECISION = 1e-3;

	@DataProvider(name = "ValidPoints")
	@Test(dataProvider = "ValidPoints")
	public void testSetStartingPointIsZero() {
		Point startPoint = new Point(0, 0);
		assertEquals(0, startPoint.getX(), PRECISION);
		assertEquals(0, startPoint.getY(), PRECISION);
	}

	@Test(dataProvider = "ValidPoints")
	public void testSetStartingPointIsNaN() {
		Point startPoint = new Point(Double.POSITIVE_INFINITY , Double.NEGATIVE_INFINITY);
		assertFalse(Double.isNaN(startPoint.getX()));
		assertFalse(Double.isNaN(startPoint.getY()));
	}


	@Test(dataProvider = "ValidPoints")
	public void testMoveMoreThanZero() {
		Point startPoint = new Point(0, 0);
		Point currentPoint = new Point(1, 2);
		assertTrue(startPoint.getDistanceBetweenPoints(currentPoint) >= 0);
	}

	@Test(dataProvider = "ValidPoints")
	public void testMoveOutOfDouble() {
		Point startPoint = new Point(0, 0);
		Point currentPoint = new Point(Double.MAX_VALUE, 2);
		assertTrue(startPoint.getDistanceBetweenPoints(currentPoint) > Double.MAX_VALUE);
	}

	@DataProvider(name = "ValidTime")
	@Test(dataProvider = "ValidTime")
	public void testGetTimePositive() {
		assertTrue(simpleBicycle.getTime() >= 0);
	}

	@DataProvider(name = "ValidCost")
	@Test(dataProvider = "ValidCost")
	public void testGetCost() {
		assertTrue(simpleBicycle.getCost() == 0);
	}
}

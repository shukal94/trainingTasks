import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class RouteBuilderTest {
	ArrayList<Movable> simpleRoute = new ArrayList<Movable>();
	
	@Test
	public void testBuildRouteIsNotNull() {
		assertNotNull(simpleRoute);
	}
	
	@Test
	public void testBuildRouteIsNotEmpty() {
		assertTrue(simpleRoute.size() > 0);
	}
}

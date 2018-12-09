import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import map.Floor;
import map.Place;

import org.junit.Before;
import org.junit.Test;

public class FloorTest {
	private Floor floor;
	private List<Place> places=new ArrayList<>();
	

	@Before
	public void setUp() throws Exception {
		
		floor=new Floor(0, places);
		
	}

	@Test
	public void testAddPlace() {
		Place p=new Place(001, "place1");
		floor.addPlace(p);
		assertNotNull(places);
	}

	

}

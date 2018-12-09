package test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import map.Floor;
import map.Place;

import org.junit.Before;
import org.junit.Test;

import sun.net.www.content.text.plain;

public class FloorTest {
	Floor floor;
	java.util.List<Place> places=new ArrayList<>();
	

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

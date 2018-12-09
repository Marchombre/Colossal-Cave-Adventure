package test;

import static org.junit.Assert.*;
import item.Apple;
import item.Item;
import game.Chest;
import game.Demogorgon;
import game.Monster;
import game.PartielAlgo;

import map.Exit;
import map.Place;

import org.junit.Before;
import org.junit.Test;

public class PlaceTest {
Place place;
	@Before
	public void setUp() throws Exception {
		 place=new Place(001, "place1");
	}

	@Test
	public void testAddExit() {
		Place p2=new Place(002, "place2");
		Exit exit=new Exit(place, p2);
		place.addExit(exit);
		assertSame(place.getExit(002), exit);
		
	}

	@Test
	public void testAddMonster() {
		Monster m=new PartielAlgo();
		place.addMonster(m);
		assertSame(place.getMonster(), m);
	}
	
	@Test
	public void testAddChest() {
		Chest i=new Chest();
		place.addChest(i);
		assertSame(place.getChest(), i);
	}

	@Test
	public void testDeadMonster() {
		Monster m=new PartielAlgo();
		place.addMonster(m);
		place.deadMonster();
		assertNull(place.getMonster());
	}

}

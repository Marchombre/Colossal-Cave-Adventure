import static org.junit.Assert.*;
import game.Player;

import map.Exit;
import map.Place;

import org.junit.Before;
import org.junit.Test;

public class TestExit {
	private Exit exit;
	private Place place2;
	private Player player;

	@Before
	public void setUp() throws Exception {
		Place place1 = new Place(001, "place 1");
		place2 = new Place(002, "place 2");
		exit= new Exit(place1, place2);
		player=new Player("ilyes", place1);
	}

	@Test
	public void testCross() {
		player.move(exit);
		assertSame(player.getPlace(), place2);
	}

}

import game.Player;
import item.*;
import map.Exit;
import map.Place;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
	private Player player;
	private Place place;
	
	
	@Before
	public void setUp() throws Exception {
		place=new Place(001, "Place1");
		player=new Player("ilyes", place);
	}

	@Test
	public void testGetLife() {
		int oldlife=player.getLife();
		player.beHit(10);
		assertNotSame(oldlife, player.getName());
	}

	@Test
	public void testAddItem() {
		Item i=new Sword();
		player.addItem(i);
		assertNotNull(player.getInventory());
	}

	@Test
	public void testEat() {
		int life=player.getLife();
		Food pomme=new Apple();
		player.beHit(2);
		player.eat(pomme);
		assertSame(life, player.getLife());
	}

	@Test
	public void testMove() {
	Place	place2=new Place(002, "place2");
		Exit exit=new Exit(place, place2);
		player.move(exit);
		assertSame(player.getPlace(), place2);
	}

	@Test
	public void testEquip() {
		Weapon s=new Sword();
		player.addItem(s);
		String str=s.getName();
		player.equip(str);
		assertNotNull(player.getWeapon());
	}

}

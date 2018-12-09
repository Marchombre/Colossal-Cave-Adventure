package test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import item.Apple;
import item.Food;
import item.Item;
import item.Sword;
import item.Weapon;
import game.Player;

import map.Exit;
import map.Place;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.utils.ListingErrorHandler;

public class PlayerTest {
	Player player;
	Place place;
	
	
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

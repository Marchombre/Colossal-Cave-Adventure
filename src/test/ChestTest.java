package test;

import static org.junit.Assert.*;
import item.Apple;
import item.Item;
import game.Chest;

import org.junit.Before;
import org.junit.Test;

public class ChestTest {
	private Chest chest;
	private Item item;

	@Before
	public void setUp() throws Exception {
		chest=new Chest();
	}

	@Test
	public void testAddItem() {
		item=new Apple();
		chest.addItem(item);
		assertSame(chest.getItems(), item);
	}

	@Test
	public void testAfficherItem() {
		item=new Apple();
		chest.addItem(item);
		assertEquals("- "+item.getName(),chest.afficherItem());
	}
}

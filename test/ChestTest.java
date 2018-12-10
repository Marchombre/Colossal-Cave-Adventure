<<<<<<< HEAD:src/test/ChestTest.java
package test;

import static org.junit.Assert.*;
=======
import game.Chest;
>>>>>>> 3f9af11e6747af58cb9a92555d26bdc58a676a4f:test/ChestTest.java
import item.Apple;
import item.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

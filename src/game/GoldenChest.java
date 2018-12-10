package game;

import java.util.ArrayList;

import item.Item;
/**
 * <b>GoldenChest is a class that extends the class Chest and represents a chest which has many items into it</b>
 * <p>
 * A GoldenChest object is characterized by the following informations.
 * <ul>
 * <li>An attribute open which says if the chest is open or close.</li>
 * <li> items that are in the golden chest.</li>
 * </ul>
 * </p>
 * @author azazga media
 * @version 1.0
 */
public class GoldenChest extends Chest{
	/**
	 * Says if the chest is open or not
	 * @see Chest#open()
	 * @see Chest#close()
	 */
	private boolean open;
	/**
	 * The list of items that are in the golden chest.
	 * @see GoldenChest#addItem(Item)
	 * @see GoldenChest#afficherItem()
	 */
	private ArrayList<Item> items;
/**
 * The constructor of GoldenChest
 *<p> Calls the super constructor.</p>
 *<p> Creats the list of the items.</p>
 */
	public GoldenChest() {
		super();
		items = new ArrayList<>();
	}
	/**
	 * Opens the golden Chest
	 */
	public void open() {
		this.open = true;
		System.out.println(afficherItem());
	}
	/**
	 * Closes the golden chest
	 */
	public void close() {
		this.open = false;
	}
	/**
	 * Adds an item in the ArrayList of items
	 */
	public void addItem(Item item) {
		if(this.items.size() <= 3) {
			this.items.add(item);
		}
	}
/**
 * Returns all the items that are in the golden chest.
 * @return the items in the GoldenChest as an ArrayList of Items
 */
	public ArrayList<Item> getItem() {
		return this.items;
	}
/**
 * Displays all the names of items in the golden chest
 */
	public String afficherItem() {
		String s="- ";
		for(Item i : items) {
			s = s + i.getName()+" - ";
		}
		return s;
	}
}

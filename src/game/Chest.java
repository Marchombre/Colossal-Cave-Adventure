package game;

import item.Item;

import javax.swing.plaf.synth.SynthOptionPaneUI;
/**
 * <b>Chest is a class that represents a chest that contains items in the game</b>
 * <p>
 * A chest is characterized by the following informations
 * <ul>
 * <li>An attribute open which is alterable and says if the chest is open or close </li>
 * <li> An item that is alterable </li>
 * @author azazga media
 * @version 1.0
 */
public class Chest {
	/**
	 * Says if the chest is open or not
	 * @see Chest#open()
	 * @see Chest#close()
	 */
	private boolean open;
	/**
	 * The item in the chest.
	 * @see Chest#addItem(Item)
	 * @see Chest#afficherItem()
	 * @see Chest#getItems()
	 */
	private Item item;
	/**
	 * The constructor of the Chest
	 *<p>At the construction of an object Chest, the open attribute is set to false.</p>
	 */
	public Chest() {
		this.open = false;
	}
/**
 * Adds an item in a chest
 * @param item
 * The item to add to the chest
 */
	public void addItem(Item item) {
		this.item = item;
	}
/**
 * Opens the chest
 */
	public void open() {
		this.open = true;
		System.out.println(afficherItem());
	}
	
	public void close() {
		this.open = false;
	}
/**
 * Displays the item in the chest.
 * @return the name of the item in the chest as a string
 */
	public String afficherItem() {
		if(this.item != null) {
			return "- " + this.item.getName();
		}
		else {
			return "Il n'y a rien";
		}
	}
	/**
	 * Returns the item in the chest
	 * @return the item in the chest as an item object.
	 */
	public Item getItems() {
		return this.item;
	}
}

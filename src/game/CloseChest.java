package game;

import item.*;

/**
 * <b>CloseChest is a class that extends Chest and represents a close chest in
 * the game </b>
 * <p>
 * Closechest is characterized by the following informations:
 * <ul>
 * <li>An attribute open which is alterable and says if the chest is open or
 * close</li>
 * <li>An item that is alterable</li>
 * <li>A key that opens the chest</li>
 * 
 * @author azazga media
 * @version 1.0
 */
public class CloseChest extends Chest {
	/**
	 * Says if the chest is open or not
	 * 
	 * @see Chest#open()
	 * @see Chest#close()
	 */
	protected boolean open;
	/**
	 * The item in the chest.
	 * 
	 * @see Chest#addItem(Item)
	 * @see Chest#afficherItem()
	 * @see Chest#getItems()
	 */
	protected Item item;
	/**
	 * The key that opens the chest
	 * 
	 * @see CloseChest#open(ChestKey)
	 * 
	 */
	protected ChestKey key;

	/**
	 * Constructor of CloseChest
	 * <p>
	 * At the construction of a CloseChest the attribute open is set to false
	 * </p>
	 */
	public CloseChest() {
		this.open = false;
	}

	/**
	 * Adds an item in a chest.
	 * 
	 * @param item
	 *            The item to add to the chest.
	 */
	public void addItem(Item item) {
		this.item = item;
	}

	public void setKey(ChestKey k) {
		this.key = k;
	}
/**.
 * Opens the current close chest.
 * @param e
 * The key that opens the chest.
 */
	public void open(ChestKey e) {
		if (this.key == e) {
			this.open = true;
		}
	}
/**
 * Closes the current chest.
 */
	public void close() {
		this.open = false;
	}

}

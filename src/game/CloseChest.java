package game;

import item.*;


public class CloseChest {

	protected boolean open;
	protected Item item;
	protected ChestKey key;
	
	public CloseChest(Item item, ChestKey key) {
		this.open = false;
		this.item = item;
		this.key = key;
	}
	
	public void open(ChestKey e) {
		if(this.key == e) {
			this.open = true;
		}
	}
	
	public void close() {
		this.open = false;
	}
	
}

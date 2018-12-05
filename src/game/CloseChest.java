package game;

import item.*;


public class CloseChest extends Chest{

	protected boolean open;
	protected Item item;
	protected ChestKey key;
	
	public CloseChest() {
		this.open = false;
	}

	public void addItem(Item item) {
		this.item = item;
	}

	public void setKey(ChestKey k) {
		this.key = k;
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

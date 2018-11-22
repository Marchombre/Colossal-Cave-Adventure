package game;

public class Chest {
	
	private boolean open;
	private Item item;
	
	public Chest(Item item) {
		this.open = false;
		this.item = item;
	}
	
	public void open() {
		this.open = true;
	}
	
	public void close() {
		this.open = false;
	}

}

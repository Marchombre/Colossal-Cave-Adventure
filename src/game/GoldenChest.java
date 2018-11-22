package game;

import java.util.ArrayList;

public class GoldenChest {
	
	private boolean open;
	private ArrayList<Item> items;

	public GoldenChest(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void open() {
		this.open = true;
	}
	
	public void close() {
		this.open = false;
	}
	
	
}

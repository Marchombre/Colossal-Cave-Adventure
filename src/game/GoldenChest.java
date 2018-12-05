package game;

import java.util.ArrayList;

import item.Item;

public class GoldenChest extends Chest{
	
	private boolean open;
	private ArrayList<Item> items;

	public GoldenChest() {
		super();
		items = new ArrayList<>();
	}
	
	public void open() {
		this.open = true;
		System.out.println(afficherItem());
	}
	
	public void close() {
		this.open = false;
	}
	
	public void addItem(Item item) {
		if(this.items.size() <= 3) {
			this.items.add(item);
		}
	}

	public ArrayList<Item> getItem() {
		return this.items;
	}

	public String afficherItem() {
		String s="- ";
		for(Item i : items) {
			s = s + i.getName()+" - ";
		}
		return s;
	}
}

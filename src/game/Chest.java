package game;

import item.Item;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Chest {
	
	private boolean open;
	private Item item;
	
	public Chest() {
		this.open = false;
	}

	public void addItem(Item item) {
		this.item = item;
	}

	public void open() {
		this.open = true;
		System.out.println(afficherItem());
	}
	
	public void close() {
		this.open = false;
	}

	public String afficherItem() {
		if(this.item != null) {
			return "Il y a " + this.item.getName();
		}
		else {
			return "Il n'y a rien";
		}
	}
	public Item getItems() {
		return this.item;
	}
}

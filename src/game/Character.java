package game;

import java.util.ArrayList;

import item.Food;
import item.Item;

public abstract class Character {
	
	private String name;
	private int life;
	
	private ArrayList<Item> items;
	
	public Character(String name, int life) {
		this.name = name;
		this.life = life;
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item i) {
		this.items.add(i);
	}
	
	public void hit(int h) {
		this.life = this.life - h;
	}
	
	public void eat(Item i) {
		if(i instanceof Food) {
			this.life = ((Food) i).getRegen() + this.life;
		}
	}
	
	public int getLife() {
		return this.life;
	}


}

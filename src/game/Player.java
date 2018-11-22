package game;

import item.Food;
import item.Item;

public class Player extends Character {

	public Player(String name) {
		// TODO Auto-generated constructor stub

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

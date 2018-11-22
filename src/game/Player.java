package game;

import item.*;

import java.util.ArrayList;

public class Player extends Character {

    private static final int MAX_HEALTH = 100;
    private String name;
    private ArrayList<Item> items;

	public Player(String heroName) {
		this.name = heroName;
		this.life = MAX_HEALTH;
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

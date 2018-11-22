package game;

import java.util.ArrayList;

import item.Food;
import item.Item;

public abstract class Character {

	protected int life;

	public void hit(int h) {
		this.life = this.life - h;
	}
	
	public int getLife() {
		return this.life;
	}
}

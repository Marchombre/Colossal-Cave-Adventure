package game;

import item.*;
import map.Exit;
import map.Place;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private static final int MAX_HEALTH = 100;
    private String name;
    private List<Item> inventory = new ArrayList<>();
    private Place currentPlace;
    private Weapon weapon;

	public Player(String heroName, Place place) {
		this.name = heroName;
		this.life = MAX_HEALTH;
		this.currentPlace = place;
	}

	public String getName(){
	    return name;
    }

	public void addItem(Item i) {
		this.inventory.add(i);
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

	public Place getPlace(){
		return currentPlace;
	}

	public void displayInventory() {
		System.out.print("Inventaire : ");
		for(Item i : inventory) {
			System.out.print(i.getName() + " ");
		}
	}

	public void move(Exit e){
		currentPlace = e.cross(currentPlace);
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void equip(String s) {
		for(Item k : inventory) {
			if(k.getName().equals(s) && k instanceof Weapon) {
				this.weapon = (Weapon)k;
				System.out.println("Equiper de : "+k.getName());
				break;
			}
			else if(k.getName().equals(s)) {
				System.out.println("IMPOSSIBLE DE SEQUIPER DE "+k.getName()+" PAS ARMES");
				break;
			}
		}
	}

	public List<Item> getInventory(){
		return this.inventory;
	}
}

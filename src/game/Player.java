package game;

import item.*;
import map.Exit;
import map.Place;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private static final int MAX_HEALTH = 7;
    private String name;
    private List<Item> inventory = new ArrayList<>();
    private Place currentPlace;
    private Weapon weapon;

	public Player(String heroName, Place place) {
		this.name = heroName;
		this.life = MAX_HEALTH;
		this.currentPlace = place;
		this.weapon = null;
		this.alive = true;
	}

	public String getName(){
	    return name;
    }

    public int getLife() {
        return this.life;
    }

    public Place getPlace(){
        return currentPlace;
    }

    public List<Item> getInventory(){
        return this.inventory;
    }


	public void addItem(Item i) {
		this.inventory.add(i);
	}

	public void beHit(int h) {
		this.life = this.life - h;
	}

	public int getWeaponDamages() {
		return this.weapon.getDamages();
	}

	public void eat(Food i){
        this.life += i.getRegen();
        inventory.remove(i);
	}

	public void displayInventory() {
	    if(inventory.size() != 0) {
            StringBuilder res = new StringBuilder("Inventaire : ");
            for (Item i : inventory) {
                res.append(i.getName()).append(" ");
            }
            System.out.println(res);
        }
	}

	public void move(Exit e){
		currentPlace = e.cross(currentPlace);
	}

	public Weapon getWeapon() {
		return this.weapon;
	}

	public void removeWeapon(Weapon i) {
		inventory.remove(i);
	}

	public void equip(String s) {
		String s1 = s.toUpperCase();
		for(Item k : inventory){
			if(k.getName().toUpperCase().equals(s1) && k instanceof Weapon) {
				this.weapon = (Weapon)k;
				System.out.println("Vous vous êtes équiper de : "+k.getName());
				break;
			}
			else if(k.getName().equals(s1)) {
				System.out.println("Vous ne pouvez pas vous équiper de "+k.getName());
				break;
			}
		}
	}

}

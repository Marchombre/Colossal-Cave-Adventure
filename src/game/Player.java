package game;

import item.*;
import map.Exit;
import map.Place;

import java.util.ArrayList;
import java.util.List;
/**
 * <b> The class Player extends Characters and represents the hero of the game </b>
 * <p>
 * A player is characterized by the following informations:
 * <ul>
 * <li> A maximum health which is not alterable</li>
 * <li> A name </li>
 * <li> An inventory that contains all the items that the player has</li>
 * <li> A current place</li>
 * <li> A weapon</li>
 * </ul>
 * </p> 
 * @author azazga media
 *@version 1.0
 */
public class Player extends Character {
/**
 * The maximum health of the player
 */
    private static final int MAX_HEALTH = 7;
    /**
     * The name of the player
     * @see Player#getName()
     */
    private String name;
    /**
     * The list of the items that the player has.
     * @see Player#getInventory()
     */
    private List<Item> inventory = new ArrayList<>();
    /**
     * The place where the player is.
     * @see Player#getPlace()
     */
    private Place currentPlace;
    /**
     * The weapon whose the player is equipped.
     * @see Player#getWeapon()
     */
    private Weapon weapon;
/**
 * The Constructor of Player
 * @param heroName
 * The name of the hero.
 * @param place
 * The name of the place at construction of the player.
 */
	public Player(String heroName, Place place) {
		this.name = heroName;
		this.life = MAX_HEALTH;
		this.currentPlace = place;
		this.weapon = null;
		this.alive = true;
	}
/**
 * Returns the name of the player.
 * @return the name of the player as a string.
 */
	public String getName(){
	    return name;
    }
	
    public int getLife() {
        return this.life;
    }
/**
 * Returns the current place of the player.
 * @return the current place of the player as a Place object.
 */
    public Place getPlace(){
        return currentPlace;
    }
/**
 * The list of items that the player has.
 * @return the items of the player as a List of Item objects.
 */
    public List<Item> getInventory(){
        return this.inventory;
    }

/**
 * Adds an item to the inventory of the player.
 * @param i
 * The item added 
 */
	public void addItem(Item i) {
		this.inventory.add(i);
	}

	public void beHit(int h) {
		this.life = this.life - h;
	}
/**
 * Returns the damages inflicted by the weapon
 * @return the damages inflicted by the weapon as an Integer
 */
	public int getWeaponDamages() {
		return this.weapon.getDamages();
	}
/**
 * Regenerates life for the player
 * @param i
 * The Food object eaten by the player
 */
	public void eat(Food i){
        this.life += i.getRegen();
        inventory.remove(i);
	}
/**
 * Displays the inventory of the player
 */
	public void displayInventory() {
	    if(inventory.size() != 0) {
            StringBuilder res = new StringBuilder("Inventaire : ");
            for (Item i : inventory) {
                res.append(i.getName()).append(" ");
            }
            System.out.println(res);
        }
	}
/**
 * Moves the player to the next place
 * @param e
 * The exit that the player chooses to move to another place
 */
	public void move(Exit e){
		currentPlace = e.cross(currentPlace);
	}
/**
 * returns The weapon owned by the player
 * @return The weapon owned by the player 
 */
	public Weapon getWeapon() {
		return this.weapon;
	}
/**
 * Removes the weapon from the inventory
 * @param i
 * The weapon to remove
 */
	public void removeWeapon(Weapon i) {
		inventory.remove(i);
	}
/**
 * Equips the player with the weapon passed in a parameter
 * @param s
 *The name of the weapon
 */
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

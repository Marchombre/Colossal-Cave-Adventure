package map;

import game.Chest;
import game.GoldenChest;
import game.Monster;
import item.Item;

import java.util.ArrayList;
import java.util.List;
/**
 *<b>Place is a class that represents the diffrent places in our game.</b>
 * @version 1.0
 *
 */
public class Place {
/**
 * The name of the place.
 */
    private String name;
    /**
     * The ID of the place.
     */
    private int id;
    /**
     * The list of exits in a place
     */
    private List<Exit> exits;
    /**
     * The chest in a place.
     */
    private Chest chest;
    /**
     * The monster in a place.
     */
    private Monster monster;
    /**
     * The list of items in a place.
     */
    private List<Item> items;
/**
 * The constructor of Place
 * @param id
 * The id of the place
 * @param name
 * The name of the place
 */
    public Place(int id, String name){
        this.id = id;
        this.name = name;
        this.exits = new ArrayList<>();
        this.items = new ArrayList<>();
        this.chest = null;
    }

    @Override
    public String toString(){
        return("Vous êtes dans la salle n°" + this.id + " à l'étage " + getFloor());
    }

    public void addExit(Exit e){
        exits.add(e);
    }

    public Exit getExit(int num){
        Exit tmp = null;
        for(int i = 0; i < exits.size(); ++i) {
            if(num == i+1)
                tmp = exits.get(i);
        }
        return tmp;
    }
/**
 * Returns the list of exits in a place.
 * @return the list of exits in a place as a list of Exit objects.
 */
    public List<Exit> getAllExits(){
        return this.exits;
    }
/**
 * Displays all the exits names.
 */
    public void displayExits(){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < exits.size(); ++i) {
            int val = i+1;
            res.append(" - Porte n°").append(val).append(" ");
        }
        System.out.println(res);
    }
/**
 * Returns the floor of the current place.
 * @return The floor of the current place as an integer.
 */
    public int getFloor(){
        return (this.id/100);
    }
/**
 * Adds a Chest in the current place.
 * @param c
 * the chest to add.
 */
    public void addChest(Chest c) {
        this.chest = c;
    }
/**
 * Returns the chest that is in the current place.
 * @return returns the chest that is in the current place as a Chest object.
 */
    public Chest getChest() {
        return this.chest;
    }
/**
 * Adds a monster into the current place.
 * @param m
 * The monster to add.
 */
    public void addMonster(Monster m) {
        this.monster = m;
    }
/**
 * Returns The Monster in the current Place.
 * @returnThe monster in the current Place.
 */
    public Monster getMonster() {
        return this.monster;
    }

    private void afficherMonsters() {
        if(this.monster != null) {
            System.out.println(" - Monstre : "+this.monster.getName());
        }
    }

    private void afficherChest(Chest c) {
        if(c != null) {
            if (c instanceof Chest) {
                System.out.println(" - 1 Coffre");
            }
            else {
                System.out.println(" - 1 Coffre doré");
            }
        }
    }

    public void displayPlace() {
        System.out.println(toString());
        System.out.println("Dans cette salle vous voyez :");
        displayExits();
        displayItems();
        afficherMonsters();
        afficherChest(this.chest);
    }

    public Item getItems(String entry){
        Item itemToReturn = null;
        for(int i =0 ; i<items.size(); ++i){
            if(items.get(i).getName().toLowerCase().equals(entry))
                itemToReturn = items.remove(i);
        }
        return itemToReturn;
    }

    public void addItem(Item item){
        items.add(item);
    }

    private void displayItems(){
        if(items.size() != 0) {
            StringBuilder res = new StringBuilder();
            for (Item item : items) {
                res.append(item.getName()).append(" ");
            }
            System.out.println(" - Item : " + res);
        }
    }
/**
 * Kills the monster in a place.
 */
    public void deadMonster() {
        this.monster = null;
    }
/**
 * Opens the chest in the current place.
 */
    public void openChest() {
        this.chest = null;
    }
}

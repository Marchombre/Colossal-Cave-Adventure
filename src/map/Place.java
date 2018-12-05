package map;

import game.Chest;
import game.GoldenChest;
import game.Monster;
import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String name;
    private int id;
    private List<Exit> exits;
    private Chest chest;
    private Monster monster;
    private List<Item> items;

    public Place(int id, String name){
        this.id = id;
        this.name = name;
        this.exits = new ArrayList<>();
        this.items = new ArrayList<>();
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

    public void displayExits(){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < exits.size(); ++i) {
            int val = i+1;
            res.append(" - Porte n°").append(val).append(" ");
        }
        System.out.println(res);
    }

    public int getFloor(){
        return (this.id/100);
    }

    public void addChest(Chest c) {
        this.chest = c;
    }

    public void getChests() {
        System.out.println("");
    }

    public Chest getChest() {
        return this.chest;
    }

    public void addMonster(Monster m) {
        this.monster = m;
    }

    public Monster getMonster() {
        return this.monster;
    }

    public void afficherMonsters() {
        if(this.monster != null) {
            System.out.println(" - Monstre : "+this.monster.getName());
        }
    }

    public void afficherChest(Chest c) {
        if(c != null) {
            if (c instanceof Chest) {
                System.out.println(" - 1 coffre");
            }
            else if(c instanceof GoldenChest) {
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

    public void displayItems(){
        String res = "";
        for (Item item : items) {
            res += item.getName() + " ";
        }
        System.out.println(" - Item : " + res);
    }
}

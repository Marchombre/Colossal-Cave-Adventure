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

    public Place(int id, String name){
        this.id = id;
        this.name = name;
        this.exits = new ArrayList<>();
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

    public void afficherExits(){
        String res = "";
        for(int i = 0; i < exits.size(); ++i) {
            int val = i+1;
            res += "Porte n°" + val + " ";
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
            System.out.println("Monste : "+this.monster.getName());
        }
    }

    public void afficherChest(Chest c) {
        if(c instanceof GoldenChest) {
            System.out.println("Il y a 1 coffre d'oré");
        }
        else {
            System.out.println("Il y a 1 Coffre");
        }
    }

    public void afficherSalle() {
        System.out.println(toString());
        afficherExits();
        afficherMonsters();
        afficherChest(this.chest);
    }
}

package map;

import game.*;
import item.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {

    private List<Floor> floors = new ArrayList<>();
    private int nbFloors;
    private Player hero = null;

    public World(File file){

        List<List<Place>> placesByFloor = new ArrayList<>();

        try (Scanner scannerFile = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scannerFile.hasNextLine()) {
                String[] lineSplit = scannerFile.nextLine().split(" : ");
                switch (lineSplit[0]) {
                    case "NBFLOORS":
                        this.nbFloors = Integer.parseInt(lineSplit[1]);
                        for (int i = 0; i < nbFloors; ++i) {
                            List<Place> p = new ArrayList<>();
                            placesByFloor.add(p);
                        }
                        break;

                    case "Place":
                        String[] splitPlace = lineSplit[1].split(",");
                        int nFloor = Integer.parseInt(splitPlace[0]) / 100;
                        placesByFloor.get(nFloor).add(new Place(Integer.parseInt(splitPlace[0]), splitPlace[1]));
                        break;

                    case "Exit":
                        String[] splitExit = lineSplit[1].split(",");
                        int place1 = Integer.parseInt(splitExit[0]);
                        int place2 = Integer.parseInt(splitExit[1]);
                        new Exit(placesByFloor.get(place1 / 100).get(place1 - ((place1 / 100) * 100)), placesByFloor.get(place2 / 100).get(place2 - ((place2 / 100) * 100)));
                        break;
                }
            }
            //creation of all Floors
            for (int i = 0; i < placesByFloor.size(); ++i) {
                floors.add(new Floor(i, placesByFloor.get(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Player getHero(){
        return this.hero;
    }

    public void setHero(String name){
        this.hero = new Player(name, getPlaceById(0));
    }

    private Place getPlaceById(int id){
        return floors.get(id/100).getPlace(id-((id/100)*100));
    }

    public void action(String com){
        //split command
        String[] command = com.split(" ");

//        Item i = new Apple();
//
//        // METHODE POUR TAKE
//        Item i2 = new Apple();
//        Sword s2 = new Sword();
//        BigMac bg = new BigMac();
//        Chest c = new Chest();
//        GoldenChest c2 = new GoldenChest();
//        c2.addItem(i2);
//        c2.addItem(s2);
//        c2.addItem(bg);
//        hero.getPlace().addChest(c);

//        // METHODE POUR FIGHT
//        Monster monster = new Demogorgon();
//        hero.getPlace().addMonster(monster);

//        //METHODE POUR INVENTAIRE
//        hero.addItem(i);
//
//        //METHODE POUR EQUIP
//        Weapon w2 = (Weapon)new Sword();
//        hero.addItem(w2);

        label:
        while (true) {
            switch (command[0]) {
                case "HELP":
                    System.out.println("todo liste des commandes");
                    //TODO
                case "LOOK":
                    hero.getPlace().afficherSalle();
                    break;
                case "GO":
                    Exit e = hero.getPlace().getExit(Integer.parseInt(command[1]));
                    if (e != null)
                        hero.move(e);
                    break;
                case "INFO":
                    hero.displayItem();
                    break;
                case "TAKE":
                    hero.addItem(hero.getPlace().getChest().getItems());
                    break;
                case "EQUIP":
                    String s = command[1];
                    hero.equip(s);
                    break;
                case "FIGHT":
                    System.out.println(hero.getPlace().getMonster().getLife());
                    hero.getPlace().getMonster().hit(hero.getWeapon().getHit());
                    System.out.println(hero.getPlace().getMonster().getLife());
                    break;
                case "OPEN":
                    hero.getPlace().getChest().open();
                    break;
                case "STOP":
                case "QUIT":
                    System.out.println("todo end game");
                    //TODO
                    break label;
                default :
                    System.out.println("Cette commande n'est pas reconnue. Entrez HELP pour connaitre la liste des commandes");
            }
        }
    }
}
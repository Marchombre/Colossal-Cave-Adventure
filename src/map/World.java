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

    public World(File file){

        List<List<Place>> placesByFloor = new ArrayList<>();

        Scanner scannerFile = null;
        try {
            scannerFile = new Scanner (new BufferedReader (new FileReader (file)));

            while (scannerFile.hasNextLine()) {
                String[] lineSplit = scannerFile.nextLine().split(" : ");
                switch (lineSplit[0]) {
                    case "NBFLOORS":
                        this.nbFloors = Integer.parseInt(lineSplit[1]);
                        for(int i = 0; i < nbFloors; ++i){
                            List<Place> p = new ArrayList<>();
                            placesByFloor.add(p);
                        }
                        break;

                    case "Place":
                        String[] splitPlace = lineSplit[1].split(",");
                        int nFloor = Integer.parseInt(splitPlace[0])/100;
                        placesByFloor.get(nFloor).add(new Place(Integer.parseInt(splitPlace[0]),splitPlace[1]));
                        break;

                    case "Exit":
                        String[] splitExit = lineSplit[1].split(",");
                        int place1 = Integer.parseInt(splitExit[0]);
                        int place2 = Integer.parseInt(splitExit[1]);
                        new Exit(placesByFloor.get(place1/100).get(place1-((place1/100)*100)),placesByFloor.get(place2/100).get(place2-((place2/100)*100)));
                        break;
                }
            }
            //creation of all Floors
            for(int i = 0; i <placesByFloor.size(); ++i){
                floors.add(new Floor(i,placesByFloor.get(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scannerFile.close(); //in any case we close the Scanner
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez choisir un nom pour votre personnage");
        String persoName = scanner.nextLine();
        System.out.println("votre perso s'nomme " + persoName);
        Player hero = new Player(persoName, getPlaceById(000));
        Item i = new Apple();
        //TODO TO REMOVE

        // METHODE POUR TAKE
        Item i2 = new Apple();
        Sword s2 = new Sword();
        BigMac bg = new BigMac();
        Chest c = new Chest();
        GoldenChest c2 = new GoldenChest();
        c2.addItem(i2);
        c2.addItem(s2);
        c2.addItem(bg);
        hero.getPlace().addChest(c);

        // METHODE POUR FIGHT
        Monster monster = new Demogorgon();
        hero.getPlace().addMonster(monster);

        //METHODE POUR INVENTAIRE
        hero.addItem(i);

        //METHODE POUR EQUIP
        Weapon w2 = (Weapon)new Sword();
        hero.addItem(w2);

        while(true){
            String[] command = scanner.nextLine().split(" ");
            if(command[0].equals("STOP") || command[0].equals("QUIT")){
                System.out.println("fin du jeu");
                break;
            }else if(command[0].equals("LOOK")){
                hero.getPlace().afficherSalle();
                
            }else if(command[0].equals("GO")){
                Exit e = hero.getPlace().getExit(Integer.parseInt(command[1]));
                if(e != null)
                    hero.move(e);
            }else if(command[0].equals("INFO")) {
                hero.displayItem();
            }else if(command[0].equals("TAKE")) {
                hero.addItem(hero.getPlace().getChest().getItems());
            }else if(command[0].equals("EQUIP")) {
                String s = command[1];
                hero.equip(s);
            }else if(command[0].equals("FIGHT")) {
                System.out.println(hero.getPlace().getMonster().getLife());
                hero.getPlace().getMonster().hit(hero.getWeapon().getHit());
                System.out.println(hero.getPlace().getMonster().getLife());
            }
            else if(command[0].equals("OPEN")) {
                hero.getPlace().getChest().open();
            }
        }

    }

    public Place getPlaceById(int id){
        return floors.get(id/100).getPlace(id-((id/100)*100));
    }
}
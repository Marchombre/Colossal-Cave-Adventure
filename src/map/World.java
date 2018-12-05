package map;

import game.*;
import item.Apple;
import item.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {

    private List<Floor> floors = new ArrayList<>();
    private int nbFloors;
    private Player hero = null;

    public World(File file) {

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

                    case "Chest":
                        String[] splitChest = lineSplit[1].split(",");
                        int place = Integer.parseInt(splitChest[0]);
                        String s = splitChest[1];
                        Item i = new();
                        Chest c = new Chest();
                        (placesByFloor.get(place/100).get(place - ((place / 100) * 100))).addChest(c);  // AJOUTE CHEST DANS CLASS
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

    public Player getHero() {
        return this.hero;
    }

    public void setHero(String name) {
        this.hero = new Player(name, getPlaceById(0));
    }

    private Place getPlaceById(int id) {
        return floors.get(id / 100).getPlace(id - ((id / 100) * 100));
    }

    public void action(String com) {
        com = com.toLowerCase();
        String[] command = com.split(" ");

//       // METHODE POUR TAKE
            Item i2 = new Apple();
//        Sword s2 = new Sword();
//        BigMac bg = new BigMac();
//       Chest c = new Chest();
//        GoldenChest c2 = new GoldenChest();
//        c2.addItem(i2);
//        c2.addItem(s2);
//        c2.addItem(bg);
  //     hero.getPlace().addChest(c);

//        // METHODE POUR FIGHT
//        Monster monster = new Demogorgon();
//        hero.getPlace().addMonster(monster);

//        //METHODE POUR INVENTAIRE
            hero.addItem(i2);
//
//        //METHODE POUR EQUIP
//        Weapon w2 = (Weapon)new Sword();
//        hero.addItem(w2);

        switch (command[0]) {
            case "help":
                System.out.println("COMMANDE :\n");
                System.out.println(" LOOK : Affiche ce qu'il y a autour du personnage\n");
                System.out.println(" GO : Permet de déplacer le personnage avec le numero de porte mis en parametre\n");
                System.out.println(" INFO : Permet de voir ce que le joueur a dans son inventaire\n");
                System.out.println(" TAKE : Affiche ce qu'il y a autour du personnage\n");
                System.out.println(" EQUIP : Permet d'équiper le hero d'un objet\n");
                System.out.println(" FIGHT : Permet de combattre\n");
                System.out.println(" OPEN : Ouvre un coffre\n");
                System.out.println(" STOP : Stop le jeu\n");
                System.out.println(" QUIT : Quitter le jeu en cours\n");
                //TODO PHRASE A REGARDER
                break;
            case "look":
                if (command.length == 1)
                    hero.getPlace().displayPlace();
                else if (command.length == 2) {
                    //todo description de l'objet passé en parametre
                    System.out.println("TODO");
                } else
                    System.out.println("la commande look s'utilise avec zéro ou un argument merci de recommencer");
                break;
            case "go":
                if (command.length == 1)
                    System.out.println("la commande GO s'utilise avec un argument merci de recommencer");
                else if (command.length == 2) {
                    try {
                        Exit e = hero.getPlace().getExit(Integer.parseInt(command[1]));
                        if (e != null)
                            hero.move(e);
                        else
                            System.out.println("Le chiffre que vous avez entré ne correspond a aucune porte");
                    }catch (NumberFormatException e){
                        System.out.println("Le deuxième argument doit être un chiffre");
                    }
                } else
                    System.out.println("la commande GO s'utilise avec un seul argument merci de recommencer");
                break;
<<<<<<< HEAD
                /// TODO: 04/12/2018
            case "info":
                hero.displayItem();
                break;
=======
                // TODO: 04/12/2018
//            case "info":
//                hero.displayItem();
//                break;
>>>>>>> 1f7796195b212467ddca385020c51f755145db0c
            case "take":
                if (command.length == 1)
                    System.out.println("la commande take s'utilise avec un argument merci de recommencer");
                else if (command.length == 2) {
                    Item itemToAdd = hero.getPlace().getItems(command[1]);
                    if(itemToAdd != null) {
                        hero.addItem(itemToAdd);
                        System.out.println("vous avez ramassé : " + command[1]);
                    } else
                        System.out.println("veuillez orthographier le nom de l'item correctement");
                } else
                    System.out.println("la commande take s'utilise avec un seul argument merci de recommencer");
                break;
            case "use" :
                // TODO: 04/12/2018
                break;
//            case "equip": // TODO: 04/12/2018
//                String s = command[1];
//                hero.equip(s);
//                break;
//            case "fight": // TODO: 04/12/2018
//                System.out.println(hero.getPlace().getMonster().getLife());
//                hero.getPlace().getMonster().hit(hero.getWeapon().getHit());
//                System.out.println(hero.getPlace().getMonster().getLife());
//                break;
            case "open": // TODO: 04/12/2018
                if (command.length == 3) {
                    switch (command[1]){
                        case "door":
                            break;
                        case "chest":
                            break;
                        default:
                            System.out.println("Le deuxième argument doit etre door ou chest selon ce que vous voulez ouvrir");
                            break;
                    }
                } else
                    System.out.println("la commande take s'utilise avec un deux arguments merci de recommencer");




                hero.getPlace().getChest().open();
                break;
            case "stop":
            case "quit":
                System.out.println("todo end game");
                break;
            default:
                System.out.println("Cette commande n'est pas reconnue. Entrez HELP pour connaitre la liste des commandes");
                break;
        }
    }
}
package map;

import game.*;
import item.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

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
                        Chest c = new Chest();
                        Item i = buildItem(s);
                        c.addItem(i);
                        (placesByFloor.get(place / 100).get(place - ((place / 100) * 100))).addChest(c);  // AJOUTE CHEST DANS CLASS
                        break;

                    case "GoldenChest":
                        String[] splitGChest = lineSplit[1].split(",");
                        int gPlace = Integer.parseInt(splitGChest[0]);
                        Chest gc = new GoldenChest();
                        String gs;
                        Item gi;
                        for (int k = 1; k < splitGChest.length; k++) {
                            gs = splitGChest[k];
                            gi = buildItem(gs);
                            gc.addItem(gi);
                        }
                        (placesByFloor.get(gPlace / 100).get(gPlace - ((gPlace / 100) * 100))).addChest(gc);  // AJOUTE CHEST DANS CLASS*/
                        break;

                    /*case "CloseChest":
                        String[] splitCChest = lineSplit[1].split(",");
                        int cPlace = Integer.parseInt(splitCChest[0]);
                        String cs = splitCChest[1];
                        Chest cc = new Chest();
                        Item ci = buildItem(cs);
                        cc.addItem(ci);
                        (placesByFloor.get(cPlace / 100).get(cPlace - ((cPlace / 100) * 100))).addChest(cc);  // AJOUTE CHEST DANS CLASS
                        break;*/

                    case "PartielAlgo":
                        String[] splitAlgo = lineSplit[1].split(",");
                        int aPlace = Integer.parseInt(splitAlgo[0]);
                        (placesByFloor.get(aPlace / 100).get(aPlace - ((aPlace / 100) * 100))).addMonster(new PartielAlgo());
                        break;

                    case "PartielPOO":
                        String[] splitPOO = lineSplit[1].split(",");
                        int pPlace = Integer.parseInt(splitPOO[0]);
                        (placesByFloor.get(pPlace / 100).get(pPlace - ((pPlace / 100) * 100))).addMonster(new PartielPOO());
                        break;

                    case "PartielProgC":
                        String[] splitPC = lineSplit[1].split(",");
                        int pcPlace = Integer.parseInt(splitPC[0]);
                        (placesByFloor.get(pcPlace / 100).get(pcPlace - ((pcPlace / 100) * 100))).addMonster(new PartielProgC());
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


        switch (command[0]) {
            case "help":
                System.out.println("COMMANDE :");
                System.out.println(" LOOK : Affiche ce qu'il y a autour du personnage");
                System.out.println(" GO : Permet de déplacer le personnage avec le numero de porte mis en parametre");
                System.out.println(" INFO : Permet de voir ce que le joueur a dans son inventaire");
                System.out.println(" TAKE : Prend l'objet passe en parametre");
                System.out.println(" USE : Permet d'équiper le hero d'une arme ou de manger de la nourriture");
                System.out.println(" FIGHT : Permet de combattre");
                System.out.println(" OPEN : Ouvre un coffre");
                System.out.println(" STOP : Stop le jeu");
                System.out.println(" QUIT : Quitter le jeu");
                //TODO PHRASE A REGARDER
                break;
            case "look":
                if (command.length == 1) {
                    hero.getPlace().displayPlace();
                } else
                    System.out.println("La commande look s'utilise sans argument merci de recommencer");
                break;
            case "go":
                if (command.length == 1)
                    System.out.println("La commande GO s'utilise avec un argument merci de recommencer");
                else if (command.length == 2) {
                    try {
                        Exit e = hero.getPlace().getExit(Integer.parseInt(command[1]));
                        if (e != null)
                            if (hero.getPlace().getMonster() == null) {
                                hero.move(e);
                            } else {
                                System.out.println(hero.getPlace().getMonster().getName() + " bloque le passage!");
                            }
                        else
                            System.out.println("Le chiffre que vous avez entré ne correspond a aucune porte");
                    } catch (NumberFormatException e) {
                        System.out.println("Le deuxième argument doit être un chiffre");
                    }
                } else {
                    System.out.println("La commande GO s'utilise avec un seul argument merci de recommencer");
                }
                break;
            case "info":
                if (command.length == 1) {
                    System.out.println("Vie : " + hero.getLife());
                    hero.displayInventory();
                } else
                    System.out.println("La commande info s'utilise sans argument merci de recommencer");
                break;
            case "take":
                if (command.length == 1)
                    System.out.println("La commande take s'utilise avec un argument merci de recommencer");
                else if (command.length == 2) {
                    Item itemToAdd = hero.getPlace().getItems(command[1]);
                    if (itemToAdd != null) {
                        hero.addItem(itemToAdd);
                        System.out.println("Vous avez ramassé : " + command[1].toUpperCase());
                    } else
                        System.out.println("Veuillez orthographier le nom de l'item correctement");
                } else
                    System.out.println("La commande take s'utilise avec un seul argument merci de recommencer");
                break;
            case "use":
                // TODO: 04/12/2018
                if (command.length == 1)
                    System.out.println("La commande use s'utilise avec au moins un argument merci de recommencer");
                else if (command.length == 2) {
                    List<Item> inventory = hero.getInventory();
                    boolean find = false;
                    int i = 0;
                    while (!find && i < inventory.size()) {
                        Item item = inventory.get(i);
                        if (item.getName().toLowerCase().equals(command[1])) {
                            if (item instanceof Food) {
                                hero.eat((Food) item);
                                find = true;
                            } else if (item instanceof Weapon) {
                                hero.equip(command[1]);
                                hero.removeWeapon((Weapon) item);
                                find = true;
                            } else
                                System.out.println("Vous ne pouvez pas utiliser cet objet");
                        }
                        ++i;
                    }
                    if (!find)
                        System.out.println("Objet inexistant");
                } else
                    System.out.println("La commande use s'utilise avec un argument merci de recommencer");
                break;
            case "fight":
                if (command.length == 1) {
                    Monster monster = hero.getPlace().getMonster();
                    if (monster != null) {
                        if (hero.getWeapon() != null) {
                            if (monster.getLife() - hero.getWeaponDamages() > 0) {
                                if (hero.getLife() - monster.getDamages() > 0) {
                                    monster.beHit(hero.getWeapon().getDamages());
                                    System.out.println(monster.getName() + " : " + monster.getLife());
                                    hero.beHit(monster.getDamages());
                                    System.out.println(hero.getName() + " : " + hero.getLife());
                                } else {
                                    System.out.println(monster.getName() + " a mit fin à vos jours...\nVous êtes mort! Dommage...");
                                    hero.die();
                                }
                            } else {
                                System.out.println(monster.getName() + " est vaincu!");
                                monster.die();
                                hero.getPlace().deadMonster();
                            }
                        } else {
                            System.out.println("Vous taper avec les poings ce n'est pas très efficace...");
                            System.out.println("Vous perdez " + monster.getDamages() + " point de vie");
                            hero.beHit(monster.getDamages());
                            if (hero.getLife() <= 0)
                                hero.die();
                        }
                    } else
                        System.out.println("Il n'y a pas d'ennemis dans cette salle.");
                } else
                    System.out.println("La commande fight s'utilise sans argument merci de recommencer");
                break;

            case "open":
                if (command.length == 2) {
                    if (command[1].equals("chest")) {
                        if (hero.getPlace().getChest() != null) {
                            if (!(hero.getPlace().getChest() instanceof CloseChest)) {
                                hero.getPlace().getChest().open();
                                hero.getPlace().addItem(hero.getPlace().getChest().getItems());
                                hero.getPlace().openChest();
                            } else
                                System.out.println("ce coffre semble fermé, essaye de recommencer avec une clé ...");
                        } else
                            System.out.println("Il n'y a pas de coffre dans cette salle.");
                    }
                } else if (command.length == 3) {
                    switch (command[1]) {
                        case "door":
                            System.out.println("Il n'y a pas de porte fermée ici");
                            break;
                        case "chest":
                            System.out.println("Il n'y a pas de coffre fermé dans cette salle");
                            break;
                        default:
                            System.out.println("Le premier argument doit etre door ou chest selon ce que vous voulez ouvrir");
                            break;
                    }
                } else
                    System.out.println("La commande open s'utilise avec un ou deux arguments merci de recommencer");
                break;
            case "stop":
            case "quit":// TODO: 08/12/2018  
                System.out.println("todo end game");
                break;
            default:
                System.out.println("Cette commande n'est pas reconnue. Entrez HELP pour connaitre la liste des commandes");
                break;
        }
    }

    public Item buildItem(String s) {
        Item i = null;
        switch (s) {
            case "APPLE":
                i = new Apple();
                break;
            case "BIGMAC":
                i = new BigMac();
                break;
            case "CHESTKEY":
                i = new ChestKey();
                break;
            case "GOLDENAPPLE":
                i = new GoldenApple();
                break;
            case "GUN":
                i = new Gun();
                break;
            case "POTION":
                i = new Potion();
                break;
            case "SWORD":
                i = new Sword();
                break;
            default:
                System.out.println("Objet inexistant");
                break;
        }
        return i;
    }
}
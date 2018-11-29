import game.*;
import item.*;
import map.Exit;
import map.World;

import java.io.File;
import java.util.Scanner;

public class Main {
    //initiate / create world
    public static void main(String[] args) {

<<<<<<< HEAD
        String FILENAME = "fileTest.txt";
=======
        Scanner scanner = new Scanner(System.in);
        Player hero = null;

        //afficher un message bienvenue sur le jeu, voulez vous reprendre une partie sauvegardée ?
        // oui / non
        //autre réponse -> exception avec message puis redemande de la question
        //si oui et pas de partie sauvegardée --> exception (si partie qui existe alors propose la liste des parties save et laisse choisir
        // si non -> proposer quelle map choisir

        System.out.println("Bienvenue dans COLOSSAL CAVE ADVENTURE !!");
        System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
        String resp = scanner.nextLine().toLowerCase();

        switch (resp) {
            case "y":
            case "yes":
            case "o":
            case "oui":
                System.out.println("Vous avez choisi de jouer sur une partie sauvegardée");
                //TODO
                break;

            case "n":
            case "no":
            case "non":


                System.out.println("Vous avez choisi de commencer une partie, merci de choisir un monde parmis la liste suivante");

                String FILENAME = choiceOfWorld(scanner);

                File file = new File(FILENAME);
                World world = new World(file);
                System.out.println("Veuillez choisir un nom pour votre personnage");
                String persoName = scanner.nextLine();
                System.out.println("votre perso s'nomme " + persoName);
                hero = new Player(persoName, world.getPlaceById(000));
                break;

            default:
                System.out.println("erreur -> faire une boucle qui redemande la question");
                //Todo
                break;
        }


        Item i = new Apple();

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
        Weapon w2 = (Weapon) new Sword();
        hero.addItem(w2);

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("STOP") || command[0].equals("QUIT")) {
                System.out.println("fin du jeu");
                break;
            } else if (command[0].equals("LOOK")) {
                hero.getPlace().afficherSalle();
            } else if (command[0].equals("GO")) {
                Exit e = hero.getPlace().getExit(Integer.parseInt(command[1]));
                if (e != null)
                    hero.move(e);
            } else if (command[0].equals("INFO")) {
                hero.displayItem();
            } else if (command[0].equals("TAKE")) {
                hero.addItem(hero.getPlace().getChest().getItems());
            } else if (command[0].equals("EQUIP")) {
                String s = command[1];
                hero.equip(s);
            } else if (command[0].equals("FIGHT")) {
                System.out.println(hero.getPlace().getMonster().getLife());
                hero.getPlace().getMonster().hit(hero.getWeapon().getHit());
                System.out.println(hero.getPlace().getMonster().getLife());
            } else if (command[0].equals("OPEN")) {
                hero.getPlace().getChest().open();
            }
        }
    }

    public static String[] listOfFiles(File rep) {
        return rep.list();
        //todo throw exception if list is empty
    }

    private Player init(World world) {
        //todo
        return null;
    }
>>>>>>> 6d98cdcca72d3742bec8d62cb50e0c57df8ba16a

    private static String choiceOfWorld(Scanner scanner){
        String[] listOfFile = listOfFiles(new File("worlds"));
        for (int i = 0; i < listOfFile.length; i++) {
            System.out.println(i + 1 + " : " + listOfFile[i].substring(0, listOfFile[i].length() - 4));
        }
        System.out.println("Vous pouvez choisir en entrant le chiffre correspondant au fichier");
        String FILENAME;
        try {
            int numOfFile = Integer.parseInt(scanner.nextLine());
            FILENAME = "worlds/" + listOfFile[numOfFile - 1];
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un chiffre");
            FILENAME = choiceOfWorld(scanner);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Veuillez entrer un chiffre correspondant a l'un de ceux affichés");
            FILENAME = choiceOfWorld(scanner);
        }
        return FILENAME;
    }
}

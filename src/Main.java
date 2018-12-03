import Exceptions.NoDirectoryOfThisNameException;
import Exceptions.NoTxtFileInDirectoryException;

import game.*;
import map.World;

import java.io.File;
import java.util.Scanner;

public class Main {
    //initiate / create world

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue dans COLOSSAL CAVE ADVENTURE !!");
        System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
        String resp = scanner.nextLine().toLowerCase();
        initiate(resp);
    }

    private static String[] listOfFiles(File rep) throws NoDirectoryOfThisNameException, NoTxtFileInDirectoryException {
        String[] list = rep.list();
        if (list == null)
            throw new NoDirectoryOfThisNameException();
        else if (list.length == 0)
            throw new NoTxtFileInDirectoryException();
        else
            return list;
    }

    private static String choiceOfWorld(String directory) throws NoDirectoryOfThisNameException, NoTxtFileInDirectoryException {
        String[] listOfFile;
        try {
            listOfFile = listOfFiles(new File(directory));
            for (int i = 0; i < listOfFile.length; i++) {
                if (listOfFile[i].endsWith(".txt"))
                    System.out.println(i + 1 + " : " + listOfFile[i].substring(0, listOfFile[i].length() - 4));
            }
            System.out.println("Vous pouvez choisir en entrant le chiffre correspondant au fichier");
            String FILENAME;
            try {
                int numOfFile = Integer.parseInt(scanner.nextLine());
                FILENAME = "worlds/" + listOfFile[numOfFile - 1];
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre");
                FILENAME = choiceOfWorld(directory);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Veuillez entrer un chiffre correspondant a l'un de ceux affichés");
                FILENAME = choiceOfWorld(directory);
            }
            return FILENAME;
        } catch (NoDirectoryOfThisNameException e) {
            throw new NoDirectoryOfThisNameException();
        } catch (NoTxtFileInDirectoryException e) {
            throw new NoTxtFileInDirectoryException();
        }
    }

    private static void initiate(String resp) {
        Player hero = null;
        String FILENAME;

        switch (resp) {
            case "y":
            case "yes":
            case "o":
            case "oui":
                try {
                    System.out.println("Vous avez choisi de jouer sur une partie sauvegardée");
                    FILENAME = choiceOfWorld("backups"); //TODO check l'extention des fichiers
                } catch (NoDirectoryOfThisNameException e) {
                    e.printStackTrace();
                } catch (NoTxtFileInDirectoryException e) {
                    System.out.println("Il n'y a pas de partie sauvegardée");
                    initiate("n");
                }
                break;

            case "n":
            case "no":
            case "non":
                try {
                    System.out.println("Vous avez choisi de commencer une nouvelle partie, merci de choisir un monde parmis la liste suivante");
                    FILENAME = choiceOfWorld("worlds");
                    File file = new File(FILENAME);
                    World world = new World(file);
                    System.out.println("Veuillez choisir un nom pour votre personnage");
                    String persoName = scanner.nextLine();
                    System.out.println("votre perso s'nomme " + persoName);
                    hero = new Player(persoName, world.getPlaceById(000));
                } catch (NoDirectoryOfThisNameException | NoTxtFileInDirectoryException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Nous n'avons pas compris la réponse, merci de répondre avec y ou n");
                System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
                resp = scanner.nextLine().toLowerCase();
                initiate(resp);
                break;
        }
    }
}

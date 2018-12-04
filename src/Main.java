import Exceptions.NoDirectoryOfThisNameException;
import Exceptions.NoTxtFileInDirectoryException;

import map.World;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static World world;

    public static void main(String[] args) {
        String filename;
        System.out.println("Bienvenue dans COLOSSAL CAVE ADVENTURE !!");
        System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
        String resp = scanner.nextLine().toLowerCase();
        filename = initiate(resp);
        File file = new File(filename);
        world = new World(file);

        if (world.getHero() == null) {
            System.out.println("Veuillez choisir un nom pour votre personnage");
            String persoName = scanner.nextLine();
            System.out.println("Bonne chance dans votre aventure " + persoName);
            world.setHero(persoName);
        } else
            System.out.println("Bon retour " + world.getHero().getName());

        while (true) {//TODO changer la condition d'arret du while
            String command = scanner.nextLine();
            world.action(command);
            System.out.println("------------------------------");
        }
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
        String filename;
        try {
            listOfFile = listOfFiles(new File(directory));
            for (int i = 0; i < listOfFile.length; i++) {
                if (listOfFile[i].endsWith(".txt"))
                    System.out.println(i + 1 + " : " + listOfFile[i].substring(0, listOfFile[i].length() - 4));
            }
            System.out.println("Vous pouvez choisir en entrant le chiffre correspondant au fichier");
            try {
                int numOfFile = Integer.parseInt(scanner.nextLine());
                filename = "worlds/" + listOfFile[numOfFile - 1];
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre");
                filename = choiceOfWorld(directory);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Veuillez entrer un chiffre correspondant a l'un de ceux affichés");
                filename = choiceOfWorld(directory);
            }
            return filename;
        } catch (NoDirectoryOfThisNameException e) {
            throw new NoDirectoryOfThisNameException();
        } catch (NoTxtFileInDirectoryException e) {
            throw new NoTxtFileInDirectoryException();
        }
    }

    private static String initiate(String resp) {
        String filename = null;

        switch (resp) {
            case "y":
            case "yes":
            case "o":
            case "oui":
                try {
                    System.out.println("Vous avez choisi de jouer sur une partie sauvegardée");
                    filename = choiceOfWorld("backups"); //TODO check l'extention des fichiers (pas forcement txt)
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
                    filename = choiceOfWorld("worlds");
                } catch (NoDirectoryOfThisNameException | NoTxtFileInDirectoryException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Nous n'avons pas compris la réponse, merci de répondre avec y ou n");
                System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
                resp = scanner.nextLine().toLowerCase();
                filename = initiate(resp);
                break;
        }

        return filename;
    }
}

import map.World;

import java.io.File;
import java.util.Scanner;

public class Main {

    //initiate / create world
    public static void main(String[] args) {

        String FILENAME = "fileTest.txt";

        //Le fichier .txt doit être placé a la racine du projet
        File file = new File(FILENAME);
        World w = new World(file);

        Scanner sc = new Scanner(Syste m.in);
        System.out.println("Veuillez choisir un nom pour votre personnage");
        String persoName = sc.nextLine();
        System.out.println("votre perso s'appelle " + persoName);
    }

    /*
    a partir de l'entré standard
    Scanner sc1 = new Scanner(System.in);

    a partir d'un chaine
    Scanner sc2 = new Scanner("coucou");

    a partir d'un fichier
    Scanner sc3 = new Scanner(new file("toto.txt"));
     */
}

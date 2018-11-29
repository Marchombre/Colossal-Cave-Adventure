import map.World;

import java.io.File;

public class Main {

    //initiate / create world
    public static void main(String[] args) {

        String FILENAME = "C:\\Users\\IzZiC\\Desktop\\Projet POO\\Colossal-Cave-Adventure\\fileTest.txt";

        //Le fichier .txt doit être placé a la racine du projet
        File file = new File(FILENAME);
        new World(file);
    }
}

import java.io.File;

public class Main {

    //initiate / create world
    public static void main(String[] args) {

        String FILENAME = "fileTest.txt";

        //Le fichier .txt doit être placé a la racine du projet
        File file = new File(FILENAME);
        World w = new World(/*file*/);


    }
}

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
    }

    public Place getPlaceById(int id){
        return floors.get(id/100).getPlace(id-((id/100)*100));
    }
}
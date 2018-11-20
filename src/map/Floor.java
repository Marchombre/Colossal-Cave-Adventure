package map;

import java.util.List;

public class Floor {

    int numFloor;
    List<Place> places;

    public Floor(int numFloor, List<Place> places){
        this.numFloor = numFloor;
        this.places = places;
    }

    public void addPlace(Place p){
        places.add(p);
    }
}

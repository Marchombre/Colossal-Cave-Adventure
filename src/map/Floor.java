package map;

import java.util.List;
/**
 * <p>
 * Floor is a class that represents floors of places in the game.
 * </p>
 */
public class Floor {
	/**
	 * The number of the floor
	 */

    int numFloor;
    /**
     * The list of the places in the floor.
     */
    List<Place> places;
/**
 * The constructor of Floor
 * @param numFloor
 * The number of the floor
 * @param places
 * The places in the floor
 */
    public Floor(int numFloor, List<Place> places){
        this.numFloor = numFloor;
        this.places = places;
    }
/**
 * Adds a place in a floor.
 * @param p
 * The place too add.
 */
    public void addPlace(Place p){
        places.add(p);
    }
/**
 * Returns a place
 * @param nPlace
 * The ID of the place to return
 * @return a place as a Place object
 */
    public Place getPlace(int nPlace){
        return places.get(nPlace);
    }
}

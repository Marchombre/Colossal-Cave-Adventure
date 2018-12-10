package map;
/**
 * <b>Exit is a class that represents a door in the game</b>
 * <p>
 * An exit is characterized by two places
 * @author azazga media
 *@version 1.0
 */
public class Exit {
	/**
	 * The first place of the exit.
	 */
    protected Place place1;
    /**
     * The Second Place of the exit.
     */
    protected Place place2;
/**
 * The Constructor of the exit
 * @param p1
 * The first place of the exit
 * @param p2
 * The second place of the exit
 */
    public Exit(Place p1, Place p2){
        place1 = p1;
        place2 = p2;

        p1.addExit(this);//est ce qu'on a le droit de faire ça ? Vu que l'objet est peut etre pas fini d'etre construit
        p2.addExit(this);
    }
/**
 * Returns the new place after crossing the exit
 * @param current
 * The Place where the player is
 * @return the new place after crossing the exit as a Place object.
 */
    public Place cross(Place current){
        if(current == place1)
            return place2;
        else
            return place1;
    }
}

package map;

public class LockedExit extends Exit {

    private boolean locked;

    public LockedExit(Place p1, Place p2){
        super(p1, p2);
        locked = true;
    }

    public void open(Key){

    }


}

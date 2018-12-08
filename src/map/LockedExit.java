package map;

import item.DoorKey;

public class LockedExit extends Exit {

    private boolean locked;
    private DoorKey key;

    public LockedExit(Place p1, Place p2, DoorKey dKey){
        super(p1, p2);
        locked = true;
        this.key = dKey;
    }

    public void unlock(DoorKey dKey){
        if(dKey == this.key)
            this.locked = false;
    }

    public boolean isTheGoodKey(DoorKey k){
        return k == this.key;
    }

    public boolean isLocked(){
        return locked;
    }
}
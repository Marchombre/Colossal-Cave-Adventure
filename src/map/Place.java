package map;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String name;
    private int id;
    private List<Exit> exits;

    public Place(int id, String name){
        this.id = id;
        this.name = name;
        this.exits = new ArrayList<>();
    }

    @Override
    public String toString(){
        return("Place's name is " + this.name + " and it's on floor n°" + getFloor());
    }

    public void addExit(Exit e){
        exits.add(e);
    }

    public int getId(){
        return id;
    }

    public void getExits(){
        String res = "";
        for(Exit e : exits)
            res += e.toString() + " ; ";
        System.out.println(res);
    }

    public int getFloor(){
        return (this.id/100)*100;
    }
}

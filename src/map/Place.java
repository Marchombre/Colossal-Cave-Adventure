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
        return("Place's name is " + this.name + " and it's on floor n" + getFloor());
    }

    public void addExit(Exit e){
        exits.add(e);
    }

    public Exit getExit(int num){
        Exit tmp = null;
        for(int i = 0; i < exits.size(); ++i) {
            if(num == i+1)
                tmp = exits.get(i);
        }
        return tmp;
    }

    public void getExits(){
        String res = "";
        for(int i = 0; i < exits.size(); ++i) {
            int val = i+1;
            res += "Door number " + val + " ";
        }
        System.out.println(res);
    }

    public int getFloor(){
        return (this.id/100);
    }
}

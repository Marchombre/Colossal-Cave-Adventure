package map;

public class Exit {
    protected Place place1;
    protected Place place2;

    public Exit(Place p1, Place p2){
        place1 = p1;
        place2 = p2;

        p1.addExit(this);//est ce qu'on a le droit de faire ça ? Vu que l'objet est peut etre pas fini d'etre construit
        p2.addExit(this);
    }

    public Place cross(Place current){
        if(current == place1)
            return place2;
        else
            return place1;
    }
}

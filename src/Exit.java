public class Exit {
    Place place1;
    Place place2;

    public Exit(Place p1, Place p2){
        place1 = p1;
        place2 = p2;

        p1.addExit(this);//est ce qu'on a le droit de faire ça ? Vu que l'objet est peut etre pas fini d'etre construit
        p2.addExit(this);
    }

    public void cross(){
        //todo récuperer la salle dans laquelle on est et si possible aller dans l'autre salle liée a la porte
    }

    @Override
    public String toString() {
        return (place1.getId() + "-" + place2.getId());
    }
}

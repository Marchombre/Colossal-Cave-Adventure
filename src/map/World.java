package map;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//je pense qu'il faut créer le monde en dernier -> c'est lui qui créé TOUT !
public class World {

    private List<Floor> floors;
    private int nbFloors;
    private final int NBFLOORS = 4;

    public World(File file){

        List<List<Place>> placesByFloor = new ArrayList<>();

        //on prérempli la liste avec un nombre de liste vide qui correspond au nombre d'étages
        for(int i = 0; i < NBFLOORS; ++i){
            List<Place> p = new ArrayList<>();
            placesByFloor.add(p);
        }

        //test mais doit etre fait comme ça
        int NBFLOOR = 2;

        //todo create les places
        (placesByFloor.get(NBFLOOR)).add(new Place(000, "Cuisine",NBFLOOR));


        //todo quand c fini on doit créer les etages donc on fera comme ça
        int index = 0;
        for(List<Place> pbf : placesByFloor){
            new Floor(index, pbf);
            ++index;
        }


        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts[0] == "map.Place")
                    System.out.println("gagné");
                else
                    System.out.println(parts[0]);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }








        /*FileChannel fc;

        //pour pouvoir lire dans un fichier on utilise un buffer pour accélérer la lecture et optimiser le programme
        try(FileInputStream fis = new FileInputStream(file)) {

            //On récupère le canal
            fc = fis.getChannel();
            //On en déduit la taille
            int size = (int)fc.size();
            //On crée un buffer correspondant à la taille du fichier
            ByteBuffer bBuff = ByteBuffer.allocate(size);

            //Démarrage de la lecture
            fc.read(bBuff);
            //On prépare à la lecture avec l'appel à flip
            bBuff.flip();

            //Puisque nous avons utilisé un buffer de byte afin de récupérer les données
            //Nous pouvons utiliser un tableau de byte
            //La méthode array retourne un tableau de byte
            byte[] tabByte = bBuff.array();

            for (byte bit : tabByte) {
                System.out.print((char) (bit & 0xFF)); // le "& 0xFF" permet de gérer correctement les caractères accentués !
            }
            System.out.println("");

        } catch (FileNotFoundException e) {
            // Cette exception est levée si l'objet FileInputStream ne trouve aucun fichier
            e.printStackTrace();
        } catch (IOException e) {
            // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
            e.printStackTrace();
        }*/
    }

    public World(){
        List<Place> placeF0 = new ArrayList<>();
        Place p000 = new Place(000, "place1",0); placeF0.add(p000);
        Place p001 = new Place(002, "place3",0); placeF0.add(p001);
        Place p002 = new Place(001, "place2",0); placeF0.add(p002);

        Floor f0 = new Floor(0, placeF0);

        List<Place> placeF1 = new ArrayList<>();
        Place p100 = new Place(100, "place1",1); placeF1.add(p100);
        Place p101 = new Place(101, "place2",1); placeF1.add(p101);
        Place p102 = new Place(102, "place2",1); placeF1.add(p102);
        Place p103 = new Place(103, "place4",1); placeF1.add(p103);
        Place p104 = new Place(104, "place5",1); placeF1.add(p104);

        Floor f1 = new Floor(1, placeF1);

        List<Place> placeF2 = new ArrayList<>();
        Place p200 = new Place(200, "place1",2); placeF2.add(p200);
        Place p201 = new Place(201, "place2",2); placeF2.add(p201);
        Place p202 = new Place(202, "place3",2); placeF2.add(p202);
        Place p203 = new Place(203, "place4",2); placeF2.add(p203);
        Place p204 = new Place(204, "place5",2); placeF2.add(p204);
        Place p205 = new Place(205, "place6",2); placeF2.add(p205);
        Place p206 = new Place(206, "place7",2); placeF2.add(p206);

        Floor f2 = new Floor(2, placeF2);

        List<Place> placeF3 = new ArrayList<>();
        Place p300 = new Place(300, "place1",3); placeF3.add(p300);
        Place p301 = new Place(301, "place2",3); placeF3.add(p301);
        Place p302 = new Place(302, "place3",3); placeF3.add(p302);
        Place p303 = new Place(303, "place4",3); placeF3.add(p303);
        Place p304 = new Place(304, "place5",3); placeF3.add(p304);
        Place p305 = new Place(305, "place6",3); placeF3.add(p305);
        Place p306 = new Place(306, "place7",3); placeF3.add(p306);
        Place p307 = new Place(307, "place8",3); placeF3.add(p307);
        Place p308 = new Place(308, "place9",3); placeF3.add(p308);
        Place p309 = new Place(309, "place10",3); placeF3.add(p309);
        Place p310 = new Place(310, "place11",3); placeF3.add(p310);
        Place p311 = new Place(311, "place12",3); placeF3.add(p311);
        Place p312 = new Place(312, "place13",3); placeF3.add(p312);
        Place p313 = new Place(313, "place14",3); placeF3.add(p313);
        Place p314 = new Place(314, "place15",3); placeF3.add(p314);
        Place p315 = new Place(315, "place16",3); placeF3.add(p315);

        Floor f3 = new Floor(3, placeF3);

        List<Place> placeF4 = new ArrayList<>();
        Place p400 = new Place(400, "place1",4); placeF4.add(p400);
        Place p401 = new Place(401, "place2",4); placeF4.add(p401);
        Place p402 = new Place(402, "place3",4); placeF4.add(p402);
        Place p403 = new Place(403, "place4",4); placeF4.add(p403);
        Place p404 = new Place(404, "place5",4); placeF4.add(p404);
        Place p405 = new Place(405, "place6",4); placeF4.add(p405);
        Place p406 = new Place(406, "place7",4); placeF4.add(p406);
        Place p407 = new Place(407, "place8",4); placeF4.add(p407);
        Place p408 = new Place(408, "place9",4); placeF4.add(p408);

        Floor f4 = new Floor(4, placeF4);

        List<Place> placeF5 = new ArrayList<>();
        Place p500 = new Place(500, "place1",5); placeF5.add(p500);

        Floor f5 = new Floor(5, placeF5);

        new Exit(p000,p001);
        new Exit(p001,p002);

        new Exit(p002,p100);

        new Exit(p100,p101);
        new Exit(p100,p102);
        new Exit(p100,p103);
        new Exit(p101,p104);
        new Exit(p103,p104);
        new Exit(p102,p104);

        new Exit(p104,p200);

        new Exit(p200,p201);
        new Exit(p201,p202);
        new Exit(p201,p203);
        new Exit(p202,p204);
        new Exit(p203,p206);
        new Exit(p204,p205);
        new Exit(p205,p206);

        new Exit(p206,p300);

        new Exit(p300,p301);
        new Exit(p300,p302);
        new Exit(p300,p303);
        new Exit(p303,p304);
        new Exit(p301,p306);
        new Exit(p306,p308);
        new Exit(p302,p305);
        new Exit(p305,p307);
        new Exit(p307,p309);
        new Exit(p308,p309);
        new Exit(p309,p310);
        new Exit(p310,p312);
        new Exit(p310,p311);
        new Exit(p311,p313);
        new Exit(p313,p314);
        new Exit(p314,p315);

        new Exit(p315,p400);

        new Exit(p400,p401);
        new Exit(p400,p402);
        new Exit(p402,p403);
        new Exit(p403,p404);
        new Exit(p403,p405);
        new Exit(p404,p406);
        new Exit(p405,p406);
        new Exit(p405,p407);
        new Exit(p407,p408);

        new Exit(p408,p500);

        p309.getExits();
    }
}

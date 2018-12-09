import Exceptions.NoDirectoryOfThisNameException;
import Exceptions.NoTxtFileInDirectoryException;
import map.World;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static World world;

    public static void main(String[] args)  throws InterruptedException {
        String filename;
        String a[]={"||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n",
        "||  _       _ _ _ _    _    __      _    _ _ _ _ _   _ _ _ _  ||\n",
        "|| | |     |_ _ _  |  | |  |   \\   | |  |  _ _ _ _| |  _ _  | ||\n",
        "|| | |      _ _ _| |  | |  | |\\ \\  | |  | |_ _ _    | |   | | ||\n",
        "|| | |     |_ _ _  |  | |  | | \\ \\ | |  |  _ _ _|   | |   | | ||\n",
        "|| | |_ _   _ _ _| |  | |  | |  \\ \\| |  | |         | |_ _| | ||\n",
        "|| |_ _ _| |_ _ _ _|  |_|  |_|   \\ __|  |_|         |_ _ _ _| ||\n",
        "||                                                            ||  \n",
        "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"};

        for (int i = 0;
                i < a.length;
                i++) {
        	for (int j = 0; j < a[i].length(); j++) {
				
			}
               Thread.sleep(60);
               System.out.print(a[i]);
           }
        
        String bienvenue ="Bienvenue dans le donjon du monstre LICENCE 3 INFO !!\n";
   String sauvegarde="Voulez vous charger une partie sauvegardée ? (y/n)\n";
   for (int i = 0;
           i < bienvenue.length();
           i++) {
          Thread.sleep(20);
          System.out.print(bienvenue.charAt(i));
      }
   for (int i = 0;
           i < sauvegarde.length();
           i++) {
          Thread.sleep(20);
          System.out.print(sauvegarde.charAt(i));
      }
   
   
        String resp = scanner.nextLine().toLowerCase();
        filename = initiate(resp);
        File file = new File(filename);
        world = new World(file);

        if (world.getHero() == null) {
            String chooseName="Veuillez choisir un nom pour votre personnage\n";
            for (int i = 0;
                    i < chooseName.length();
                    i++) {
                   Thread.sleep(20);
                   System.out.print(chooseName.charAt(i));
               }
            String persoName = scanner.nextLine();
            String bonneChance="Bonne chance dans votre aventure " + persoName +"\n";
            String intro=persoName +
                    ", après tant d'année à chercher ce lieux maudit vous l'avez enfin trouvé! Le donjon de la LICENCE 3 INFO.\n" +
                    "Vous le voyez se profiler à travers la roche des montagnes. Il n’est pas très haut, mais dangereux. \n" +
                    "Ses murs semblent épais, ses rares fenêtres étroites et il s’en dégage une impression malsaine!\n";
            for (int i = 0;
                    i < intro.length();
                    i++) {
                   Thread.sleep(20);
                   System.out.print(intro.charAt(i));
               }
            
                  String  mission="La mission que vous vous êtes donné il y a bien longtemps est sur le point de se finir!\n" +
                    "Atteindre le haut de ce donjon pour pouvoir vaincre le PUISSANT et TERRIFIANT monstre\n" +
                    "DIPLOME DE LA LICENCE 3 INFO!\n";
                    for (int i = 0;
                            i < mission.length();
                            i++) {
                           Thread.sleep(20);
                           System.out.print(mission.charAt(i));
                       }
            System.out.println("------------------------------");
            world.setHero(persoName);
        } else
            System.out.println("Bon retour " + world.getHero().getName());

        while (world.getHero().isAlive() && !world.getEndOfGame() && !world.getQuit()) {
            String command = scanner.nextLine();
            world.action(command);
            System.out.println("------------------------------");
        }
        if(!world.getHero().isAlive())
            System.out.println("Echec, vous etes mort");
        else if (world.getEndOfGame())
            System.out.println("A la prochaine ;)");
    }

    private static String[] listOfFiles(File rep) throws NoDirectoryOfThisNameException, NoTxtFileInDirectoryException {
        String[] list = rep.list();
        if (list == null)
            throw new NoDirectoryOfThisNameException();
        else if (list.length == 0)
            throw new NoTxtFileInDirectoryException();
        else
            return list;
    }

    private static String choiceOfWorld(String directory) throws NoDirectoryOfThisNameException, NoTxtFileInDirectoryException {
        String[] listOfFile;
        String filename;
        try {
            listOfFile = listOfFiles(new File(directory));
            for (int i = 0; i < listOfFile.length; i++) {
                if (listOfFile[i].endsWith(".txt"))
                    System.out.println(i + 1 + " : " + listOfFile[i].substring(0, listOfFile[i].length() - 4));
            }
            String worldchoice="Vous pouvez choisir en entrant le chiffre correspondant au fichier\n";
            for (int i = 0;
                    i < worldchoice.length();
                    i++) {
                   try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   System.out.print(worldchoice.charAt(i));
               }
            try {
                int numOfFile = Integer.parseInt(scanner.nextLine());
                filename = "worlds/" + listOfFile[numOfFile - 1];
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre");
                filename = choiceOfWorld(directory);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Veuillez entrer un chiffre correspondant a l'un de ceux affichés");
                filename = choiceOfWorld(directory);
            }
            return filename;
        } catch (NoDirectoryOfThisNameException e) {
            throw new NoDirectoryOfThisNameException();
        } catch (NoTxtFileInDirectoryException e) {
            throw new NoTxtFileInDirectoryException();
        }
    }

    private static String initiate(String resp) {
        String filename = null;

        switch (resp) {
            case "y":
            case "yes":
            case "o":
            case "oui":
                try {
                    System.out.println("Vous avez choisi de jouer sur une partie sauvegardée");
                    filename = choiceOfWorld("backups"); //TODO check l'extention des fichiers (pas forcement txt)
                } catch (NoDirectoryOfThisNameException e) {
                    e.printStackTrace();
                } catch (NoTxtFileInDirectoryException e) {
                    System.out.println("Il n'y a pas de partie sauvegardée");
                    initiate("n");
                }
                break;

            case "n":
            case "no":
            case "non":
                try {
                    String choice="Vous avez choisi de commencer une nouvelle partie, merci de choisir un monde parmis la liste suivante\n";
                    for (int i = 0;
                            i < choice.length();
                            i++) {
                           try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                           System.out.print(choice.charAt(i));
                       }
                    filename = choiceOfWorld("worlds");
                } catch (NoDirectoryOfThisNameException | NoTxtFileInDirectoryException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Nous n'avons pas compris la réponse, merci de répondre avec y ou n");
                System.out.println("Voulez vous charger une partie sauvegardée ? (y/n)");
                resp = scanner.nextLine().toLowerCase();
                filename = initiate(resp);
                break;
        }

        return filename;
    }
}

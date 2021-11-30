package view;

import model.Dungeon;
import model.Player;
import model.room.Room;

public class Drawer {
    public String draw (Room room) {
        return room.getValuesOfRoom();
    }

    public String printMap(Dungeon dungeon) {
        String viewMap = "";

        for (int raw=0; raw<=dungeon.getSizeOfMatrix()-1; raw++){
            for (int column=0; column<=dungeon.getSizeOfMatrix()-1; column++){
                if (dungeon.getMap()[raw][column].isVisited()) {
                    viewMap = viewMap + dungeon.getMap()[raw][column].accept(this);
                }
                if (!dungeon.getMap()[raw][column].isVisited()) viewMap = viewMap + "*";
                if (dungeon.getMap()[raw][column].playerInThisRoom()) viewMap = viewMap + "+";
                if (dungeon.getMap()[raw][column].canGoToEast()) viewMap = viewMap + " --- ";
            }
            viewMap += "\n";
            for (int column=0; column<=dungeon.getSizeOfMatrix()-1; column++){
                if (dungeon.getMap()[raw][column].canGoToSouth()) viewMap = viewMap + "|     ";
            }
            viewMap += "\n";
        }
        return viewMap;

    }

    public String printStatus(Player player){
        return "hp = "+player.getHealth()+"\nforce = "+player.getStrength();
    }

    public String printTutos (){
        return "-Pour vous déplacer, utilsez les flèches directionnelles\n" +
                "-Pour ouvrir l'inventaire,appuyer sur I\n"+
                "-Pour utilser vos objets utilser 1, 2 ou 3 une fois dans l'inventaire\n" +
                "-Les combats et la récupération des objets sont automatique";
    }
    public String printIntro (){
        return "Bienvenue dans le donjon, votre but et " +
                "d'arriver à la fin, bonne chance \n" +
                "appuyer sur entrée pour commencer ";
    }

}

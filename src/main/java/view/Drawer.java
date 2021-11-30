package view;

import model.Door;
import model.Dungeon;
import model.Player;
import model.Wall;
import model.content.HealPotion;
import model.content.PoisonPotion;
import model.content.StrengthPotion;
import model.room.Room;
import model.room.RoomItem;
import model.room.RoomMonster;

public class Drawer {
    public String drawRoom(Room room) {
        return "" + room.getValuesOfRoom();
    }

    public String drawDescriptionHealPotion(HealPotion item){return "Oh, vous tomber sur une potion de vie, vous gagner " + item.getPowerUp() + " de vie.";}

    public String drawDescriptionStrengthPotion(StrengthPotion item){return "Oh, vous tomber sur une potion de force, vous gagner " + item.getPowerUp() + " de force.";}

    public String drawDescriptionPoisonPotion(PoisonPotion item){return "Oh, it's a trap, vous perdez perdez " + item.getDamage() +" de vie.";}

    public String drawDescriptionWall() {return "Un mur qui semble solide vous bloque la route";}

    public String drawDescriptionDoor() {return "Un porte se trouve devant vous. Vous traversez cette porte.";}

    public String drawDescritioonRoomMonster(RoomMonster room) {
        if (room.getMonster().isDead()) return "Un cadavre de monstre gît à vos pieds.\nIl semble qu'il soit tomber sur vous";
        return "Un monstre se dresse sur votre chemin, vous devez le combattre";
    }

    public String drawDescritioonRoomItem(RoomItem room) {
        if (room.getItem() == null) return "Un coffre vide se tient au beau milleu de la salle.\nVous avez déjà pris son contenu.";
        return "Un coffre se tient au beau millieu de la salle.\nVous prenez son contenue et continuer votre route.";
    }

    public String drawDescritioonRoomFinish() {return "Bienvenue à la fin de ce donjon,\n dans cette dernière salle pour votre dernière épreuve.";}

    public String drawDescritioonRoomStart() {return "Vous êtes de retour dans la salle de départ";}

    public String printMap(Dungeon dungeon) {
        String viewMap = "";

        for (int raw=0; raw<=dungeon.getSizeOfMatrix()-1; raw++){
            for (int column=0; column<=dungeon.getSizeOfMatrix()-1; column++){
                if (dungeon.getMap()[raw][column].isVisited()) {
                    viewMap = viewMap + dungeon.getMap()[raw][column].drawRoom(this);
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
                "-Pour utilser vos objets utilser A pour le premier, " +
                "Z pour le second ou E pour le troisième une fois dans l'inventaire\n" +
                "-La récupération des objets est automatique\n" +
                "-Dans une salle où il y a un monstre,vous pouvez soit retourner dans une salle déjà visiter," +
                "soit combattre le monstre en appuyant sur entrée";
    }
    public String printIntro (){
        return "Bienvenue dans le donjon, votre but et " +
                "d'arriver à la fin, bonne chance \n\n" +
                "---appuyer sur entrée pour commencer---";
    }

    public String printInventory (Player player){
        String viewInventory = "";
        for(int index = 0; index<3; index++){
            if(index < player.getInventory().size()) viewInventory +=(index+1)+". ?????\n";
            else viewInventory +=(index+1)+". -------\n";
        }
        return viewInventory;
    }

}


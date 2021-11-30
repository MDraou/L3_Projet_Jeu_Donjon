package model.room;

import model.Player;

public class RoomStart extends Room {

    public RoomStart(Player player, int x, int y){
        super(x,y);
        super.setFirstRoom();
        super.setValuesOfRoom("0");
        super.playerEntersInRoom(player);
    }

    @Override
    public boolean isVisited() {
        return true;
    }

    public String description() {
        String message = "Vous êtes de retour dans la salle de départ";
        return message;
    }

    @Override
    public void setInLastRoom() {
    }
}

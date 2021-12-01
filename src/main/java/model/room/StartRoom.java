package model.room;

import model.Player;
import view.Drawer;

public class StartRoom extends Room {

    public StartRoom(Player player, int x, int y){
        super(x,y);
        super.setValuesOfRoom(0);
        super.playerEntersInRoom(player);
    }

    @Override
    public boolean isVisited() {
        return true;
    }

    public String description(Drawer drawer) {
        return drawer.drawDescritioonRoomStart();
    }

    @Override
    public void setInLastRoom() {
    }

    @Override
    public void takeItem() {}
}

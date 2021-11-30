package model.room;

import model.Monster;
import view.Drawer;

public class RoomMonster extends Room {

    public RoomMonster(Monster monster, int x, int y){
        super(x,y);
        super.monster = monster;
        super.setValuesOfRoom(1);
    }

    @Override
    public boolean isVisited() {
        return monster.isDead();
    }

    public String description(Drawer drawer) {
        return drawer.drawDescritioonRoomMonster(this);
    }

    @Override
    public void setInLastRoom() {
    }

    @Override
    public void takeItem() {}
}

package model.room;

import view.Drawer;

public class LastRoom extends Room {
    private boolean inLastRoom;

    public LastRoom(int x, int y){
        super(x,y);
        super.setLastRoom();
        this.inLastRoom = false;
        super.setValuesOfRoom(4);
    }

    @Override
    public boolean isVisited() {
        return inLastRoom;
    }

    public void setInLastRoom() {
        this.inLastRoom = true;
    }

    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescritioonRoomFinish();
    }

    @Override
    public void takeItem() {}
}

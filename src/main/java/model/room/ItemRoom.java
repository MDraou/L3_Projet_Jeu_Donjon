package model.room;

import model.content.Item;
import view.Drawer;

public class ItemRoom extends Room {

    public ItemRoom(Item item, int x, int y){
        super(x,y);
        super.item = item;
        super.setValuesOfRoom(2);
    }

    @Override
    public boolean isVisited() {
        return item==null;
    }

    public String description(Drawer drawer) {
        return drawer.drawDescritioonRoomItem(this);
    }

    @Override
    public void setInLastRoom() {
    }

    @Override
    public void takeItem() {super.item = null;}

}

package model.room;

public class RoomStart extends Room {

    public RoomStart(){
        super();
        super.setFirstRoom();
        this.valuesOfRoom = "0";
    }

    @Override
    public boolean isVisited() {
        return true;
    }

}

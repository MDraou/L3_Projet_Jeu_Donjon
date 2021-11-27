package model.room;

public class RoomFinish extends Room {
    private boolean inLastRoom;

    public RoomFinish(){
        super();
        super.setLastRoom();
        this.inLastRoom = false;
        this.valuesOfRoom = "4";
    }

    @Override
    public boolean isVisited() {
        return inLastRoom;
    }

    public void setInLastRoom() {
        this.inLastRoom = true;
    }


}

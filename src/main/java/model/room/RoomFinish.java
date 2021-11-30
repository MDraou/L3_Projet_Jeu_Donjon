package model.room;

public class RoomFinish extends Room {
    private boolean inLastRoom;

    public RoomFinish(int x, int y){
        super(x,y);
        super.setLastRoom();
        this.inLastRoom = false;
        super.setValuesOfRoom("4");
    }

    @Override
    public boolean isVisited() {
        return inLastRoom;
    }

    public void setInLastRoom() {
        this.inLastRoom = true;
    }

    @Override
    public String description() {
        String message = "Bienvenue à la fin de ce donjon,\n dans cette dernière salle pour votre dernière épreuve.";
        return message;
    }

}

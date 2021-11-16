package model;

public class CreatorRoomFinish implements CreatorRoom {
    @Override
    public Room createRoom() {
        return new RoomFinish();
    }
}

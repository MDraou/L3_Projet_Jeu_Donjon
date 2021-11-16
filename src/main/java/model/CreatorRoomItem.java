package model;

public class CreatorRoomItem implements CreatorRoom {
    @Override
    public Room createRoom() {
        return new RoomItem();
    }
}

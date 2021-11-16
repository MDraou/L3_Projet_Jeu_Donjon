package model;

public class CreatorRoomStart implements CreatorRoom {
    @Override
    public Room createRoom() {
        return new RoomStart();
    }
}

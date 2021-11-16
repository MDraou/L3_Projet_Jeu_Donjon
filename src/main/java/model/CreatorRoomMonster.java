package model;

public class CreatorRoomMonster implements CreatorRoom {
    @Override
    public Room createRoom() {
        return new RoomStart();
    }
}

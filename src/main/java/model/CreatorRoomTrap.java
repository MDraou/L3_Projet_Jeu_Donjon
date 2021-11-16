package model;

public class CreatorRoomTrap implements CreatorRoom {
    @Override
    public Room createRoom() {
        return new RoomTrap();
    }
}

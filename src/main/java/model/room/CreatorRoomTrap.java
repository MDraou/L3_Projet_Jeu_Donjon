package model.room;

import java.util.Random;

public class CreatorRoomTrap implements CreatorRoom {
    @Override
    public Room createRoom(Random rand) {
        return new RoomTrap(rand);
    }
}

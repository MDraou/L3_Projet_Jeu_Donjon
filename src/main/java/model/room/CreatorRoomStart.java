package model.room;

import java.util.Random;

public class CreatorRoomStart implements CreatorRoom {
    @Override
    public Room createRoom(Random rand) {
        return new RoomStart();
    }
}

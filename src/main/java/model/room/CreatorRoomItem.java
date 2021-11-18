package model.room;

import java.util.Random;

public class CreatorRoomItem implements CreatorRoom {
    @Override
    public Room createRoom(Random rand) {
        return new RoomItem(rand);
    }
}

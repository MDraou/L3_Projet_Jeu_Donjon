package model;

import java.util.Random;

public class CreatorRoomFinish implements CreatorRoom {
    @Override
    public Room createRoom(Random rand) {
        return new RoomFinish();
    }
}

package model;

import java.util.Random;

public class CreatorRoomMonster implements CreatorRoom {
    @Override
    public Room createRoom(Random rand) {
        return new RoomMonster(rand);
    }
}

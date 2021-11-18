package model;

import java.util.Random;

public class RandomRoom {
    CreatorRoom[] typesOfRoom;
    Random rand;

    public RandomRoom() {
        this.typesOfRoom = new CreatorRoom[]{
                new CreatorRoomMonster(),new CreatorRoomItem(),new CreatorRoomTrap()
        };
        this.rand = new Random();
    }

    public Room createRandomRoom(){
        return typesOfRoom[rand.nextInt(3)].createRoom(rand);
    }
}

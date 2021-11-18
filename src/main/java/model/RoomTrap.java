package model;

import java.util.Random;

public class RoomTrap extends Room {
    Trap trap;

    public RoomTrap (Random rand){
        super();
        this.trap = new Trap(rand.nextInt(5));
    }
}

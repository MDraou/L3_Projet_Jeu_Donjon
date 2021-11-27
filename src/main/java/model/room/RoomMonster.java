package model.room;

import model.Monster;

import java.util.Random;

public class RoomMonster extends Room {
    private Monster monster;

    public RoomMonster(Monster monster){
        super();
        this.monster = monster;
        this.valuesOfRoom = "1";
    }

    @Override
    public boolean isVisited() {
        return monster.isDead();
    }


}

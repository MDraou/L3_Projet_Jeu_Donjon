package model.room;

import model.Monster;

import java.util.Random;

public class RoomMonster extends Room {
    private Monster monster;

    public RoomMonster(Monster monster, int x, int y){
        super(x,y);
        this.monster = monster;
        super.setValuesOfRoom("1");
    }

    /*@Override
    public boolean isVisited() {
        return monster.isDead();
    }*/


}

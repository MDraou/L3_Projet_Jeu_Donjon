package model.room;

import model.Monster;

import java.util.Random;

public class RoomMonster extends Room {

    public RoomMonster(Monster monster, int x, int y){
        super(x,y);
        super.monster = monster;
        super.setValuesOfRoom("1");
    }

    @Override
    public boolean isVisited() {
        return monster.isDead();
    }

    public String description() {
        String message = "Un monstre se dresse sur votre chemin, vous devez le combattre";
        return message;
    }

    @Override
    public void setInLastRoom() {
    }
}

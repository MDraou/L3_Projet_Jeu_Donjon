package model.room;

import model.Monster;
import model.content.HealPotion;
import model.content.Item;
import model.content.StrengthPotion;
import model.content.PoisonPotion;

import java.util.Random;

public class CreatorRoomRandom implements CreatorsRoom {
    private int x, y;

    public CreatorRoomRandom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Room createRandomRoom(){
        Random rand = new Random();
        Item[] itemTypes = new Item[]{
                new PoisonPotion(rand.nextInt(5) + 1), new StrengthPotion(rand.nextInt(5) + 1), new HealPotion(rand.nextInt(5) + 1)
        };
        Item item = itemTypes[rand.nextInt(3)];
        Monster monster = new Monster(rand.nextInt(10)+1, rand.nextInt(5)+1);
        Room[] typesOfRoom = new Room[]{
                new MonsterRoom(monster, x, y), new ItemRoom(item, x, y)
        };
        return typesOfRoom[rand.nextInt(2)];
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

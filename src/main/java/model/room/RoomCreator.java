package model.room;

import model.Monster;
import model.content.HealPotion;
import model.content.Item;
import model.content.StrengthPotion;
import model.content.Trap;

import java.util.Random;

public class RoomCreator {
    private Room[] typesOfRoom;
    private Item[] itemTypes;
    private Random rand;

    public RoomCreator() {
        this.rand = new Random();
        this.itemTypes = new Item[]{
                new Trap(rand.nextInt(5)+1), new StrengthPotion(rand.nextInt(5)+1), new HealPotion(rand.nextInt(5)+1)
        };
        Item item = itemTypes[rand.nextInt(3)];
        Monster monster = new Monster(rand.nextInt(5+1), rand.nextInt(5+1));
        this.typesOfRoom = new Room[]{
                new RoomMonster(monster),new RoomItem(item)
        };
    }

    public Room createRandomRoom(){
        return typesOfRoom[rand.nextInt(2)];
    }
}

package model.room;

import model.content.HealPotion;
import model.content.Item;
import model.content.StrengthPotion;
import model.content.Trap;

import java.util.ArrayList;
import java.util.Random;

public class RoomItem extends Room {
    private Item item;
    private Item[] itemTypes;

    public RoomItem(Item item, int x, int y){
        super(x,y);
        this.item = item;
        super.setValuesOfRoom("2");
    }

    /*@Override
    public boolean isVisited() {
        return item.isUsed();
    }*/


}

package model;

import model.battle.BattleMode;
import model.content.Item;
import model.room.Room;
import view.View;

import java.util.LinkedList;

public class Player extends Fighter {
    private View view ;
    private Room currentRoom;
    private LinkedList<Item> inventory;
    private BattleMode battleMode;


    public Player(View view,BattleMode battleMode, int health, int strength) {
        super(health, strength);
        this.view = view;
        inventory = new LinkedList<>();
        this.battleMode = battleMode;
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }

    public void increaseHealth(int quantity) {
        this.health += quantity;
    }

    public void increaseSrength(int quantity) {
        this.strength += quantity;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public View getView() {
        return view;
    }

    public void battle(Fighter enemy){ battleMode.battle(this,enemy); }

    public void addItemInInventory (Item item){
        inventory.add(item);
    }

    public void removeLastItemInInventory (){
        inventory.removeFirst();
    }

    public void removeFromInventory (int index) {inventory.remove(index);}
}

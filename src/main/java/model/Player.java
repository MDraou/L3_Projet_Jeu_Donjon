package model;

import model.content.Item;
import model.room.Room;
import view.View;

import java.util.ArrayList;

public class Player extends Fighter {
    private View view ;
    private Dungeon dungeon;
    private Room currentRoom;
    private ArrayList<Item> inventory;


    public Player(View view, int health, int strength) {
        super(health, strength);
        this.view = view;
        inventory = new ArrayList<>();
    }

    public void goNorth() {
        if (currentRoom.canGoToNorth()) {
            this.currentRoom.playerEntersInRoom(null);
            this.currentRoom = dungeon.getRoomInXAndInY(currentRoom.getX()-1, currentRoom.getY());
            if (currentRoom.isLastRoom()) currentRoom.setInLastRoom();
            this.currentRoom.playerEntersInRoom(this);
            view.handleMove(currentRoom,dungeon,this);
        }
        else {
            view.descriptionSide(currentRoom.getNorthSide());
        }
    }

    public void goSouth() {
        if (currentRoom.canGoToSouth()) {
            this.currentRoom.playerEntersInRoom(null);
            this.currentRoom = dungeon.getRoomInXAndInY(currentRoom.getX()+1, currentRoom.getY());
            if (currentRoom.isLastRoom()) currentRoom.setInLastRoom();
            this.currentRoom.playerEntersInRoom(this);
            view.handleMove(currentRoom,dungeon,this);
        }
        else {
            view.descriptionSide(currentRoom.getSouthSide());
        }
    }

    public void goEast() {
        if (currentRoom.canGoToEast()) {
            this.currentRoom.playerEntersInRoom(null);
            this.currentRoom = dungeon.getRoomInXAndInY(currentRoom.getX(), currentRoom.getY()+1);
            if (currentRoom.isLastRoom()) currentRoom.setInLastRoom();
            this.currentRoom.playerEntersInRoom(this);
            view.handleMove(currentRoom,dungeon,this);
        }
        else {
            view.descriptionSide(currentRoom.getEastSide());
        }
    }

    public void goWest() {
        if (currentRoom.canGoToWest()) {
            view.descriptionSide(currentRoom.getWestSide());
            this.currentRoom.playerEntersInRoom(null);
            this.currentRoom = dungeon.getRoomInXAndInY(currentRoom.getX(), currentRoom.getY()-1);
            if (currentRoom.isLastRoom()) currentRoom.setInLastRoom();
            this.currentRoom.playerEntersInRoom(this);
            view.handleMove(currentRoom,dungeon,this);
        }
        else {
            view.descriptionSide(currentRoom.getWestSide());
        }
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public ArrayList<Item> getInventory() {
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
}

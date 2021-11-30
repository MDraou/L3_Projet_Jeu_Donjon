package model.room;

import model.*;
import model.content.Item;
import view.Drawer;

public abstract class Room {
    private Side northSide, eastSide, southSide, westSide;
    private Boolean isLastRoom;
    private int valuesOfRoom;
    private Player player;
    private final int x;
    private final int y;
    Monster monster;
    Item item;

    public Room(int x, int y) {
        this.northSide = new Wall();
        this.eastSide = new Wall();
        this.southSide = new Wall();
        this.westSide = new Wall();
        this.isLastRoom = false;
        this.player = null;
        this.x = x;
        this.y = y;
    }

    public boolean canGoToNorth(){
        return northSide.canGoThere();
    }

    public boolean canGoToEast(){
        return eastSide.canGoThere();
    }

    public boolean canGoToSouth(){
        return southSide.canGoThere();
    }

    public boolean canGoToWest(){
        return westSide.canGoThere();
    }

    public void addDoorToNorth(){
        this.northSide = new Door();
    }

    public void addDoorToEast(){
        this.eastSide = new Door();
    }

    public void addDoorToSouth(){
        this.southSide = new Door();
    }

    public void addDoorToWest(){
        this.westSide = new Door();
    }

    public Side getEastSide() { return eastSide; }

    public Side getNorthSide() { return northSide; }

    public Side getSouthSide() { return southSide; }

    public Side getWestSide() { return westSide; }

    public void setLastRoom(){
        isLastRoom = true;
    }

    public boolean isLastRoom() { return isLastRoom;}

    public abstract boolean isVisited();

    public abstract String description(Drawer drawer);

    public abstract void setInLastRoom();

    public String drawRoom(Drawer drawer) {
        return drawer.drawRoom(this);
    }

    public void playerEntersInRoom(Player player){
        this.player = player;
    }

    public boolean playerInThisRoom() {
        return !(player == null);
    }

    public int getValuesOfRoom() {
        return valuesOfRoom;
    }

    public void setValuesOfRoom(int valuesOfRoom) {
        this.valuesOfRoom = valuesOfRoom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Monster getMonster() { return monster; }

    public boolean isMonster() {return monster != null;}

    public Item getItem() { return item; }

    public boolean isItem() {return item != null;}

    public abstract void takeItem();
}

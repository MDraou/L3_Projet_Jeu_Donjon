package model.room;

import model.*;
import view.Drawer;

public abstract class Room {
    private Side northSide, eastSide, southSide, westSide;
    private Boolean isFirstRoom;
    private Boolean isLastRoom;
    private String valuesOfRoom;
    private Player player;
    private int x;
    private int y;
    Monster monster;
    boolean isVisited = false;

    public Room(int x, int y) {
        this.northSide = new Wall();
        this.eastSide = new Wall();
        this.southSide = new Wall();
        this.westSide = new Wall();
        this.isFirstRoom = false;
        this.isLastRoom = false;
        this.player = null;
        this.x = x;
        this.y = y;
    }

    public boolean canGoToNorth(){
        return northSide.canThisGo();
    }

    public boolean canGoToEast(){
        return eastSide.canThisGo();
    }

    public boolean canGoToSouth(){
        return southSide.canThisGo();
    }

    public boolean canGoToWest(){
        return westSide.canThisGo();
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

    public void setFirstRoom() {isFirstRoom = true;}

    public boolean isLastRoom() { return isLastRoom;}

    public boolean isFirstRoom() { return isFirstRoom;}

    //public abstract boolean isVisited();

    public abstract String description();

    public abstract void setInLastRoom();

    public boolean isVisited(){
        return isVisited;
    }

    public String accept(Drawer drawer) {
        return drawer.draw(this);
    }

    public void playerEntersInRoom(Player player){
        this.player = player;
        this.isVisited = true;
    }

    public boolean playerInThisRoom() {
        return !(player == null);
    }

    public String getValuesOfRoom() {
        return valuesOfRoom;
    }

    public void setValuesOfRoom(String valuesOfRoom) {
        this.valuesOfRoom = valuesOfRoom;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMonster() {return !(monster == null);}
}

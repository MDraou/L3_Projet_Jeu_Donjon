package model;

import model.state.*;

public class Model {

    private Player player;
    private Dungeon dungeon;
    private State currentState;

    public Model(Player player, Dungeon dungeon) {
        this.player = player;
        this.dungeon = dungeon;
        this.currentState = new StartState();
    }

    public void goNorth() {
        if (player.getCurrentRoom().canGoToNorth()) {
            this.player.getCurrentRoom().playerEntersInRoom(null);
            this.player.setCurrentRoom(dungeon.getRoomInXAndInY(player.getCurrentRoom().getX()-1, player.getCurrentRoom().getY()));
            if (player.getCurrentRoom().isLastRoom()) player.getCurrentRoom().setInLastRoom();
            this.player.getCurrentRoom().playerEntersInRoom(player);
            player.getView().handleMove(player.getCurrentRoom(),dungeon,player);
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getNorthSide());
        }
    }

    public void goSouth() {
        if (player.getCurrentRoom().canGoToSouth()) {
            this.player.getCurrentRoom().playerEntersInRoom(null);
            this.player.setCurrentRoom(dungeon.getRoomInXAndInY(player.getCurrentRoom().getX()+1, player.getCurrentRoom().getY()));
            if (player.getCurrentRoom().isLastRoom()) player.getCurrentRoom().setInLastRoom();
            this.player.getCurrentRoom().playerEntersInRoom(player);
            player.getView().handleMove(player.getCurrentRoom(),dungeon,player);
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getSouthSide());
        }
    }

    public void goEast() {
        if (player.getCurrentRoom().canGoToEast()) {
            this.player.getCurrentRoom().playerEntersInRoom(null);
            this.player.setCurrentRoom(dungeon.getRoomInXAndInY(player.getCurrentRoom().getX(), player.getCurrentRoom().getY()+1));
            if (player.getCurrentRoom().isLastRoom()) player.getCurrentRoom().setInLastRoom();
            this.player.getCurrentRoom().playerEntersInRoom(player);
            player.getView().handleMove(player.getCurrentRoom(),dungeon,player);
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getEastSide());
        }
    }

    public void goWest() {
        if (player.getCurrentRoom().canGoToWest()) {
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
            this.player.getCurrentRoom().playerEntersInRoom(null);
            this.player.setCurrentRoom(dungeon.getRoomInXAndInY(player.getCurrentRoom().getX(), player.getCurrentRoom().getY()-1));
            if (player.getCurrentRoom().isLastRoom()) player.getCurrentRoom().setInLastRoom();
            this.player.getCurrentRoom().playerEntersInRoom(player);
            player.getView().handleMove(player.getCurrentRoom(),dungeon,player);
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
        }
    }

    public void changeState (State newState) {
        this.currentState = newState;
    }

    public Player getPlayer() {
        return player;
    }

    public void goBackRoomWest () {
        if (player.getCurrentRoom().canGoToWest()) {
            if (dungeon.getRoomInXAndInY(player.getCurrentRoom().getX(), player.getCurrentRoom().getY() - 1).isVisited()) {
                goWest();
                changeState(new MoveState());
            }
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
        }
    }

    public void goBackRoomEast() {
        if (player.getCurrentRoom().canGoToEast()) {
            if (dungeon.getRoomInXAndInY(player.getCurrentRoom().getX(), player.getCurrentRoom().getY() + 1).isVisited()) {
                goEast();
                changeState(new MoveState());
            }
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getEastSide());
        }
    }

    public void goBackRoomNorth() {
        if (player.getCurrentRoom().canGoToNorth()) {
            if (dungeon.getRoomInXAndInY(player.getCurrentRoom().getX() - 1, player.getCurrentRoom().getY()).isVisited()) {
                goNorth();
                changeState(new MoveState());
            }
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getNorthSide());
        }
    }
    public void goBackRoomSouth(){
        if (player.getCurrentRoom().canGoToSouth()) {
            if (dungeon.getRoomInXAndInY(player.getCurrentRoom().getX() + 1, player.getCurrentRoom().getY()).isVisited()) {
                goSouth();
                changeState(new MoveState());
            }
        }
        else {
            player.getView().descriptionSide(player.getCurrentRoom().getSouthSide());
        }
    }

    public void battle(){
        player.battle(player.getCurrentRoom().getMonster());
        //System.out.println("PVMonster = " + player.getCurrentRoom().getMonster().health);
    }

    public void addItemInInventory(){
        if (player.getInventory().size() <3){
            player.addItemInInventory(player.getCurrentRoom().getItem());
            player.getCurrentRoom().takeItem();
        }
        else {
            player.removeLastItemInInventory();
            player.addItemInInventory(player.getCurrentRoom().getItem());
            player.getView().inventoryFull();
            player.getCurrentRoom().takeItem();
        }
        //System.out.println(player.getInventory());
    }

    public void roomEvent(){
        if(this.getPlayer().getCurrentRoom().isMonster() && !this.getPlayer().getCurrentRoom().isVisited()) {
            this.changeState(new IsMonsterState());
        }
        if(this.getPlayer().getCurrentRoom().isLastRoom()) {
            this.getPlayer().getView().playerWin();
            this.changeState((new EndGameState()));
        }
        if(this.getPlayer().getCurrentRoom().isItem() && !this.getPlayer().getCurrentRoom().isVisited()){
            this.addItemInInventory();
            this.getPlayer().getView().printMap(this.getDungeon());
        }
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void keyPressedI() {
        this.currentState.keyPressedI(this);
    }

    public void keyPressedUP() {
        this.currentState.keyPressedUP(this);
    }

    public void keyPressedDOWN() {
        this.currentState.keyPressedDOWN(this);
    }

    public void keyPressedLEFT() {
        this.currentState.keyPressedLEFT(this);
    }

    public void keyPressedRIGHT() {
        this.currentState.keyPressedRIGHT(this);
    }

    public void keyPressedA() {
        this.currentState.keyPressedA(this);
    }

    public void keyPressedZ() {
        this.currentState.keyPressedZ(this);
    }

    public void keyPressedE() {
        this.currentState.keyPressedE(this);
    }

    public void keyPressedENTER() {
        this.currentState.keyPressedENTER(this);
    }
}

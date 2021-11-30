package model;

import model.state.MoveState;
import model.state.StartState;
import model.state.State;

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

    public State getCurrentState() {
        return currentState;
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
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
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
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
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
            player.getView().descriptionSide(player.getCurrentRoom().getWestSide());
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

    public void keyPressedDIGIT1() {
        this.currentState.keyPressedDIGIT1(this);
    }

    public void keyPressedDIGIT2() {
        this.currentState.keyPressedDIGIT2(this);
    }

    public void keyPressedDIGIT3() {
        this.currentState.keyPressedDIGIT3(this);
    }

    public void keyPressedENTER() {
        this.currentState.keyPressedENTER(this);
    }
}

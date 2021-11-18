package model;

import model.room.Room;
import view.ConsoleView;
import view.View;

public class Player extends Fighter {
    View view ;
    Room currentRoom;


    public Player(View view, int health, int strength) {
        super(health, strength);
        this.view = view;
    }

    public void goNorth() {
        view.handleMove(new Move("You face a wall"));
    }



    public void increaseHealth(int quantity) {
        this.health += quantity;
    }

    public void increaseSrength(int quantity) {
        this.strength += quantity;
    }

}

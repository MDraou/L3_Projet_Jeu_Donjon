package model;

import model.content.Item;
import model.room.Room;
import view.ConsoleView;
import view.View;

import java.util.ArrayList;

public class Player extends Fighter {
    View view ;
    Room currentRoom;
    ArrayList<Item> inventory;


    public Player(View view, int health, int strength) {
        super(health, strength);
        this.view = view;
        inventory = new ArrayList<>();
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

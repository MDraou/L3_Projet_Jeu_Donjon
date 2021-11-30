package view;

import model.Dungeon;
import model.Player;
import model.Side;
import model.room.Room;

public class ConsoleView implements View {

    Drawer drawer;

    public ConsoleView (Drawer drawer){
        this.drawer=drawer;
    }

    @Override
    public void printMap(Dungeon dungeon) {
        System.out.println(drawer.printMap(dungeon));
    }

    @Override
    public void handleMove(Room room, Dungeon dungeon, Player player) {
        System.out.println("vous êtes en x="+room.getY()+" et en y="+room.getX());
        System.out.println(drawer.printMap(dungeon));
    }

    @Override
    public void printStatus(Player player) {
    }

    @Override
    public void printStart() {

    }

    @Override
    public void descriptionSide(Side side) {

    }

    @Override
    public void printTutos() {

    }

    @Override
    public void openInventory(Player player) {

    }

    @Override
    public void closeInventory(Room room, Dungeon dungeon, Player player) {

    }
}

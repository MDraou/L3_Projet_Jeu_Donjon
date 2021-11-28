package view;

import model.Dungeon;
import model.Move;
import model.room.Room;

public class ConsoleView implements View {

    Drawer drawer;

    public ConsoleView (Drawer drawer){
        this.drawer=drawer;
    }

    @Override
    public void handleMove(Move move){
        System.out.println(move.message);
    }

    @Override
    public void printMap(Dungeon dungeon) {
        System.out.println(drawer.printMap(dungeon));
    }

    @Override
    public void handleUp(Room room, Dungeon dungeon) {

    }
}

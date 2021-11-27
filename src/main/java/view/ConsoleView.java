package view;

import model.Dungeon;
import model.Move;

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
}

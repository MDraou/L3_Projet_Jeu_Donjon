package view;

import javafx.scene.text.*;
import model.Dungeon;
import model.Move;

public class JavaFXView implements View{

    Drawer drawer;

    public JavaFXView(Drawer drawer) {
        this.drawer = drawer;
    }

    public Text text = new Text(100,100,"Nothing");

    public void handleMove(Move move){
        text.setText(move.message);
    }

    public void printMap(Dungeon dungeon) {
        text.setText(drawer.printMap(dungeon));
    }
}

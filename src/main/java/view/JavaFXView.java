package view;

import javafx.scene.text.*;
import model.Dungeon;
import model.Move;

public class JavaFXView implements View{

    Drawer drawer;

    public JavaFXView(Drawer drawer) {
        this.drawer = drawer;
    }

    public Text text = new Text(300,175,"Nothing");
    public Text map = new Text(500,20,"");

    public void handleMove(Move move){
        map.setText(move.message);
    }

    public void printMap(Dungeon dungeon) {
        map.setText(drawer.printMap(dungeon));
        map.setStyle("-fx-font-family: monospace;");
        map.setFont(new Font(5));
    }
}

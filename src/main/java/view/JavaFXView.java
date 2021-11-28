package view;

import javafx.scene.text.*;
import model.Dungeon;
import model.Move;
import model.room.Room;

public class JavaFXView implements View{

    Drawer drawer;

    public JavaFXView(Drawer drawer) {
        this.drawer = drawer;
        map.setStyle("-fx-font-family: monospace;");
        map.setFont(new Font(5));
    }

    public Text text = new Text(300,175,"Nothing");
    public Text map = new Text(500,20,"");

    public void handleMove(Move move){
        text.setText(move.message);
    }

    public void printMap(Dungeon dungeon) {
        map.setText(drawer.printMap(dungeon));
    }

    @Override
    public void handleUp(Room room,Dungeon dungeon) {
        text.setText("vous êtes en x="+room.getY()+" et en y="+room.getX());
        printMap(dungeon);
    }
}

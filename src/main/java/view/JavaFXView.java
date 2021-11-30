package view;

import javafx.scene.text.*;
import model.Dungeon;
import model.Player;
import model.Side;
import model.room.Room;

public class JavaFXView implements view.View {

    view.Drawer drawer;

    public JavaFXView(view.Drawer drawer) {
        this.drawer = drawer;
        map.setStyle("-fx-font-family: monospace;");
        map.setFont(new Font(10));
        printStart();
    }

    public Text text = new Text(400,285,"");
    public Text intro = new Text(300,285,"");
    public Text tuto = new Text(30,285,"");
    public Text map = new Text(650,20,"");
    public Text status = new Text(20,20,"");


    public void printMap(Dungeon dungeon) {
        map.setText(drawer.printMap(dungeon));
    }

    @Override
    public void handleMove(Room room, Dungeon dungeon, Player player) {
        intro.setText("");
        tuto.setText("");
        text.setText(room.description());
        text.setTextAlignment(TextAlignment.CENTER);
        printMap(dungeon);
        printStatus(player);
    }

    @Override
    public void descriptionSide(Side side) {
        text.setText(side.description());
    }

    @Override
    public void printStatus(Player player) {
        status.setText(drawer.printStatus(player));
    }

    @Override
    public void printStart() {
        intro.setText(drawer.printIntro());
        intro.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void printTutos() {
        intro.setText("");
        tuto.setText(drawer.printTutos());
        tuto.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void openInventory(Player player) {
        map.setText("");
        status.setText("");
        tuto.setText("");
        text.setText("Vous ouvrez l'inventaire");

    }

    @Override
    public void closeInventory(Room room, Dungeon dungeon, Player player) {
        printStatus(player);
        printMap(dungeon);
        handleMove(room,dungeon,player);
    }
}

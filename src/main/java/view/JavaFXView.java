package view;

import javafx.scene.text.*;
import model.Dungeon;
import model.Player;
import model.Side;
import model.content.Item;
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
    public Text intro = new Text(100,285,"");
    public Text tuto = new Text(30,285,"");
    public Text map = new Text(650,20,"");
    public Text status = new Text(20,20,"");
    public Text inventory = new Text(400,200,"");


    public void printMap(Dungeon dungeon) {
        map.setText(drawer.printMap(dungeon));
    }

    @Override
    public void handleMove(Room room, Dungeon dungeon, Player player) {
        intro.setText("");
        tuto.setText("");
        text.setText(room.description(drawer));
        text.setTextAlignment(TextAlignment.CENTER);
        printMap(dungeon);
        printStatus(player);
    }

    @Override
    public void descriptionSide(Side side) {
        tuto.setText("");
        text.setText(side.description(drawer));
    }

    @Override
    public void printStatus(Player player) {
        status.setText(drawer.printStatus(player));
    }

    @Override
    public void printStart() {
        intro.setText(drawer.printIntro());
        intro.setTextAlignment(TextAlignment.CENTER);
        intro.setFont(new Font(22));
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
        tuto.setText("");
        text.setText("");
        inventory.setText(drawer.printInventory(player));
    }

    @Override
    public void returnInInventory(Player player) {
        inventory.setText(drawer.printInventory(player));
    }

    @Override
    public void closeInventory(Room room, Dungeon dungeon, Player player) {
        inventory.setText("");
        printStatus(player);
        printMap(dungeon);
        handleMove(room,dungeon,player);
    }

    @Override
    public void inventoryFull() {
        text.setText("Votre inventaire est complet,\nvotre dernier objet est jetée puis remplacer par un nouveau");
    }

    @Override
    public void monsterLoose(Dungeon dungeon, Player player) {
        text.setText("Le monstre est mort, vous pouvez continuer");
        printMap(dungeon);
        printStatus(player);
    }

    @Override
    public void playerLoose() {
        map.setText("");
        status.setText("");
        text.setText("Vous avez Perdu\nVeuillez fermer le jeu et le relancer pour rejouer");
        text.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void playerWin() {
        map.setText("");
        status.setText("");
        text.setText("BRAVO !!!!!\nVous avez Gagner\nSi vous voulez rejouer, fermer le jeu et relancer le");
        text.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void descriptionItem(Item item) {
        text.setText(item.description(drawer));
    }
}

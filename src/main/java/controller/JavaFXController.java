package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Dungeon;
import model.Player;

public class JavaFXController {
    EventHandler<? super KeyEvent> eventHandler;
    Dungeon dungeon;

    JavaFXController(Player player, Dungeon dungeon){
        this.dungeon = dungeon;
     eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:    player.goNorth(); break;
                case DOWN:  player.goSouth(); break;
                case LEFT:  player.goWest(); break;
                case RIGHT: player.goEast(); break;
                case I: break;
            }
        }
    }; }
}

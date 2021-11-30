package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Model;


public class JavaFXController {
    EventHandler<? super KeyEvent> eventHandler;

    JavaFXController(Model model) {
        eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        model.keyPressedUP();
                        break;
                    case DOWN:
                        model.keyPressedDOWN();
                        break;
                    case LEFT:
                        model.keyPressedLEFT();
                        break;
                    case RIGHT:
                        model.keyPressedRIGHT();
                        break;
                    case I:
                        model.keyPressedI();
                        break;
                    case A:
                        model.keyPressedA();
                        break;
                    case Z:
                        model.keyPressedZ();
                        break;
                    case E:
                        model.keyPressedE();
                        break;
                    case ENTER:
                        model.keyPressedENTER();
                        break;
                }
            }
        };
    }



}

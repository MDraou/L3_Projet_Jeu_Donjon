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
                    case DIGIT1:
                        model.keyPressedDIGIT1();
                        break;
                    case DIGIT2:
                        model.keyPressedDIGIT2();
                        break;
                    case DIGIT3:
                        model.keyPressedDIGIT3();
                        break;
                    case ENTER:
                        model.keyPressedENTER();
                        break;
                }
            }
        };
    }



}

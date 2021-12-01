package controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Dungeon;
import model.Model;
import model.Player;
import model.battle.BattleMode;
import model.battle.ModePlayerInFirst;
import model.room.CreatorRoomRandom;
import model.room.CreatorsRoom;
import view.Drawer;
import view.JavaFXView;

public class App extends Application {


    /*
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Drawer drawer = new Drawer();
        JavaFXView view = new JavaFXView(drawer);
        BattleMode battleMode = new ModePlayerInFirst();
        Player player = new Player(view,null,15,5);
        CreatorsRoom creatorRoom = new CreatorRoomRandom(0,0);
        Dungeon dungeon = new Dungeon(10,player,creatorRoom);
        Text message = view.text;
        Text map = view.map;
        //view.printMap(dungeon);
        root.getChildren().add(message);
        root.getChildren().add(map);
        root.getChildren().add(view.tuto);
        root.getChildren().add(view.intro);
        root.getChildren().add(view.status);
        root.getChildren().add(view.inventory);
        root.getChildren().add(new Canvas(1000,600));
        Scene scene = new Scene(root);
        //viewTest.printMap(dungeon);
        Model model = new Model(player, dungeon);
        JavaFXController javaFXController = new JavaFXController(model);
        scene.setOnKeyPressed(javaFXController.eventHandler);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

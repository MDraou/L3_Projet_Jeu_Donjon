package view;

import model.Dungeon;
import model.Player;
import model.Side;
import model.room.Room;

public interface View {
    void printMap(Dungeon dungeon);
    void handleMove(Room room, Dungeon dungeon, Player player);
    void descriptionSide (Side side);
    void printStatus (Player player);
    void printStart ();
    void printTutos ();
    void openInventory (Player player);
    void closeInventory (Room room, Dungeon dungeon, Player player);
}

package view;

import model.Dungeon;
import model.Player;
import model.Side;
import model.content.Item;
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
    void inventoryFull();
    void monsterLoose(Dungeon dungeon, Player player);
    void playerLoose();
    void playerWin();
    void descriptionItem(Item item);
    void returnInInventory(Player player);
}

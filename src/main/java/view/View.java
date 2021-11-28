package view;

import model.Dungeon;
import model.Move;
import model.room.Room;

public interface View {
    void handleMove(Move move);
    void printMap(Dungeon dungeon);
    void handleUp(Room room, Dungeon dungeon);
}

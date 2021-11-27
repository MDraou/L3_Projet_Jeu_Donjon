package view;

import model.Dungeon;
import model.Move;

public interface View {
    void handleMove(Move move);
    void printMap(Dungeon dungeon);
}

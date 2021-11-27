package model.content;

import model.Player;

public interface Item {
    void use (Player player);
    boolean isUsed ();
}

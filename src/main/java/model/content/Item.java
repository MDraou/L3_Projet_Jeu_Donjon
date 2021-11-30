package model.content;

import model.Player;
import view.Drawer;

public interface Item {
    void use (Player player);
    String description(Drawer drawer);
}

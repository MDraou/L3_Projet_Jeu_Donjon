package model;

import view.Drawer;

public interface Side {

    String description(Drawer drawer);
    boolean canGoThere();
}

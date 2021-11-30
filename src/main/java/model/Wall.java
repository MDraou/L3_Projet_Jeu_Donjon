package model;

import view.Drawer;

public class Wall implements Side{
    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescriptionWall();
    }

    @Override
    public boolean canGoThere() {
        return false;
    }
}

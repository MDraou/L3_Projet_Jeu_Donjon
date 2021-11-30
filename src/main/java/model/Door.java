package model;

import view.Drawer;

public class Door implements Side{
    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescriptionDoor();
    }

    @Override
    public boolean canGoThere() {
        return true;
    }
}

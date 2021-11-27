package view;

import model.Dungeon;
import model.room.Room;

public class Drawer {
    public String draw (Room room) {
        return room.valuesOfRoom;
    }

    public String printMap(Dungeon dungeon) {
        String viewMap = "";

        for (int raw=0; raw<=dungeon.getSizeOfMatrix()-1; raw++){
            for (int column=0; column<=dungeon.getSizeOfMatrix()-1; column++){
                viewMap = viewMap + dungeon.getMap()[raw][column].accept(this);
                if (dungeon.getMap()[raw][column].canGoToEast()) viewMap = viewMap + " --- ";
            }
            viewMap += "\n";
            for (int column=0; column<=dungeon.getSizeOfMatrix()-1; column++){
                if (dungeon.getMap()[raw][column].canGoToSouth()) viewMap = viewMap + "|     ";
            }
            viewMap += "\n";
        }
        return viewMap;

    }

}

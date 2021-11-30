package model.state;

import model.Model;

public class IsMonsterState implements State{
    @Override
    public void keyPressedI(Model model) {
        model.getPlayer().getView().openInventory(model.getPlayer());
        model.changeState(new InventoryState(this));
    }

    @Override
    public void keyPressedUP(Model model) {
        model.goBackRoomNorth();
    }

    @Override
    public void keyPressedDOWN(Model model) {
        model.goBackRoomSouth();
    }

    @Override
    public void keyPressedLEFT(Model model) {
        model.goBackRoomWest();
    }

    @Override
    public void keyPressedRIGHT(Model model) {
        model.goBackRoomEast();
    }

    @Override
    public void keyPressedDIGIT1(Model model) {

    }

    @Override
    public void keyPressedDIGIT2(Model model) {

    }

    @Override
    public void keyPressedDIGIT3(Model model) {

    }

    @Override
    public void keyPressedENTER(Model model) {

    }
}

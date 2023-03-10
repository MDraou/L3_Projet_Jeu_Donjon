package model.state;

import model.Model;

public class MoveState implements State {

    @Override
    public void keyPressedI(Model model) {
        model.getPlayer().getView().openInventory(model.getPlayer());
        model.changeState(new InventoryState(this));
    }

    @Override
    public void keyPressedUP(Model model) {
        model.goNorth();
        model.roomEvent();
    }

    @Override
    public void keyPressedDOWN(Model model) {
        model.goSouth();
        model.roomEvent();
    }

    @Override
    public void keyPressedLEFT(Model model) {
        model.goWest();
        model.roomEvent();
    }

    @Override
    public void keyPressedRIGHT(Model model) {
        model.goEast();
        model.roomEvent();
    }

    @Override
    public void keyPressedA(Model model) {

    }

    @Override
    public void keyPressedZ(Model model) {

    }

    @Override
    public void keyPressedE(Model model) {

    }

    @Override
    public void keyPressedENTER(Model model) {

    }
}

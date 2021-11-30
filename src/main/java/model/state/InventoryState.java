package model.state;

import model.Model;

public class InventoryState implements State{
    State oldState;

    public InventoryState(State oldState){
        this.oldState = oldState;
    }

    @Override
    public void keyPressedI(Model model) {
        model.getPlayer().getView().closeInventory(model.getPlayer().getCurrentRoom(), model.getDungeon(), model.getPlayer());
        model.changeState(oldState);
    }

    @Override
    public void keyPressedUP(Model model) {

    }

    @Override
    public void keyPressedDOWN(Model model) {

    }

    @Override
    public void keyPressedLEFT(Model model) {

    }

    @Override
    public void keyPressedRIGHT(Model model) {

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

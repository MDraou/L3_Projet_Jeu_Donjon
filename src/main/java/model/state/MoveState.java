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
        if(model.getPlayer().getCurrentRoom().isMonster()) model.changeState(new IsMonsterState());
    }

    @Override
    public void keyPressedDOWN(Model model) {
        model.goSouth();
        if(model.getPlayer().getCurrentRoom().isMonster()) model.changeState(new IsMonsterState());
    }

    @Override
    public void keyPressedLEFT(Model model) {
        model.goWest();
        if(model.getPlayer().getCurrentRoom().isMonster()) model.changeState(new IsMonsterState());
    }

    @Override
    public void keyPressedRIGHT(Model model) {
        model.goEast();
        if(model.getPlayer().getCurrentRoom().isMonster()) model.changeState(new IsMonsterState());
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

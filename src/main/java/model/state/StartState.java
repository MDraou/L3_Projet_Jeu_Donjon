package model.state;

import model.Model;

public class StartState implements State {

    @Override
    public void keyPressedI(Model model) {

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
        model.getPlayer().getView().printStatus(model.getPlayer());
        model.getPlayer().getView().printMap(model.getDungeon());
        model.getPlayer().getView().printTutos();
        model.changeState(new MoveState());
    }
}

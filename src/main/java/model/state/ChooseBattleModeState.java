package model.state;

import model.Model;
import model.battle.ModeMonsterInFirst;
import model.battle.ModePlayerInFirst;

public class ChooseBattleModeState implements State{

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
    public void keyPressedA(Model model) {
        model.getPlayer().changeBattleMode(new ModePlayerInFirst());
        model.getPlayer().getView().printStatus(model.getPlayer());
        model.getPlayer().getView().printMap(model.getDungeon());
        model.getPlayer().getView().printTutos();
        model.changeState(new MoveState());
    }

    @Override
    public void keyPressedZ(Model model) {
        model.getPlayer().changeBattleMode(new ModeMonsterInFirst());
        model.getPlayer().getView().printStatus(model.getPlayer());
        model.getPlayer().getView().printMap(model.getDungeon());
        model.getPlayer().getView().printTutos();
        model.changeState(new MoveState());
    }

    @Override
    public void keyPressedE(Model model) {

    }

    @Override
    public void keyPressedENTER(Model model) {

    }

}

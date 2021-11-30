package model.state;

import model.Model;

public class InventoryState implements State{
    private State oldState;

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
    public void keyPressedA(Model model) {
        if(model.getPlayer().getInventory().size()>=1) {
            model.getPlayer().getView().descriptionItem(model.getPlayer().getInventory().get(0));
            model.getPlayer().getInventory().get(0).use(model.getPlayer());
            model.getPlayer().removeFromInventory(0);
            model.getPlayer().getView().printStatus(model.getPlayer());
            model.getPlayer().getView().returnInInventory(model.getPlayer());
        }
        if (model.getPlayer().isDead()){
            model.getPlayer().getView().playerLoose();
            model.changeState(new EndGameState());
        }
    }

    @Override
    public void keyPressedZ(Model model) {
        if(model.getPlayer().getInventory().size()>=2) {
            model.getPlayer().getView().descriptionItem(model.getPlayer().getInventory().get(1));
            model.getPlayer().getInventory().get(1).use(model.getPlayer());
            model.getPlayer().removeFromInventory(1);
            model.getPlayer().getView().printStatus(model.getPlayer());
            model.getPlayer().getView().returnInInventory(model.getPlayer());
        }
        if (model.getPlayer().isDead()){
            model.getPlayer().getView().playerLoose();
            model.changeState(new EndGameState());
        }

    }

    @Override
    public void keyPressedE(Model model) {
        if(model.getPlayer().getInventory().size()>=3) {
            model.getPlayer().getView().descriptionItem(model.getPlayer().getInventory().get(2));
            model.getPlayer().getInventory().get(2).use(model.getPlayer());
            model.getPlayer().removeFromInventory(2);
            model.getPlayer().getView().printStatus(model.getPlayer());
            model.getPlayer().getView().returnInInventory(model.getPlayer());
        }
        if (model.getPlayer().isDead()){
            model.getPlayer().getView().playerLoose();
            model.changeState(new EndGameState());
        }
    }

    @Override
    public void keyPressedENTER(Model model) {

    }
}

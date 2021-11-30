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
        model.battle();
        if (model.getPlayer().isDead()){
            model.getPlayer().getView().playerLoose();
            model.changeState(new EndGameState());
        }
        if (model.getPlayer().getCurrentRoom().isVisited() && !model.getPlayer().isDead()){
            model.getPlayer().getView().monsterLoose(model.getDungeon(), model.getPlayer());
            model.changeState((new MoveState()));
        }
        //System.out.println("PV = "+ model.getPlayer().getHealth() +" Force = " + model.getPlayer().getStrength() );
    }
}

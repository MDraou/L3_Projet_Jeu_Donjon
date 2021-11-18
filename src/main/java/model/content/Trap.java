package model.content;

import model.Player;

public class Trap {
    private int damage;
    private boolean isUsed;

    public Trap(int damage){
        this.damage = damage;
        this.isUsed = false;
    }

    public void setTrap(Player player){
        if (!this.isUsed) {
            player.decreaseHealth(this.damage);
            this.isUsed = true;
        }
    }
}

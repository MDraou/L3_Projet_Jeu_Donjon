package model.content;

import model.Player;

public class Trap implements Item {
    private int damage;
    private boolean isUsed;

    public Trap(int damage){
        this.damage = damage;
        this.isUsed = false;
    }

    public void use(Player player){
        if (!this.isUsed) {
            player.decreaseHealth(this.damage);
            this.isUsed = true;
        }
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}

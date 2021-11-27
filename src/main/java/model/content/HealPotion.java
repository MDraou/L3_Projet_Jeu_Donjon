package model.content;

import model.Player;

public class HealPotion implements Item{
    private int powerUp;
    private boolean isUsed;

    public HealPotion(int powerUp){
        this.powerUp = powerUp;
        this.isUsed = false;
    }

    @Override
    public void use(Player player) {
        if (!this.isUsed) {
            player.increaseHealth(this.powerUp);
            this.isUsed = true;
        }
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}

package model.content;

import model.Player;

public class StrengthPotion implements Item{
    private int powerUp;
    private boolean isUsed;

    public StrengthPotion(int powerUp){
        this.powerUp = powerUp;
        this.isUsed = false;
    }

    @Override
    public void use(Player player) {
        if (!this.isUsed) {
            player.increaseSrength(this.powerUp);
            this.isUsed = true;
        }
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }
}

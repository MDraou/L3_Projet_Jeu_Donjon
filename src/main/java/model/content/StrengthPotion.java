package model.content;

import model.Player;
import view.Drawer;

public class StrengthPotion implements Item{
    private int powerUp;

    public StrengthPotion(int powerUp){
        this.powerUp = powerUp;
    }

    @Override
    public void use(Player player) {
        player.increaseSrength(this.powerUp);
    }

    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescriptionStrengthPotion(this);
    }

    public int getPowerUp() { return powerUp; }
}

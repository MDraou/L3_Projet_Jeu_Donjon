package model.content;

import model.Player;
import view.Drawer;

public class HealPotion implements Item{
    private int powerUp;

    public HealPotion(int powerUp){
        this.powerUp = powerUp;
    }

    @Override
    public void use(Player player) {
        player.increaseHealth(this.powerUp);
    }

    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescriptionHealPotion(this);
    }

    public int getPowerUp() { return powerUp; }
}

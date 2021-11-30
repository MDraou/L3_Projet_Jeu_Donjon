package model.content;

import model.Player;
import view.Drawer;

public class PoisonPotion implements Item {
    private int damage;

    public PoisonPotion(int damage){
        this.damage = damage;
    }

    public void use(Player player){
        player.decreaseHealth(this.damage);
    }

    @Override
    public String description(Drawer drawer) {
        return drawer.drawDescriptionPoisonPotion(this);
    }

    public int getDamage() { return damage; }
}

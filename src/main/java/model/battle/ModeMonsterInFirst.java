package model.battle;

import model.Fighter;
import model.Player;

public class ModeMonsterInFirst implements BattleMode{

    @Override
    public void battle(Player player, Fighter enemy){
        while (!player.isDead() && !enemy.isDead()){
            enemy.attack(player);
            if (player.isDead()) break;
            else player.attack(enemy);
            //System.out.println("tour de combat !!!!!!");
        }
    }
}

package model.battle;

import model.Fighter;
import model.Player;

public class ModePlayerInFirst implements BattleMode{

    public void battle(Player player, Fighter enemy){
        while (!player.isDead() && !enemy.isDead()){
            player.attack(enemy);
            if (enemy.isDead()) break;
            else enemy.attack(player);
            //System.out.println("tour de combat !!!!!!");
        }
    }
}

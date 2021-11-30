package model.battle;

import model.Fighter;
import model.Player;

public interface BattleMode {
    void battle(Player player, Fighter enemy);
}

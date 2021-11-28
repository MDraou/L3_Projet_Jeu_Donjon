package model;

public abstract class Fighter {
    int health;
    int strength;

    public Fighter(int health, int strength) {
        this.health = health;
        this.strength = strength;
    }

    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    public void attack(Fighter ennemy) {
        ennemy.decreaseHealth(this.strength);
    }

    public boolean isDead(){
        return health <= 0;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }
}

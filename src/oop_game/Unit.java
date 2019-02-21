package oop_game;

public class Unit {
    private int health;
    private int damage;
    private String name;

    Unit(){

    }

    public Unit(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package oop_game;

public class Mill implements Building {
    private static final  int EFFICIENCY=30;

    private Player player;
    private int health;
    private String name;



    public Mill(Player player) {
        this.player = player;
        name = player.getUsername() + "'s mill";
        health = 100;
    }

    public void activate() {
        player.setWood(player.getWood() + EFFICIENCY);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mill{" +
                "name='" + name + '\'' +"health= "+health+
                '}';
    }
}

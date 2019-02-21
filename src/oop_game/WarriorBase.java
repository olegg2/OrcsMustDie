package oop_game;

import java.util.ArrayList;
import java.util.List;

public class WarriorBase implements  Building {
    Warrior warriors ;
   // List<Unit> myArmy = new ArrayList<>();

    private Player player;
    private int health;
    private String name;


    public WarriorBase(Player player) {
        this.player = player;
        name = player.getUsername() + "'s warrior base";
        health = 100;
    }

 /*   public void setWarriors(){
        myArmy=warriors.setListOfWarriors();
        System.out.println();
    }*/





    public void activate() {
        warriors = new Warrior();
        player.myArmy.addAll(warriors.setListOfWarriors());

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
        return "Warrior Base{" +
                "name='" + name + '\'' +" health= "+health+
                '}';
    }



}

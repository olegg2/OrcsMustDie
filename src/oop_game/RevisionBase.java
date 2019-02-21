package oop_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RevisionBase implements Building {
  //  private static final  int EFFICIENCY=30;

    private Player player;
    private int health;
    private String name;
    private List<Junk> listOfJunk= new ArrayList<>();
    private Random rand = new Random();

    public void setListOfJunk() {

        listOfJunk.add(new Junk("DeformedCar",15));
        listOfJunk.add(new Junk("CaseWithCash",40));
        listOfJunk.add(new Junk("RuinedHelicopter",90));
        listOfJunk.add(new Junk("WorkingComputer",10));
        listOfJunk.add(new Junk("BagWithInstruments",5));
        listOfJunk.add(new Junk("ValuableBook",20));

    }






    public RevisionBase(Player player) {
        this.player = player;
        name = player.getUsername() + "'s Revision Base";
        health = 125;
    }

    public void activate() {
        setListOfJunk();
       Junk myJunk=  listOfJunk.get(rand.nextInt(listOfJunk.size()));
       player.setGold(player.getGold()+myJunk.getValue());
        System.out.println("Your base has found : "+myJunk.getName()+" whitch is worth "+myJunk.getValue()+" gold");

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
        return "RevisionBase{" +
                "name='" + name + '\'' +"health= "+health+
                '}';
    }
}

package oop_game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public  class Enemy {

    private List<String> names = new ArrayList<>();
    private List<Unit> listOfEnemys= new ArrayList<>();
    private Random rand = new Random();
    private int damageCoun=0;

    public Enemy( ) {
        setListOfEnemys();

    }

    private void setNames(){
        names.add("Azog");
        names.add("Boldor");
        names.add("Lygdush");
        names.add("Shagrat");
        names.add("Narzul");
        names.add("Otrog");
        names.add("Shagrat");
        names.add("Yazneg");
        names.add("Ktuglu");

    }

    public void getNames() {
         setNames();
         System.out.print(names.get(1));
    }

    public void setListOfEnemys() {
        setNames();
        for (int i = 0; i < rand.nextInt(4) + 1; i++) {
            listOfEnemys.add(new Unit(rand.nextInt(6) + 4, rand.nextInt(6) + 4, names.get(rand.nextInt(names.size()))));

        }

    }

    public List<Unit> getListOfEnemys() {
        return listOfEnemys;
    }
    /*  public int enemyDamage(){
        int damageCount=0;
        for (int i = 0; i <listOfEnemys.size() ; i++) {
            damageCount+=listOfEnemys.get(i).

        }

    }*/

    public int getDamageCoun() {
        return damageCoun;
    }

    public void setDamageCoun(int damageCoun) {
        this.damageCoun = damageCoun;
    }

    @Override
    public String toString() {
        String [] str= new String[listOfEnemys.size()];
        for (int i = 0; i <listOfEnemys.size() ; i++) {
           str[i]="\nName= "+ listOfEnemys.get(i).getName()+" Health= "+listOfEnemys.get(i).getHealth()+" Damage= "+listOfEnemys.get(i).getDamage();
        }

        return  Arrays.toString(str);


              //  "Enemy{" +
               // "listOfEnemys=" + listOfEnemys.get(1).getName()+""+listOfEnemys.get(1).getHealth()+""+listOfEnemys.get(1).getDamage() +
               // '}';}
    }
}

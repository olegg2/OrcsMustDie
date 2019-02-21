package oop_game;

import java.util.Arrays;
import java.util.List;

public class Fight {
   // Enemy enemy;
  //  Warrior warrior;
    List<Unit> enemy;
    List<Unit> warrior;
    public Fight(){

    }

    public Fight(List<Unit> enemy, List<Unit> warrior) {
        this.enemy = enemy;
        this.warrior = warrior;
    }

    public  void printArmys(){
        System.out.println();
        System.out.println();
        System.out.println(enemy.get(0).getName());
        System.out.println();
        System.out.println(warrior.get(0).getName());
    }

    public void fighting(){

    }

    public String toString() {
        String[] str = new String[enemy.size()];
        for (int i = 0; i < enemy.size(); i++) {
            str[i] = "\nName= " + enemy.get(i).getName() + " Health= " + enemy.get(i).getHealth() + " Damage= " + enemy.get(i).getDamage();
        }

        return Arrays.toString(str);
    }
}

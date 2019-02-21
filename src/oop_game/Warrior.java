package oop_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warrior {
    private List<String> names = new ArrayList<>();
    private List<Unit> listOfWarriors= new ArrayList<>();
    private Random rand = new Random();

    private void setNames(){
        names.add("Ivan");
        names.add("Petro");
        names.add("Vova");
        names.add("Petro");
        names.add("Vlad");
        names.add("Stas");
        names.add("Oleg");
        names.add("Nazar");
        names.add("Igor");
        names.add("Vasuliy");
        names.add("illya");
    }

    public List<Unit> setListOfWarriors() {
        setNames();
        for (int i = 0; i < rand.nextInt(3) + 1; i++) {
            listOfWarriors.add(new Unit(rand.nextInt(7) + 3, rand.nextInt(7) + 3, names.get(rand.nextInt(names.size()))));

        }
        return listOfWarriors;
    }

}

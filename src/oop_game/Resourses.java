package oop_game;

public enum Resourses {
    GOLD_FROM_CAVE(30);
   // WOOD_FROM_MILL(30);
    /////////////
    int numOfGold;
    int numOfWood;
    Resourses(int num){
        this.numOfGold=num;
        this.numOfWood=num;

    }


    public int getNumOfGold() {
        return numOfGold;
    }

    public int getNumOfWood() {
        return numOfWood;
    }
}

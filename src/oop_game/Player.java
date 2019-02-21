package oop_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
	private String username;
	private int gold;
	private int wood;
	private List<Building> buildings;
	public List<Unit> myArmy;
	private boolean endGame;

	public Player(String username) {
		this.username = username;
		gold = 100;
		wood = 100;
		buildings = new ArrayList<>();
		myArmy = new ArrayList<>();
	}
	
	public void activateBuilding(int index) {
		buildings.get(index).activate();
	}

	public boolean addBuiding(Building building) {
		return buildings.add(building);
	}

	public List<Building> getBuildings() {
		return buildings;
	}
	public int getBuildingHealth(int index){return buildings.get(index).getHealth();}
	public void setBuildingHealth(int index,int index2){
		int count=buildings.get(index).getHealth();
		buildings.get(index).setHealth(count-index2);
	}

	public void removeBuilding(int index) {
		buildings.remove(index);
	}

	public   void printMyArmy(){
		String [] str= new String[myArmy.size()];
		for (int i = 0; i <myArmy.size() ; i++) {
			str[i]="\nName= "+ myArmy.get(i).getName()+" Health= "+myArmy.get(i).getHealth()+" Damage= "+myArmy.get(i).getDamage();
		}

		System.out.println( Arrays.toString(str));
	}

	public boolean checkHealth(){
		if(buildings.size()==0){return true;}
		for (int i = 0; i <buildings.size()-1 ; i++) {
			if(buildings.get(i).getHealth()<=0){
				buildings.remove(i);
				i--;
			}
		}
		return false;

	}




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public boolean isEndGame() {
		return endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	public List<Unit> getMyArmy() {
		return myArmy;
	}

	public String getMyArmy2() {
		String [] str= new String[myArmy.size()];
		for (int i = 0; i <myArmy.size() ; i++) {
			str[i]="\nName= "+ myArmy.get(i).getName()+" Health= "+myArmy.get(i).getHealth()+" Damage= "+myArmy.get(i).getDamage();
		}
		return Arrays.toString(str);
	}

	@Override
	public String toString() {
		return username + ": gold=" + gold + ", wood=" + wood;
	}
}

package oop_game;

import java.util.*;

public class Program {
	static Scanner sc = new Scanner(System.in);

	static Player player;
	static Enemy enemy;
	static Warrior warrior = new Warrior();
	static Fight fight;


	public static void main(String[] args) {
		List<Unit> listOfEnemy;
		int DeathCount = 0;
		boolean endGame;

		System.out.println("Hello\nEnter your username:");
		player = new Player(sc.next());
		while (true) {
			if(player.isEndGame()){break;}
			player.checkHealth();
			//player.checkHealth();
			System.out.println(player);
			printMenu();
			int chooise = sc.nextInt();
			switch (chooise) {
				case 1:
					addBuilding();
					break;
				case 2:
					activateBuilding();
					break;
				case 3:
					printBuildingsList();
					break;
				case 4:
					printArmy();
					break;

				case 0:
					break;
				default:
					System.out.println("There is no such option");
			}
			DeathCount++;
			if (DeathCount >= 2) {

				enemy = new Enemy();
				System.out.println("Army of orks are coming:");
				if(player.getBuildings().size()==0)
					break;
				if (player.myArmy.size() == 0) {

					System.out.println("Ork army: "+enemy);
					enemyDamage(enemy.getListOfEnemys());
					System.out.println("Orks attacked our " + player.getBuildings().get(player.getBuildings().size() - 1).getName() + " and dealt " + enemy.getDamageCoun() + " points of damage");

				} else if (player.myArmy.size() > 0) {
					fighing(player.getMyArmy(),enemy.getListOfEnemys());
				}
				DeathCount = 0;
				if(player.isEndGame()){break;}
			}

		}
		System.out.print("LOL YOU DIED, LOL LOL YOU DIED!!");
	}


	///////////////////////enemy damage
	public static void enemyDamage(List<Unit> listOfEnemy) {
		int damageCount = 0;
		for (int i = 0; i < listOfEnemy.size(); i++) {
			damageCount += listOfEnemy.get(i).getDamage();
		}
		enemy.setDamageCoun(damageCount*4);
		if (player.getBuildings().size()==0){
			player.setEndGame(true);
			return;
		}
		player.getBuildings().get(player.getBuildings().size() - 1).setHealth(player.getBuildings().get(player.getBuildings().size() - 1).getHealth() - damageCount*4);

	}



	///////////////////////activate building
	public static void activateBuilding() {
		printBuildingsList();
		System.out.println("Select building: ");
		player.activateBuilding(sc.nextInt());
	}

	///////////////////////print building list
	public static void printBuildingsList() {
		List<Building> buildings = player.getBuildings();
		for (int i = 0; i < buildings.size(); i++) {
			System.out.println(i + " " + buildings.get(i));
		}
	}

	//////////////////////pirnt my army
	public static void printArmy() {
		player.printMyArmy();
	}

	//////////////////////add building
	public static void addBuilding() {
		System.out.println("1 - cave");
		System.out.println("2 - mill");
		System.out.println("3 - revision base");
		System.out.println("4 - warrior base");
		int chooise = sc.nextInt();

		switch (chooise) {
			case 1:
				if (player.getGold() > 30) {
					player.addBuiding(new Cave(player));
					player.setGold(player.getGold() - 30);
				} else {
					System.out.println("Not enough gold");
				}
				break;


			case 2:
				if (player.getWood() > 25) {
					player.addBuiding(new Cave(player));
					player.setGold(player.getWood() - 25);
				} else {
					System.out.println("Not enough wood");
				}
				break;


			case 3:
				if (player.getGold() > 30 && player.getWood() > 35) {
					player.addBuiding(new RevisionBase(player));
					player.setGold(player.getGold() - 30);
					player.setWood(player.getWood() - 35);

				} else {
					if (player.getGold() > 30)
						System.out.println("Not enough gold ");
					if (player.getWood() > 35)
						System.out.println("Not enough wood ");
				}
				break;

			case 4:
				if (player.getGold() > 30 && player.getWood() > 35) {
					player.addBuiding(new WarriorBase(player));
					player.setGold(player.getGold() - 20);
					player.setWood(player.getWood() - 50);

				} else {
					if (player.getGold() > 30)
						System.out.println("Not enough gold ");
					if (player.getWood() > 35)
						System.out.println("Not enough wood ");
				}
				break;
		}

	}

	/////////////////////////////Print menu
	public static void printMenu() {
		System.out.println("1 - to add building");
		System.out.println("2 - to activate building");
		System.out.println("3 - to see list of buildings");
		System.out.println("4 - to see list of warriors");
		System.out.println("0 - to close program");
	}

	/////////////////////////////fighting proccess
	public static void fighing(List<Unit> listOfWarriors, List<Unit> listOfEnemy) {
		int indexOfEnemy=0;
		int indexOfWarriors=0;
		int roundCount=1;
		System.out.println("Army of warriors: "+player.getMyArmy2()+ "\nVS\nArmy of orks "+enemy+"\n");
		System.out.println("\nROUND "+roundCount);
		while (listOfEnemy.size() > 0 || listOfWarriors.size() > 0) {
			System.out.println("Warrior "+listOfWarriors.get(0).getName()+" is attacking the ork "+listOfEnemy.get(0).getName()+" and damages it with "+listOfWarriors.get(0).getDamage()+" points of damage");
			listOfEnemy.get(0).setHealth(listOfEnemy.get(0).getHealth() - listOfWarriors.get(0).getDamage());
			if (listOfEnemy.get(0).getHealth() <= 0) {
				System.out.println("Ork with a name "+listOfEnemy.get(0).getName()+" dies from the hit,"+" with health of "+listOfEnemy.get(0).getHealth());
				listOfEnemy.remove(0);
				roundCount++;
				if(listOfEnemy.size()==0)
					break;
				continue;

			}
			System.out.println("Ork "+listOfEnemy.get(0).getName()+" is attacking the warrior "+listOfWarriors.get(0).getName()+" and damages it with "+listOfEnemy.get(0).getDamage()+" points of damage");
			listOfWarriors.get(0).setHealth(listOfWarriors.get(0).getHealth() - listOfEnemy.get(0).getDamage());
			if(listOfWarriors.get(0).getHealth() <= 0){
				System.out.println("Warrior with a name "+listOfWarriors.get(0).getName()+" dies from the hit,with the health of "+listOfWarriors.get(0).getHealth());
				listOfWarriors.remove(0);
				roundCount++;
				if(listOfWarriors.size()==0)
					break;
				continue;
			}
			System.out.println("Nobody died");

		 roundCount++;
		}
		if(listOfEnemy.size()==0){System.out.println("Army of warriors has won");}
		if(listOfWarriors.size()==0){
			System.out.println("Army of orks has won");
			enemyDamage(listOfEnemy);
			System.out.println("Orks attacked our " + player.getBuildings().get(player.getBuildings().size() - 1).getName() + " and dealt " + enemy.getDamageCoun() + " points of damage");
		}

	}


}

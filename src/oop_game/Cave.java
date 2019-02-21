package oop_game;

public class Cave implements Building {
	
	private static final int EFFICIENCY = 10;
	
	private Player player;
	private int health;
	private String name;

	
	
	public Cave(Player player) {
		this.player = player;
		name = player.getUsername() + "'s cave";
		health = 100;
	}

	@Override
	public void activate() {
		player.setGold(player.getGold() + EFFICIENCY);
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
		return "Cave{" +
				"name='" + name + '\'' +" health= "+health+
				'}';
	}
}

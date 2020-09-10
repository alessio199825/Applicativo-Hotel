package model;

public class DrinkEFood {

	private String name;
	private String type;
	private boolean inRoom;
	private double cost;

	public DrinkEFood(String name, String type, boolean inRoom, double cost) {
		this.name = name;
		this.type = type;
		this.inRoom = inRoom;
		this.cost = cost;
	}

	public String getName() { return name; }

	public String getType() { return type; }
	
	public boolean getInRoom() { return inRoom; }

	public double getCost() { return cost; }
	
}
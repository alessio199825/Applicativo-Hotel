package model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Room extends Observable{
	
	public int code_room;
	public int cost_room;
	public boolean free;
	
	public Room() {
		free = true;
	}
	
	public void roomStatusChange() {
		if(free) {
			free=false;
		}
		else {
			free=true;
		}
		setChanged();
	}
}
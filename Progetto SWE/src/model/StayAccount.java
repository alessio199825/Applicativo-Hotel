package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class StayAccount {
	
	private LocalDate dateArrive;
	private LocalDate dateDeparture;
	private Room room;
    private List<DrinkEFood> roomExtra;
	private List<DrinkEFood> restaurantExtra;
    private Extra extra;
	
	public StayAccount() {
		roomExtra = new ArrayList<DrinkEFood>();
		restaurantExtra = new ArrayList<DrinkEFood>();
		extra = new Extra(); }
	
	public void setDateArrive(LocalDate dateArrive) { this.dateArrive = dateArrive; }
	
	public void setDateDeparture(LocalDate dateDeparture) { this.dateDeparture = dateDeparture; }

	@SuppressWarnings("deprecation")
	public void setRoom(Room room) {
		this.room = room;
		room.roomStatusChange();
		room.notifyObservers(); }
	
	public Room getRoom() { return room; }
		
	@SuppressWarnings("deprecation")
	public void setRoomFree() { 
		room.roomStatusChange(); 
		room.notifyObservers(); }
	
	public int getCost() { 
		long daysBetween = ChronoUnit.DAYS.between(dateArrive, dateDeparture);
		int tmpDays = (int) daysBetween;
		int tmp = room.cost_room * tmpDays;
		return tmp; }
	
	public void addExtraRoom(DrinkEFood extra) throws ExtraRoomException{ 
		if(extra.getInRoom()) {
		roomExtra.add(extra); 
		} else {
			throw new ExtraRoomException();
		} }
	
	public void addExtraRestaurant(DrinkEFood extra) { restaurantExtra.add(extra); }
	
	public double getCostExtra() {
		double tmp;
		tmp = extra.getBill(restaurantExtra);
		extra.changeExtraStrategy(true);
		tmp = tmp + extra.getBill(roomExtra);
		extra.changeExtraStrategy(false);
		return tmp; }
	
	public List<DrinkEFood> getRoomExtra() { return roomExtra; }

	public LocalDate getDateArrive() { return dateArrive; }

	public LocalDate getDateDeparture() { return dateDeparture; }

	public List<DrinkEFood> getRestaurantExtra() { return restaurantExtra; }
}


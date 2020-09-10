package model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class HotelMenagement implements Observer{
	
	private static HotelMenagement hotel;
	private static Employee employee;
	private static List<Guest> guests;
	private static List<Room> roomsFree;
	private static List<Room> roomsOccupied;
	private static List<DrinkEFood> drinksEfoods;

	private HotelMenagement() {
		guests = new ArrayList<>();
		roomsFree = new ArrayList<>();
		roomsOccupied = new ArrayList<>();
		drinksEfoods = new ArrayList<>();
	}
	
	public static HotelMenagement getInstance() {
		if(hotel == null)
			hotel = new HotelMenagement();
		return hotel;
	}
	
	public List<Guest> getGuests() { return guests;}
	
	public Employee getEmployee() { return employee; }
	
	public void setEmployee(String name, String surname, String code) { employee = new Employee(name, surname, code); }
	
	public List<Room> getRoomsFree() { return roomsFree; }
	
	public List<Room> getRoomsOccupied() { return roomsOccupied; }
	
	public List<DrinkEFood> getDrinksEfoods() { return drinksEfoods; }
	
	public void addGuest(Guest guest) { guests.add(guest); }
	
	public void removeGuest(Guest guest) {	
        if (guest != null) {
            guests.remove(guest); }
    }
	
	public void addRoomFree(Room room) { roomsFree.add(room); }
	
	public void removeRoomFree(Room room) {
        if (room != null) {
            roomsFree.remove(room); }
    }
	
	public void addRoomOccupied(Room room) { roomsOccupied.add(room); }
	
	public void removeRoomOccupied(Room room) {
        if (room != null) {
            roomsOccupied.remove(room); }
    }
	
	public void addDrinkEFood(DrinkEFood drinkEfood) { drinksEfoods.add(drinkEfood); }
	
	public void removeDrinkEFood(DrinkEFood drinkEfood) {
        if (drinkEfood != null) {
            drinksEfoods.remove(drinkEfood); }
    }
	
	public void updateHotel(Observable o) {
		Room room = (Room) o;
		if(room.free) {
			removeRoomOccupied(room);
			addRoomFree(room);
		}
		else {
			removeRoomFree(room);
			addRoomOccupied(room);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		updateHotel(o); }
}


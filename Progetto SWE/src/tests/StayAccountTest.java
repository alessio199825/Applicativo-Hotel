package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DrinkEFood;
import model.ExtraRoomException;
import model.Guest;
import model.HotelMenagement;
import model.Room;
import model.SingleRoom;

class StayAccountTest {

	HotelMenagement hotel;
	Guest guest;
	
	@BeforeEach
    void setUp() {
		hotel = HotelMenagement.getInstance();
        guest = new Guest.GuestBuilder("Mauro", "Bianchi")
        		.setNationality("italiana")
				.setAddress("via Roma, Firenze")
				.setBirthAge(1978)
				.setAlone(true).build(); }

	@SuppressWarnings("deprecation")
	@Test
    void ObserverTest() {
		Room room = new SingleRoom(101);
		room.addObserver(hotel);
		hotel.addRoomFree(room);
		
        guest.getStayAccount().setRoom(room);
        
        assertEquals(guest.getStayAccount().getRoom().code_room, 101);
        assertEquals(hotel.getRoomsOccupied().get(0).code_room, 101);
        
        guest.getStayAccount().setRoomFree();
        assertEquals(hotel.getRoomsFree().get(0).code_room, 101); }
	
	@SuppressWarnings("deprecation")
	@Test
    void TestExtraCost() throws ExtraRoomException { 
		Room room = new SingleRoom(101);
		room.addObserver(hotel);
		hotel.addRoomFree(room);
		guest.getStayAccount().setRoom(room);
        
		DrinkEFood extra = new DrinkEFood("pizza", "food", false, 8);
		guest.getStayAccount().addExtraRestaurant(extra);
		assertEquals(guest.getStayAccount().getRestaurantExtra().get(0).getName() , "pizza");
		
		DrinkEFood extraRoom = new DrinkEFood("Spumante", "drink", true, 15);
		guest.getStayAccount().addExtraRoom(extraRoom);
		
		assertEquals(guest.getStayAccount().getCostExtra(), 25); 
		assertThrows(ExtraRoomException.class, () -> guest.getStayAccount().addExtraRoom(extra)); }
		
	@SuppressWarnings("deprecation")
	@Test
    void TestCost() { 
		Room room = new SingleRoom(101);
		room.addObserver(hotel);
		hotel.addRoomFree(room);
		guest.getStayAccount().setRoom(room);
        
        guest.getStayAccount().setDateArrive(LocalDate.of(2019, 10, 19));
        guest.getStayAccount().setDateDeparture(LocalDate.of(2019, 10, 28));
        
        assertEquals(guest.getStayAccount().getDateArrive(), LocalDate.of(2019, 10, 19));
        assertEquals(guest.getStayAccount().getDateDeparture(), LocalDate.of(2019, 10, 28));
        assertEquals(guest.getStayAccount().getCost(), 450); } 
}
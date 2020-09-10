package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DoubleRoom;
import model.DrinkEFood;
import model.Guest;
import model.HotelMenagement;
import model.SingleRoom;

class HotelMenagementTest {

	HotelMenagement hotel;
	
    @BeforeEach
    void setUp() {
        hotel = HotelMenagement.getInstance();
        hotel.setEmployee("Mario", "Rossi", "001"); }

    @Test
    void getInstance() {
        assertSame(hotel, HotelMenagement.getInstance()); }
    
    @Test
    void getEmployee() {
        assertEquals(hotel.getEmployee().getName(), "Mario");
        assertEquals(hotel.getEmployee().getSurname(), "Rossi");
        assertEquals(hotel.getEmployee().getRegisterCode() , "001"); }
    
    @Test
    void addRoom() {
        hotel.addRoomFree(new DoubleRoom(102));
        hotel.addRoomFree(new SingleRoom(101));
        assertEquals(hotel.getRoomsFree().get(0).code_room, 102);
        assertEquals(hotel.getRoomsFree().get(1).code_room, 101); }

    @Test
    void BuilderTest() {
        hotel.addGuest(new Guest.GuestBuilder("Mauro", "Bianchi")
        		.setNationality("italiana")
				.setAddress("via Roma, Firenze")
				.setBirthAge(1978)
				.setAlone(true).build());
        assertEquals(hotel.getGuests().get(0).getName(), "Mauro");
        assertEquals(hotel.getGuests().get(0).getSurname(), "Bianchi");
        assertEquals(hotel.getGuests().get(0).getNationality(), "italiana");
        assertEquals(hotel.getGuests().get(0).getAddress(), "via Roma, Firenze");
        assertEquals(hotel.getGuests().get(0).getBirthAge(), 1978);
        assertTrue(hotel.getGuests().get(0).isAlone()); }

    @Test
    void addDrinkEFood() {
    	hotel.addDrinkEFood( new DrinkEFood("pizza", "food", true, 8));
        assertEquals(hotel.getDrinksEfoods().get(0).getName() , "pizza");
        assertEquals(hotel.getDrinksEfoods().get(0).getType() , "food");
        assertTrue(hotel.getDrinksEfoods().get(0).getInRoom());
        assertEquals(hotel.getDrinksEfoods().get(0).getCost() , 8); }
}


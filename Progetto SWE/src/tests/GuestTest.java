package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Guest;

class GuestTest {
	
	Guest guest;
	
	@BeforeEach
    void setUp() {
        guest = new Guest.GuestBuilder("Luca", "Verdi")
        		.setNationality("italiana")
				.setAddress("via Roma, Firenze")
				.setBirthAge(1978)
				.setAlone(true).build(); }

    @Test
    void getName() {
        assertEquals(guest.getName(), "Luca"); }

    @Test
    void getSurname() {
        assertEquals(guest.getSurname(), "Verdi"); }
    
    @Test
    void getRelatives() {
    	guest.getGuestRelatives().AddGuestRelatives("Simone", "Neri", 1987);
        assertEquals(guest.getGuestRelatives().getName().get(0), "Simone");
        assertEquals(guest.getGuestRelatives().getSurname().get(0), "Neri");
        assertEquals(guest.getGuestRelatives().getBirthAge().get(0), 1987); }
    
    @Test
    void getStayAccount() {
    	guest.getStayAccount().setDateArrive(LocalDate.of(2019, 10, 19));
        assertEquals(guest.getStayAccount().getDateArrive(), LocalDate.of(2019, 10, 19)); }
}


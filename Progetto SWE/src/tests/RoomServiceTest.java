package tests;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DrinkEFood;
import model.RoomService;

class RoomServiceTest {

	RoomService roomService;
	List<DrinkEFood> extra = new ArrayList<>();

    @BeforeEach
    void setUp() {
        roomService = new RoomService();
    }

    @Test
    void roomServiceTest() {
    	extra.add( new DrinkEFood("pizza", "food", true, 5));
    	
        assertEquals(roomService.getBill(extra), 7);
    }
}


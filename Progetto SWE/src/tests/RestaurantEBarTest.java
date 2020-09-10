package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DrinkEFood;
import model.RestaurantEBar;

class RestaurantEBarTest {

	RestaurantEBar restaurant;
	List<DrinkEFood> extra = new ArrayList<>();

    @BeforeEach
    void setUp() {
    	restaurant = new RestaurantEBar();
    }

    @Test
    void roomServiceTest() {
    	extra.add( new DrinkEFood("pizza", "food", true, 5));
    	
        assertEquals(restaurant.getBill(extra), 5);
    }
}


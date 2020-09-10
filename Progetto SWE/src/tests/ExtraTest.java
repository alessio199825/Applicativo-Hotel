package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DrinkEFood;
import model.Extra;

class ExtraTest {

	Extra extra;
	List<DrinkEFood> foodRestaurant = new ArrayList<>();
	List<DrinkEFood> foodRoom = new ArrayList<>();
	
	@BeforeEach
    void setUp() {
		extra = new Extra();
		foodRestaurant.add( new DrinkEFood("pollo", "food", true, 10));
		foodRestaurant.add( new DrinkEFood("pizza", "food", false, 5));
		foodRoom.add( new DrinkEFood("fanta", "drink", true, 2));
		foodRoom.add( new DrinkEFood("pasta", "food", true, 8));
	}	

    @Test
    void strategyTest() {
    	assertEquals(extra.getBill(foodRestaurant), 15);
    	extra.changeExtraStrategy(true);
    	assertEquals(extra.getBill(foodRoom), 14);
    }
}


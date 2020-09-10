package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DrinkEFood;

class DrinkEFoodTest {

	DrinkEFood extra;

    @BeforeEach
    void setUp() {
        extra = new DrinkEFood("pizza", "food", true, 5); }

    @Test
    void getName() {
        assertEquals(extra.getName(), "pizza"); }

    @Test
    void getType() {
        assertEquals(extra.getType(), "food"); }

    @Test
    void getCost() {
        assertEquals(extra.getCost(), 5); }
    
    @Test
    void getInRoom() {
        assertTrue(extra.getInRoom()); }
}


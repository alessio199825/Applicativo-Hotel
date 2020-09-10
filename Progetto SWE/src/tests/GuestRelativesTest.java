package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GuestRelatives;

class GuestRelativesTest {

	GuestRelatives relatives;

    @BeforeEach
    void setUp() {
        relatives = new GuestRelatives();
        relatives.AddGuestRelatives("Simone", "Verdi", 1986); }

    @Test
    void getName() {
        assertEquals(relatives.getName().get(0), "Simone"); }

    @Test
    void getSurname() {
        assertEquals(relatives.getSurname().get(0), "Verdi"); }

    @Test
    void getBirthAge() {
        assertEquals(relatives.getBirthAge().get(0), 1986); }
}


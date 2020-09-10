package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Employee;

class EmployeeTest {

	Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("Giorgio", "Rossi", "002"); }

    @Test
    void getName() {
        assertEquals(employee.getName(), "Giorgio"); }

    @Test
    void getSurname() {
        assertEquals(employee.getSurname(), "Rossi"); }

    @Test
    void getSpecialization() {
        assertEquals(employee.getRegisterCode(), "002"); }
}


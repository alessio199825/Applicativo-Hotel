package model;

import java.util.ArrayList;
import java.util.List;

public class GuestRelatives {

	private List<String> name;
	private List<String> surname;
	private List<Integer> birthAge;

	public GuestRelatives() {
		name = new ArrayList<>();
		surname = new ArrayList<>();
		birthAge = new ArrayList<>();
	}
	
	public List<String> getName() { return name; }

	public List<String> getSurname() { return surname; }

	public List<Integer> getBirthAge() { return birthAge; }
	
	public void AddGuestRelatives(String Name, String Surname, int Age) {
		AddName(Name);
		AddSurname(Surname);
		AddBirthAge(Age);
	}
	
	private void AddName(String Name) { name.add(Name); }

	private void AddSurname(String Surname) { surname.add(Surname); }
	
	private void AddBirthAge(int Age) { birthAge.add(Age); }
}
package model;

public class Employee {
	
	private final String Name;
	private final String Surname;
	private final String RegisterCode;
	
	public Employee(String name, String surname, String registerCodeField) {
		Name = name;
		Surname = surname;
		RegisterCode = registerCodeField; 
	}

	public String getName() { return Name; }

	public String getSurname() { return Surname; }

	public String getRegisterCode() { return RegisterCode; }
}

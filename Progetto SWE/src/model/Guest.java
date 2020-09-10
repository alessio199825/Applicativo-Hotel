package model;

public class Guest{
	private String name;
	private String surname;
	private String nationality;
	private String address;
	private int birthAge;
	private boolean alone;
	private GuestRelatives guestRelatives;
	private StayAccount stayAccount;
	
	private Guest(GuestBuilder builder) {
		name = builder.name;
		surname = builder.surname;
		nationality = builder.nationality;
		address = builder.address;
		birthAge = builder.birthAge;
		alone = builder.alone;
		stayAccount = new StayAccount();
		guestRelatives = new GuestRelatives();
	}
	
	public String getName() { return name; }

	public String getSurname() { return surname; }

	public String getNationality() { return nationality; }

	public String getAddress() { return address; }

	public int getBirthAge() { return birthAge; }

	public boolean isAlone() { return alone; }
	
	public void setAlone(boolean alone) { this.alone = alone; }

	public GuestRelatives getGuestRelatives() { return guestRelatives; }

	public StayAccount getStayAccount() { return stayAccount; }
	
	public static class GuestBuilder {
		private final String name;
		private final String surname;
		private String nationality;
		private String address;
		private int birthAge;
		private boolean alone;
		
		public GuestBuilder(String name, String surname) {
			this.name=name;
			this.surname=surname;
		}

		public Guest build() { return new Guest(this); }

		public GuestBuilder setNationality(String nationality) {
			this.nationality = nationality;
			return this;
		}

		public GuestBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public GuestBuilder setBirthAge(int birthAge) {
			this.birthAge = birthAge;
			return this;
		}

		public GuestBuilder setAlone(boolean alone) {
			this.alone = alone;
			return this;
		}
	}
}

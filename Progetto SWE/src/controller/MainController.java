package controller;

import view.*;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class MainController {
	
    private HotelMenagement hotel;
	private final Main_Frame view;
    
    private List<String> relatives_name = new ArrayList<String>();
    private List<String> relatives_surname = new ArrayList<String>();
    private List<Integer> relatives_age = new ArrayList<Integer>();

    public MainController(Main_Frame view) {
        this.view = view;
        hotel = HotelMenagement.getInstance();
        relatives_name = new ArrayList<String>();
        relatives_surname = new ArrayList<String>();
        relatives_age = new ArrayList<Integer>();
    }
    
    public void setEmployee(String name, String surname, String registerCodeField) {
        hotel.setEmployee(name, surname, registerCodeField);
        view.refresh();
    }

    public String getEmploeeName() {
        return hotel.getEmployee().getName();
    }

    public String getEmployeeSurname() {
    	return hotel.getEmployee().getSurname();
    }

    public String getEmployeeRegisterCode() {
    	return hotel.getEmployee().getRegisterCode();
    }
    
    public Object[] GuestsList() {
        ArrayList<String> guests = new ArrayList<>();
        for (int i = 0; i < hotel.getGuests().size(); i++) {
            guests.add(hotel.getGuests().get(i).getName() + " " + hotel.getGuests().get(i).getSurname());
        }
        return guests.toArray();
    }
    
    public boolean getAlone(int i) {
    	if(hotel.getGuests().get(i).isAlone()) {
    		return true;
    	}
    	return false;
    }

    public Object[] RelativesList(int index) {
    	if(!hotel.getGuests().get(index).isAlone()) {
    		ArrayList<String> relatives = new ArrayList<>();
    		for (int i = 0; i < hotel.getGuests().get(index).getGuestRelatives().getName().size(); i++) {
    			relatives.add(hotel.getGuests().get(index).getGuestRelatives().getName().get(i) + " " + hotel.getGuests().get(index).getGuestRelatives().getSurname().get(i));
    		}
    		return relatives.toArray();
    	}
    	return null;
    }
    
    public String getGuestName(int i) {
        return hotel.getGuests().get(i).getName();
    }

    public String getGuestSurname(int i) {
        return hotel.getGuests().get(i).getSurname();
    }

    public String getGuestNationality(int i) {
        return hotel.getGuests().get(i).getNationality();
    }

    public String getGuestAddress(int i) {
        return hotel.getGuests().get(i).getAddress();
    }

    public int getGuestBirthAge(int i) {
        return hotel.getGuests().get(i).getBirthAge();
    }
    
    public int getRelativesBirthAge(int iG, int iR) {
        return hotel.getGuests().get(iG).getGuestRelatives().getBirthAge().get(iR);
    }
    
    public void AddGuest(String name, String surname, int BirthAge, String Nationality, String Address) /*throws NoRoomsException*/ {
		Guest guest = new Guest.GuestBuilder(name, surname)
				.setNationality(Nationality)
				.setAddress(Address)
				.setBirthAge(BirthAge)
				.setAlone(true).build();
        hotel.addGuest(guest);
        for(int i=0; i< relatives_name.size(); i++) {
        	guest.getGuestRelatives().AddGuestRelatives(relatives_name.get(i), relatives_surname.get(i), relatives_age.get(i));
        	guest.setAlone(false);
        }	
        
        relatives_name = new ArrayList<String>();
        relatives_surname = new ArrayList<String>();
        relatives_age = new ArrayList<Integer>();
    
        view.refresh();
    }
    
    public void addRelative(String name, String surname, int BirthAge) /*throws MaxPreviousPathologiesException*/ {
        relatives_name.add(name);
        relatives_surname.add(surname);
        relatives_age.add(BirthAge);
    }
   
	@SuppressWarnings("deprecation")
	public void InstanceRoom() {
		for(int i=1; i<4; i++) {
			Room room = new SingleRoom(100 + i);
			hotel.addRoomFree(room);
			room.addObserver(hotel);	
		}
		
		for(int i=1; i<4; i++) {
			Room room = new DoubleRoom(200 + i);
			hotel.addRoomFree(room);
			room.addObserver(hotel);
		}
			
		for(int i=1; i<4; i++) {
			Room room = new SuiteRoom(300 + i);
			hotel.addRoomFree(room);
			room.addObserver(hotel);
		}
	}
	
	public String getRoomFree(int i) {
		String Tmp = new String();
		if(hotel.getRoomsFree().get(i).code_room <200){
			Tmp = "Single: " + Integer.toString(hotel.getRoomsFree().get(i).code_room);
		}
		else if(hotel.getRoomsFree().get(i).code_room <300){
			Tmp = "Double: " + Integer.toString(hotel.getRoomsFree().get(i).code_room);
		}
		else{
			Tmp = "Suite: " + Integer.toString(hotel.getRoomsFree().get(i).code_room);
		}
		return Tmp;
	}
	
	public HotelMenagement getHotel() {
		return hotel;
	}
	
	public DrinkEFood getDrinkEFood(int selection) {
		return hotel.getDrinksEfoods().get(selection);
	}
	
	public void setExtraRoom(DrinkEFood food, int selection) throws ExtraRoomException {
			hotel.getGuests().get(selection).getStayAccount().addExtraRoom(food);
	}
	
	public void setExtraLoco(DrinkEFood food, int selection) {
		hotel.getGuests().get(selection).getStayAccount().addExtraRestaurant(food);
	}
	
	public void InstanceExtra(){
		List<DrinkEFood> alimenti = new ArrayList<>();
		alimenti.add(new DrinkEFood("CocaCola", "Bevanda", true, 2.50));
		alimenti.add(new DrinkEFood("Fanta", "Bevanda", false, 2.00));
		alimenti.add(new DrinkEFood("Sprite", "Bevanda", true, 2.00));
		alimenti.add(new DrinkEFood("Pizza", "Piatto", true, 5.00));
		alimenti.add(new DrinkEFood("HotDog", "Piatto", false, 3.50));
		alimenti.add(new DrinkEFood("Hamburger", "Piatto", true, 6.00));
		alimenti.add(new DrinkEFood("Penne al pomodoro", "Piatto", true, 9.50));
		alimenti.add(new DrinkEFood("Vino rosso", "Bevanda", true, 11.00));
		alimenti.add(new DrinkEFood("Bistecca", "Piatto", false, 15.00));
		alimenti.add(new DrinkEFood("Spumante", "Bevanda", true, 5.00));
		alimenti.add(new DrinkEFood("Tiramisù", "Piatto", false, 8.50));
		alimenti.add(new DrinkEFood("Birra", "Bevanda", true, 4.50));
		for(int i=0; i<alimenti.size(); i++) {
			hotel.addDrinkEFood(alimenti.get(i));
		}
	}
	
	public Object[] ExtrasList() {
		ArrayList<String> Extras = new ArrayList<>();
		for (int i = 0; i < hotel.getDrinksEfoods().size(); i++) {
			Extras.add(hotel.getDrinksEfoods().get(i).getType()+ ":  " + hotel.getDrinksEfoods().get(i).getName());
		}
		return Extras.toArray();
    }
	
	public Object[] getExtraChoose(int index) {
		ArrayList<String> Extras = new ArrayList<>();
		for (int i=0; i<hotel.getGuests().get(index).getStayAccount().getRestaurantExtra().size(); i++) {
			Extras.add(hotel.getGuests().get(index).getStayAccount().getRestaurantExtra().get(i).getName() + ":  " + hotel.getGuests().get(index).getStayAccount().getRestaurantExtra().get(i).getCost());
		}
		for (int i=0; i<hotel.getGuests().get(index).getStayAccount().getRoomExtra().size(); i++) {
			Extras.add(hotel.getGuests().get(index).getStayAccount().getRoomExtra().get(i).getName() + ":  " + hotel.getGuests().get(index).getStayAccount().getRoomExtra().get(i).getCost());
		}
		return Extras.toArray();
	}
	
	public boolean getExtraInRoom(int index, int guestSelection) {
		if(index >= hotel.getGuests().get(guestSelection).getStayAccount().getRestaurantExtra().size())
			return true;
		return false;
	}

	public void deleteGuest(int indicatore) {
		hotel.getGuests().get(indicatore).getStayAccount().setRoomFree();
		hotel.removeGuest(hotel.getGuests().get(indicatore));
	}
}
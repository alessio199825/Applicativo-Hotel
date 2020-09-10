package model;

import java.util.List;

public class Extra {

	ExtraStrategy extraStrategy;
	
	public Extra() {
		extraStrategy = new RestaurantEBar();
	}
	
	public double getBill(List<DrinkEFood> shoppingExtra) {
		return extraStrategy.getBill(shoppingExtra);
	}

	public void changeExtraStrategy(boolean change) {
		if(change) {
		    extraStrategy = new RoomService();
		}
		else {
			extraStrategy = new RestaurantEBar();
		}
	}
}


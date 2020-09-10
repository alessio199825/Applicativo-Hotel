package model;

import java.util.List;

public class RoomService implements ExtraStrategy{

	@Override
	public double getBill(List<DrinkEFood> shoppingExtra) {
		
		double tmp = 0;
		if(shoppingExtra.size() == 0) {
			return 0;
		}
		else {
			for(int i = 0; i < shoppingExtra.size(); i++) {
				tmp = tmp + shoppingExtra.get(i).getCost();
				tmp = tmp + 2;
			}
		}
		return tmp;
	}
}


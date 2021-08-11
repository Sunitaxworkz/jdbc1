package com.xworkz.restaurant;

import com.xworkz.restaurant.constants.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;

public class RestaurantTester {

	public static void main(String[] args) {
		RestaurantDTO dto = new RestaurantDTO("Navya Bar and Restaurant", "Basaveshwara Nagar", "Parota", false,
				RestaurantType.BAR);
		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		
	}

}

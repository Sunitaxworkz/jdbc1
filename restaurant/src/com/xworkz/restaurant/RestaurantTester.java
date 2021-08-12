package com.xworkz.restaurant;

import java.util.Collection;

import com.xworkz.restaurant.constants.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;

public class RestaurantTester {

	public static void main(String[] args) {
		RestaurantDTO dto = new RestaurantDTO("Darshini", "Dharwad", "Gobi", true, RestaurantType.FAMILY);
		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		RestaurantDTO name = dao.findByName("Darshini");
		System.out.println(name);
		Collection<RestaurantDTO> type = dao.findByType(RestaurantType.BAR);
		type.forEach(s -> System.out.println(s));
		boolean temp = dao.updateTypeByName(RestaurantType.FAST_FOOD, "Darshini");

		System.out.println(temp);
		 boolean temp1 = dao.deleteByTypeAndName(RestaurantType.FAST_FOOD, "Darshini");
		 System.out.println(temp1);
	}

}

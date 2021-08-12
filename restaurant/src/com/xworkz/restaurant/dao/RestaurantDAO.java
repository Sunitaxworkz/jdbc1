package com.xworkz.restaurant.dao;

import java.util.Collection;

import com.xworkz.restaurant.RestaurantDTO;
import com.xworkz.restaurant.constants.RestaurantType;

public interface RestaurantDAO {
	int save(RestaurantDTO dto);

	RestaurantDTO findByName(String name);

	Collection<RestaurantDTO> findByType(RestaurantType type);

	default boolean updateTypeByName(RestaurantType newtype, String name) {
		return false;
	}
	default boolean deleteByTypeAndName(RestaurantType newtype, String name) {
		return false;
	}
}

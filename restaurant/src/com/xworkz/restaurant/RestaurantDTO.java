package com.xworkz.restaurant;

import com.xworkz.restaurant.constants.*;

public class RestaurantDTO {
	private int id;
	private String name;
	private String location;
	private String specialFood;
	private boolean best;
	private RestaurantType type;

	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "RestaurantDTO [id=" + id + ", name=" + name + ", location=" + location + ", specialFood=" + specialFood
				+ ", best=" + best + ", type=" + type + "]";
	}


	public RestaurantDTO( String name, String location, String specialFood, boolean best, RestaurantType type) {
		super();
		this.id=id;
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		return 100;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantDTO other = (RestaurantDTO) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSpecialFood() {
		return specialFood;
	}


	public void setSpecialFood(String specialFood) {
		this.specialFood = specialFood;
	}


	public boolean isBest() {
		return best;
	}


	public void setBest(boolean best) {
		this.best = best;
	}


	public RestaurantType getType() {
		return type;
	}


	public void setType(RestaurantType type) {
		this.type = type;
	}
	
	
	
}
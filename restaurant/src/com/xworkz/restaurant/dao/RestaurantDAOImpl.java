package com.xworkz.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.xworkz.restaurant.constant.RestaurantConstants.*;
import com.xworkz.restaurant.constants.*;

import com.xworkz.restaurant.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int save(RestaurantDTO dto) {
		System.out.println("saving to db" + dto);
		Connection connect = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connect = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table values(1,'" + dto.getName() + "','" + dto.getLocation() + "','"
					+ dto.getSpecialFood() + "','" + dto.isBest() + "','" + dto.getType() + "')";
			Statement state = connection.createStatement();
			state.execute(query);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connect.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
}

package com.xworkz.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import static com.xworkz.restaurant.constant.RestaurantConstants.*;
import com.xworkz.restaurant.constants.*;

import com.xworkz.restaurant.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int save(RestaurantDTO dto) {
		System.out.println("saving to db" + dto);
		Connection connect = null;
		int temp = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connect = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant_table(r_name,r_location,r_speicalFood,r_best,r_type)values('"
					+ dto.getName() + "','" + dto.getLocation() + "','" + dto.getSpecialFood() + "','" + dto.isBest()
					+ "','" + dto.getType() + "')";
			Statement state = connection.createStatement();
			state.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = state.getGeneratedKeys();
			if (rs.next()) {
				temp = rs.getInt(1);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connect.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return temp;
	}

	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String querry = "select * from restaurant_table where r_name='" + name + "'";
			Statement statement = connection.createStatement();
			statement.execute(querry);
			ResultSet resultSet = statement.getResultSet();
			if (resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String resName = resultSet.getString("r_name");
				String location = resultSet.getString("r_location");
				String specialFood = resultSet.getString("r_speicalFood");
				boolean best = resultSet.getBoolean("r_best");
				String type = resultSet.getString("r_type");
				RestaurantDTO dto = new RestaurantDTO(resName, location, specialFood, best,RestaurantType.valueOf(type));
				dto.setId(id);
				return dto;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Collection<RestaurantDTO> findByType(RestaurantType type) {
		Collection<RestaurantDTO> coll=new ArrayList<RestaurantDTO>();
		try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String querry="select*from restaurant_table where r_type='"+type+"'";
			Statement statement=connection.createStatement();
			statement.execute(querry);
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String resName=resultSet.getString("r_name");
				String location=resultSet.getString("r_location");
				String specialFood=resultSet.getString("r_speicalFood");
				boolean best = resultSet.getBoolean("r_best");
				String rtype=resultSet.getString("r_type");
				System.out.println("converting from type to enum" + type);
				RestaurantDTO dto = new RestaurantDTO(resName, location, specialFood, best,RestaurantType.valueOf(rtype));
				dto.setId(id);
				coll.add(dto);
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return coll;
	}
	@Override
	public boolean updateTypeByName(RestaurantType newtype, String name) {
		try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			connection.setAutoCommit(false);
			String que="update restaurant_table set r_type='"+newtype+"' where r_name='"+name+"'";
			Statement state=connection.createStatement();
			state.executeUpdate(que);
			ResultSet resultSet = state.getResultSet();
			connection.commit();				
			return true;
				
				
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteByTypeAndName(RestaurantType newtype, String name) {
		try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String que="delete from restaurant_table where r_name='"+name+"' and r_type='"+newtype+"'";
			Statement state=connection.createStatement();
			state.executeUpdate(que);
			ResultSet resultSet = state.getResultSet();
			while(resultSet.next()) {
				int id = resultSet.getInt("r_id");
				String resName=resultSet.getString("r_name");
				String location=resultSet.getString("r_location");
				String specialFood=resultSet.getString("r_speicalFood");
				boolean best = resultSet.getBoolean("r_best");
				String rtype=resultSet.getString("r_type");
				System.out.println("converting from type to enum" + newtype);
				RestaurantDTO dto = new RestaurantDTO(resName, location, specialFood, best,RestaurantType.valueOf(rtype));
				dto.setId(id);
				return true;
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

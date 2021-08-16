package com.xworkz.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constants.EducationType;
import com.xworkz.customer.dto.CustomerDTO;
import static com.xworkz.customer.constants.JdbcConstants.*;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		System.out.println(dto);
		Connection tempConnection = null;
		int temp = 0;

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer_table(c_name,c_from,c_to,c_address,c_married,c_passPortNo,c_eductaionType) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, dto.getName());
			pst.setString(2, dto.getFrom());
			pst.setString(3, dto.getTo());
			pst.setString(4, dto.getAddress());
			pst.setBoolean(5, dto.isMarried());
			pst.setString(6, dto.getPassPortNo());
			pst.setString(7, dto.getEducationType().toString());
			pst.execute();
			ResultSet result = pst.getGeneratedKeys();
			if (result.next()) {
				temp = result.getInt(1);
				System.out.println(temp);
			}
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return temp;

	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		Connection temp = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			temp = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query);
			collection.forEach(nick -> {
				try {
					prepare.setString(1, nick.getName());
					prepare.setString(2, nick.getFrom());
					prepare.setString(3, nick.getTo());
					prepare.setString(4, nick.getAddress());
					prepare.setBoolean(5, nick.isMarried());
					prepare.setString(6, nick.getPassPortNo());
					prepare.setString(7, nick.getEducationType().toString());
					prepare.execute();
					System.out.println(nick);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
			connection.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
			try {
				temp.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("c_id");
				String name = result.getString("c_name");
				String from = result.getString("c_from");
				String to = result.getString("c_to");
				String address = result.getString("c_address");
				Boolean married = result.getBoolean("c_married");
				String passPortNo = result.getString("c_passPortNo");
				String education = result.getString("c_education");

				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passPortNo,
						EducationType.valueOf(education));
				dto.setId(id);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return optional;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("c_id");
				String name = result.getString("c_name");
				String from = result.getString("c_from");
				String to = result.getString("c_to");
				String address = result.getString("c_address");
				Boolean married = result.getBoolean("c_married");
				String passPortNo = result.getString("c_passPortNo");
				String education = result.getString("c_education");

				String educationType;
				
				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passPortNo,
						EducationType.valueOf(education));
				dto.setId(id);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("c_id");
				String name = result.getString("c_name");
				String from = result.getString("c_from");
				String to = result.getString("c_to");
				String address = result.getString("c_address");
				Boolean married = result.getBoolean("c_married");
				String pass = result.getString("c_passPortNo");
				String education = result.getString("c_education");

				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, pass,EducationType.valueOf(education));
				dto.setId(id);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from customer_table order by c_name desc";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				int id = result.getInt("c_id");
				String name = result.getString("c_name");
				String from = result.getString("c_from");
				String to = result.getString("c_to");
				String address = result.getString("c_address");
				Boolean married = result.getBoolean("c_married");
				String pass = result.getString("c_passportNo");
				String education = result.getString("c_education");

				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, pass,EducationType.valueOf(education));
				dto.setId(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return collection;
	}

	@Override
	public int total() {
		int total = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT count(c_id) FROM customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				total = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return total;

	}
}

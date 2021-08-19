package com.xworkz.webSeries.dao;

import static com.xworkz.webSeries.dto.constant.JdbcConstants.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.webSeries.dto.WebSeriesDTO;
import com.xworkz.webSeries.dto.constant.Genre;
import com.xworkz.webSeries.dto.constant.StreamedIn;

public class WebSeriesDAOImpl implements WebSeriesDAO {

	@Override
	public int save(WebSeriesDTO dto) {
		System.out.println("saving to db" + dto);
		int r = 0;
		Connection connect = null;// connection is visible for rollBack
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connect = connection;
			connection.setAutoCommit(false);
			String query = "insert into webSeries_table(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn,w_genre,w_ageLimit) values(?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getNoOfEpisodes());
			ps.setInt(3, dto.getTotalSeason());
			ps.setString(4, dto.getStreamedIn().toString());
			ps.setString(5, dto.getGenre().toString());
			ps.setInt(6, dto.getAgeLimit());

			ps.execute();
			ResultSet result = ps.getGeneratedKeys();
			if (result.next()) {
				r = result.getInt(1);
				System.out.println(r);
			}
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return r;

	}

	@Override
	public int total() {
		int count = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connection.setAutoCommit(false);
			String query = "SELECT count(w_id) FROM webSeries_table";
			PreparedStatement set = connection.prepareStatement(query);
			set.execute();
			ResultSet resultset = set.getResultSet();
			if (resultset.next()) {
				count = resultset.getInt(1);
			}
			connection.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int findMax() {
		int count = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connection.setAutoCommit(false);
			String query = "SELECT max(w_totalSeason) FROM  webSeries_table";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.execute();
			ResultSet resultSet = pst.getResultSet();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();

		ResultSet set = prepare.getResultSet();
		return set;
	}

	@Override
	public int findMinSeason() {
		int count = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT min(w_totalSeason) FROM webSeries_table";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			ResultSet set = preparedStatement.getResultSet();
			if (set.next()) {
				count = set.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Collection<WebSeriesDTO> findAll() {
		Collection<WebSeriesDTO> list = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from webSeries_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				int id = result.getInt("w_id");
				String name = result.getString("w_name");
				int noOfEpisodes = result.getInt("w_noOfEpisodes");
				int total = result.getInt("w_totalSeason");
				String streamedIn = result.getString("w_streamedIn");
				String genre = result.getString("w_genre");
				int age = result.getInt("w_ageLimit");

				WebSeriesDTO webseriesdto = new WebSeriesDTO(name, noOfEpisodes, total,
						StreamedIn.valueOf(streamedIn), Genre.valueOf(genre), age);
				webseriesdto.setId(id);
				list.add(webseriesdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	private WebSeriesDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
		int id=result.getInt("w_id");
		String name=result.getString("w_name");
		int episodes=result.getInt("w_noOfEpisodes");
		int total=result.getInt("w_totalSeason");
		String stream=result.getString("w_streamedIn");
		String genre=result.getString("w_genre");
		int age=result.getInt("w_yestAgeIndaNodbohudu");

		WebSeriesDTO dto=new WebSeriesDTO( name, episodes, total, StreamedIn.valueOf(stream),Genre.valueOf(genre),age);
		dto.setId(id);
		return dto;
	}

	@Override
	public Collection<WebSeriesDTO> findAllSortByNameDesc() {
		Collection<WebSeriesDTO> list = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from webSeries_table order by w_name desc";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				int id = result.getInt("w_id");
				String name = result.getString("w_name");
				int noOfEpisodes = result.getInt("w_noOfEpisodes");
				int total = result.getInt("w_totalSeason");
				String streamedIn = result.getString("w_streamedIn");
				String genre = result.getString("w_genre");
				int age = result.getInt("w_ageLimit");

				WebSeriesDTO webseriesdto = new WebSeriesDTO(name, noOfEpisodes, total,
						StreamedIn.valueOf(streamedIn), Genre.valueOf(genre), age);
				webseriesdto.setId(id);
				list.add(webseriesdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}
	@Override
	public Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate) {
		Optional<WebSeriesDTO> optional=Optional.empty();
		try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String query="select * from websereis_table";
			PreparedStatement prepare=connection.prepareStatement(query);
			ResultSet result=prepare.executeQuery();
			
			while(result.next()) {
				WebSeriesDTO dto = createdValuesFromResultSet(result);
				if(predicate.test(dto)) {
					optional=Optional.of(dto);
					break;
				}
				}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
			
		return optional;
	}

	}



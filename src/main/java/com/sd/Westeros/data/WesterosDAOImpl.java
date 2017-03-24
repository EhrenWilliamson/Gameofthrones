package com.sd.Westeros.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class WesterosDAOImpl implements WesterosDAO{

	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";
	public WesterosDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	@Override
	public List<House> getHouse(House house) {
		List<House> houses = new ArrayList<>();
		String sql = "SELECT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + house + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				House newHouse = new House(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10));
				houses.add(newHouse);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return houses;
	}

	@Override
	public List<Player> getPlayer(Player player) {
		List<Player> players = new ArrayList<>();
		String sql = "SELECT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + player + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player newPlayer = new Player();
				players.add(newPlayer);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return players;

	}
	@Override
	public Player addPlayer(Player player) {
		List<Player> players = new ArrayList<>();
		String sql = "INSERT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + player + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player newPlayer = new Player();
				players.add(newPlayer);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return player;
	}
	@Override
	public House addHouse(House house) {
		List<House> houses = new ArrayList<>();
		String sql = "INSERT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + house + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				House newHouse = new House(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10));
				houses.add(newHouse);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return house;		
	}
	
	public House editHouse(House house) {

		String sql = "UPDATE house SET name = ?, location = ?, headofhouse = ? WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			stmt.setString(1, house.getName());
			stmt.setString(2, house.getLocation());
			stmt.setString(3, house.getHeadOfHouse());
			stmt.setInt(4, house.getId());
			int rowsUpdated = stmt.executeUpdate();

			if ( rowsUpdated == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return house;		
	}
	
	public Player editPlayer(Player player) {
		
		String sql = "UPDATE player SET first_name = ?, last_name = ?, nickname = ?,  "
						+ "player_status = ? WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			stmt.setString(1, player.getFirstName());
			stmt.setString(2, player.getLastName());
			stmt.setString(3, player.getNickName());
			stmt.setString(4, player.getPlayerStatus());			
			stmt.setInt(5, player.getId());
			int rowsUpdated = stmt.executeUpdate();
			
			if ( rowsUpdated == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return player;		
	}
}

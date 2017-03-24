package com.sd.Westeros.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class WesterosDAOImpl implements WesterosDAO{

	private static String url = "jdbc:mysql://localhost:3306/gotdb";
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
		String sql = "SELECT first_name, last_name, nickname, player_status"
				+ " FROM player"
				+ " WHERE first_name=?"
				+ " OR last_name = ?"
				+ " OR nickname = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, player.getFirstName());
			stmt.setString(2, player.getLastName());
			stmt.setString(3, player.getNickName());
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
	@Override
	public List<Player> getPlayersByHouse(House house) {
		List<Player> players = new ArrayList<>();
		String sql = "SELECT c.first_name, c.last_name, c.nickname, c.player_status, h.house_name "
				+ "FROM player c JOIN house h"
				+ "ON c.last_name = h.house_name"
				+ "WHERE c.last_name = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, house.getName());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player newPlayer = new Player(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
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
	public void deletePlayer(Integer id) {
		List<Player> players = new ArrayList<>();
		String sql = "INSERT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + player + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player newPlayer = new Player();
				players.remove(newPlayer);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<House> deleteHouse(House house) {
		List<House> houses = new ArrayList<>();
		String sql = "Delete * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + house + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				House newHouse = new House(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10));
				houses.remove(newHouse);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return houses;	
	}
}

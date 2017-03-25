package com.sd.westeros.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WesterosDAOImpl implements WesterosDAO {

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
	public House getHouse(String h) {
		House house = null;
		String sql = "SELECT id, location, headOfHouse FROM house WHERE name = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, h);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				house = new House();
				house.setId(rs.getInt(1));
				house.setName(h);
				house.setLocation(rs.getString(2));
				house.setHeadOfHouse(rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return house;
	}
//
//	 @Override
//	 public List<Player> getPlayer(Player player) {
//	 List<Player> players = new ArrayList<>();
//	 String sql = "SELECT first_name, last_name, nickname, player_status"
//	 + " FROM player"
//	 + " WHERE first_name=?"
//	 + " OR last_name = ?"
//	 + " OR nickname = ?";
//	 try {
//	 Connection conn = DriverManager.getConnection(url, user, pass);
//	 PreparedStatement stmt = conn.prepareStatement(sql);
//	 stmt.setString(1, player.getFirstName());
//	 stmt.setString(2, player.getLastName());
//	 stmt.setString(3, player.getNickName());
//	 ResultSet rs = stmt.executeQuery();
//	 while (rs.next()) {
//	 Player newPlayer = new Player();
//	 players.add(newPlayer);
//	 }
//	 rs.close();
//	 stmt.close();
//	 conn.close();
//	 } catch (SQLException e) {
//	 e.printStackTrace();
//	 }
//	 return players;
//	 }
//	
//	 @Override
//	 public Player addPlayer(Player player) {
//	 List<Player> players = new ArrayList<>();
//	 String sql = "INSERT * FROM film WHERE title like ?";
//	 try {
//	 Connection conn = DriverManager.getConnection(url, user, pass);
//	 PreparedStatement stmt = conn.prepareStatement(sql);
//	 stmt.setString(1, "%" + player + "%");
//	 ResultSet rs = stmt.executeQuery();
//	 while (rs.next()) {
//	 Player newPlayer = new Player();
//	 players.add(newPlayer);
//	 }
//	 rs.close();
//	 stmt.close();
//	 conn.close();
//	 } catch (SQLException e) {
//	 e.printStackTrace();
//	 }
//	 return player;
//	 }
//	 @Override
//	 public House addHouse(House house) {
//	 List<House> houses = new ArrayList<>();
//	 String sql = "INSERT * FROM film WHERE title like ?";
//	 try {
//	 Connection conn = DriverManager.getConnection(url, user, pass);
//	 PreparedStatement stmt = conn.prepareStatement(sql);
//	 stmt.setString(1, "%" + house + "%");
//	 ResultSet rs = stmt.executeQuery();
//	 while (rs.next()) {
//	 House newHouse = new House(rs.getInt(1), rs.getString(2),
//	 rs.getString(3), rs.getInt(4), rs.getInt(5),
//	 rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9),
//	 rs.getString(10));
//	 houses.add(newHouse);
//	 }
//	 rs.close();
//	 stmt.close();
//	 conn.close();
//	 } catch (SQLException e) {
//	 e.printStackTrace();
//	 }
//	 return house;
//	 }
//
//	public House editHouse(House house) {
//
//		String sql = "UPDATE house SET name = ?, location = ?, headofhouse = ? WHERE id = ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			conn.setAutoCommit(false);
//			stmt.setString(1, house.getName());
//			stmt.setString(2, house.getLocation());
//			stmt.setString(3, house.getHeadOfHouse());
//			stmt.setInt(4, house.getId());
//			int rowsUpdated = stmt.executeUpdate();
//
//			if (rowsUpdated == 1) {
//				conn.commit();
//			} else {
//				conn.rollback();
//			}
//
//			stmt.close();
//			conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return house;
//	}
//
//	public Player editPlayer(Player player) {
//
//		String sql = "UPDATE player SET first_name = ?, last_name = ?, nickname = ?,  "
//				+ "player_status = ? WHERE id = ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			conn.setAutoCommit(false);
//			stmt.setString(1, player.getFirstName());
//			stmt.setString(2, player.getLastName());
//			stmt.setString(3, player.getNickName());
//			stmt.setString(4, player.getPlayerStatus());
//			stmt.setInt(5, player.getId());
//			int rowsUpdated = stmt.executeUpdate();
//
//			if (rowsUpdated == 1) {
//				conn.commit();
//			} else {
//				conn.rollback();
//			}
//
//			stmt.close();
//			conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return player;
//	}
//
//	@Override
//	public List<Player> getPlayersByHouse(House house) {
//		List<Player> players = new ArrayList<>();
//		String sql = "SELECT c.first_name, c.last_name, c.nickname, c.player_status, h.house_name "
//				+ "FROM player c JOIN house h" + "ON c.last_name = h.house_name" + "WHERE c.last_name = ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, house.getName());
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Player newPlayer = new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5));
//				players.add(newPlayer);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return players;
//	}
//
//	@Override
//	public void deletePlayer(Integer id) {
//		List<Player> players = new ArrayList<>();
//		String sql = "INSERT * FROM film WHERE title like ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + player + "%");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Player newPlayer = new Player();
//				players.remove(newPlayer);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public List<House> deleteHouse(House house) {
//		List<House> houses = new ArrayList<>();
//		String sql = "Delete * FROM film WHERE title like ?";
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + house + "%");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				House newHouse = new House(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
//						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10));
//				houses.remove(newHouse);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return houses;
//
//	}
//
//	@Override
//	public Player getPlayer(String player) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	@Override
	public List<House> getHouses() {

		List<House> houses = null;
		
		String sql = "SELECT id, house_name, castle_name, location, head_of_house FROM house";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				House house = new House();
				houses = new ArrayList<>();
				house.setId(rs.getInt(1));
				house.setHouseName(rs.getString(2));
				house.setLocation(rs.getString(2));
				house.setLocation(rs.getString(2));
				house.setHeadOfHouse(rs.getString(3));
				houses.add(house);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return houses;
	}
//
//	@Override
//	public List<Player> getPlayers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

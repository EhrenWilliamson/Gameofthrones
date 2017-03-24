package data;

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
	private List<House> Houses = new ArrayList<>();
	public WesterosDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	@Override
	public List<House> GetHouse(House house) {
		List<House> houses = new ArrayList<>();
		String sql = "SELECT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + house + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				House newHouse = new House(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
						getCastOfMovie(rs.getInt(1)));
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
	public List<Character> getPlayer(Player player) {
		List<Player> players = new ArrayList<>();
		String sql = "SELECT * FROM film WHERE title like ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + player + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Player newPlayer = new Character();
				players.add(players);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return players;

	}

}

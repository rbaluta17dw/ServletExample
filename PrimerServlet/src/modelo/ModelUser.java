package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import config.Connector;

public class ModelUser extends Connector {

	public ArrayList<User> selectAll() {

		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);
			while (rst.next()) {
				User user = new User();
				user.setId_user(rst.getInt("id_user"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setEmail(rst.getString("email"));
				user.setBirthdate(rst.getDate("birthdate"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User selectUserID(int id_user) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM users WHERE id_user = ?");
			pst.setInt(1, id_user);
			ResultSet rst = pst.executeQuery();

			if (rst.next()) {
				User user = new User();
				user.setId_user(rst.getInt("id_user"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setEmail(rst.getString("email"));
				user.setBirthdate(rst.getDate("birthdate"));

				return user;
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;

	}

	public User selectUserName(String username) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM users WHERE username = ?");
			pst.setString(1, username);
			ResultSet rst = pst.executeQuery();

			if (rst.next()) {
				User user = new User();
				user.setId_user(rst.getInt("id_user"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				user.setEmail(rst.getString("email"));
				user.setBirthdate(rst.getDate("birthdate"));

				return user;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;

	}

	public void deleteUserID(int id_user) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("DELETE FROM users WHERE id_user =?");
			pst.setInt(1, id_user);

			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateUser(User user) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("UPDATE users SET username=?, password=?, email=?, birthdate=? where id_user=?");

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setDate(4, dateToSql(user.getBirthdate()));
			pst.setInt(5, user.getId_user());

			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void insertUser(User user) {
		try {
			PreparedStatement pst = super.conexion
					.prepareStatement("INSERT INTO users (username, password, email, birthdate) values(?,?,?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setDate(4, dateToSql(user.getBirthdate()));

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateImgUser(User user) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE users SET prf_img where id_user=?");

			pst.setInt(2, user.getId_user());

			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public java.sql.Date dateToSql(Date fecha) {
		java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

		return sqlDate;
	}
}

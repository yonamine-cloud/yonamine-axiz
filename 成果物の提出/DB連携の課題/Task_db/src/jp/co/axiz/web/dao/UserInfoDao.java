package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM user_info join role on user_info.role_id = role.role_id";
	private static final String SQL_SELECT_WHERE_LOGIN_ID_AND_PASSWORD = "SELECT * FROM user_info join role on user_info.role_id = role.role_id WHERE login_id like ? AND password like ?";
	private static final String SQL_SELECT_WHERE_NAME_AND_TELL = "SELECT * FROM user_info join role on user_info.role_id = role.role_id WHERE user_name like ? AND telephone like ?";
	private static final String SQL_SELECT_WHERE_TELL = "SELECT * FROM user_info join role on user_info.role_id = role.role_id WHERE telephone like ?";
	private static final String SQL_SELECT_WHERE_NAME = "SELECT * FROM user_info join role on user_info.role_id = role.role_id WHERE user_name like ?";
	private static final String SQL_SELECT_ID = "SELECT * FROM user_info join role on user_info.role_id = role.role_id where role_id = ?";
	private static final String SQL_SELECT_LOGID = "SELECT * FROM user_info join role on user_info.role_id = role.role_id where login_id like ?";
	private static final String SQL_INSERT = "INSERT INTO user_info (login_id, user_name, telephone, password, role_id) VALUES (?,?,?,?,?)";



	private Connection connection;

	public UserInfoDao(Connection connection) {
		this.connection = connection;
	}


	public  UserInfo findByIdPass(String loginId,String password) {

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_LOGIN_ID_AND_PASSWORD)){
			stmt.setString(1, loginId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),  rs.getString("role_name"));
			}

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;

	}

	public List<UserInfo> findAll() {
		List<UserInfo> list = new ArrayList<UserInfo>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				UserInfo u = new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id") ,  rs.getString("role_name"));
				list.add(u);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public  List<UserInfo> findByTelName(String name,String tel) {
		List<UserInfo> list = new ArrayList<UserInfo>();


		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_NAME_AND_TELL)){
			stmt.setString(1, name);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				UserInfo u = new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),   rs.getString("role_name"));
				list.add(u);
			}

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;

	}

	public  List<UserInfo> findByTel(String tel) {
		List<UserInfo> list = new ArrayList<UserInfo>();


		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_TELL)){
			stmt.setString(1, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				UserInfo u = new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),  rs.getString("role_name"));
				list.add(u);
			}

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;

	}

	public  List<UserInfo> findByName(String name) {
		List<UserInfo> list = new ArrayList<UserInfo>();


		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_NAME)){
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				UserInfo u = new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),  rs.getString("role_name"));
				list.add(u);
			}

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;

	}


	public  List<UserInfo> findId(Integer id){
		List list = new ArrayList();

		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				UserInfo u = new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),  rs.getString("role_name"));
				list.add(u);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public  UserInfo findLogId(String id){

		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_LOGID)){
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				return new UserInfo(rs.getInt("user_id"), rs.getString("login_id"), rs.getString("user_name"),rs.getString("telephone"), rs.getString("password"), rs.getInt("role_id"),  rs.getString("role_name"));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public  UserInfo Register(String login_id,String user_name,String telephone,String password,Integer role_id){

		try(PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)){
			stmt.setString(1, login_id);
			stmt.setString(2, user_name);
			stmt.setString(3, telephone);
			stmt.setString(4, password);
			stmt.setInt(5, role_id);
			stmt.executeUpdate();



		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}



}




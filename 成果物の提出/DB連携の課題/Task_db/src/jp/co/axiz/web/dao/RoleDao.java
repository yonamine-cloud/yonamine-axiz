package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM role order by role_id";
	private static final String SQL_SELECT_NAME = "SELECT role_name FROM role where role_id = ?";

	private Connection connection;

	public RoleDao(Connection connection) {
		this.connection = connection;
	}

	public  List<Role> findAll(){
		List<Role> list = new ArrayList<Role>();

		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Role r = new Role(rs.getInt("role_id"), rs.getString("role_name"));
				list.add(r);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public  String findName(Integer id){

		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_NAME)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				String r = rs.getString("role_name");
				System.out.println(r);
				return r;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}






}




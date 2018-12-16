package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOImpl implements LoginDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/stock-management-automation";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;

	@Override
	public boolean login(int username, int password) {
		boolean loginStatus = false;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT employee_id, password FROM employee";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int usernameFromDatabase = resultSet.getInt("employee_id");
				int passwordFromDatabase = resultSet.getInt("password");

				if (username == usernameFromDatabase && password == passwordFromDatabase) {
					loginStatus = true;
					break;
				} else
					loginStatus = false;
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return loginStatus;
	}

}

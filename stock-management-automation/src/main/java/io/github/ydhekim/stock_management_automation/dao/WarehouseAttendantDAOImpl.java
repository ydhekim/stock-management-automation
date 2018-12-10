package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Employee;

public class WarehouseAttendantDAOImpl implements WarehouseAttendantDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/stock-management-automation";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;

	@Override
	public void insertWarehouseAttendant(int warehouseAttendantId, int password, String firstName, String lastName,
			int departmentId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "INSERT INTO employee VALUES(" + warehouseAttendantId + "," + departmentId + "," + password
					+ ",'" + firstName + "','" + lastName + "')";
			statement.execute(sql);
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
	}

	@Override
	public void deleteWarehouseAttendant(int warehouseAttendantId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "DELETE FROM employee WHERE employee_id = " + warehouseAttendantId;
			statement.execute(sql);
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
	}

	// TODO: sql kontrol et!
	@Override
	public void updateWarehouseAttendant(int warehouseAttendantId, int password, String firstName, String lastName,
			int departmentId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "UPDATE employee SET department_id = " + departmentId + ", password = " + password
					+ ", first_name = '" + firstName + "', last_name = '" + lastName + "' WHERE employee_id = "
					+ warehouseAttendantId;
			statement.execute(sql);
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

	}

	// TODO: gozden gecir
	@Override
	public Employee getWarehouseAttendant(int warehouseAttendantId) {
		Employee employee = new Employee();
		Department department = new Department();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM employee WHERE employee_id = " + warehouseAttendantId;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int employeeIdFromDatabase = resultSet.getInt("employee_id");
				int departmentIdFromDatabase = resultSet.getInt("department_id");
				int passwordFromDatabase = resultSet.getInt("password");
				String employeeFirstNameFromDatabase = resultSet.getString("first_name");
				String employeeLastNameFromDatabase = resultSet.getString("last_name");
				employee.setId(employeeIdFromDatabase);
				department.setId(departmentIdFromDatabase);
				employee.setDepartment(department);
				employee.setPassword(passwordFromDatabase);
				employee.setFirstName(employeeFirstNameFromDatabase);
				employee.setLastName(employeeLastNameFromDatabase);
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
		return employee;
	}

	// TODO: tekrar bak
	@Override
	public ArrayList<Employee> getAllWarehouseAttendants() {
		Employee employee = new Employee();
		Department department = new Department();
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM employee";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int employeeIdFromDatabase = resultSet.getInt("employee_id");
				int departmentIdFromDatabase = resultSet.getInt("department_id");
				int passwordFromDatabase = resultSet.getInt("password");
				String employeeFirstNameFromDatabase = resultSet.getString("first_name");
				String employeeLastNameFromDatabase = resultSet.getString("last_name");
				employee.setId(employeeIdFromDatabase);
				department.setId(departmentIdFromDatabase);
				employee.setDepartment(department);
				employee.setPassword(passwordFromDatabase);
				employee.setFirstName(employeeFirstNameFromDatabase);
				employee.setLastName(employeeLastNameFromDatabase);

				list.add(employee);
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
		return list;
	}

}

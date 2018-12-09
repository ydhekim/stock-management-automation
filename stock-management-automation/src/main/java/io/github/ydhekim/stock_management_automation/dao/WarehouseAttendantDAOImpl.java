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
	public static final String DB_URL = "jdbc:h2:~/test";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;
	
	@Override
	public void deleteWarehouseAttendant(int warehouseAttendantId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + warehouseAttendantId;
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
	public Employee getWarehouseAttendant(int warehouseAttendantId) {
		Employee employee = new Employee();
		Department department = new Department();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = " + warehouseAttendantId;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int employeeIdFromDatabase = resultSet.getInt("EMPLOYEE_ID");
				Department departmentIdFromDatabase = resultSet.getInt("DEPARTMENT_ID");
				int passwordFromDatabase = resultSet.getInt("PASSWORD");
				String employeeFirstNameFromDatabase = resultSet.getString("FIRST_NAME");
				String employeeLastNameFromDatabase = resultSet.getString("LAST_NAME");
				employee.setId(employeeIdFromDatabase);
				employee.setDepartment(departmentIdFromDatabase);
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

	@Override
	public void insertWarehouseAttendant(int warehouseAttendantId, int password, String firstName, String lastName,
			int departmentId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "INSERT INTO EMPLOYEE VALUES(" + warehouseAttendantId + ",'" + password + ",'" + firstName + ",'" + lastName + ",'" + password + ",'" + departmentId + "')";
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
	public void updateWarehouseAttendant(int warehouseAttendantId, int password, String firstName, String lastName,
			int departmentId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "UPDATE EMPLOYEE SET DEPARTMENT_ID = '" + departmentId + "', PASSWORD = '" + password + "', FIRST_NAME = '" + firstName + "', LAST_NAME = '" + lastName + "' WHERE EMPLOYEE_ID = "
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

	@Override
	public ArrayList<Employee> getAllWarehouseAttendants() {
		Employee employee = new Employee();
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM department";
			ResultSet resultSet = statement.executeQuery(sql);
			
			
	        while(resultSet.next())
	        {
	        	
	        	employee.setId(resultSet.getInt("EMPLOYEE_ID"));
	        	employee.setDepartment(resultSet.getInt("DEPARTMENT_ID"));
	        	employee.setPassword(resultSet.getInt("PASSWORD"));
	        	employee.setFirstName(resultSet.getString("FIRST_NAME"));
	        	employee.setLastName(resultSet.getString("LAST_NAME"));
	             
	            list.add(employee);
	        }
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

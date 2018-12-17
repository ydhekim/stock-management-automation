package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.github.ydhekim.stock_management_automation.model.Employee;
import io.github.ydhekim.stock_management_automation.model.Order;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class OrderDAOImpl implements OrderDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/stock-management-automation";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;

	@Override
	public Order getOrder(int orderId) {
		Order order = new Order();
		Supplier supplier = new Supplier();
		Employee employee = new Employee();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM orders WHERE order_id = " + orderId;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int orderIdFromDatabase = resultSet.getInt("ORDER_ID");
				int orderAmountFromDatabase = resultSet.getInt("ORDER_AMOUNT");
				boolean confirmedFromDatabase = resultSet.getBoolean("ORDER_STATUS");

				Date orderDateFromDatabase = resultSet.getDate("ORDER_DATE");
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(orderDateFromDatabase);

				int supplierIdFromDatabase = resultSet.getInt("SUPPLIER_ID");
				int employeeIdFromDatabase = resultSet.getInt("EMPLOYEE_ID");

				order.setId(orderIdFromDatabase);
				order.setAmount(orderAmountFromDatabase);
				order.setConfirmed(confirmedFromDatabase);
				order.setOrderDate(calendar);
				supplier.setId(supplierIdFromDatabase);
				order.setSupplier(supplier);
				employee.setId(employeeIdFromDatabase);
				order.setEmployee(employee);
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
		return order;
	}

	@Override
	public void confirmOrder(int orderId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "UPDATE orders SET order_status = true WHERE order_id = " + orderId;
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
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM orders";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Order order = new Order();
				Supplier supplier = new Supplier();
				Employee employee = new Employee();

				int orderIdFromDatabase = resultSet.getInt("order_id");
				int amountFromDatabase = resultSet.getInt("order_amount");
				boolean confirmedFromDatabase = resultSet.getBoolean("order_status");

//				Date orderDateFromDatabase = resultSet.getDate("order_date");
//				Calendar calendar = new GregorianCalendar();
//				calendar.setTime(orderDateFromDatabase);

				int supplierIdFromDatabase = resultSet.getInt("supplier_id");
				int employeeIdFromDatabase = resultSet.getInt("employee_id");

				order.setId(orderIdFromDatabase);
				order.setAmount(amountFromDatabase);
				order.setConfirmed(confirmedFromDatabase);
				supplier.setId(supplierIdFromDatabase);
				order.setSupplier(supplier);
				employee.setId(employeeIdFromDatabase);
				order.setEmployee(employee);

				orders.add(order);
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
		return orders;

	}

	@Override
	public ArrayList<Order> showOrderStatus(int employeeId) {
		ArrayList<Order> orders = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM orders WHERE employee_id = " + employeeId;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Order order = new Order();
				Supplier supplier = new Supplier();
				Employee employee = new Employee();
				
				int orderIdFromDatabase = resultSet.getInt("ORDER_ID");
				int orderAmountFromDatabase = resultSet.getInt("ORDER_AMOUNT");
				boolean confirmedFromDatabase = resultSet.getBoolean("ORDER_STATUS");

//				Date orderDateFromDatabase = resultSet.getDate("ORDER_DATE");
//				Calendar calendar = new GregorianCalendar();
//				calendar.setTime(orderDateFromDatabase);

				int supplierIdFromDatabase = resultSet.getInt("SUPPLIER_ID");
				int employeeIdFromDatabase = resultSet.getInt("EMPLOYEE_ID");

				order.setId(orderIdFromDatabase);
				order.setAmount(orderAmountFromDatabase);
				order.setConfirmed(confirmedFromDatabase);
//				order.setOrderDate(calendar);
				supplier.setId(supplierIdFromDatabase);
				order.setSupplier(supplier);
				employee.setId(employeeIdFromDatabase);
				order.setEmployee(employee);
				
				orders.add(order);
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
		return orders;
	}

	@Override
	public void placeOrder(int orderId, int supplierId, int employeeId, int orderAmount, boolean orderStatus) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "INSERT INTO ORDERS VALUES(" + orderId + "," + supplierId + "," + employeeId + ","
					+ orderAmount + "," + orderStatus + ")";
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

}
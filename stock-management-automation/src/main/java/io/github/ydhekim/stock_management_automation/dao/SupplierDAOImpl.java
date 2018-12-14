package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import io.github.ydhekim.stock_management_automation.model.Product;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/stock-management-automation";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;

	public void insertSupplier(int supplierId, String supplierName, int productId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "INSERT INTO SUPPLIER VALUES(" + supplierId + "," + productId + ",'" + supplierName + "')";
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

	public void deleteSupplier(int supplierId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "DELETE FROM supplier WHERE supplier_id = " + supplierId;
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

	public void updateSupplier(int supplierId, String supplierName, int productId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "UPDATE supplier SET product_id = " + productId + ", supplier_name = '" + supplierName
					+ "' WHERE supplier_id = " + supplierId;
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

	public Supplier getSupplier(int supplierId) {
		Supplier supplier = new Supplier();
		Product product = new Product();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM supplier WHERE supplier_id = " + supplierId;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int supplierIdFromDatabase = resultSet.getInt("supplier_id");
				int productIdFromDatabase = resultSet.getInt("product_id");
				String supplierNameFromDatabase = resultSet.getString("SUPPLIER_NAME");
				product.setId(productIdFromDatabase);
				supplier.setId(supplierIdFromDatabase);
				supplier.setProduct(product);
				supplier.setName(supplierNameFromDatabase);
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
		return supplier;
	}

	@Override
	public ArrayList<Supplier> getAllSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM supplier";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Supplier supplier = new Supplier();
				Product product = new Product();
				int supplierIdFromDatabase = resultSet.getInt("supplier_id");
				int productIdFromDatabase = resultSet.getInt("product_id");
				String supplierNameFromDatabase = resultSet.getString("supplier_name");
				supplier.setId(supplierIdFromDatabase);
				product.setId(productIdFromDatabase);
				supplier.setProduct(product);
				supplier.setName(supplierNameFromDatabase);

				suppliers.add(supplier);
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
		return suppliers;
	}

}

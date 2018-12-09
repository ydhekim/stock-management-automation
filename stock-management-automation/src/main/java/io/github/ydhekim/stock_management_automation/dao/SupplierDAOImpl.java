package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Employee;
import io.github.ydhekim.stock_management_automation.model.Product;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/test";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;

	@Override
	public void deleteSuppliert(int supplierId) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "DELETE FROM SUPPLIER WHERE SUPPLIER_ID = " + supplierId;
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
	public Supplier getSupplier(int supplierId) {
		Supplier supplier = new Supplier();
		Product product = new Product();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM SUPPLIER WHERE SUPPLIER_ID = " + supplierId;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int supplierIdFromDatabase = resultSet.getInt("SUPPLIER_ID");
				Product productIdFromDatabase = resultSet.getInt("PRODUCT_ID");
				String supplierNameFromDatabase = resultSet.getString("SUPPLIER_NAME");
				supplier.setId(supplierIdFromDatabase);
				supplier.setProduct(productIdFromDatabase);
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
	public void insertSupplier(int supplierId, int productId, String supplierName) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "INSERT INTO SUPPLIER VALUES(" + supplierId + ",'" + productId + ",'" + supplierName + "')";
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
	public void updateSupplier(int supplierId, int productId, String supplierName) {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "UPDATE SUPPLIER SET PRODUCT_ID = '" + productId + "', SUPPLIER_NAME = '" + supplierName + "' WHERE SUPPLIER_ID = "
					+ supplierId;
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
	public ArrayList<Supplier> getAllSupliers() {
		Supplier supplier = new Supplier();
		ArrayList<Supplier> list = new ArrayList<Supplier>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM SUPPLIER";
			ResultSet resultSet = statement.executeQuery(sql);
			
			
	        while(resultSet.next())
	        {
	        	
	        	supplier.setId(resultSet.getInt("SUPPLIER_ID"));
	        	supplier.setProduct(resultSet.getInt("DEPARTMENT_ID"));
	        	supplier.setName(resultSet.getString("SUPPLIER_NAME"));
	             
	            list.add(supplier);
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

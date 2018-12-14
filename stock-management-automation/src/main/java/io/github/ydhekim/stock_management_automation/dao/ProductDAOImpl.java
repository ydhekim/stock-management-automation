package io.github.ydhekim.stock_management_automation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import io.github.ydhekim.stock_management_automation.model.Product;

public class ProductDAOImpl implements ProductDAO {

	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:~/stock-management-automation";
	public static final String USER = "sa";
	public static final String PASS = "";

	Connection connection = null;
	Statement statement = null;
	
	@Override
	public Product getProduct(int productId) {
		Product product = new Product();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = " + productId;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int productIdFromDatabase = resultSet.getInt("PRODUCT_ID");
				int productAmountFromDatabase = resultSet.getInt("PRODUCT_AMOUNT");
				String productNameFromDatabase = resultSet.getString("PRODUCT_NAME");
				String productTypeFromDatabase = resultSet.getString("PRODUCT_TYPE");
				
				product.setId(productIdFromDatabase);
				product.setAmount(productAmountFromDatabase);
				product.setName(productNameFromDatabase);
				product.setType(productTypeFromDatabase);
				
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
		return product;
	}
	

}

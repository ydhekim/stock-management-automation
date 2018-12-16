package io.github.ydhekim.stock_management_automation.dao;

import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Product;

public interface ProductDAO {

	public void deleteProduct(int productId);
	
	public void insertProduct(int productId, int productAmount, String productName, String productType);
	
	public void updateProduct(int productId, int productAmount, String productName, String productType);
	
	public Product getProduct(int productId);
	
	public ArrayList<Product> getAllProducts();

}
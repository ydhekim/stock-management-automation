package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Product;

public class TestProductDAO {

	@Test
	public void testGetProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		Product product = productDAO.getProduct(1);
		assertEquals(productDAO.getProduct(1).getName(), product.getName());
	}

	@Test
	public void testInsertProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		productDAO.insertProduct(11, 11, "pro11", "typ11");
		assertNotNull(productDAO.getProduct(11).getName());
	}
	
	@Test
	public void testDeleteProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		productDAO.deleteProduct(11);
		assertNull(productDAO.getProduct(11).getName());
	}
	
	@Test
	public void testUpdateProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		String productName = productDAO.getProduct(3).getName();
		productDAO.updateProduct(3, 1100, "pro3", "typ3");
		String newProductName = productDAO.getProduct(3).getName();
		assertNotEquals(productName, newProductName);
	}
	
	@Test
	public void testGetAllProducts() {
		ProductDAO productDAO = new ProductDAOImpl();
		assertNotNull(productDAO.getAllProducts());
	}

}
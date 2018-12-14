package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Order;
import io.github.ydhekim.stock_management_automation.model.Product;

public class TestProductDAO {

	@Test
	public void testGetProduct() {
		ProductDAO productDAO = new ProductDAOImpl();
		Product product = productDAO.getProduct(1);
		assertEquals(productDAO.getProduct(1).getName(), product.getName());
	}
	
	@Test
	public void testAddProduct() {
		fail("Yapılacak");
	}

}

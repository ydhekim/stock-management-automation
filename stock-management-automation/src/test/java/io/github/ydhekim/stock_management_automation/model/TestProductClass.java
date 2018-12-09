/** 
 * @author Yasin Dogukan Hekim
 * @see ydhekim.github.io
 * */
package io.github.ydhekim.stock_management_automation.model;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Product;

public class TestProductClass {

	@Test
	public void testConstructorEmpty() {
		Product product = new Product();
		assertNotNull(product);
	}

	@Test
	public void testConstructor() {
		Product product = new Product(5, 5, "testName", "testType");
		assertNotNull(product);
	}

	@Test
	public void testGetId() {
		Product product = new Product();
		assertEquals(product.getId(), product.id);
	}

	@Test
	public void testSetId() {
		Product product = new Product();
		product.setId(5);
		assertEquals(product.getId(), 5);
	}

	@Test
	public void testGetAmount() {
		Product product = new Product();
		assertEquals(product.getAmount(), product.amount);
	}

	@Test
	public void testSetAmount() {
		Product product = new Product();
		product.setAmount(5);
		assertEquals(product.getAmount(), 5);
	}

	@Test
	public void testGetName() {
		Product product = new Product();
		assertEquals(product.getName(), product.name);
	}

	@Test
	public void testSetName() {
		Product product = new Product();
		product.setName("testName");
		assertEquals(product.getName(), product.name);
	}

	@Test
	public void testGetType() {
		Product product = new Product();
		assertEquals(product.getType(), product.type);
	}

	@Test
	public void testSetType() {
		Product product = new Product();
		product.setType("testType");
		assertEquals(product.getType(), product.type);
	}

}

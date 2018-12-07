/**
 * @author ydhekim
 *  */
package io.github.ydhekim.stock_management_automation.model;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Product;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class TestSuppilerClass {

	@Test
	public void testConstructorEmpty() {
		Supplier supplier = new Supplier();
		assertNotNull(supplier);
	}

	@Test
	public void testConstructor() {
		Product product = new Product();
		Supplier supplier = new Supplier(5, "testName", product);
		assertNotNull(supplier);
	}

	@Test
	public void testGetId() {
		Supplier supplier = new Supplier();
		assertEquals(supplier.getId(), supplier.id);
	}

	@Test
	public void testSetId() {
		Supplier supplier = new Supplier();
		supplier.setId(5);
		assertEquals(supplier.getId(), 5);
	}

	@Test
	public void testGetName() {
		Supplier supplier = new Supplier();
		assertEquals(supplier.getName(), supplier.name);
	}

	@Test
	public void testSetName() {
		Supplier supplier = new Supplier();
		supplier.setName("Can");
		assertEquals(supplier.getName(), "Can");
	}

	@Test
	public void testGetProduct() {
		Supplier supplier = new Supplier();
		assertEquals(supplier.getProduct(), supplier.product);
	}

	@Test
	public void testSetProductById() {
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setId(5);
		supplier.setProduct(product);
		assertEquals(supplier.getProduct().getId(), product.getId());
	}

	@Test
	public void testSetProductByAmount() {
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setAmount(5);
		supplier.setProduct(product);
		assertEquals(supplier.getProduct().getAmount(), product.getAmount());
	}

	@Test
	public void testSetProductByName() {
		Supplier supplier = new Supplier();
		Product product = new Product();

		product.setName("testName");
		supplier.setProduct(product);
		assertEquals(supplier.getProduct().getName(), product.getName());
	}

	@Test
	public void testSetProductByType() {
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setType("testType");
		supplier.setProduct(product);
		assertEquals(supplier.getProduct().getType(), product.getType());
	}

}

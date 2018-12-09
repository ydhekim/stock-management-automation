/** 
 * @author Yasin Dogukan Hekim
 * @see ydhekim.github.io
 * */
package io.github.ydhekim.stock_management_automation.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestOrderClass {

	@Test
	public void testConstructorEmpty() {
		Order order = new Order();
		assertNotNull(order);
	}

	@Test
	public void testConstructor() {
		Supplier supplier = new Supplier();
		Employee employee = new Employee();
		Date date = new Date();
		Order order = new Order(1, 2, true, date, supplier, employee);
		assertNotNull(order);
	}

	@Test
	public void testGetId() {
		Order order = new Order();
		assertEquals(order.getId(), order.id);
	}

	@Test
	public void testSetId() {
		Order order = new Order();
		order.setId(5);
		assertEquals(order.getId(), order.id);
	}

	@Test
	public void testGetAmount() {
		Order order = new Order();
		assertEquals(order.getAmount(), order.amount);
	}

	@Test
	public void testSetAmount() {
		Order order = new Order();
		order.setAmount(5);
		assertEquals(order.getAmount(), order.amount);
	}

	@Test
	public void testIsConfirmed() {
		Order order = new Order();
		assertFalse(order.isConfirmed());
	}

	@Test
	public void testSetConfirmed() {
		Order order = new Order();
		order.setConfirmed(true);
		assertTrue(order.isConfirmed());
	}

	// TODO: Get/Set for orderDate!
//	@Test
//	public void testGetOrderDate() {
//		Order order = new Order();
//		order.getOrderDate().getYear();
//	}

	@Test
	public void testGetSupplier() {
		Order order = new Order();
		assertEquals(order.getSupplier(), order.supplier);
	}

	@Test
	public void testSetSupplierById() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		supplier.setId(1);
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getId(), supplier.getId());
	}

	@Test
	public void testSetSupplierByName() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		supplier.setName("testName");
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getName(), supplier.getName());
	}

	@Test
	public void testSetSupplierByProductId() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setId(1);
		supplier.setProduct(product);
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getProduct().getId(), product.getId());
	}

	@Test
	public void testSetSupplierByProductAmount() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setAmount(100);
		supplier.setProduct(product);
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getProduct().getAmount(), product.getAmount());
	}

	@Test
	public void testSetSupplierByProductName() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setName("testName");
		supplier.setProduct(product);
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getProduct().getName(), product.getName());
	}

	@Test
	public void testSetSupplierByProductType() {
		Order order = new Order();
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setType("testType");
		supplier.setProduct(product);
		order.setSupplier(supplier);
		assertEquals(order.getSupplier().getProduct().getType(), product.getType());
	}

	@Test
	public void testGetEmployee() {
		Order order = new Order();
		assertEquals(order.getEmployee(), order.employee);
	}

	@Test
	public void testSetEmployeeById() {
		Order order = new Order();
		Employee employee = new Employee();
		employee.setId(1);
		order.setEmployee(employee);
	}

	@Test
	public void testSetEmployeeByDepartmentId() {
		Order order = new Order();
		Employee employee = new Employee();
		Department department = new Department();
		department.setId(1);
		employee.setDepartment(department);
		order.setEmployee(employee);
		assertEquals(order.getEmployee().getDepartment().getId(), department.getId());
	}

}

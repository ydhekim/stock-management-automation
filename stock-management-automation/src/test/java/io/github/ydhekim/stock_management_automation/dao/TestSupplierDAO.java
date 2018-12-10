package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Supplier;

public class TestSupplierDAO {

	@Test
	public void testDeleteSupplier() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		supplierDAO.deleteSupplier(11);
		assertNull(supplierDAO.getSupplier(11).getName());
	}
	
	@Test
	public void testGetSupplier() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		Supplier supplier = supplierDAO.getSupplier(1);
		assertEquals(supplierDAO.getSupplier(1).getName(), supplier.getName());
	}
	
	@Test
	public void testInsertSupplier() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		supplierDAO.insertSupplier(11, "sup11", 11);
		assertNotNull(supplierDAO.getSupplier(11).getName());
	}
	
	@Test
	public void testUpdateDepartment() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		String supplierName = supplierDAO.getSupplier(3).getName();
		supplierDAO.updateSupplier(3, "usup3", 3);
		String newSupplierName = supplierDAO.getSupplier(3).getName();
		assertNotEquals(supplierName, newSupplierName);
	}
	
	@Test
	public void testGetAllSuppliers() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		assertNotNull(supplierDAO.getAllSuppliers());
	}

}

package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Employee;
import io.github.ydhekim.stock_management_automation.model.Product;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class TestSupplierDAO {
	
	//TODO: Test uzerinden SupplierDAO interfacesini ve SupplierDAOImpl classini olustur!.

	@Test
	public void testDeleteSupplier() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		supplierDAO.deleteSuppliert(1);
		assertNull(supplierDAO.getSupplier(1));
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
		Product product = new Product();
		supplierDAO.insertSupplier(6, product.getId(), "name6");
		assertNotNull(supplierDAO.getSupplier(6).getName());
	}

	@Test
	public void testUpdateSupplier() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		String supplierName = supplierDAO.getSupplier(3).getName();
		Product product = new Product();
		supplierDAO.updateSupplier(6, product.getId(), "name6");
		String newSupplierName = supplierDAO.getSupplier(3).getName();
		assertNotEquals(supplierName, newSupplierName);
	}

	@Test
	public void testGetAllSuppliers() {
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		assertNotNull(supplierDAO.getAllSupliers());
	}

}

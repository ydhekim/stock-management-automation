package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Employee;

public class TestWarehouseAttendantDAO {

	@Test
	public void testDeleteSupplier() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		warehouseAttendantDAO.deleteWarehouseAttendant(11);
		assertNull(warehouseAttendantDAO.getWarehouseAttendant(11).getFirstName());
	}

	@Test
	public void testGetSupplier() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		Employee employee = warehouseAttendantDAO.getWarehouseAttendant(1);
		assertEquals(warehouseAttendantDAO.getWarehouseAttendant(1).getFirstName(), employee.getFirstName());
	}

	@Test
	public void testInsertSupplier() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		warehouseAttendantDAO.insertWarehouseAttendant(11, 11, "fname11", "lname11", 11);
		assertNotNull(warehouseAttendantDAO.getWarehouseAttendant(11).getFirstName());
	}

	@Test
	public void testUpdateDepartment() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		String firstName = warehouseAttendantDAO.getWarehouseAttendant(3).getFirstName();
		warehouseAttendantDAO.updateWarehouseAttendant(3, 3, "ufname2", "ulname2", 3);
		String newFirstName = warehouseAttendantDAO.getWarehouseAttendant(3).getFirstName();
		assertNotEquals(firstName, newFirstName);
	}

	@Test
	public void testGetAllSuppliers() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		assertNotNull(warehouseAttendantDAO.getAllWarehouseAttendants());
	}

}

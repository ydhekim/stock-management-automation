package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Employee;

public class TestWarehouseAttendantDAO {

	@Test
	public void testDeleteWarehouseAttendant() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		warehouseAttendantDAO.deleteWarehouseAttendant(1);
		assertNull(warehouseAttendantDAO.getWarehouseAttendant(1).getFirstName());
	}
	
	@Test
	public void testGetWarehouseAttendant() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		Employee emp = warehouseAttendantDAO.getWarehouseAttendant(1);
		assertEquals(warehouseAttendantDAO.getWarehouseAttendant(1).getFirstName(), emp.getFirstName());
	}

	@Test
	public void testInsertWarehouseAttendant() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		Department department = new Department();
		warehouseAttendantDAO.insertWarehouseAttendant(6, 1, "firstName6", "lastName6", department.getId());
		assertNotNull(warehouseAttendantDAO.getWarehouseAttendant(6).getFirstName());
	}

	@Test
	public void testUpdateWarehouseAttendant() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		String departmentName = warehouseAttendantDAO.getWarehouseAttendant(3).getFirstName();
		Department department = new Department();
		warehouseAttendantDAO.updateWarehouseAttendant(6, 1, "firstName6", "lastName6", department.getId());
		String newDepartmentName = warehouseAttendantDAO.getWarehouseAttendant(3).getFirstName();
		assertNotEquals(departmentName, newDepartmentName);
	}

	@Test
	public void testGetAllWarehouseAttendants() {
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		assertNotNull(warehouseAttendantDAO.getAllWarehouseAttendants());
	}
}

/** 
 * @author Yasin Dogukan Hekim
 * @see ydhekim.github.io
 * */
package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.dao.DepartmentDAO;
import io.github.ydhekim.stock_management_automation.dao.DepartmentDAOImpl;
import io.github.ydhekim.stock_management_automation.model.Department;

public class TestDepartmentDAO {

	@Test
	public void testDeleteDepartment() {
		DepartmentDAO departmentDao = new DepartmentDAOImpl();
		departmentDao.deleteDepartment(11);
		assertNull(departmentDao.getDepartment(11).getName());
	}

	@Test
	public void testGetDepartment() {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		Department department = departmentDAO.getDepartment(1);
		assertEquals(departmentDAO.getDepartment(1).getName(), department.getName());
	}

	@Test
	public void testInsertDepartment() {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		departmentDAO.insertDepartment(11, "dep11");
		assertNotNull(departmentDAO.getDepartment(11).getName());
	}

	@Test
	public void testUpdateDepartment() {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		String departmentName = departmentDAO.getDepartment(3).getName();
		departmentDAO.updateDepartment(3, "dep3");
		String newDepartmentName = departmentDAO.getDepartment(3).getName();
		assertNotEquals(departmentName, newDepartmentName);
	}

	@Test
	public void testGetAllDepartments() {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		assertNotNull(departmentDAO.getAllDepartments());
	}

}

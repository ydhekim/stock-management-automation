/**
 * @author ydhekim
 *  */
package io.github.ydhekim.stock_management_automation.model;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Employee;

public class TestEmployeeClass {

	@Test
	public void testConstructorEmpty() {
		Employee employee = new Employee();
		assertNotNull(employee);
	}
	
	@Test
	public void testConstructor() {
		Department department = new Department();
		Employee employee = new Employee(5, 4, "testFirstName", "testLastName", department);
		assertNotNull(employee);
	}
	
	@Test
	public void testGetId() {
		Employee employee = new Employee();
		assertEquals(employee.getId(), employee.id);
	}
	
	@Test
	public void testSetId() {
		Employee employee = new Employee();
		employee.setId(25);
		assertEquals(employee.getId(), 25);
	}
	
	@Test
	public void testGetPassword() {
		Employee employee = new Employee();
		assertEquals(employee.getPassword(), employee.password);
	}
	
	@Test
	public void testSetPassword() {
		Employee employee = new Employee();
		employee.setPassword(14);
		assertEquals(employee.getPassword(), 14);
	}
	
	@Test
	public void testGetFirstName() {
		Employee employee = new Employee();
		assertEquals(employee.getFirstName(), employee.firstName);
	}
	
	@Test
	public void testSetFirstName() {
		Employee employee = new Employee();
		employee.setFirstName("testFirstName");
		assertTrue(employee.getFirstName() == "testFirstName");
	}
	
	@Test
	public void testGetLastName() {
		Employee employee = new Employee();
		assertEquals(employee.getLastName(), employee.lastName);
	}
	
	@Test
	public void testSetLastName() {
		Employee employee = new Employee();
		employee.setLastName("testLastName");
		assertTrue(employee.getLastName() == "testLastName");
	}
	
	@Test
	public void testGetDepartment() {
		Employee employee = new Employee();
		assertEquals(employee.getDepartment(), employee.department);
	}
	
	@Test
	public void testSetDepartmentById() {
		Employee employee = new Employee();
		Department department = new Department();
		department.setId(5);
		employee.setDepartment(department);
		assertEquals(employee.getDepartment().getId(), department.getId());
	}
	
	@Test
	public void testSetDepartmentByName() {
		Employee employee = new Employee();
		Department department = new Department();
		department.setName("testName");
		employee.setDepartment(department);
		assertEquals(employee.getDepartment().getName(), department.getName());
	}

	

}

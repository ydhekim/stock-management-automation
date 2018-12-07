/** 
 * @author ydhekim
 * */
package io.github.ydhekim.stock_management_automation.model;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;

public class TestDepartmentClass {

	@Test
	public void testConstructorEmpty() {
		Department department = new Department();
		assertNotNull(department);
	}
	
	@Test
	public void testConstructor() {
		Department department = new Department(5, "testName");
		assertNotNull(department);
	}
	
	@Test
	public void testGetId() {
		Department department = new Department();
		assertEquals(department.getId(), department.id);
	}

	@Test
	public void testSetId() {
		Department department = new Department();
		department.setId(97);
		assertEquals(department.getId(), 97);
	}

	@Test
	public void testGetName() {
		Department department = new Department();
		assertEquals(department.getName(), department.name);
	}

	@Test
	public void testSetName() {
		Department department = new Department();
		department.setName("testName");
		assertEquals(department.getName(), "testName");
	}
}

package io.github.ydhekim.stock_management_automation.controller;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;

public class TestDepartmentController {

	@Test
	public void test() throws SQLException {
		DepartmentController dpcontroller = new DepartmentController();
		ArrayList<Department> list = new ArrayList<Department>();
		list = dpcontroller.showDepartmentList();
		assertFalse(list.isEmpty());
	}
}

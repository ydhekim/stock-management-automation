package io.github.ydhekim.stock_management_automation.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Employee;

public class TestWarehouseAttendantController {

	@Test
	public void test() {
		WarehouseAttendantController wcontroller = new WarehouseAttendantController();
		ArrayList<Employee> list = new ArrayList<Employee>();
		list = wcontroller.showWarehouseAttendantList();
		assertFalse(list.isEmpty());
	}

}

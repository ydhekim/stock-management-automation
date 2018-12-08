package io.github.ydhekim.stock_management_automation.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.controller.DepartmentController;
import io.github.ydhekim.stock_management_automation.controller.SupplierController;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class TestSupplierController {

	@Test
	public void test() {
		SupplierController scontroller = new SupplierController();
		ArrayList<Supplier> list = new ArrayList<Supplier>();
		list = scontroller.showSupplierList();
		assertFalse(list.isEmpty());
	}

}

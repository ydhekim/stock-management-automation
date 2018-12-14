package io.github.ydhekim.stock_management_automation.dao;


import io.github.ydhekim.stock_management_automation.model.Employee;
import io.github.ydhekim.stock_management_automation.model.Supplier;

public class Test {

	public static void main(String[] args) {

		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		
		for (Employee employee : warehouseAttendantDAO.getAllWarehouseAttendants()) {
			System.out.println(employee.getFirstName());
		}
		
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		
		for (Supplier supplier : supplierDAO.getAllSuppliers()) {
			System.out.println(supplier);
		}
		

	}

}

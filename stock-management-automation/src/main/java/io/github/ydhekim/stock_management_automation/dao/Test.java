package io.github.ydhekim.stock_management_automation.dao;


public class Test {

	public static void main(String[] args) {

		DepartmentDAO dao = new DepartmentDAOImpl();

		System.out.println(dao.getDepartment(1).getName());

		System.out.println(dao.getAllDepartments());

		SupplierDAO dao2 = new SupplierDAOImpl();

		System.out.println(dao2.getSupplier(1).getName());

	}

}

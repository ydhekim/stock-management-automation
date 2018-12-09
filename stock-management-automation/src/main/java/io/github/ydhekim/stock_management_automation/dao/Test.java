package io.github.ydhekim.stock_management_automation.dao;

public class Test {

	public static void main(String[] args) {
		
		DepartmentDAO dao = new DepartmentDAOImpl();
		
		dao.insertDepartment(1, "dep1");
		System.out.println(dao.getDepartment(1).getName());
		dao.updateDepartment(1, "udep1");
		
		
		System.out.println(dao.getDepartment(1).getName());
		
		System.out.println(dao.getAllDepartments());
	}

}

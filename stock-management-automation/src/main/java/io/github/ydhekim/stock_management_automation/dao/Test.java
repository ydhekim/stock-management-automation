package io.github.ydhekim.stock_management_automation.dao;


public class Test {

	public static void main(String[] args) {

		DepartmentDAO dao = new DepartmentDAOImpl();
		
		
		System.out.println(dao.getDepartment(2).getName());
		
		dao.updateDepartment(2, "dep2_degıstı");
		
		System.out.println(dao.getDepartment(2).getName());
		
		dao.deleteDepartment(2);
		
		System.out.println(dao.getDepartment(2).getName());
		
		System.out.println(dao.getAllDepartments());
	

	}

}

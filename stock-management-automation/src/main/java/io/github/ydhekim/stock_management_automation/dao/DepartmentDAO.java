
package io.github.ydhekim.stock_management_automation.dao;

import java.util.HashMap;

import io.github.ydhekim.stock_management_automation.model.Department;

public interface DepartmentDAO {

	public void insertDepartment(int departmentId, String departmentName);
	
	public void deleteDepartment(int departmentId);
	
	public void updateDepartment(int departmentId, String departmentName);
	
	public Department getDepartment(int departmentId);
	
	public HashMap<Integer, String> getAllDepartments(); 
}

package io.github.ydhekim.stock_management_automation.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Employee;

public class WarehouseAttendantController {

	public ArrayList<Employee> showWarehouseAttendantList() {
		// TODO Auto-generated method stub
				ConnectionController cC = new ConnectionController();
				cC.Connect();
				Connection conn = cC.conn;
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEE");
				ArrayList<Employee> list = new ArrayList<Employee>();
		        while(rs.next())
		        {
		        	Employee e = new Employee();
		            e.setId(rs.getInt("EMPLOYEE_ID"));
		            e.setDepartment(rs.getString("DEPARTMENT_ID"));		            
		            e.setPassword(rs.getInt("PASSWORD"));
		            e.setFirstName(rs.getString("FIRST_NAME"));
		            e.setLastName(rs.getString("LAST_NAME"));	
		             
		            list.add(e);
		        }
				return list;
	}

}

package io.github.ydhekim.stock_management_automation.controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Department;

public class DepartmentController {

	public ArrayList<Department> showDepartmentList() throws SQLException {
		// TODO Auto-generated method stub
		ConnectionController cC = new ConnectionController();
		cC.Connect();
		Connection conn = cC.conn;
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM DEPARTMENT");
		ArrayList<Department> list = new ArrayList<>();
        while(rs.next())
        {
        	Department d = new Department();
            d.setId(rs.getInt("DEPARTMENT_ID"));
            d.setName(rs.getString("DEPARTMENT_NAME"));
             
            list.add(d);
        }
		return list;
	}

}

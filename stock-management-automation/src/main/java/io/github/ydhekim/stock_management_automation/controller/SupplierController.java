package io.github.ydhekim.stock_management_automation.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.ydhekim.stock_management_automation.model.Supplier;

public class SupplierController {

	public ArrayList<Supplier> showSupplierList() {
		// TODO Auto-generated method stub
				ConnectionController cC = new ConnectionController();
				cC.Connect();
				Connection conn = cC.conn;
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM SUPPLIER");
				ArrayList<Supplier> list = new ArrayList<Supplier>();
		        while(rs.next())
		        {
		        	Supplier s = new Supplier();
		            s.setId(rs.getInt("SUPPLIER_ID"));
		            s.setProduct(rs.getString("PRODUCT_ID"));
		            s.setName(rs.getString("SUPPLIER_NAME"));
		             
		            list.add(s);
		        }
				return list;
	}

}

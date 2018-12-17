package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.DepartmentDAO;
import io.github.ydhekim.stock_management_automation.dao.DepartmentDAOImpl;

@WebServlet("/GetAllDepartmentsController")
public class GetAllDepartmentsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		HashMap<Integer, String> departments;

		departments = departmentDAO.getAllDepartments();
		out.println("Departman Numarasi - Departman Adi <br/>");
		for (Map.Entry<Integer, String> entry : departments.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();

			out.println(key + "   ----------   " + value + " <br/> ");
		}
		
		out.println("<a href='index-mng.jsp'>Geri Don!</a>");

		out.close();
	}

}

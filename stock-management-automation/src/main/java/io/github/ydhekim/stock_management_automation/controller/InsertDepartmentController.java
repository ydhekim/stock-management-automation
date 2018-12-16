package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.DepartmentDAO;
import io.github.ydhekim.stock_management_automation.dao.DepartmentDAOImpl;

@WebServlet("/InsertDepartmentController")
public class InsertDepartmentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		PrintWriter out = response.getWriter();

		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		String departmentName = request.getParameter("departmentName");

		departmentDAO.insertDepartment(departmentId, departmentName);
		
		out.println("Ekleme Basarili!");
		request.getRequestDispatcher("index-mng.html").include(request, response); 
	}

}

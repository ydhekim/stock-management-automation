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

@WebServlet("/DeleteDepartmentController")
public class DeleteDepartmentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();

		int departmentId = Integer.parseInt(request.getParameter("departmentId"));

		departmentDAO.deleteDepartment(departmentId);
		
		out.println("Silme Basarili!");
		request.getRequestDispatcher("index-mng.html").include(request, response);
	}

}

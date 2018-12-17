package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.WarehouseAttendantDAO;
import io.github.ydhekim.stock_management_automation.dao.WarehouseAttendantDAOImpl;

@WebServlet("/UpdateWarehouseAttendantController")
public class UpdateWarehouseAttendantController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();

		int warehouseAttendantId = Integer.parseInt(request.getParameter("warehouseAttendantId"));
		int password = Integer.parseInt(request.getParameter("password"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));

		warehouseAttendantDAO.updateWarehouseAttendant(warehouseAttendantId, password, firstName, lastName,
				departmentId);

		out.println("Guncelleme Basarili!");
		request.getRequestDispatcher("index-mng.jsp").include(request, response);

		out.close();
	}

}

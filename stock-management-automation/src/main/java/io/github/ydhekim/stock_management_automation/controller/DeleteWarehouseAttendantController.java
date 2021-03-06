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

@WebServlet("/DeleteWarehouseAttendantController")
public class DeleteWarehouseAttendantController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();

		int warehouseAttendantId = Integer.parseInt(request.getParameter("warehouseAttendantId"));

		warehouseAttendantDAO.deleteWarehouseAttendant(warehouseAttendantId);

		out.println("Silme Basarili!");
		request.getRequestDispatcher("index-mng.jsp").include(request, response);

		out.close();
	}

}

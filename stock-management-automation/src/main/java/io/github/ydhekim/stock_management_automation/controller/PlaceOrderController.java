package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.OrderDAO;
import io.github.ydhekim.stock_management_automation.dao.OrderDAOImpl;

@WebServlet("/PlaceOrderController")
public class PlaceOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OrderDAO orderDAO = new OrderDAOImpl();

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		int orderAmount = Integer.parseInt(request.getParameter("orderAmount"));

		orderDAO.placeOrder(orderId, supplierId, employeeId, orderAmount, false);
		
		out.println("Siparis Verme Basarili!");
		request.getRequestDispatcher("index-emp.jsp").include(request, response);

		out.close();
	}
	

}

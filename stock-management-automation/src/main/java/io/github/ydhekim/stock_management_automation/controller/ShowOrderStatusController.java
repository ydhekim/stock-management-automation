package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.OrderDAO;
import io.github.ydhekim.stock_management_automation.dao.OrderDAOImpl;
import io.github.ydhekim.stock_management_automation.model.Order;

@WebServlet("/ShowOrderStatusController")
public class ShowOrderStatusController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OrderDAO orderDAO = new OrderDAOImpl();
		ArrayList<Order> orders;

		int employeeId = Integer.parseInt(request.getParameter("employeeId"));

		orders = orderDAO.showOrderStatus(employeeId);
		out.println("Siparis Numarasi - Siparis Miktari - Siparis Durumu <br/>");
		for (Order order : orders) {
			int orderId = order.getId();
			int orderAmount = order.getAmount();
			boolean orderStatus = order.isConfirmed();

			out.println(orderId + "   ----------   " + orderAmount + " ---------- " + orderStatus + " <br/> ");
		}
		
		out.println("<a href='index-emp.jsp'>Geri Don!</a>");

		out.close();
	}

}

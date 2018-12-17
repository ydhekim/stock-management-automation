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

@WebServlet("/ConfirmOrderController")
public class ConfirmOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		OrderDAO orderDAO = new OrderDAOImpl();

		int orderId = Integer.parseInt(request.getParameter("orderId"));

		orderDAO.confirmOrder(orderId);

		out.println("Onaylama Basarili!");
		request.getRequestDispatcher("index-war.jsp").include(request, response);

		out.close();
	}

}

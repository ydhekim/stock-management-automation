package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.ProductDAO;
import io.github.ydhekim.stock_management_automation.dao.ProductDAOImpl;

@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductDAO productDAO = new ProductDAOImpl();

		int productId = Integer.parseInt(request.getParameter("productId"));

		productDAO.deleteProduct(productId);
		
		out.println("Silme Basarili!");
		request.getRequestDispatcher("index-war.jsp").include(request, response);

		out.close();
	}
	
}

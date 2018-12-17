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

@WebServlet("/InsertProductController")
public class InsertProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductDAO productDAO = new ProductDAOImpl();

		int productId = Integer.parseInt(request.getParameter("productId"));
		int productAmount = Integer.parseInt(request.getParameter("productAmount"));
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");

		productDAO.insertProduct(productId, productAmount, productName, productType);
		
		out.println("Ekleme Basarili!");
		request.getRequestDispatcher("index-war.jsp").include(request, response);
		
		out.close();
	}

}

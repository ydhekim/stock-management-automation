package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.ProductDAO;
import io.github.ydhekim.stock_management_automation.dao.ProductDAOImpl;
import io.github.ydhekim.stock_management_automation.model.Product;

@WebServlet("/GetAllProductsController")
public class GetAllProductsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductDAO productDAO = new ProductDAOImpl();
		ArrayList<Product> products;

		products = productDAO.getAllProducts();
		out.println("Urun ID - Urun Miktari - Urun Adi - Urun Tipi <br/>");
		for (Product product : products) {
			int productId = product.getId();
			int productAmount = product.getAmount();
			String productName = product.getName();
			String productType = product.getType();

			out.println(productId + " --------- " + productAmount + " ---------- " + productName + " ---------- "
					+ productType + "<br/>");
		}
		out.println("<a href='index-war.jsp'>Geri Don!</a>");

		out.close();
	}

}

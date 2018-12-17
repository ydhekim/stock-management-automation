package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.SupplierDAO;
import io.github.ydhekim.stock_management_automation.dao.SupplierDAOImpl;
import io.github.ydhekim.stock_management_automation.model.Supplier;

@WebServlet("/GetAllSuppliersController")
public class GetAllSuppliersController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SupplierDAO supplierDAO = new SupplierDAOImpl();
		ArrayList<Supplier> suppliers;

		suppliers = supplierDAO.getAllSuppliers();
		out.println("Tedarikci ID - Tedarikci Adi - Urun ID <br/>");
		for (Supplier supplier : suppliers) {
			int supplierId = supplier.getId();
			String supplierName = supplier.getName();
			int productId = supplier.getProduct().getId();

			out.println(supplierId + " ---------- " + supplierName + " ---------- " + productId + "<br/>");
		}

		out.println("<a href='index-mng.jsp'>Geri Don!</a>");

		out.close();
	}

}

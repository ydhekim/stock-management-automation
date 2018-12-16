package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.LoginDAO;
import io.github.ydhekim.stock_management_automation.dao.LoginDAOImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAOImpl();
		response.setContentType("text/html");

		int username = Integer.parseInt(request.getParameter("emp_user"));
		int password = Integer.parseInt(request.getParameter("emp_pass"));

		if (loginDAO.login(username, password)) {

		}
	}

}

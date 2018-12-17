package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.LoginDAO;
import io.github.ydhekim.stock_management_automation.dao.LoginDAOImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		LoginDAO loginDAO = new LoginDAOImpl();

		int username = Integer.parseInt(request.getParameter("emp_user"));
		int password = Integer.parseInt(request.getParameter("emp_pass"));
		String username2 = request.getParameter("emp_user");

		if (loginDAO.login(username, password)) {
			if (username <= 2000 && username >= 1000) {
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "index-mng.jsp");
				
				Cookie cookie = new Cookie("username", username2);
				response.addCookie(cookie);
			} else if (username <= 3000 && username >= 2001) {
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "index-war.jsp");
				
				Cookie cookie = new Cookie("username", username2);
				response.addCookie(cookie);
			} else if (username <= 4000 && username >= 3001) {
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "index-emp.jsp");
				
				Cookie cookie = new Cookie("username", username2);
				response.addCookie(cookie);
			} else {
				RequestDispatcher rs = request.getRequestDispatcher("error.html");
				rs.include(request, response);
			}
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("error.html");
			rs.include(request, response);
		}
	}

}

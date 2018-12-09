package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/stock-management-automation";

	static final String USER = "sa";
	static final String PASS = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idFromLoginForm = Integer.parseInt(request.getParameter("employee_id"));
		int pwFromLoginForm = Integer.parseInt(request.getParameter("employee_pw"));

		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connecting to the db");
			String sql = "SELECT employee_id, department_id, password FROM employee";
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int employee_id = resultSet.getInt("employee_id");
				int department_id = resultSet.getInt("department_id");
				int password = resultSet.getInt("password");

				if (idFromLoginForm == employee_id && pwFromLoginForm == password) {
					RequestDispatcher dispatcher;
					if (department_id == 1) {
//						dispatcher = request.getRequestDispatcher("/manager/index.html");
//						dispatcher.forward(request, response);
						// request.getRequestDispatcher("/manager/index.html").forward(request,response);
						response.sendRedirect("/manager/index.html");
					} else if (department_id == 2) {
						dispatcher = request.getRequestDispatcher("/warehouseAttendant/index.html");
						dispatcher.forward(request, response);
					} else if (department_id == 3) {
						dispatcher = request.getRequestDispatcher("/department/add-order.html");
						dispatcher.forward(request, response);
					} else {
						dispatcher = request.getRequestDispatcher("/error.html");
					}
				}
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package io.github.ydhekim.stock_management_automation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.ydhekim.stock_management_automation.dao.WarehouseAttendantDAO;
import io.github.ydhekim.stock_management_automation.dao.WarehouseAttendantDAOImpl;
import io.github.ydhekim.stock_management_automation.model.Employee;

@WebServlet("/GetAllWarehouseAttendantsController")
public class GetAllWarehouseAttendantsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		WarehouseAttendantDAO warehouseAttendantDAO = new WarehouseAttendantDAOImpl();
		ArrayList<Employee> employees;

		employees = warehouseAttendantDAO.getAllWarehouseAttendants();
		out.println("Personel ID - Personel PW - Personel Adi - Personel Soyadi - Departman ID <br/>");
		for (Employee employee : employees) {
			int employeeId = employee.getId();
			int employeePw = employee.getPassword();
			String firstName = employee.getFirstName();
			String lastName = employee.getLastName();
			int departmentId = employee.getDepartment().getId();

			out.println(employeeId + " ---------- " + employeePw + " ---------- " + firstName + " ---------- "
					+ lastName + " ---------- " + departmentId + "<br/>");
		}

		out.println("<a href='index-mng.jsp'>Geri Don!</a>");

		out.close();
	}

}

package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLoginDAO {

	@Test
	public void testLogin() {
		LoginDAO loginDAO = new LoginDAOImpl();
		boolean loginStatus = loginDAO.login(2, 2);
		assertTrue(loginStatus);
	}

}

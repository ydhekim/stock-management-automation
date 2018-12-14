package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.ydhekim.stock_management_automation.model.Department;
import io.github.ydhekim.stock_management_automation.model.Order;

public class TestOrderDAO {
	
	@Test
	public void testGetOrder() {
		OrderDAO orderDAO = new OrderDAOImpl();
		Order order = orderDAO.getOrder(1);
		assertEquals(orderDAO.getOrder(1).getId(), order.getId());
	}

	@Test
	public void testConfirmOrder() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPlaceOrder() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testShowOrderStatus() {
		fail("Not yet implemented");
	}

}

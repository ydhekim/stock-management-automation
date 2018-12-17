package io.github.ydhekim.stock_management_automation.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

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
		OrderDAO orderDAO = new OrderDAOImpl();
		boolean before = orderDAO.getOrder(1).isConfirmed();
		orderDAO.confirmOrder(1);
		boolean after = orderDAO.getOrder(1).isConfirmed();
		assertNotEquals(before, after);

	}

	@Test
	public void testPlaceOrder() {
		OrderDAO orderDAO = new OrderDAOImpl();
		Order order = new Order();
	//	Calendar calendar = new GregorianCalendar(2018, 12, 16);
		orderDAO.placeOrder(2, 1, 1, 10, true);
		assertNotNull(order.getId());
	}

	@Test
	public void testShowOrderStatus() {
		OrderDAO orderDAO = new OrderDAOImpl();
		ArrayList<Order> orders = orderDAO.showOrderStatus(1);
		assertNotNull(orders);
	}
}

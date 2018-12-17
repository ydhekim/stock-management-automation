package io.github.ydhekim.stock_management_automation.dao;

import java.util.ArrayList;
import java.util.Calendar;

import io.github.ydhekim.stock_management_automation.model.Order;

public interface OrderDAO {

	public Order getOrder(int orderId);

	public ArrayList<Order> getAllOrders();

	public void confirmOrder(int orderId);

	public void placeOrder(int orderId, int supplierId, int employeeId, int orderAmount, boolean orderStatus);

	public ArrayList<Order> showOrderStatus(int employeeId);

}
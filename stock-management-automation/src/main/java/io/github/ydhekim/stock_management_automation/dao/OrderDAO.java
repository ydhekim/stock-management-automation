package io.github.ydhekim.stock_management_automation.dao;

import io.github.ydhekim.stock_management_automation.model.Order;

public interface OrderDAO {

	public Order getOrder(int orderId);

}

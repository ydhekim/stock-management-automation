/** 
 * @author ydhekim
 * */
package io.github.ydhekim.stock_management_automation.model;

import java.util.Date;

public class Order {

	protected int id;
	protected int amount;
	protected boolean confirmed;
	protected Date orderDate;
	protected Supplier supplier;
	protected Employee employee;

	public Order(int id, int amount, boolean confirmed, Date orderDate, Supplier supplier, Employee employee) {
		this.id = id;
		this.amount = amount;
		this.confirmed = false;
		this.orderDate = orderDate;
		this.supplier = supplier;
		this.employee = employee;
	}

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

//	public Date getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

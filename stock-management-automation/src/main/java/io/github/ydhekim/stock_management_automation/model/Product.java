/**
 * @author ydhekim
 *  */
package io.github.ydhekim.stock_management_automation.model;

public class Product {

	protected int id;
	protected int amount;
	protected String name;
	protected String type;

	public Product() {
	}

	public Product(int id, int amount, String name, String type) {
		this.id = id;
		this.amount = amount;
		this.name = name;
		this.type = type;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

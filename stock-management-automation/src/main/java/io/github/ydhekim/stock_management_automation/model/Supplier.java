/**
 * @author ydhekim
 *  */
package io.github.ydhekim.stock_management_automation.model;

public class Supplier {

	protected int id;
	protected String name;
	protected Product product;

	public Supplier() {
	}

	public Supplier(int id, String name, Product product) {
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

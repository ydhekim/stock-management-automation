/** 
 * @author ydhekim
 * */
package io.github.ydhekim.stock_management_automation.model;

public class Department {

	protected int id;
	protected String name;

	public Department() {
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}

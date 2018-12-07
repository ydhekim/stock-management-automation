/** 
 * @author ydhekim
 * */
package io.github.ydhekim.stock_management_automation.model;

public class Employee {

	protected int id;
	protected int password;
	protected String firstName;
	protected String lastName;
	protected Department department;

	public Employee() {
	}

	public Employee(int id, int password, String firstName, String lastName, Department department) {
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return this.password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}

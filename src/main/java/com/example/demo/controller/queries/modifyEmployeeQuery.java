package com.example.demo.controller.queries;

import java.math.BigDecimal;

public class modifyEmployeeQuery {

	private long employeeId;
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public modifyEmployeeQuery() {
		super();
	}
	
	
}

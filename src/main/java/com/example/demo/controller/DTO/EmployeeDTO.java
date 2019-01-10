package com.example.demo.controller.DTO;

import java.math.BigDecimal;

public class EmployeeDTO {

	private long employeeId;
	private String firstName;
	private String lastName;
	private String departementName;
	private BigDecimal salary;
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
	public String getDepartementName() {
		return departementName;
	}
	public void setDepartementName(String departementName) {
		this.departementName = departementName;
	}
	
public EmployeeDTO(String firstName, String lastName, String departementName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departementName = departementName;
	}
public EmployeeDTO() {
	super();
}
public long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(long employeeId) {
	this.employeeId = employeeId;
}
public BigDecimal getSalary() {
	return salary;
}
public void setSalary(BigDecimal salary) {
	this.salary = salary;
}
	
	
	
	
	
}

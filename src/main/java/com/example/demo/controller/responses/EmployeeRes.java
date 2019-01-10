package com.example.demo.controller.responses;

import java.util.List;

import com.example.demo.controller.DTO.EmployeeDTO;

public class EmployeeRes {

	private List<EmployeeDTO> employees;

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

	public EmployeeRes(List<EmployeeDTO> employees) {
		super();
		this.employees = employees;
	}

	public EmployeeRes() {
		super();
	}
	
	
}

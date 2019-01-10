package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.queries.modifyEmployeeQuery;
import com.example.demo.controller.responses.Decile;
import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> filterByFirstName(String firstName);
	public List<Employee> findAll();
	public List<Decile> decileEmployees();
	public Employee findByEmail(String email);
	public void updateEmployee(modifyEmployeeQuery q);
	
}

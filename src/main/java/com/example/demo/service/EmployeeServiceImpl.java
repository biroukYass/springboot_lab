package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.responses.Decile;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> filterByFirstName(String firstName) {
		
		return employeeRepository.findByFirstNameOrderByLastNameAsc(firstName);
	}

	@Override
	public List<Employee> findAll() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Decile> decileEmployees() {
		List<Decile> deciles =new ArrayList<>();
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		List<BigDecimal> salaries = new ArrayList<BigDecimal>();
		for (Employee e : employees) {
			salaries.add(e.getSalary());
		}
		Collections.sort(salaries, Collections.reverseOrder());
		BigDecimal pas = salaries.get(0).subtract(salaries.get(salaries.size()-1)).divide(new BigDecimal(10));
		
		
		for (int i = 0; i < 10; i++) {
			Decile d = new Decile();
			d.setMinSalary(salaries.get(0).add(pas).multiply(new BigDecimal(i)));
			d.setMaxSalary(d.getMinSalary().add(pas));
			deciles.add(d);
			
		}
		
		for (int i = 0; i < 10; i++) {
			for (BigDecimal s : salaries) {
				if(s.compareTo(deciles.get(i).getMaxSalary()) == -1 && s.compareTo(deciles.get(i).getMinSalary()) == 1 ){
					deciles.get(i).setPercentage(deciles.get(i).getPercentage()+1);
				}
			}
		}
		
		return deciles;
	}

}

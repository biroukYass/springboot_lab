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

import com.example.demo.controller.queries.modifyEmployeeQuery;
import com.example.demo.controller.responses.Decile;
import com.example.demo.model.Country;
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
		Collections.sort(salaries);
		BigDecimal pas = (salaries.get(salaries.size()-1).subtract(salaries.get(0))).divide(new BigDecimal(10));
		
		
		for (int i = 0; i < 10; i++) {
			Decile d = new Decile();
			d.setMinSalary(salaries.get(0).add(pas.multiply(new BigDecimal(i))));
			d.setMaxSalary(d.getMinSalary().add(pas));
			d.setPercentage(0);
			deciles.add(d);
			
		}
		for (BigDecimal s : salaries) {
		for (int i = 0; i < 10; i++) {
//			System.out.println(deciles.get(i).getMinSalary());
			
				if(s.compareTo(deciles.get(i).getMaxSalary()) <0 && s.compareTo(deciles.get(i).getMinSalary()) >= 0 ){
					 
					float x = deciles.get(i).getPercentage();
					deciles.get(i).setPercentage(x + 1*100/((float)salaries.size()));
				}
			}
			
		}
		for (Decile decile : deciles) {
			System.out.println(decile.getMinSalary());
		}
		return deciles;
	}

	@Override
	public Employee findByEmail(String email) {
		
		return employeeRepository.findByEmail( email);
	}

	@Override
	public void updateEmployee(modifyEmployeeQuery q) {
		Employee e= employeeRepository.findByEmployeeId(q.getEmployeeId());
		e.setFirstName(q.getFirstName());
		e.setLastName(q.getLastName());
		e.setSalary(q.getSalary());
		employeeRepository.save(e);
	}

}

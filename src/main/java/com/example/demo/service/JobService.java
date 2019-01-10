package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.Job;

public interface JobService {
	
	public Job findJobById(String jobID);
	public void updateJobTitle(Job job, String jobTitle);
	List<Job> findByMaxSalaryGreaterThanEqual(BigDecimal maxSalary);
	public List<Job> findAll();
}

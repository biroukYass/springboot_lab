package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;

@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepository;

	@Override
	public Job findJobById(String JobId) {
		// TODO Auto-generated method stub
		return jobRepository.findByJobId(JobId);
	}

	@Override
	public void updateJobTitle(Job job, String jobTitle) {
		job.setJobTitle(jobTitle);
		jobRepository.save(job);
	}
	public List<Job> findByMaxSalaryGreaterThanEqual(BigDecimal maxSalary){
		return jobRepository.findByMaxSalaryGreaterThanEqualOrderByMaxSalary(maxSalary);
		
	}
	public List<Job> findAll() {
		return (List<Job>) jobRepository.findAll();
		
	}
	
}

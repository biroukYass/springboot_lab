package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Job;

public interface JobRepository extends CrudRepository<Job, String>{

	Job findByJobId(String JobId);
	List<Job> findByMaxSalaryLessThanEqual(BigDecimal maxSalary);
}

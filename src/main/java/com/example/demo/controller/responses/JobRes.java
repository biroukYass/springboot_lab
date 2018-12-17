package com.example.demo.controller.responses;

import java.util.List;

import com.example.demo.controller.DTO.JobDTO;

public class JobRes {
	private List<JobDTO> jobs;

	public JobRes(List<JobDTO> jobs) {
		super();
		this.jobs = jobs;
	}

	public JobRes() {
		super();
	}

	public List<JobDTO> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobDTO> jobs) {
		this.jobs = jobs;
	}
	
	
}

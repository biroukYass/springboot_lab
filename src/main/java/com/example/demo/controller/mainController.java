package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.DTO.JobDTO;
import com.example.demo.controller.queries.SalaryQuery;
import com.example.demo.controller.responses.JobRes;
import com.example.demo.model.Job;
import com.example.demo.service.JobService;

@Controller
public class mainController {

	@Autowired
	private JobService jobService;
	
//	@Autowired
//	private ModelMapper modelMapper =new ModelMapper();

	@RequestMapping(value = "/updateJob")
	public @ResponseBody String updateJobTitle(@RequestParam String jobId, @RequestParam String jobTitle) {
		jobService.updateJobTitle(jobService.findJobById(jobId), jobTitle);
		return jobTitle;
	}

	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
	public @ResponseBody JobRes jobs(@RequestBody SalaryQuery q) {
		JobRes j =new JobRes();
		List<JobDTO> jobsDTO = jobToDTO(jobService.findByMaxSalaryLessThanEqual(q.getMinSalary()));
		j.setJobs(jobsDTO);
		return j;
	}
	
	public List<JobDTO> jobToDTO(List<Job> jobs){
		List<JobDTO> jobsDTO = new ArrayList<>();
		ModelMapper modelMapper =new ModelMapper();
		for (Job job : jobs) {
			JobDTO j = modelMapper.map(job, JobDTO.class);
			jobsDTO.add(j);
			}
		return jobsDTO;
	}
}

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.DTO.CountryDTO;
import com.example.demo.controller.DTO.EmployeeDTO;
import com.example.demo.controller.DTO.JobDTO;
import com.example.demo.controller.queries.SalaryQuery;
import com.example.demo.controller.queries.UpdateJobTitleQuery;
import com.example.demo.controller.queries.modifyCountryQuery;
import com.example.demo.controller.responses.EmployeeRes;
import com.example.demo.controller.responses.JobRes;
import com.example.demo.model.Country;
import com.example.demo.model.Employee;
import com.example.demo.model.Job;
import com.example.demo.service.CountryService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.JobService;

@Controller
//@RequestMapping(value = "/home")
public class mainController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CountryService countryService;
	
//	@Autowired
//	private ModelMapper modelMapper =new ModelMapper();
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/countries")
	public String allCountries(Model model){
		
		model.addAttribute("countries",countryToDTO( countryService.findAll()));
		return "countries";
	}
	
	@RequestMapping(value = "/modifyCountry")
	public String modifyCountry( @RequestBody modifyCountryQuery q ){
		countryService.updateCountry(q);
		System.out.println(q.getCountryId());
		return "/chart";
	}

	@RequestMapping(value = "/updateJob", method = RequestMethod.POST)
	public @ResponseBody String updateJobTitle(@RequestBody UpdateJobTitleQuery q) {
		jobService.updateJobTitle(jobService.findJobById(q.getJobId()), q.getJobTitle());
		return q.getJobTitle();
	}

	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
	public @ResponseBody JobRes jobs(@RequestBody SalaryQuery q) {
		JobRes j =new JobRes();
		List<JobDTO> jobsDTO = jobToDTO(jobService.findByMaxSalaryLessThanEqual(q.getMinSalary()));
		j.setJobs(jobsDTO);
		return j;
	}
	
	@RequestMapping(value = "/emloyeeByFirst")
	public @ResponseBody EmployeeRes employeeByFist(@RequestParam String firstName) {
		EmployeeRes e=new EmployeeRes();
		List<EmployeeDTO> empDTO = employeeToDTO( employeeService.filterByFirstName(firstName));
		e.setEmployees(empDTO);
		return e;
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
	
	public List<EmployeeDTO> employeeToDTO(List<Employee> employees){
		List<EmployeeDTO> employeeDTO =new ArrayList<>();
		ModelMapper modelMapper =new ModelMapper();
		for (Employee emp : employees) {
			EmployeeDTO e = modelMapper.map(emp, EmployeeDTO.class);
			e.setDepartementName(emp.getDepartment().getDepartmentName());
//			typeMap.addMappings(mapper -> mapper.map(src -> src.getCustomer().getAge(), PersonDTO::setAge));
			employeeDTO.add(e);
		}
		return employeeDTO;
	}
	public List<CountryDTO> countryToDTO(List<Country> countries){
		List<CountryDTO> countryDTO = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for (Country country : countries) {
			CountryDTO j = modelMapper.map(country, CountryDTO.class);
			countryDTO.add(j);
			}
		return countryDTO;
	}
}

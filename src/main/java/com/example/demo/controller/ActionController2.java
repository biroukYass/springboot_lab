package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.DTO.EmployeeDTO;
import com.example.demo.controller.responses.Decile;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;



@Controller
public class ActionController2 {

	@Autowired
	private EmployeeService employeeService;
	
	//**********
	@RequestMapping(value="/chart", method = RequestMethod.GET)
	public String springMVC(Model model) {
		List<EmployeeDTO> canvasjsDataList = employeeToDTO(employeeService.findAll());
//		canvasjsDataList.add(new Point(1, 100));

		model.addAttribute("data", canvasjsDataList);
		return "chart2";
	}
	public List<EmployeeDTO> employeeToDTO(List<Employee> employees){
		List<EmployeeDTO> employeeDTO =new ArrayList<>();
		ModelMapper modelMapper =new ModelMapper();
		for (Employee emp : employees) {
			EmployeeDTO e = modelMapper.map(emp, EmployeeDTO.class);
			employeeDTO.add(e);
		}
		return employeeDTO;
	}
	
	@RequestMapping(value="/deciles", method = RequestMethod.GET)
	public String deciles(Model model) {
		List<Decile> canvasjsDataList = employeeService.decileEmployees();
		model.addAttribute("data_decile", canvasjsDataList);
		return "chart_decile";
	}	
	
	@RequestMapping(value="/chart_zoom", method = RequestMethod.GET)
	public String zoomchartC(Model model) {
//		List<Point> canvasjsDataList = new ArrayList<Point>();
//		canvasjsDataList.add(new Point(1, 100));
//		canvasjsDataList.add(new Point(2, 100));
//		canvasjsDataList.add(new Point(3, 100));
//		canvasjsDataList.add(new Point(4, 100));
		
//		model.addAttribute("data", canvasjsDataList);
		return "chart_zoom";
	}
}
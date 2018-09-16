package com.bmo.alerts.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmo.alerts.bs.model.Employee;
import com.bmo.alerts.bs.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/addAllEmployees")
	public String addAllEmployees() {
		employeeService.addAllEmployees();
		return "all employees added";
		
	}
	
	@GetMapping("/Employee/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable int id) {
		return employeeService.getEMployeeById(id);
	}
	@GetMapping("/getAllEmployees")
	public @ResponseBody List<Employee> getAllEmployees() {
		return employeeService.listEmployees();
	}
	
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		if(employee.getId()==0) {
			employeeService.addEmployee(employee);
	}else {
		employeeService.updateEmployee(employee);
    }
	}
	@GetMapping("/getAllEmployees/{pageNo}/{totalNoPages}")
	public @ResponseBody List<Employee> getAllEmployees(@PathVariable int pageNo,@PathVariable int totalNoPages) {
		return employeeService.listEmployes(pageNo,totalNoPages);
	}
	
	

}

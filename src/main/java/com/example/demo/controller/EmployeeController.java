package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save-employee")
	public String addNewEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
		return "Hello "+employee.getFirstName()+" you have succesfully register your records";
	}
	
	@GetMapping("/getall-employee")
	public List<Employee> fetchAllEmployeeRecords() {
		return employeeService.fetchAllEmployeeRecords();
	}
	
	@DeleteMapping("/delete-employee/{firstName}")
	@Transactional
	public String deleteEmployeeRecords(@PathVariable String firstName) {
		employeeService.deleteEmployeeRecords(firstName);
		return "Employee Name : "+firstName+ ",Deleted Records Succefully";
	}
	
	@GetMapping("/filter/employee/{firstName}")
	public List<Employee> getEmployeeRecordsByFirstName(@PathVariable String firstName){
		return employeeService.fetchEmployeeRecordsByName(firstName);
	}
}

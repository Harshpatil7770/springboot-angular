package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	 Employee addNewEmployee(Employee employee);
	
	 List<Employee> fetchAllEmployeeRecords();
	
	 void deleteEmployeeRecords(String firstName);
	 
	 List<Employee> fetchEmployeeRecordsByName(String firstName);
}

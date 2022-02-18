package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployeeRecords() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeRecords(String firstName) {
		
		employeeRepository.deleteByFirstName(firstName);
	}

	@Override
	public List<Employee> fetchEmployeeRecordsByName(String firstName) {
		
		return employeeRepository.findByFirstName(firstName);
	}

}

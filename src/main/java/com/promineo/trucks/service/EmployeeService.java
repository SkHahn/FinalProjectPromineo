package com.promineo.trucks.service;

import java.util.List;
import com.promineo.trucks.entity.Employee;

public interface EmployeeService {

	//Post an employee (CREATE)
	//takes in employee object named employee
	public Employee saveEmployee(Employee employee);
		
	//Get employees (READ)
	public List<Employee> getAllEmployees();
		
	//Get employee by Id (READ)
	public Employee getEmployeeById(int Id);
		
	//Put the new employee in (UPDATE)
	public Employee updateEmployee(Employee employee, int Id);		
		
	//Deletes the employee (DELETE)
	public void deleteEmployee(int Id);

}

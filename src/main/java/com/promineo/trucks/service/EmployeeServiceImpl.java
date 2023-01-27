package com.promineo.trucks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.trucks.entity.Employee;
import com.promineo.trucks.exception.ResourceNotFoundException;
import com.promineo.trucks.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	//creates an object from the employee repository so you can call on the list of methods 
	private EmployeeRepository employeeRepository;
	
	//repository object that gets passed in the constructor
	//the auto wired annotation allows the whole bean to be created so you can use all the methods in the repo
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//CREATE (saving the employee)
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//READ - GET (returning the list of employees)
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	//READ - GET (getting employee specific by ID)
	@Override
	public Employee getEmployeeById(int Id) {
		return employeeRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("employee", "Id", Id));
	}

	//UPDATEs and writes of the employee after making sure the employee exists and stores it here.
	//Otherwise it throws the not found exception.
	@Override
	public Employee updateEmployee(Employee employee, int Id) {
		Employee existingEmployee = employeeRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("employee", "Id", Id));
		//new informations input
		existingEmployee.setFirst_name(employee.getFirst_name());
		existingEmployee.setLast_name(employee.getLast_name());
		existingEmployee.setPhone_contact(employee.getPhone_contact());
		existingEmployee.setFood_truck_id(employee.getFood_truck_id());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	//DELETES the employee by the Id. Makes sure it exists first though
	@Override
	public void deleteEmployee(int Id) {
		Employee existingEmployee = employeeRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("employee", "Id", Id));
		employeeRepository.deleteById(Id);
	}

}

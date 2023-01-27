package com.promineo.trucks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.trucks.entity.Employee;
import com.promineo.trucks.service.EmployeeService;


@RestController
@RequestMapping("/truck_db/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//CREATE API
	//allows us to retrieve the columns and info about the object
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//READ API
	//returns a list of truck employees by pulling everyone from the table
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	//READ by ID - gets an employee by looking at a specific column
	@GetMapping("{employee_id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employee_id") int employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	//UPDATE - putting the new employee information
	@PutMapping("{employee_id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employee_id") int employeeId, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
	}
	
		
	//DELETE - deletes the employee by the Id
	@DeleteMapping("{employee_id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employee_id") int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("That employee has been terminated.", HttpStatus.OK);
	}
	
}

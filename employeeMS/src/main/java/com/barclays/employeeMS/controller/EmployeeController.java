package com.barclays.employeeMS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.exception.IdNotFoundException;
import com.barclays.employeeMS.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
// rest api : api  / employee : employee purpose
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//
	@GetMapping("/hello")
	public String helloMapping() {
		return "hello from advik";
	}
	
	@PostMapping("/add")                          // json to java
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		
		Employee employee2 = null;
		String result =  employeeService.addEmployee(employee);
		if("success".equals(result)) {
			employee2 = employeeService.getEmployeeById(employee.getEmpNo()).get();
			return ResponseEntity.created(null).body(employee2);
		}
		else {
			return ResponseEntity.badRequest().body("data is not proper");
		}
		
		
		
		// created ===> httpstatus code 201 
		//---> to inform that record which you want to insert that is inserted successfully
		// body : response ==> it can hold anything.
		// 
		
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees() {
		
		List<Employee> employees = employeeService.getEmployees();
		
		if(employees.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(employees);
		// list ===> to json array 
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) throws IdNotFoundException{
		
		Optional<Employee> optional = employeeService.getEmployeeById(id);
		
		if(optional.isEmpty()) {
			throw new IdNotFoundException("there is no id found");
		}
			//return ResponseEntity.of(optional);
		//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("message");
		return ResponseEntity.ok(id);
	}
	
	
	

}

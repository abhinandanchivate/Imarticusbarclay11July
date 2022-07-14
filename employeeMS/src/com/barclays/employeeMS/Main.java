package com.barclays.employeeMS;

import java.util.Optional;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.service.EmployeeService;
import com.barclays.employeeMS.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();
		Employee employee = new Employee(0, "abhinandan", "chivate", 10000, "freelancer");
		
//		String result = employeeService.addEmployee(employee);
//		System.out.println(result);
		
		Optional<Employee> optional = employeeService.getEmployeeById(5);
		
		System.out.println(optional.get());
		
		employeeService.getEmployees().forEach(e->System.out.println(e));
		
	}
}

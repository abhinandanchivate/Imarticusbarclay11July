package com.barclays.employeeMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.service.EmployeeService;

@SpringBootApplication
public class EmployeeMsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =   SpringApplication
				.run(EmployeeMsApplication.class, args);

		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		System.out.println(employeeService);
		EmployeeService employeeService2 = applicationContext.getBean(EmployeeService.class);
		System.out.println(employeeService2);
		System.out.println(employeeService.equals(employeeService2));
		System.out.println("after equals call");
		
		String result = employeeService.addEmployee(new Employee(0, "advik", "chivate", 1000, "master"));
		System.out.println(result);
	}

}

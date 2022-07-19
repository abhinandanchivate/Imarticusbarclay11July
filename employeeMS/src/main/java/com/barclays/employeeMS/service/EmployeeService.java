package com.barclays.employeeMS.service;

import java.util.List;
import java.util.Optional;

import com.barclays.employeeMS.dto.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee, int empId);
	public String deleteEmployee(int empId);
	public Optional<Employee> getEmployeeById(int empId);
	public List<Employee> getEmployees();
}

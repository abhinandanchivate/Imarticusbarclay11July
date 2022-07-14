package com.barclays.employeeMS.service;

import java.util.List;
import java.util.Optional;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.repo.EmployeeRepository;
import com.barclays.employeeMS.repo.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	// Singleton DP
	
	// EmployeeRepository Ref will hold singleton object
	EmployeeRepository employeeRepository   = EmployeeRepositoryImpl.getInstance();
	
	private EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static EmployeeService employeeService;
	// it will hold only one object since it is static 
	// private so that no one can access from the outside world.
	
	public static EmployeeService getInstance() {
		
		if(employeeService ==null)
		{
		
		employeeService = new EmployeeServiceImpl();
		return employeeService;
		// interface ref can hold the object of its impl.
		}
		return employeeService;
		// 
	}
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public String updateEmployee(Employee employee, int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployees();
	}

}

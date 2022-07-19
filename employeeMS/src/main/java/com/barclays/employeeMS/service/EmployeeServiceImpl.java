package com.barclays.employeeMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.repo.EmployeeRepository;
//import com.barclays.employeeMS.repo.EmployeeRepositoryImpl;

@Service // it should be marked on all service impls and will give singleton object
public class EmployeeServiceImpl implements EmployeeService {

	// Singleton DP
	
	// EmployeeRepository Ref will hold singleton object
	// we provided the required dependant object
	// injected the dependancy ?
	// oracle implementation ? 
	// spring has to inject the object here 
	// but this thing we have to inform it to the spring
	@Autowired
	EmployeeRepository employeeRepository;
//	
//	private EmployeeServiceImpl() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	private static EmployeeService employeeService;
//	// it will hold only one object since it is static 
//	// private so that no one can access from the outside world.
//	
//	public static EmployeeService getInstance() {
//		
//		if(employeeService ==null)
//		{
//		
//		employeeService = new EmployeeServiceImpl();
//		return employeeService;
//		// interface ref can hold the object of its impl.
//		}
//		return employeeService;
//		// 
//	}
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2= employeeRepository.save(employee);
		
		if(employee2!= null)
			return "success";
		else
			return "fail";
	}

	@Override
	public String updateEmployee(Employee employee, int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(empId);
		if(optional.isPresent())
		{
			employeeRepository.deleteById(empId);
			return "success";
		}
		
		return "no record found";
	}

	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		
		return employeeRepository.findById(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}

package com.barclays.employeeMS.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.barclays.employeeMS.dto.Employee;
import com.barclays.employeeMS.utils.DBUtils;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private EmployeeRepositoryImpl() {
		//TODO auto generated constructor add
	}
	private static EmployeeRepository employeeRepository;
	
	public static EmployeeRepository getInstance() {
		if(employeeRepository == null)
		{
			employeeRepository = new EmployeeRepositoryImpl();
			return employeeRepository;
		}
		return employeeRepository;
	}
	

	@Override
	public String addEmployee(Employee employee) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null; // this statement will help us to improve the performance during the db call
		// 
		
		String insertStatement = "insert into employee"
				+ " (empNo,empfirstname, emplastname,designation,salary) "
				+ "values(?,?,?,?,?)";
		
		if(connection==null) {
			return "problem with DB";
		}
		else {
			// we will write the code to insert the emp details.
			
			try {
				preparedStatement  = connection.prepareStatement(insertStatement);
				preparedStatement.setInt(1, employee.getEmpNo());
				preparedStatement.setString(2, employee.getEmpFname());
				preparedStatement.setString(3, employee.getEmpLastName());
				preparedStatement.setString(4, employee.getDesignation());
				preparedStatement.setFloat(5, employee.getSalary());
				int result = preparedStatement.executeUpdate();
				if(result > 0) {
					return "success";
				}
				else {
					return "fail";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeConnection(connection);
			}
			
		}
		// TODO Auto-generated method stub
		return null;
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
		String query = "select * from employee where empNo=?";
		// we can provide the column no but on the basis of select statement
		// 
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null; // this statement will help us to improve the performance during the db call
		// 
		
		
		if(connection==null) {
			return Optional.empty();
		}
		else {
			// we will write the code to insert the emp details.
			
			try {
				preparedStatement  = connection.prepareStatement(query);
				preparedStatement.setInt(1, empId);
				
				resultSet = preparedStatement.executeQuery();
				
				// if / while 
				if(resultSet.next()) {
					// record exists ---> we need to create the emp object?
					Employee employee = new Employee();
					employee.setEmpNo(resultSet.getInt("empNo"));
					employee.setEmpFname(resultSet.getString("empfirstname"));
					employee.setEmpLastName(resultSet.getString("emplastname"));
					employee.setDesignation(resultSet.getString("designation"));
					employee.setSalary(resultSet.getFloat("salary"));
					return Optional.of(employee);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeConnection(connection);
			}

	}
		return Optional.empty();
	}

	@Override
	public List<Employee> getEmployees() {
		String query = "select * from employee";
		// we can provide the column no but on the basis of select statement
		// 
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null; // this statement will help us to improve the performance during the db call
		// 
		
		
		if(connection==null) {
			return null;
		}
		else {
			// we will write the code to insert the emp details.
			
			try {
				preparedStatement  = connection.prepareStatement(query);
				//preparedStatement.setInt(1, empId);
				
				resultSet = preparedStatement.executeQuery();
				List<Employee> list = new ArrayList<>();
				// if / while 
				while(resultSet.next()) {
					// record exists ---> we need to create the emp object?
					Employee employee = new Employee();
					employee.setEmpNo(resultSet.getInt("empNo"));
					employee.setEmpFname(resultSet.getString("empfirstname"));
					employee.setEmpLastName(resultSet.getString("emplastname"));
					employee.setDesignation(resultSet.getString("designation"));
					employee.setSalary(resultSet.getFloat("salary"));
					list.add(employee);
					
				}
				return list;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				DBUtils.closeConnection(connection);
			}

	}
		return null;

	}

}

package com.barclays.employeeMS.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.employeeMS.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}

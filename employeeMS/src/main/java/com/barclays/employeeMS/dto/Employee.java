package com.barclays.employeeMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int empNo;
	private String empFname;
	private String empLastName;
	private float salary;
	private String designation;
	
	// setter : to set the value won't return anything : return void 
	// getter : to get the value : will return the value : return type declaration of field
}


// Department  : deptno deptName , location
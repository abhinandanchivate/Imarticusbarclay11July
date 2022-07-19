package com.barclays.employeeMS.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// table 
@Entity
@Table(name = "emptable")
public class Employee {

	@Id // for PK
	private int empNo;
	@Column
	private String empFname;
	@Transient
	private String empLastName;
	private float salary;
	private String designation;
	
	// setter : to set the value won't return anything : return void 
	// getter : to get the value : will return the value : return type declaration of field
}


// Department  : deptno deptName , location
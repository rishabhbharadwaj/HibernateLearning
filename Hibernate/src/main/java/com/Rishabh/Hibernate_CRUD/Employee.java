package com.Rishabh.Hibernate_CRUD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*This class is an example of CRUD (create, read, update, delete) operations and state of the objects.*/

@Entity
@SuppressWarnings("deprecation")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id @GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private int employeeID;
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	

}

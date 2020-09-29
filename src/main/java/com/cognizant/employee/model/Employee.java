package com.cognizant.employee.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "employee")
public class Employee {

	@Id
	private String id;
	@Field( "employee_name")
	private String employeeName;
	@Field( "address")
	private String address;
	@Field( "salary")
	private Double salary;
	@Field( "date_of_birth")
	@JsonFormat(pattern = "YYYY-MM-DD")
	private Date dateOfBirth;
	@Field( "date_of_joining")
	@JsonFormat(pattern = "YYYY-MM-DD")
	private Date dateOfJoining;
	@DBRef
	@Field("department")
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String id, String employeeName, String address, Double salary, Date dateOfBirth, Date dateOfJoining,
			Department department) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.address = address;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

}

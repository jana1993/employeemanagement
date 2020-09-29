package com.cognizant.employee.service;

import java.util.List;

import com.cognizant.employee.exception.ResourceNotFoundException;
import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public Employee updateEmployeeSalaryById(Employee employee) throws ResourceNotFoundException;

	public Department createDepartment(Department department);
	
	public List<Employee> getEmployeeByDeportmentId(String id);
	//public List<Employee> getAllEmployeeByDepartment(String department) ;

	public List<Employee> getEmployees();

}

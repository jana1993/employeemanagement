package com.cognizant.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employee.exception.ResourceNotFoundException;
import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.DepartmentRepository;
import com.cognizant.employee.repository.EmployeeRepository;
import com.cognizant.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		employee.setDepartment(departmentInfo(employee.getDepartment()));
		return employeeRepository.save(employee);
	}

	private Department departmentInfo(Department department) {
		Department existedDepartment=this.getDepartmentByName(department.getName());
		if(existedDepartment!=null)
			return existedDepartment;
		return this.createDepartment(department);
	}
	private Department getDepartmentByName(String deptName) {
		return departmentRepository.findByName(deptName);
	}
	@Override
	public Employee updateEmployeeSalaryById(Employee employee) throws ResourceNotFoundException {
		Optional<Employee> employeeId = employeeRepository.findById(employee.getId());

		if (employeeId.isPresent()) {
			Employee employeeData = employeeId.get();
			employeeData.setSalary(employee.getSalary());
			employeeData.setDepartment(createDepartment(employeeData.getDepartment()));
			employeeRepository.save(employeeData);
			return employeeData;
		} else {
			throw new ResourceNotFoundException("Data is not available :" + employeeId);
		}
	}
	

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Employee> getEmployeeByDeportmentId(String id) {
		Optional<Department> dept = departmentRepository.findById(id);
		if(dept.isPresent()) {
			return employeeRepository.findAllByDepartment(dept.get());
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

}

package com.cognizant.employee.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String>{

	List<Employee> findAllByDepartment(Department department);

}

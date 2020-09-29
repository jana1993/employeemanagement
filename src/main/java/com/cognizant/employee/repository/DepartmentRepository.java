package com.cognizant.employee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cognizant.employee.model.Department;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, String>{

	Department findByName(String deptName);

}

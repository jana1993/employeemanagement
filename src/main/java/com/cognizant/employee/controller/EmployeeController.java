package com.cognizant.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employee.exception.ResourceNotFoundException;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.service.EmployeeService;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
    public ResponseEntity < Employee > createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable String id, @RequestBody Employee employee) throws ResourceNotFoundException {
		employee.setId(id);
		employee.setSalary(employee.getSalary());
        return ResponseEntity.ok().body(this.employeeService.updateEmployeeSalaryById(employee));
    }
	
	@GetMapping("/deportment/{id}")
    public ResponseEntity < List<Employee> > listEmployees(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(this.employeeService.getEmployeeByDeportmentId(id));
    }
	
	@GetMapping()
    public ResponseEntity < List<Employee> > employees() throws ResourceNotFoundException {
        return ResponseEntity.ok().body(this.employeeService.getEmployees());
    }

}

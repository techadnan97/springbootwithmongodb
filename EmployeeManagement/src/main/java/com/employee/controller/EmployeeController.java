package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	private EmployeeService employeeService;

	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/add-emp")
	private  ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<EmployeeDto>
		(this.employeeService.addEmployee(employeeDto), HttpStatus.CREATED);
	}
	@GetMapping("/emp")
	private ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		return new  ResponseEntity<List<EmployeeDto>>(this.employeeService.getAllEmployee(),HttpStatus.OK);
	}

}

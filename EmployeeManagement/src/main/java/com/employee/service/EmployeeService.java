package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;


public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	public List<EmployeeDto> getAllEmployee();

}

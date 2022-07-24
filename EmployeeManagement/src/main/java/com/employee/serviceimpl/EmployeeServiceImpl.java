package com.employee.serviceimpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.sequence.SequenceGenerate;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	ModelMapper modelMapper;
	SequenceGenerate sequenceGenerate;
	EmployeeRepo employeeRepo;

	public EmployeeServiceImpl() {
		super();
	}

	@Autowired
	public EmployeeServiceImpl(ModelMapper modelMapper, SequenceGenerate sequenceGenerate, EmployeeRepo employeeRepo) {
		super();
		this.modelMapper = modelMapper;
		this.sequenceGenerate = sequenceGenerate;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		employeeDto.setId(sequenceGenerate.generateSequence(Employee.SEQUENCE_NAME));
		Employee employee = modelMapper.map(employeeDto, Employee.class);

		return modelMapper.map(this.employeeRepo.save(employee), EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> allEmp = this.employeeRepo.findAll();
		Type type = new TypeToken<List<EmployeeDto>>() {
		}.getType();

		return modelMapper.map(allEmp, type);
	}

}

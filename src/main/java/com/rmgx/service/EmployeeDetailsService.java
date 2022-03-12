package com.rmgx.service;

import java.util.List;

import com.rmgx.dto.EmployeeDetailsDto;
import com.rmgx.entity.EmployeeDetails;

public interface EmployeeDetailsService {

	public EmployeeDetails saveEmployee(EmployeeDetailsDto employeeDetailsDto);

	public EmployeeDetails fetchEmployee(Integer id);

	public List<EmployeeDetails> fetchAllEmployee();

	public String deleteEmployee(Integer id);

	public EmployeeDetails updateEmployee(Integer id, EmployeeDetailsDto employeeDetailsDto);
}

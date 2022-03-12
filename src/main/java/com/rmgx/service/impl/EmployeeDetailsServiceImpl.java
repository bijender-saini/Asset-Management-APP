package com.rmgx.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rmgx.dto.EmployeeDetailsDto;
import com.rmgx.entity.EmployeeDetails;
import com.rmgx.exception.EmployeeNotFoundException;
import com.rmgx.repository.EmployeeDetailsRepository;
import com.rmgx.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Override
	public EmployeeDetails saveEmployee(EmployeeDetailsDto employeeDetailsDto) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName(employeeDetailsDto.getName());
		employeeDetails.setDesignation(employeeDetailsDto.getDesignation());
		return employeeDetailsRepository.save(employeeDetails);
	}

	@Override
	public EmployeeDetails fetchEmployee(Integer id) {
		Optional<EmployeeDetails> findById = employeeDetailsRepository.findById(id);
		if (!findById.isPresent()) {
			throw new EmployeeNotFoundException("employee not found with given id::" + id);
		}
		return findById.get();
	}

	@Override
	public List<EmployeeDetails> fetchAllEmployee() {
		List<EmployeeDetails> employeeList = employeeDetailsRepository.findAll();
		if (CollectionUtils.isEmpty(employeeList)) {
			throw new EmployeeNotFoundException("employee not found");
		}
		return employeeList;
	}

	@Override
	public String deleteEmployee(Integer id) {
		if (!employeeDetailsRepository.existsById(id)) {
			throw new EmployeeNotFoundException("employee not found with given id::" + id);
		}
		employeeDetailsRepository.deleteById(id);
		return "employee deleted successfully.";
	}

	@Override
	public EmployeeDetails updateEmployee(Integer id, EmployeeDetailsDto employeeDetailsDto) {
		EmployeeDetails employeeDetails = fetchEmployee(id);
		employeeDetails.setName(employeeDetailsDto.getName());
		employeeDetails.setDesignation(employeeDetailsDto.getDesignation());
		return employeeDetailsRepository.save(employeeDetails);
	}

}

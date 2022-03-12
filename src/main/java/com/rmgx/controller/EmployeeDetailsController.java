package com.rmgx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmgx.dto.EmployeeDetailsDto;
import com.rmgx.service.EmployeeDetailsService;
import com.rmgx.utils.ResponseHandler;

@RestController
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@PostMapping("/saveEmployee")
	ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDetailsDto employeeDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "employee saved successfully.",
				employeeDetailsService.saveEmployee(employeeDetailsDto));
	}

	@GetMapping("/fetchAllEmployee")
	ResponseEntity<Object> fetchAllEmployee() {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "success",
				employeeDetailsService.fetchAllEmployee());
	}

	@GetMapping("/fetchEmployee/{id}")
	ResponseEntity<Object> fetchEmployee(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				employeeDetailsService.fetchEmployee(id));
	}

	@DeleteMapping("/deleteEmployee/{id}")
	ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "employee deleted successfully.",
				employeeDetailsService.deleteEmployee(id));
	}

	@PostMapping("/updateEmployee/{id}")
	ResponseEntity<Object> saveEmployee(@PathVariable("id") Integer id,
			@RequestBody EmployeeDetailsDto employeeDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "employee saved successfully.",
				employeeDetailsService.updateEmployee(id, employeeDetailsDto));
	}

}

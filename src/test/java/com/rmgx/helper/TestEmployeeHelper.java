package com.rmgx.helper;

import java.util.ArrayList;
import java.util.List;

import com.rmgx.dto.EmployeeDetailsDto;
import com.rmgx.entity.EmployeeDetails;

public class TestEmployeeHelper {

	static EmployeeDetailsDto buildEmployeeDto() {
		EmployeeDetailsDto dto = new EmployeeDetailsDto();
		dto.setName("xxx");
		dto.setDesignation("Tester");
		return dto;
	}

	static List<EmployeeDetails> buildEmployeeList() {
		EmployeeDetails em = new EmployeeDetails();
		em.setName("xxx");
		em.setDesignation("Tester");

		EmployeeDetails em2 = new EmployeeDetails();
		em2.setName("yyy");
		em2.setDesignation("qa");

		ArrayList<EmployeeDetails> al = new ArrayList<EmployeeDetails>();
		al.add(em);
		al.add(em2);

		return al;
	}

	static EmployeeDetails buildEmployeeDetails() {
		EmployeeDetails em = new EmployeeDetails();
		em.setName("xxx");
		em.setDesignation("Tester");

		return em;
	}

}

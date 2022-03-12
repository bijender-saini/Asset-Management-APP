package com.rmgx.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.rmgx.entity.EmployeeDetails;
import com.rmgx.repository.EmployeeDetailsRepository;
import com.rmgx.service.impl.EmployeeDetailsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestEmployeeServiceImpl {
	@InjectMocks
	EmployeeDetailsServiceImpl employeeService;
	
	@Mock
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void buildEmployeeDetailsTest() {
		when(employeeDetailsRepository.save(TestEmployeeHelper.buildEmployeeDetails()))
				.thenReturn(TestEmployeeHelper.buildEmployeeDetails());
		assertNotNull(employeeService.saveEmployee(TestEmployeeHelper.buildEmployeeDto()));
	}

	@Test
	public void fetchAllEmployeeTest() {
		when(employeeDetailsRepository.findAll()).thenReturn(TestEmployeeHelper.buildEmployeeList());
		assertEquals(2, employeeDetailsRepository.findAll().size());
	}
	
	@Test
	public void fetchEmployeeDetailsTest() {
		when(employeeDetailsRepository.findById(1)).thenReturn(Optional.of(TestEmployeeHelper.buildEmployeeDetails()));
		assertNotNull(employeeService.fetchEmployee(1));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void deleteCategoryest() throws Exception {
		when(employeeDetailsRepository.existsById(1)).thenReturn(true);
		employeeService.deleteEmployee(1);
		verify(employeeDetailsRepository, times(1)).deleteById(1);

	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void updatePatientTest() {
		when(employeeDetailsRepository.findAll()).thenReturn(TestEmployeeHelper.buildEmployeeList());
		when(employeeDetailsRepository.findById(1)).thenReturn(Optional.of(TestEmployeeHelper.buildEmployeeDetails()));
		 EmployeeDetails buildEmployeeDetails = TestEmployeeHelper.buildEmployeeDetails();
		 buildEmployeeDetails.setId(1);
		 buildEmployeeDetails.setName("xxx");
		 employeeDetailsRepository.save(TestEmployeeHelper.buildEmployeeDetails());
		verify(employeeDetailsRepository, times(1)).save(TestEmployeeHelper.buildEmployeeDetails());

	}


}

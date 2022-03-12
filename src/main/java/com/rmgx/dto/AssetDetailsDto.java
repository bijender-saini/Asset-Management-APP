package com.rmgx.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AssetDetailsDto {

	private String name;
	private Date purchasedDate;
	private String assetCondition;
	private String assignmentStatus;

	private Integer categoryId;
	private Integer employeeId;
}

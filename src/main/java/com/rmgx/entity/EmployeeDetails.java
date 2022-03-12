package com.rmgx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeDetails {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String designation;
	
//	@OneToMany
//	@JoinColumn(name="asset_details_FK")
//	private AssetDetails assetDetails=new AssetDetails();
}

package com.rmgx.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.type.TrueFalseType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import net.bytebuddy.dynamic.scaffold.TypeInitializer.None;

@Data
@Entity
public class AssetDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date purchasedDate;
	private String assetCondition;
	private String assignmentStatus;

	@ManyToOne
	@JoinColumn(name = "category_FK")
	private Category category = new Category();

//	@ManyToOne(cascade = CascadeType.MERGE,optional = true)
////	 @JoinColumn(columnDefinition="integer", name="subtype_id")
////	@Column(nullable = true)
	@JoinColumn(nullable = true, name = "employee_FK")
	@ManyToOne
//	@JoinColumn(columnDefinition="integer", name="customer_id")
	private EmployeeDetails employeeDetails = new EmployeeDetails();
}

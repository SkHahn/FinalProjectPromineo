package com.promineo.trucks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Entity

@Table(name="employee")
public class Employee {

	//indicates that this is the primary key. //AUTO if IDENTITY wont work.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indicates that the IDs are auto assigned
	private int employee_id;
	
	@Column(value = "food_truck_id") //tells the mapper that the variable is referencing this column
	private int food_truck_id;
	
	@Column(value = "first_name")
	private String first_name;
	
	@Column(value = "last_name")
	private String last_name;
	
	@Column(value = "phone_contact")
	private String phone_contact;
	
	
	
}

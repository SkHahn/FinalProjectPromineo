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

@Table(name="location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int location_id;
	
	@Column(value = "address")
	private String location_address;
	
	@Column(value = "location_name")
	private String location_name;
	
	@Column(value = "serves_alcohol")
	private String alcohol;
	
	
	
}

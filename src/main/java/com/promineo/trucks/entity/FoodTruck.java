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

@Table(name="food_truck")
public class FoodTruck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int food_truck_id;
	
	@Column(value = "home_base_address")
	private String homeBase;
	
	@Column(value = "truck_name")
	private String truck_name;
	
	@Column(value = "truck_owner")
	private String owner;
}

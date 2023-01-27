package com.promineo.trucks.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Entity

@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_id;
	
	@Column(value = "food_truck_id")
	private int food_truck_id;
	
	@Column(value = "food_type")
	private String food_type;
	
	@Column(value = "food_price")
	private BigDecimal food_price;
	
}

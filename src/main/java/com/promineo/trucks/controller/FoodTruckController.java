package com.promineo.trucks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.trucks.entity.FoodTruck;
import com.promineo.trucks.service.FoodTruckService;

@RestController
@RequestMapping("/truck_db/food_truck")
public class FoodTruckController {

	@Autowired
	private FoodTruckService foodTruckService;
	
	public FoodTruckController(FoodTruckService foodTruckService) {
		super();
		this.foodTruckService = foodTruckService;
	}
	
	@GetMapping
	public List<FoodTruck> getAllFoodtrucks() {
		return foodTruckService.getAllFoodtrucks();
	}	
		
		
}

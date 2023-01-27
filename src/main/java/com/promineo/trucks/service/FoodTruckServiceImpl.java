package com.promineo.trucks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.trucks.entity.FoodTruck;
import com.promineo.trucks.repository.FoodTruckRepository;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {

	private FoodTruckRepository foodTruckRepository;
	
	@Autowired
	public FoodTruckServiceImpl(FoodTruckRepository foodTruckRepository) {
		this.foodTruckRepository = foodTruckRepository;
	}
	
	//Get - Read
	@Override
	public List<FoodTruck> getAllFoodtrucks() {
		return foodTruckRepository.findAll();
	}

	
}

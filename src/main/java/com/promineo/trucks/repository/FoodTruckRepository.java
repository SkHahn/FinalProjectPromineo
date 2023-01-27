package com.promineo.trucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.trucks.entity.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Integer> {

}

package com.promineo.trucks.service;

import java.util.List;

import com.promineo.trucks.entity.Location;

public interface LocationService {

	//Post - Create
	public Location saveLocation(Location location);
	
	//Get - Read
	public List<Location> getAllLocations();
	
	//Put - Update
	public Location updateLocation(Location location, int Id);
	
	
	
}

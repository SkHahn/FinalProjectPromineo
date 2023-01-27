package com.promineo.trucks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.trucks.entity.Location;
import com.promineo.trucks.exception.ResourceNotFoundException;
import com.promineo.trucks.repository.LocationRepository;

@Service
public class LocationServiceImpl  implements LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	//CREATE - post
	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	//READ - get
	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	//UPDATE - put
	@Override
	public Location updateLocation(Location location, int Id) {
		Location existingLocation = locationRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("location", "Id", Id));
		existingLocation.setLocation_address(location.getLocation_address());
		existingLocation.setLocation_name(location.getLocation_name());
		existingLocation.setAlcohol(location.getAlcohol());
		locationRepository.save(existingLocation);
		return existingLocation;
	}

}

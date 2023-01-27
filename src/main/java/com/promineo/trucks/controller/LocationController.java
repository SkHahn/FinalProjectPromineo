package com.promineo.trucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.trucks.entity.Location;
import com.promineo.trucks.service.LocationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/truck_db/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	//create - post
	@PostMapping()
	public ResponseEntity<Location> saveLocation(@RequestBody Location location) {
		return new ResponseEntity<Location>(locationService.saveLocation(location), HttpStatus.CREATED);
	}
	
	//read - get
	@GetMapping
	public List<Location> getAllLocations() {
		return locationService.getAllLocations();
	}
	
	//update - put
	@PutMapping("{location_id}")
	public ResponseEntity<Location> updateLocation(@PathVariable("location_id") int locationId, @RequestBody Location location) {
		return new ResponseEntity<Location>(locationService.updateLocation(location, locationId), HttpStatus.OK);	
	}
	
}

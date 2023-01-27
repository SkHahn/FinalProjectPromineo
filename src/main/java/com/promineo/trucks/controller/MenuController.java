package com.promineo.trucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.trucks.entity.Menu;
import com.promineo.trucks.service.MenuService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/truck_db/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	//create - post
	@PostMapping()
	public ResponseEntity<Menu> addMenuItem(@RequestBody Menu menu) {
		return new ResponseEntity<Menu>(menuService.addMenuItem(menu), HttpStatus.CREATED);
	}
	
	//update - put
	@PutMapping("{menu_id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable("menu_id") int menuId, @RequestBody Menu menu) {
		return new ResponseEntity<Menu>(menuService.updateMenu(menu, menuId), HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("{menu_id}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable("menu_id") int menuId) {
		menuService.deleteMenuItem(menuId);
		return new ResponseEntity<String>("That itme has been removed from the menu.", HttpStatus.OK);
	}
	
}

package com.promineo.trucks.service;

import com.promineo.trucks.entity.Menu;

public interface MenuService {

	//Post - Create
	public Menu addMenuItem(Menu menu);
	
	//Put - Update
	public Menu updateMenu(Menu menu, int Id);
	
	//Delete
	public void deleteMenuItem(int Id);
	
}

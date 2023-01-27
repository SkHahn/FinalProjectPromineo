package com.promineo.trucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.trucks.entity.Menu;
import com.promineo.trucks.exception.ResourceNotFoundException;
import com.promineo.trucks.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

	private MenuRepository menuRepository;
	
	@Autowired
	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	//CREATE - post
	@Override
	public Menu addMenuItem(Menu menu) {
		return menuRepository.save(menu);
	}

	//UPDATE - put
	@Override
	public Menu updateMenu(Menu menu, int Id) {
		Menu existingMenuItem = menuRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("Menu Item", "Id", Id));
		existingMenuItem.setFood_type(menu.getFood_type());
		existingMenuItem.setFood_truck_id(menu.getFood_truck_id());
		existingMenuItem.setFood_price(menu.getFood_price());
		menuRepository.save(existingMenuItem);
		return existingMenuItem;
	}

	//DELETE
	@Override
	public void deleteMenuItem(int Id) {
		Menu existingMenuItem = menuRepository.findById(Id).orElseThrow(() ->
		new ResourceNotFoundException("Menu Item", "Id", Id));
		
	}

}

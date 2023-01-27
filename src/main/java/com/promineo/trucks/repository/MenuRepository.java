package com.promineo.trucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.trucks.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}

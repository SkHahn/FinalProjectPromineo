package com.promineo.trucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.trucks.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}

package com.gds.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gds.restaurant.entities.RestaurantLocation;

/**
 * JPA repository implementation for managing RestaurantLocation entities.
 */
@Repository
public interface RestaurantLocationRepository extends JpaRepository<RestaurantLocation, Long> {

	List<RestaurantLocation> findByAreaAndCategory(String area, String category);
	
	List<RestaurantLocation> findByCategory(String category);
	
	List<RestaurantLocation> findByArea(String area);
	
	
}

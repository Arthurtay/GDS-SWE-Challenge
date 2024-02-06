package com.gds.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
	@Query("SELECT res FROM RestaurantLocation res WHERE res.shopName LIKE %:shopName%")
	Optional<RestaurantLocation> findByShopNameLike(String shopName);
	
}

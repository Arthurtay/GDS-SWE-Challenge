package com.gds.restaurant.dao;
import java.util.List;

import com.gds.restaurant.entities.RestaurantLocation;


/**
 * DAO interface for managing operations related to restaurant locations.
 */

public interface RestaurantLocationDAO {
	
    public List<RestaurantLocation> findAll();
    
    public List<RestaurantLocation> findByAreaAndCategory(String area, String category);
	
    public List<RestaurantLocation> findByCategory(String category);
	
    public List<RestaurantLocation> findByArea(String area);
    
    
}

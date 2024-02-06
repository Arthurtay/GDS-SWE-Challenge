package com.gds.restaurant.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gds.restaurant.entities.RestaurantLocation;
import com.gds.restaurant.repository.RestaurantLocationRepository;



/**
 * Dao implementation for managing operations related to restaurant locations.
 */

@Service
public class RestaurantLocationDAOImpl implements RestaurantLocationDAO{

	@Autowired
	private RestaurantLocationRepository restaurantLocationRepo;
	
    @Override
    public List<RestaurantLocation> findAll() {
        return restaurantLocationRepo.findAll();
    }

	@Override
	public List<RestaurantLocation> findByAreaAndCategory(String area, String category) {
		return restaurantLocationRepo.findByAreaAndCategory(area, category);
		
	}

	@Override
	public List<RestaurantLocation> findByCategory(String category) {
		return restaurantLocationRepo.findByCategory(category);
	}

	@Override
	public List<RestaurantLocation> findByArea(String area) {
		return  restaurantLocationRepo.findByArea(area);
	}

	@Override
	public RestaurantLocation findSingleRestaurantByName(String shopName) {
		
		  Optional<RestaurantLocation> restaurantOptional = restaurantLocationRepo.findByShopNameLike(shopName);	
		  return restaurantOptional.orElse(new RestaurantLocation());
		  
	}
}

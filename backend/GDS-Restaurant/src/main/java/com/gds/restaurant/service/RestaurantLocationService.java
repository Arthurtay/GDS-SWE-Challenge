package com.gds.restaurant.service;

import com.gds.restaurant.dto.RestaurantLocationReqDTO;
import com.gds.restaurant.dto.RestaurantLocationResDTO;

/**
 * Service interface for managing operations related to restaurant locations.
 */
public interface RestaurantLocationService {
	
	public RestaurantLocationResDTO getRandomRestaurantLocation(RestaurantLocationReqDTO reqDto);
	
}

package com.gds.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gds.restaurant.dao.RestaurantLocationDAO;
import com.gds.restaurant.dto.RestaurantLocationReqDTO;
import com.gds.restaurant.dto.RestaurantLocationResDTO;
import com.gds.restaurant.entities.RestaurantLocation;
import com.gds.restaurant.exception.NoDataException;
import org.modelmapper.ModelMapper;

import java.util.Random;


/**
 * Service implementation for managing operations related to restaurant locations.
 */
@Service
public class RestaurantLocationServiceImpl implements RestaurantLocationService {

	@Autowired
	private RestaurantLocationDAO restaurantDao;
	
	private static ModelMapper mapper = new ModelMapper();
	
	/**
	 * Retrieves a random restaurant location based on the provided criteria.
	 * If both area and category are specified in the request, it filters locations accordingly.
	 * If only category or only area is specified, it filters locations based on the available criteria.
	 * If no criteria are provided, it returns a random location from all available restaurants.
	 *
	 * @param reqDto Request DTO containing choices of (area, category) to determine type of list retrieve.
	 * @return A randomly selected restaurant location response DTO.
	 */
	@Override
	public RestaurantLocationResDTO getRandomRestaurantLocation(RestaurantLocationReqDTO reqDto) {
		
		List<RestaurantLocation> listOfLocation;
		
		if(!reqDto.getArea().isBlank() && !reqDto.getCategory().isBlank()){
			listOfLocation = restaurantDao.findByAreaAndCategory(reqDto.getArea(), reqDto.getCategory());
			 selectRandomRestaurant(listOfLocation);
		}else if(!reqDto.getCategory().isBlank()) {	
			listOfLocation = restaurantDao.findByCategory(reqDto.getCategory());
		}else if(!reqDto.getArea().isBlank()) {
			listOfLocation = restaurantDao.findByArea(reqDto.getArea());
		}else {
			listOfLocation = restaurantDao.findAll();
		}
		
		return selectRandomRestaurant(listOfLocation);
	}


	/**
	 * Selects a random restaurant from the provided list of locations.
	 *
	 * @param listOfLocation - List of restaurant locations to choose from.
	 * @return A randomly selected restaurant location response DTO.
	 */
	private RestaurantLocationResDTO selectRandomRestaurant(List<RestaurantLocation> listOfLocation) {
		
		// Ensure the list is not empty and fetch from DAO if needed
		if (listOfLocation.isEmpty() && (listOfLocation = restaurantDao.findAll()).isEmpty()) {
		    throw new NoDataException("There is no Data in the database for restaurant location");
		}
		
	
		int size = listOfLocation.size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        
    	//Select location randomly based on index
        RestaurantLocation location = listOfLocation.get(randomIndex);
        return  mapper.map(location, RestaurantLocationResDTO.class);
		
	}





	
	
	
	

}

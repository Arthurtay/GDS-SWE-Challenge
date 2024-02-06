package com.gds.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.gds.restaurant.dto.RestaurantLocationReqDTO;
import com.gds.restaurant.dto.RestaurantLocationResDTO;
import com.gds.restaurant.service.RestaurantLocationService;


/**
 * Controller for handling restaurant location related requests.
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantLocationController {

	@Autowired
	private RestaurantLocationService restaurantLocationService;
	
	  /**
     * Endpoint to retrieve a random restaurant location based on the provided criteria.
     *
     * @param choices - Request body containing criteria (area, category) for filtering locations.
     * @return ResponseEntity - containing the randomly selected restaurant location response DTO.
     *         Returns HttpStatus.OK if successful else HttpStatus.INTERNAL_SERVER_ERROR on exception.
     */
	@PostMapping("/random")
	public ResponseEntity<?> getRandomRestaurant(@RequestBody RestaurantLocationReqDTO choices) {
		try {
			RestaurantLocationResDTO result = restaurantLocationService.getRandomRestaurantLocation(choices);
			return new ResponseEntity<RestaurantLocationResDTO>(result, HttpStatus.OK);
		}catch (Exception e) {
	        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	  /**
     * Endpoint to retrieve a restaurant location based on it's name.
     * @param name 
     * @return ResponseEntity containing the randomly selected restaurant location response DTO.
     *         Returns HttpStatus.OK if successful else HttpStatus.INTERNAL_SERVER_ERROR on exception.
     */
	@GetMapping("/{name}")
	public ResponseEntity<?> getRestaurant(@PathVariable String name) {
		try {
			RestaurantLocationResDTO result = restaurantLocationService.getRestaurantLocationByName(name);
			return new ResponseEntity<RestaurantLocationResDTO>(result, HttpStatus.OK);
		}catch (Exception e) {
	        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

	
	
}

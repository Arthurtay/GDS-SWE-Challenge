package com.gds.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param choices Request body containing criteria (area, category) for filtering locations.
     * @return ResponseEntity containing the randomly selected restaurant location response DTO.
     *         Returns HttpStatus.OK if successful else HttpStatus.INTERNAL_SERVER_ERROR on exception.
     */
	@PostMapping("/get")
	public ResponseEntity<?> getRestaurant(@RequestBody RestaurantLocationReqDTO choices) {
		try {
			RestaurantLocationResDTO result = restaurantLocationService.getRandomRestaurantLocation(choices);
			return new ResponseEntity<RestaurantLocationResDTO>(result, HttpStatus.OK);
		}catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}

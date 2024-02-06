package com.gds.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.gds.restaurant.dto.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class GdsRestaurantApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test case for retrieving a restaurant by specifying the area.
	 * Expects the result area to match the specified area, even if other attributes are random.
	 * Expects status 200
     * @throws Exception
     */
    @Test
    void testGetRestaurantbyArea() throws Exception {
  
    	RestaurantLocationReqDTO requestDTO = new RestaurantLocationReqDTO();
    	requestDTO.setArea("Tampines");
    	requestDTO.setCategory("");
  
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        try {
            MvcResult result = mockMvc.perform(post("/restaurant/random")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);

            assertEquals("Tampines", responseDTO.getArea());
            
            //assumption expects that all attribute should not be empty from the table
            assertNotEquals("", responseDTO.getShopName());
            assertNotEquals("", responseDTO.getAddress());
            assertNotEquals("", responseDTO.getLng());
            assertNotEquals("", responseDTO.getLat());
            assertNotEquals("", responseDTO.getCategory());
            
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
      
    
    /**
     * 
     * Test case for retrieving a restaurant by specifying the category.
	 * Expects the result category to match the specified category, even if other attributes are random.
	 * Expects status 200
     * @throws Exception
     */
    @Test
    void testGetRestaurantByCategory() throws Exception {
    	
    	RestaurantLocationReqDTO requestDTO = new RestaurantLocationReqDTO();
    	requestDTO.setArea("");
    	requestDTO.setCategory("Dessert");
  
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        try {
            MvcResult result = mockMvc.perform(post("/restaurant/random")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);

            assertEquals("Dessert", responseDTO.getCategory());
            
            //assumption expects that all attribute should not be empty from the table
            assertNotEquals("", responseDTO.getShopName());
            assertNotEquals("", responseDTO.getAddress());
            assertNotEquals("", responseDTO.getLng());
            assertNotEquals("", responseDTO.getLat());
            assertNotEquals("", responseDTO.getArea());
                    
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
    
    /**
     * 
     * Test case for retrieving a restaurant by specifying the category and area .
	 * Expects the result category and area to match the same category and area, even 
	 * if other attributes are random.
     * @throws Exception
     */
    @Test
    void testGetRestaurantByAreaAndCategory() throws Exception {
    	
     	RestaurantLocationReqDTO requestDTO = new RestaurantLocationReqDTO();
    	requestDTO.setArea("Tampines");
    	requestDTO.setCategory("Dessert");
  
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        try {
            MvcResult result = mockMvc.perform(post("/restaurant/random")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);
            
            assertEquals("Tampines", responseDTO.getArea());
            assertEquals("Dessert", responseDTO.getCategory());
            
            //assumption expects that all attribute should not be empty from the table
            assertNotEquals("", responseDTO.getShopName());
            assertNotEquals("", responseDTO.getAddress());
            assertNotEquals("", responseDTO.getLng());
            assertNotEquals("", responseDTO.getLat());
     
            
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    	
    }
    
    
    /**
     * Test case for retrieving a random restaurant with no choices 
     * @throws Exception
     */
    @Test
    void testGetRestaurant() throws Exception {
     	RestaurantLocationReqDTO requestDTO = new RestaurantLocationReqDTO();
    	requestDTO.setArea("");
    	requestDTO.setCategory("");
  
        String requestBody = objectMapper.writeValueAsString(requestDTO);

        try {
            MvcResult result = mockMvc.perform(post("/restaurant/random")
                    .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);
            
          
            assertNotNull(responseDTO);

           
            //assumption expects that all attribute should not be empty from the table
            assertNotEquals("", responseDTO.getShopName());
            assertNotEquals("", responseDTO.getAddress());
            assertNotEquals("", responseDTO.getLng());
            assertNotEquals("", responseDTO.getLat());
            assertNotEquals("", responseDTO.getArea());
            assertNotEquals("", responseDTO.getCategory());
               
            
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
    
    
    /**
     * Test case for retrieving a restaurant for Joe & Dough
     * Expects the result information to be specific to the restaurant.
     * @throws Exception
     */
    @Test
    void testGetRestaurantbyName() throws Exception {

        try {
            MvcResult result = mockMvc.perform(get("/restaurant/" + "Joe & Dough")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);
            
            assertEquals("Joe & Dough", responseDTO.getShopName());
            assertEquals("5 Straits View #B2-12, 018935 Local Cit Singapore", responseDTO.getAddress());
            assertEquals(103.8529889, responseDTO.getLng());
            assertEquals(1.2774589, responseDTO.getLat());
            assertEquals("18935", responseDTO.getPostalCode());
            assertEquals("Orchard", responseDTO.getArea());
            assertEquals("Chinese", responseDTO.getCategory());
                
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
    
    /**
     * Test case for retrieving a restaurant for Joe & Dough but using half Joe only
     * Expects the result information to be specific to the restaurant.
     * @throws Exception
     */
    @Test
    void testGetRestaurantbySimilarName() throws Exception {

        try {
            MvcResult result = mockMvc.perform(get("/restaurant/" + "Joe")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);
            
            assertEquals("Joe & Dough", responseDTO.getShopName());   
            assertEquals("5 Straits View #B2-12, 018935 Local Cit Singapore", responseDTO.getAddress());
            assertEquals(103.8529889, responseDTO.getLng());
            assertEquals(1.2774589, responseDTO.getLat());
            assertEquals("18935", responseDTO.getPostalCode());
            assertEquals("Orchard", responseDTO.getArea());
            assertEquals("Chinese", responseDTO.getCategory());
                
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
    
    
    /**
     * Test case for retrieving a restaurant that does not exist
     * Expects the result information empty.
     * @throws Exception
     */
    @Test
    void testGetRestaurantNotExist() throws Exception {
    	
        try {
            MvcResult result = mockMvc.perform(get("/restaurant/" + "test")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            String responseContent = result.getResponse().getContentAsString();
            RestaurantLocationResDTO responseDTO = objectMapper.readValue(responseContent, RestaurantLocationResDTO.class);
            
            assertEquals(null, responseDTO.getShopName());    
            assertEquals(null, responseDTO.getAddress());
            assertEquals(0.0, responseDTO.getLng());
            assertEquals(0.0, responseDTO.getLat());
            assertEquals(null, responseDTO.getPostalCode());
            assertEquals(null, responseDTO.getArea());
            assertEquals(null, responseDTO.getCategory());
                
        } catch (Exception e) {
       
            e.printStackTrace();
            throw e; 
        }
    }
    
    

}
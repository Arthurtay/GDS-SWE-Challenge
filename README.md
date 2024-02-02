# GDS-SWE-Challenge

## Video Demo
https://youtu.be/bqQCJDsaN08

## Overview

The objective of this project is to develop a random restaurant finder, utilizing the React JavaScript framework and the Material-UI library for the frontend. The backend is powered by a Java Spring Boot REST API, while using an in-memory H2 database with pre-configured with seeder data within the application.

## How to Run

### Installation

1. Ensure that the necessary dependencies are installed for the React application.
2. Navigate to the ../frontend/restaurant-finder directory and run the following command to install dependencies:
```
  npm install
```


### Running the application

1. To run the API, you can use the following command for the already-built JAR:
```
java -jar GDS-Restaurant-v2.jar
```
Alternatively, if you are running the backend application as a Spring Boot application from your IDE, ensure the backend is ready.

Once the backend is set up, go to the ../frontend/restaurant-finder directory and run the following command to start the react application:
```
  npm start
```

# GDS Restraunt Api Documentation

The API would be hosted in localhost port 9090.

## Controller

Controller for handling restaurant location-related requests.

### Get Restaurant Endpoint

#### `POST http://localhost:9090/restaurant/get`

Endpoint to retrieve a random restaurant location based on the provided criteria.

##### Request

- **Method:** `POST`
- **Path:** `/restaurant/get`

##### Request Body

```json
{
  "area": "Tampines",
  "category": "Dessert"
}
```
##### Response Body
```json
{
    "shopName": "CoolMan Froyo",
    "address": "18 Cross Street, China Square Central, Unit 01-106, 048423 Singapore",
    "postalCode": "48423",
    "category": "Dessert",
    "lat": 1.283384,
    "lng": 103.846868,
    "area": "Tampines"
}
```


## Configuration

#### CorsConfig

This configuration, CorsConfig, is designed to handle Cross-Origin Resource Sharing (CORS). Given that the client's location host port can vary, and there is no fixed origin, this configuration allows requests from any origin for the /restaurant/** endpoint. Specifically, only POST requests are permitted, ensuring secure interaction with the API while accommodating a variety of client origins."

```CorsConfig.java
/** 
 * Cross-Origin Configuration
 * */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/restaurant/**")
                .allowedOrigins("*")
                .allowedMethods("POST"); 
    }
}
```

##### DatabaseSeederConfig
The DatabaseSeederConfig is used to populate the in-memory database. 

```DatabaseSeederConfig.java
/**
 * Configuration to Seed the H2 memory database. 
 * */
@Configuration
public class DatabaseSeederConfig {

    @Bean
    public CommandLineRunner seedDatabase(RestaurantLocationRepository repository) {
        return args -> {
            List<RestaurantLocation> locations = List.of(
                    new RestaurantLocation("Joe & Dough", "5 Straits View #B2-12, 018935 Local Cit Singapore", "18935", "Chinese", 1.2774589, 103.8529889, "Orchard"),
                    new RestaurantLocation("Xiao Jun Gan Mala Xiang Guo", "The 101 Beach Road #01-01 Singapore 189703", "18935", "Dessert", 1.2774589, 103.8529889, "Orchard"),
                    new RestaurantLocation("HEYTEA", "2 Bayfront Ave, #01-73/74, 018972 Singapore", "18972", "Western", 1.283949, 103.858846, "Orchard"),
                    new RestaurantLocation("Priority Pizza by The Priority Club", "The Orchard Food Market 1 Claymore Dr, #02-01,Kitchen 8A, Singapore, 229594", "229594", "Western", 1.307492079, 103.8294198, "Orchard"),
                    new RestaurantLocation("Donburi Ya japanese rice bowl", "1 Raffles Link CityLink Mall B1-16 Singapore 039393", "39393", "Dessert", 1.292009, 103.85588, "Orchard"),
                    new RestaurantLocation("Magic Touch", "1 Raffles Link, #B1-23 CityLink Mall, 039393 Singapore", "39393", "Dessert", 1.292009, 103.85588, "Orchard"),
                    new RestaurantLocation("Straits Chinese Nonya Restaurant", "8 Raffles Ave #02-21, Singapore, 039802", "39802", "Chinese", 1.289825, 103.855015, "Tampines"),
                    new RestaurantLocation("Bee Kee Truffle Wanton Noodle", "01-15, Market Street Interim Hawker Centre, 5 Cross Street, 048418 Singapore", "48418", "Dessert", 1.281939656, 103.8484445, "Tampines"),
                    new RestaurantLocation("Escobar", "01-23/24, 20 Cross Street, China Square, Chinatown, Lower Central, 048422 Singapore", "48422", "Western", 1.283745, 103.847478, "Tampines"),
                    new RestaurantLocation("Yolé", "18 Cross Street Exchange #B1-110 Kitchen 21, 048423 Singapore", "48423", "Dessert", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("Donuteria", "18 Cross Street Exchange B1-110, S 048423", "48423", "Dessert", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("CoolMan Froyo", "18 Cross Street, China Square Central, Unit 01-106, 048423 Singapore", "48423", "Dessert", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("Cantolicious", "18 Cross Street, Cross Street Exchange B1-110, 048423 Singapore", "48423", "Chinese", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("Pimp My Salad", "Central Food Co, 18 Cross Street, #B1-110, Singapore, Singapore 048423", "48423", "Dessert", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("Formosa Delights", "18 Cross Street B1-110 Singapore 048423", "48423", "Chinese", 1.283384, 103.846868, "Tampines"),
                    new RestaurantLocation("Huevos", "18 Cross Street B1-110, S048423", "48423", "Dessert", 1.283384, 103.846868, "Tampines")
            );

            repository.saveAll(locations);
        };
    }
}
```






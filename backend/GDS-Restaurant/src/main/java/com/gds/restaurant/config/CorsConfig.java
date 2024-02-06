package com.gds.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/** 
 * Cross-Origin Configuration
 * */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/restaurant/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST"); 
    }
}
package com.springrest.springrest;



import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Add the origin of your frontend application
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the HTTP methods you want to allow
            .allowedHeaders("*"); // Add the headers you want to allow
    }
}


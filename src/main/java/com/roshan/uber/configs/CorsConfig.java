package com.roshan.uber.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE")
                .allowedHeaders("Access-Control-Allow-Origin","X-Requested-With", "accept", "Origin",
                        "Access-Control-Request-Method", "Access-Control-Request-Headers",
                        "Authorization", "userType", "content-type")
                .allowCredentials(true)
                .maxAge(3600);
    }
}

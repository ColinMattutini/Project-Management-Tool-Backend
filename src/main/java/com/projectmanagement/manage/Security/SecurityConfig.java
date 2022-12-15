package com.projectmanagement.manage.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration @RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
         final CorsConfiguration config = new CorsConfiguration();
         config.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:3000/Projects/forumapplication"));
         config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
         config.setAllowCredentials(true);
         config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Control-Type", "Content-Type"));

         final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", config);
         return source;
    }
}

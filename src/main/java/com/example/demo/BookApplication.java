package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.resource.BookResource;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	@CrossOrigin
	CommandLineRunner run(BookRepo bookRepo){
		return args -> {
			bookRepo.save(new Book(null, "Mowa Ciala", "Barbra",
					"psychologiczne", "2019",
					"http://localhost:8080/book/image/book1.png"));
			bookRepo.save(new Book(null, "Emocje Ujawnione", "Paul Ekman",
					"psychologiczne", "2007",
					"http://localhost:8080/book/image/book2.png"));
			bookRepo.save(new Book(null, "XYZ", "Pdfg",
					"q", "2021",
					"http://localhost:8080/book/image/book3.png"));
		};
	}

//	@Bean
//	public CorsFilter corsFilter(){
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200/"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin",
//				"Content-Type", "Accept", "Jwt-Token", "Authorization",
//				"Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
//				"Access-Control-Allow-Credentials", "Filename"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
////		return new CorsFilter(urlBasedCorsConfigurationSource);
//		return new CorsFilter();
//	}

}

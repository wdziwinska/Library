package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.resource.BookResource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BookRepo bookRepo){
		return args -> {
			bookRepo.save(new Book(null, "Mowa Ciala", "Barbra",
					"psychologiczne", "2019",
					"http://localhost:8080/library/image/book1.png"));
			bookRepo.save(new Book(null, "Emocje Ujawnione", "Paul Ekman",
					"psychologiczne", "2007",
					"http://localhost:8080/library/image/book2.png"));
		};
	}

}

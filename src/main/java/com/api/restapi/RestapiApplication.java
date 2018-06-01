package com.api.restapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.restapi.domain.Category;
import com.api.restapi.repositories.CategoryRepository;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Info");
		Category cat2 = new Category(null, "Office");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
	}
	
}

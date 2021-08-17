package com.relesi.architecture;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.repositories.CategoryRepository;

@SpringBootApplication
public class PocMicroservicesArchitectureApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(PocMicroservicesArchitectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Keyboard");
		Category cat3 = new Category(null, "Apple Watch");
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
	}

	
	
}

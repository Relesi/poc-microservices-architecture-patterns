package com.relesi.architecture;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.domain.City;
import com.relesi.architecture.domain.Product;
import com.relesi.architecture.domain.State;
import com.relesi.architecture.repositories.CategoryRepository;
import com.relesi.architecture.repositories.CityRepository;
import com.relesi.architecture.repositories.ProductRepository;
import com.relesi.architecture.repositories.StateRepository;

@SpringBootApplication
public class PocMicroservicesArchitectureApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(PocMicroservicesArchitectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");

		Product p1 = new Product(null, "Computing", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		

		State sta1 = new State(null, "California");
		State sta2 = new State(null, "Texa");

		City c1 = new City(null, "Los Angeles", sta1);
		City c2 = new City(null, "Dallas", sta2);
		City c3 = new City(null, "Houston", sta2);

		
		sta1.getCities().addAll(Arrays.asList(c1));
		sta2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

	}

}

package com.relesi.architecture.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.services.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;

	public static final Integer ID = 1;

	@Before
	public void setUp() throws Exception {
		Category category = new Category();
		category.setName("Canvas Box");
		this.categoryRepository.save(category);

	}

	@Test
	public void testSearch() {
		final Optional<Category> category = Optional.ofNullable(this.categoryService.search(ID));
		assertTrue(category.isPresent());
	}

	@Test
	public void testPersistCategory() {
		Category category = this.categoryService.insert(new Category());
		assertNotNull(category);
	}

}

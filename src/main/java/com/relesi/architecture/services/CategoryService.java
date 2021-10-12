package com.relesi.architecture.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.repositories.CategoryRepository;
import com.relesi.architecture.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found!  Id: " + id + ", Tipo: " + Category.class.getName()));

	}

	public Category insert(Category obj) {
		obj.setId(null);
		return categoryRepository.save(obj);
	}

	public Category update(Category obj) {
		find(obj.getId());
		return categoryRepository.save(obj);
		
	}

}

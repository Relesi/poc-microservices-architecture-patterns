package com.relesi.architecture.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.relesi.architecture.domain.Category;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {

		Category cat1 = new Category(1, "Computing");
		Category cat2 = new Category(2, "keyboard");

		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);

		return list;
	}

}

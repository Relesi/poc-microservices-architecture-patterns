package com.relesi.architecture.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.services.CategoriaService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Category obj = categoriaService.search(id);
		return ResponseEntity.ok().body(obj);

	}

}

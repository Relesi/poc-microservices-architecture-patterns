package com.relesi.architecture.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.relesi.architecture.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.relesi.architecture.domain.Category;
import com.relesi.architecture.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> find(@PathVariable Integer id) {
        Category obj = categoryService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Category obj) {
        obj = categoryService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Category obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = categoryService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = categoryService.findAll();
        List<CategoryDTO> listDto = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CategoryDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Category> list = categoryService.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoryDTO> listDto = list.map(obj -> new CategoryDTO(obj));
        return ResponseEntity.ok().body(listDto);

    }


}

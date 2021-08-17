package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

package com.relesi.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relesi.architecture.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
